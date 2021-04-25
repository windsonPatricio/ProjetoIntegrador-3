package com.ifrn.sisconpro.controller;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.Fornecedor;
import com.ifrn.sisconpro.service.serviceImple.FornecedorServiceImple;
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

    // EXIBIR LISTA DOS FORNECEDORES
    @GetMapping(value = "/fornecedores")
    public ModelAndView getForncedores(){
        ModelAndView mv = new ModelAndView("fornecedores");
        List<Fornecedor> fornecedor = service.findAll();
        mv.addObject("fornecedorLista", fornecedor);
        return mv;
    }

    // CADASTRO FORNECEDOR --------------------------------------------
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


    // EXCLUIR FORNECEDOR ----------------------------------------
    @GetMapping("/fornecedores/{id}")
    public String excluirFornecedor(@PathVariable("id") long id){
        service.deleteById(id);
        return "redirect:/fornecedores";
    }


       // EXIBIR DETALHES FORNECEDOR ---------------------------------
    @RequestMapping(value = "/fornecedores/..{id}", method = RequestMethod.GET)
    public ModelAndView exibirFornecedor(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("detalhes-fornecedores");
        Fornecedor fornecedores = service.findById(id);
        mav.addObject("fornecedor", fornecedores);
        return mav;
    }

    @GetMapping("fornecedores/.{id}")
    public ModelAndView editarForncedor(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/Editar-cad-fornecedores");
        Fornecedor fornecedor = service.findById(id);
        mv.addObject("fornecedor", fornecedor);
        return  mv;
    }

    @PostMapping("/Editar-cad-fornecedores/{id}")
    public String atualizarFornecedor(@PathVariable("id") long id,
                                   @ModelAttribute("fornecedor") Fornecedor fornecedor) {
        Fornecedor FornecedorEditado = service.findById(id);
        if (!FornecedorEditado.equals(fornecedor)) {
            FornecedorEditado.setCodigo(fornecedor.getCodigo());
            FornecedorEditado.setCnpj(fornecedor.getCnpj());
            FornecedorEditado.setNome(fornecedor.getNome());
            FornecedorEditado.setTelefone(fornecedor.getTelefone());
            FornecedorEditado.setEndereco(fornecedor.getEndereco());
            FornecedorEditado.setRamo(fornecedor.getRamo());

            service.save(FornecedorEditado); // Cadastra e atualiza
        }

        return "redirect:/fornecedores";
    }

}
