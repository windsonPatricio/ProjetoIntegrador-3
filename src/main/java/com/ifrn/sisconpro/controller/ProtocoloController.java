package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Departamento;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.service.ProtocoloService;
import com.ifrn.sisconpro.service.serviceImple.DepartamentoServiceImpl;
import org.hibernate.tool.schema.internal.exec.ScriptTargetOutputToFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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



    //METODOS DOS CADASTROS ----------------
    @RequestMapping(value = "/cad-protocolo", method = RequestMethod.GET)
    public String listaDepartamento(Departamento departamento, Protocolos protocolo) {
//        ModelAndView mv = new ModelAndView("cad-protocolo");
//        long teste = 1;
//        Departamento departamento = departamentoService.findById(teste);
//        System.out.println(departamento.toString());
//        mv.addObject("departamento", departamento);
//        System.out.println(mv.toString());
//        return mv;
        return "/cad-protocolo";
    }
//    @GetMapping("/cad-protocolo")
//    public String exibirForm(Protocolos protocolos){
//        return "/cad-protocolo";
//    }
   @PostMapping("/cad-protocolo")
    public String salvarProtocolo(Protocolos protocolo) {
        //protocolo.setStatus(Integer.parseInt(1));
        service.save(protocolo); // Cadastra e atualiza
        return "redirect:/protocolos";
    }

    // METODO DE LISTAGEM DOS CONTRATOS ------------
    @RequestMapping(value = "/protocolos", method = RequestMethod.GET)
    public ModelAndView getProtocolos() {
        ModelAndView mv = new ModelAndView("protocolos");
        mv.addObject("protocoloLista", service.findAll());
        return mv;
    }




}
