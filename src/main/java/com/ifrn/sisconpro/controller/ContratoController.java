package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.service.serviceImple.ContratoServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ContratoController {

    @Autowired
    ContratoServiceImple service;


    @RequestMapping(value = "/contratos",  method = RequestMethod.GET)
    public ModelAndView getContratos(){
        ModelAndView mv = new ModelAndView("contratos");
        List<Contrato> contratos = service.findAll();
        mv.addObject("contratosLista", contratos);
        return mv;
    }

    @RequestMapping(value = "/contratos/{id}", method = RequestMethod.GET)
    public ModelAndView exibirDepartamento(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("detalhes-contratos");
        Contrato contrato = service.findById(id);
        mav.addObject("contrato", contrato);
        return mav;
    }

    @GetMapping("/contratos/.{id}")
    public String excluirContrato(@PathVariable("id") long id){
        service.deleteById(id);
        return "redirect:/contratos";
    }


    @GetMapping("/cad-contratos")
   public String exibirForm(Contrato contrato){
        return "cad-contratos";
    }

    @PostMapping("/cad-contratos")
    public String salvarContrato(Contrato contrato){
        contrato.builder()
        .fonteRecurso("BNDES")
                .build();
        service.save(contrato); // Cadastra e atualiza
        return "redirect:/contratos";
    }


    @GetMapping("contratos/..{id}")
    public ModelAndView editarContrato(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/Editar-cad-contratos");
        Contrato contrato = service.findById(id);
        mv.addObject("contrato", contrato);
        return  mv;
    }

    @PostMapping("/Editar-cad-contratos/{id}")
    public String atualizarCliente(@PathVariable("id") long id,
                                   @ModelAttribute("contrato") Contrato contrato) {
        Contrato contratoEditado = service.findById(id);
        if (!contratoEditado.equals(contrato)) {
            contratoEditado.setNumero(contrato.getNumero());
            contratoEditado.setCnpj(contrato.getCnpj());
            contratoEditado.setRazaoSocial(contrato.getRazaoSocial());
            contratoEditado.setValorInicial(contrato.getValorInicial());
            contratoEditado.setDataInicioVigencia(contrato.getDataInicioVigencia());
            contratoEditado.setDataFimVigencia(contrato.getDataFimVigencia());
            contratoEditado.setUnidadeBeneficiaria(contrato.getUnidadeBeneficiaria());
            contratoEditado.setModalidade(contrato.getModalidade());
            contratoEditado.setTipoContrato(contrato.getTipoContrato());
            contratoEditado.setObjetoContrato(contrato.getObjetoContrato());
            service.save(contratoEditado); // Cadastra e atualiza
        }

        return "redirect:/contratos";
    }

}
