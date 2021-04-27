package com.ifrn.sisconpro.controller;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.model.Usuario;
import com.ifrn.sisconpro.repository.DepartamentoRepository;
import com.ifrn.sisconpro.service.ProtocoloService;
import com.ifrn.sisconpro.service.UsuarioService;
import com.ifrn.sisconpro.service.serviceImple.UsuarioServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @Autowired
    UsuarioService users;


    @RequestMapping("/login")
    public String login(){return "login";}

    @RequestMapping(value = "/usuarios", method = RequestMethod.GET)
    public ModelAndView getProtocolos() {
        ModelAndView mv = new ModelAndView("usuarios");
        mv.addObject("usersLista", users.findAll());
        return mv;
    }

    @PostMapping("/cad-usuarios")
    public String salvaUsuario(Usuario usuario ) {
        //protocolo.setStatus(Integer.parseInt(1));

        users.save(usuario); // Cadastra e atualiza
        return "redirect:/usuarios";
    }

    @GetMapping("/usuarios/.{id}")
    public String excluirContrato(@PathVariable("id") long id){
        users.deleteById(id);
        return "redirect:/usuarios";
    }

    @GetMapping("/cad-contratos")
    public String exibirForm(Usuario usuario){
        return "cad-contratos";
    }


}
