package com.udihealth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udihealth.dominio.Paciente;
import com.udihealth.modelo.PacienteModelo;
import com.udihealth.modelo.UsuarioModelo;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;



@Controller
public class PacienteController {


    @RequestMapping(value = "/consultarPacientes", method = RequestMethod.GET)
    public ModelAndView consultarPacientes() {
        return new ModelAndView("consultarPacientes", "paciente", new Paciente());
    }

    // Controller para processar a seleção do paciente
    @RequestMapping(value = "/consultarPaciente", method = RequestMethod.POST)
    public String consultarPaciente(@ModelAttribute("paciente") Paciente paci, Model modelo) {
        Paciente paciente = PacienteModelo.buscarPacienteCodigo(paci.getCodigoPaciente());
        System.out.println(paciente.getNome());
        modelo.addAttribute("paciente", paciente);

        return "resultadoPaciente"; // Exemplo de redirecionamento
    }

    @RequestMapping(value = "/adicionarPaciente", method = RequestMethod.GET)
    public ModelAndView adicionarPaciente() {
        return new ModelAndView("adicionarPaciente", "paciente", new Paciente());
    }
    
    @RequestMapping(value = "/adicionarNovoPaciente", method = RequestMethod.POST)
    public String adicionarPaciente(@ModelAttribute("paciente")@Validated Paciente paci, BindingResult bindingResult, Model modelo) {
        // if (bindingResult.hasErrors()) return "adicionarMedico";
        
        // Verifique se a data foi convertida corretamente
        //System.out.println("Data Nascimento: " + paci.getNome());
        //System.out.println("Data Nascimento: " + paci.getDataNascimento());
        
        UsuarioModelo.inserirUsuario(paci);        
        
        modelo.addAttribute("nome", paci.getNome());
        modelo.addAttribute("senha", paci.getSenha());
        modelo.addAttribute("sexo", paci.getSexo());
        modelo.addAttribute("dataNascimento", paci.getDataNascimento());
        modelo.addAttribute("observacoes", paci.getObservacoes());
        modelo.addAttribute("cpf", paci.getCpf());
        modelo.addAttribute("cep", paci.getCep());
        modelo.addAttribute("telefone", paci.getTelefone());
        modelo.addAttribute("email", paci.getEmail());
        
        return "resultadoNovoPaciente";
    }
    
    @RequestMapping(value = "/atualizarPaciente", method = RequestMethod.POST)
    public String atualizarMedico(@ModelAttribute("medico")@Validated Paciente paci, BindingResult bindingResult, Model modelo) {
        // Salvar as alterações no banco
        int cod = UsuarioModelo.buscarUsuarioCPF(paci.getCpf()).getCodigoUsuario(); //pegar código
        System.out.println("Códinho: " + cod);
        UsuarioModelo.atualizarUsuario(cod, paci); // Implementar no serviço
        return "sucesso"; // Redireciona para uma página de sucesso
    }

    @ModelAttribute("paciente")
    public Paciente criarPacienteModelo() {
        return new Paciente();
    }

    @ModelAttribute("webConsultarPacientes")
    public Map<Integer, String> webConsultarPacientes() {
        ArrayList<Paciente> pacientes = PacienteModelo.buscarPacientes();

        Map<Integer, String> consultaPacientes = new HashMap<>();
        for (int i = 0; i < pacientes.size(); i++) {
            consultaPacientes.put(pacientes.get(i).getCodigoPaciente(), pacientes.get(i).getNome());
        }
        return consultaPacientes;
    }
}