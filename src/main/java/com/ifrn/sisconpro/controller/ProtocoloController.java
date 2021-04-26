package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Departamento;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.repository.DepartamentoRepository;
import com.ifrn.sisconpro.service.ProtocoloService;
import com.ifrn.sisconpro.service.serviceImple.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProtocoloController {

    @Autowired
    ProtocoloService service;
    DepartamentoRepository departamentoService;




    //METODOS DOS CADASTROS ----------------
    @RequestMapping(value = "/cad-protocolo", method = RequestMethod.GET)
    public ModelAndView listaDepartamento() {
        List<Departamento> departamento = departamentoService.findAll();
        System.out.println("lista de teste" + departamento);
        ModelAndView mv = new ModelAndView("cad-protocolo");
        mv.addObject("departamento",departamento);
        return mv;
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

    @GetMapping("/protocolos/{id}")
    public String receberContrato(@PathVariable("id") long id){
        Protocolos prot = service.findById(id);
        if (prot.getStatus() =="3"|| prot.getStatus() =="2"){

        } else {
            prot.setStatus("1");
        }
        service.save(prot);
        return "redirect:/protocolos";
    }

    @GetMapping("/protocolos/.{id}")
    public String cancelarContrato(@PathVariable("id") long id){
        Protocolos prot = service.findById(id);
        prot.setStatus("3");
        service.save(prot);
        return "redirect:/protocolos";
    }
}
