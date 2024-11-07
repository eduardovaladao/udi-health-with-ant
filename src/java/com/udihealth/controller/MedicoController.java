package com.udihealth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.sql.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udihealth.dominio.Medico;
import com.udihealth.dominio.Usuario;
import com.udihealth.modelo.MedicoModelo;
import com.udihealth.modelo.UsuarioModelo;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;

@Controller
public class MedicoController {
    
    @RequestMapping(value="/", method=RequestMethod.GET)
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/consultarMedicos", method = RequestMethod.GET)
    public ModelAndView consultarMedicos() {
        return new ModelAndView("consultarMedicos", "medico", new Medico());
    }

    // Controller para processar a seleção do médico
    @RequestMapping(value = "/consultarMedico", method = RequestMethod.POST)
    public String consultarMedico(@ModelAttribute("medico") Medico med, Model modelo) {
        Medico medico = MedicoModelo.buscarMedicoCodigo(med.getCodigoMedico());
        System.out.println(med.getNome());
        modelo.addAttribute("nome", medico.getNome());
        modelo.addAttribute("sexo", medico.getSexo() + ""); // conversão para String
        modelo.addAttribute("cpf", medico.getCpf());
        modelo.addAttribute("crm", medico.getCrm());
        modelo.addAttribute("telefone", medico.getTelefone());

        return "resultadoMedico"; // Exemplo de redirecionamento
    }

    @RequestMapping(value = "/adicionarMedico", method = RequestMethod.GET)
    public ModelAndView adicionarMedico() {
        return new ModelAndView("adicionarMedico", "medico", new Medico());
    }
    
    @RequestMapping(value = "/adicionarNovoMedico", method = RequestMethod.POST)
    public String adicionarMedico(@ModelAttribute("medico")@Validated Medico med, BindingResult bindingResult, Model modelo) {
        // if (bindingResult.hasErrors()) return "adicionarMedico";
        
        UsuarioModelo.inserirUsuario(med);        
        
        modelo.addAttribute("nome", med.getNome());
        modelo.addAttribute("senha", med.getSenha());
        modelo.addAttribute("sexo", med.getSexo());
        if (med.getDataNascimento() instanceof java.sql.Date) {
            modelo.addAttribute("dataNascimento",  med.getDataNascimento());
        } else {
            modelo.addAttribute("dataNascimento",  java.sql.Date.valueOf("2006-04-19"));
        }
        modelo.addAttribute("crm", med.getCrm());
        modelo.addAttribute("cpf", med.getCpf());
        modelo.addAttribute("cep", med.getCep());
        modelo.addAttribute("telefone", med.getTelefone());
        modelo.addAttribute("email", med.getEmail());
        
        
        
        return "resultadoNovoMedico";
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
