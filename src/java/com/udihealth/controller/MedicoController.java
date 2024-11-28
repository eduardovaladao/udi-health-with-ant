package com.udihealth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udihealth.dominio.Medico;
import com.udihealth.modelo.MedicoModelo;
import com.udihealth.modelo.UsuarioModelo;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class MedicoController {

    @RequestMapping(value = "/consultarMedicos", method = RequestMethod.GET)
    public ModelAndView consultarMedicos() {
        return new ModelAndView("consultarMedicos", "medico", new Medico());
    }

    // Controller para processar a seleção do médico
    @RequestMapping(value = "/consultarMedico", method = RequestMethod.POST)
    public String consultarMedico(@ModelAttribute("medico") Medico med, Model modelo) {
        Medico medico = MedicoModelo.buscarMedicoCodigo(med.getCodigoMedico());
        System.out.println(medico.getNome());
        modelo.addAttribute("medico", medico);

        return "resultadoMedico"; // Exemplo de redirecionamento
    }

    @RequestMapping(value = "/adicionarMedico", method = RequestMethod.GET)
    public ModelAndView adicionarMedico() {
        return new ModelAndView("adicionarMedico", "medico", new Medico());
    }
    
    @RequestMapping(value = "/adicionarNovoMedico", method = RequestMethod.POST)
    public String adicionarMedico(@ModelAttribute("medico")@Validated Medico med, BindingResult bindingResult, Model modelo) {
        // if (bindingResult.hasErrors()) return "adicionarMedico";
        
        // Verifique se a data foi convertida corretamente
        System.out.println("Data Nascimento: " + med.getNome());
        System.out.println("Data Nascimento: " + med.getDataNascimento());
        
        UsuarioModelo.inserirUsuario(med);        
        
        modelo.addAttribute("nome", med.getNome());
        modelo.addAttribute("senha", med.getSenha());
        modelo.addAttribute("sexo", med.getSexo());
        modelo.addAttribute("dataNascimento", med.getDataNascimento());
        modelo.addAttribute("crm", med.getCrm());
        modelo.addAttribute("cpf", med.getCpf());
        modelo.addAttribute("cep", med.getCep());
        modelo.addAttribute("telefone", med.getTelefone());
        modelo.addAttribute("email", med.getEmail());
        
        return "resultadoNovoMedico";
    }
    
    @RequestMapping(value = "/atualizarMedico", method = RequestMethod.POST)
    public String atualizarMedico(@ModelAttribute("medico")@Validated Medico med, BindingResult bindingResult, Model modelo) {
        // Salvar as alterações no banco
        int cod = UsuarioModelo.buscarUsuarioCPF(med.getCpf()).getCodigoUsuario(); //pegar código
        System.out.println("Códinho: " + cod);
        UsuarioModelo.atualizarUsuario(cod, med); // Implementar no serviço
        return "sucesso"; // Redireciona para uma página de sucesso
    }

    @ModelAttribute("medico")
    public Medico criarMedicoModelo() {
        return new Medico();
    }

    @ModelAttribute("webConsultarMedicos")
    public Map<Integer, String> webConsultarMedicos() {
        ArrayList<Medico> medicos = MedicoModelo.buscarMedicos();

        Map<Integer, String> consultaMedicos = new HashMap<>();
        for (int i = 0; i < medicos.size(); i++) {
            consultaMedicos.put(medicos.get(i).getCodigoMedico(), medicos.get(i).getNome());
        }
        return consultaMedicos;
    }
}
