package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Departamento;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.service.ProtocoloService;
import com.ifrn.sisconpro.service.serviceImple.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProtocoloController {
    @Autowired
    ProtocoloService service;
    DepartamentoServiceImpl departamentoService;

    @RequestMapping(value = "/cad-protocolo", method = RequestMethod.GET)
    public ModelAndView listaDepartamento() {
        ModelAndView mv = new ModelAndView("cad-protocolo");
        List<Departamento> departamento = departamentoService.findAll();
        mv.addObject("departamento", departamento);
        System.out.println(mv.toString());
        return mv;
    }

    @PostMapping("/cad-protocolo")
    public String salvarProtocolo(Protocolos protocolo) {
        service.save(protocolo); // Cadastra e atualiza
        return "redirect:/protocolos";
    }

    @RequestMapping(value = "/protocolos", method = RequestMethod.GET)
    public ModelAndView getProtocolos() {
        ModelAndView mv = new ModelAndView("protocolos");
        mv.addObject("protocoloLista", service.findAll());
        return mv;
    }
/*
    @GetMapping("/cad-protocolo")
        public String exibirForm(Protocolos protocolos){
            return "/cad-protocolo";
        }*/



}
