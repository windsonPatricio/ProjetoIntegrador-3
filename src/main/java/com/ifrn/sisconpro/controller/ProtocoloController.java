package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.*;
import com.ifrn.sisconpro.repository.DepartamentoRepository;
import com.ifrn.sisconpro.service.ProtocoloService;
import com.ifrn.sisconpro.service.serviceImple.DepartamentoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.annotation.HttpMethodConstraint;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

        LocalDate localDate = LocalDate.now();
       Date date1 = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        protocolo.setDataEnvio(date1);


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

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String nome;
        if (principal instanceof UserDetails) {
            nome = ((UserDetails)principal).getUsername();
        } else {
            nome = principal.toString();
        }
        prot.setUsuario(nome);


        if (!prot.getStatus().contains("3")){
            prot.setStatus("1");
            service.save(prot);
        }else if(prot.getStatus().contains("3") && prot.getUsuario().contains("Admin")){
            prot.setStatus("2");
            service.save(prot);
            prot.setStatus(prot.getStatus());
        }else{
            prot.setStatus(prot.getStatus());
        }

        return "redirect:/protocolos";
    }

    @GetMapping("/protocolos/cancelar-recebimento/{id}")
    public String cancelarContrato(@PathVariable("id") long id){
        Protocolos prot = service.findById(id);
        prot.setStatus("3");
        service.save(prot);
        return "redirect:/protocolos";
    }

    // EXIBIR DETALHES FORNECEDOR ---------------------------------
    @RequestMapping(value = "/protocolos/exibir/{id}", method = RequestMethod.GET)
    public ModelAndView exibirDetalhes(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("detalhes-protocolos");
        Protocolos protocolos = service.findById(id);
        mav.addObject("protocolos", protocolos);
        return mav;
    }
}
