package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Departamento;
import com.ifrn.sisconpro.model.Protocolos;
import com.ifrn.sisconpro.repository.DepartamentoRepository;
import com.ifrn.sisconpro.service.ProtocoloService;
import com.ifrn.sisconpro.service.serviceImple.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProtocoloController {

    @Autowired
    ProtocoloService service;

    @Autowired
    DepartamentoRepository departamentoService;




    //METODOS DOS CADASTROS ----------------
    @RequestMapping(value = "/cad-protocolo", method = RequestMethod.GET)
    public ModelAndView listaDepartamento() {
        List<Departamento> departamento = departamentoService.findAll();
        ModelAndView mv = new ModelAndView("cad-protocolo");
        mv.addObject("departamento",departamento);
        return mv;
    }
//    @GetMapping("/cad-protocolo")
//    public String exibirForm(Protocolos protocolos){
//        return "cad-protocolo";
//    }

   @PostMapping("/cad-protocolo")
    public String salvarProtocolo(Protocolos protocolo) {
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
        if (prot.getStatus() !="3"){
            prot.setStatus("1");
        }
        service.save(prot);
        return "redirect:/protocolos";
    }

    @GetMapping("/protocolos/cancelar-recebimento/{id}")
    public String cancelarContrato(@PathVariable("id") long id, HttpSession session){
        Protocolos prot = service.findById(id);
        prot.getUsuario();
        prot.setStatus("3");
        service.save(prot);
        return "redirect:/protocolos";
    }
}
