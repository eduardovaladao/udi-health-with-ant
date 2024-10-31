package com.udihealth.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.udihealth.dominio.Medico;
import com.udihealth.modelo.MedicoModelo;

@Controller
public class MedicoController {
    
    @RequestMapping(value = "/consultarMedicos", method = RequestMethod.GET)
    public ModelAndView consultarMedicos() {
        return new ModelAndView("consultarMedicos", "medico", new Medico());
    }
    
    // Controller para processar a seleção do médico
    @RequestMapping(value = "/consultarMedicos", method = RequestMethod.POST)
    public String processarMedico(@ModelAttribute("medico") Medico medico) {
        // Processar a seleção do médico aqui, com base no codigoMedico
        // Pode redirecionar para outra página ou exibir os dados do médico selecionado
        return "resultadoMedico"; // Exemplo de redirecionamento
    }
    
    @RequestMapping(value = "/adicionarMedico", method = RequestMethod.GET)
    public String adicionarMedico(@RequestParam String param) {
        return new String();
    }
    
    @ModelAttribute("webConsultarMedicos") 
    public Map<Integer, String> webConsultarMedicos() { 
        ArrayList<Medico> medicos = MedicoModelo.buscarMedicos();
        
        Map<Integer, String> consultaMedicos = new HashMap<>();
        for(int i = 0; i < medicos.size(); i++)
            consultaMedicos.put(medicos.get(i).getCodigoMedico(), medicos.get(i).getNome());
        return consultaMedicos;
    }
    
}
