package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.service.serviceImple.ContratoServiceImple;
import com.ifrn.sisconpro.service.serviceImple.ProtocoloServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
public class IndexController {

    @Autowired
    ContratoServiceImple service;

    @Autowired
    ProtocoloServiceImple servico;

    @RequestMapping("/")
    public String getHomePage(){
        return "index";
    }
    

    @GetMapping("/")
    public ModelAndView listarContratosVencimentoProximo(){
        ModelAndView mv = new ModelAndView("index");
        List<Contrato> contrato = service.findAll();
        List<Protocolos> protocolos = servico.findAll();
        List<Contrato> listaCtr = (List<Contrato>)service.listarContratoProximoVencimento();
        List<Contrato> listaConf = (List<Contrato>)service.contarContratosConfirmados();
        List<Protocolos> listaRec = (List<Protocolos>)servico.contarProtocolosRecebidos();
        List<Protocolos> listaEnv = (List<Protocolos>)servico.contarProtocolosEnviados();
        mv.addObject("listaRec", listaRec.size());
        mv.addObject("listaEnv", listaEnv.size());
        mv.addObject("listaCtr", listaCtr.size()); 
        mv.addObject("listaConf", listaConf.size());
        mv.addObject("protocolo", protocolos);
        mv.addObject("contratoVenc", contrato);
        return mv;
    }



}