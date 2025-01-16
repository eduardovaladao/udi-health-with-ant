package com.udihealth.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.udihealth.dominio.Usuario;
import com.udihealth.modelo.UsuarioModelo;

@Controller
public class UsuarioController {

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    /*
    @RequestMapping(value = "/verificarLogin", method = RequestMethod.POST)
    public ModelAndView usuario() {
        return new ModelAndView("verificarLogin", "command", new Usuario());
    }
     */
    @RequestMapping(value = "verificarLogin", method = RequestMethod.POST)
    public String verificarLogin(
            @ModelAttribute("usuario") Usuario user,
            BindingResult bindingResult,
            Model modelo
    ) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        modelo.addAttribute("cpf", user.getCpf());
        modelo.addAttribute("senha", user.getSenha());
        Usuario res = UsuarioModelo.verificarLogin(user);

        if (res.getCpf() == null) {
            return "login";
        } else {
            System.out.println(res.toString());
            return "index";
        }
    }
    
    @ModelAttribute("usuario")
    public Usuario criarUsuarioModelo() {
        return new Usuario();  
    }
}
