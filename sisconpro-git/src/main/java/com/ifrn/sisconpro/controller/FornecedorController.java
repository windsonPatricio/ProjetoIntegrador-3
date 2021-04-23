package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Fornecedor;
import com.ifrn.sisconpro.repository.FornecerdorRepository;
import com.ifrn.sisconpro.service.serviceImple.ContratoServiceImple;
import com.ifrn.sisconpro.service.serviceImple.FornecedorServiceImple;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.lang.*;
import java.util.List;

@Controller
public class FornecedorController {

    @Autowired
    FornecedorServiceImple service;


    @RequestMapping(value = "/fornecedores",  method = RequestMethod.GET)
    public ModelAndView getForncedores(){
        ModelAndView mv = new ModelAndView("fornecedores");
        List<Fornecedor> fornecedor = service.findAll();
        mv.addObject("fornecedorLista", fornecedor);
        return mv;
    }


    @GetMapping("/cad-fornecedores")
    public String exibirForm(Fornecedor forncedores){
    return "cad-fornecedores";
    }

    @PostMapping("/cad-fornecedores")
    public String salvarFonecedor(Fornecedor fornecedor){
        fornecedor.builder()
                .build();
        service.save(fornecedor); // Cadastra e atualiza
        return "redirect:/fornecedores";
    }

    @GetMapping("/fornecedores/{id}")
    public String excluirFornecedor(@PathVariable("id") long id){
        service.deleteById(id);
        return "redirect:/fornecedores";
    }



}
