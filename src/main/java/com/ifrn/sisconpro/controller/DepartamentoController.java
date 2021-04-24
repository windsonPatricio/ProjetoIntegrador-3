package com.ifrn.sisconpro.controller;


import com.ifrn.sisconpro.model.Departamento;
import com.ifrn.sisconpro.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class DepartamentoController {

    @Autowired
    DepartamentoService service;

    /* LISTAGEM DOS DEPARTAMENTOS */
    @RequestMapping(value = "/departamentos",  method = RequestMethod.GET)
    public ModelAndView getDepartamentos(){
        ModelAndView mv = new ModelAndView("departamentos");
        List<Departamento> departamento = service.findAll();
        mv.addObject("departamentoLista", departamento);
        return mv;
    }


    // EXCLUI OS DEPARTAMENTOS
    @GetMapping("/departamentos/.{id}")
    public String excluirContrato(@PathVariable("id") long id){
        service.deleteById(id);
        return "redirect:/departamentos";
    }


    //
    @GetMapping("/cad-departamentos")
    public String exibirForm(Departamento departamento){
        return "/cad-departamentos";
    }

    @PostMapping("/cad-departamentos")
    public String salvarContrato(Departamento departamento){
        departamento.builder().build();
        service.save(departamento); // Cadastra e atualiza
        return "redirect:/departamentos";
    }





    @RequestMapping(value = "/departamentos/{id}", method = RequestMethod.GET)
    public ModelAndView exibirDepartamento(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("detalhes-departamento");
        Departamento departamento = service.findById(id);
        mav.addObject("departamento", departamento);
        return mav;
    }

    @GetMapping("departamentos/..{id}")
    public ModelAndView editarContrato(@PathVariable("id") long id){
        ModelAndView mv = new ModelAndView("/Editar-cad-departamento");
        Departamento departamento = service.findById(id);
        mv.addObject("departamento", departamento);
        return  mv;
    }

    @PostMapping("departamentos/..{id}")
    public String atualizarDepartamento(@PathVariable("id") long id,
                                   @ModelAttribute("departamento") Departamento departamento) {
        Departamento departamentoEditado = service.findById(id);
        if (!departamentoEditado.equals(departamento)) {
            departamentoEditado.setCodigo(departamento.getCodigo());
            departamentoEditado.setEmail(departamento.getEmail());
            departamentoEditado.setNome(departamento.getNome());
            departamentoEditado.setSigla(departamento.getSigla());
            departamentoEditado.setTelefone(departamento.getTelefone());
            departamentoEditado.setUsuario(departamento.getUsuario());
            service.save(departamentoEditado); // Cadastra e atualiza
        }

        return "redirect:/departamentos";
    }

/*
    @GetMapping("/produtos/cadastrar")
    public String exibirForm(Produto produto){
        return "formestoque";
    }

    @PostMapping("/produtos/cadastrar")
    public String salvarProduto(Produto produto){
        produto.setUltimaReposicao(Reposicao.builder()
                                .qtdeUnidades(1000)
                                .data(LocalDate.now()).build());
        produto.addVariasUnidades(geradorDeUnidades.gerarUnidades(5));
        produtoService.save(produto); // Cadastra e atualiza
        return "redirect:/produtos";
    }

    @GetMapping("/produtos/editar/{id}")
    public ModelAndView editarProduto(@PathVariable("id") long id){
        ModelAndView mav = new ModelAndView("editar_produto");
        Produto produto = produtoService.findById(id);
        mav.addObject("produto", produto);
        return mav;
    }

    @PostMapping("/produtos/editar/{id}")
    public String atualizarProduto(@PathVariable("id") long id,
                                   @ModelAttribute("produto") Produto produto){
        Produto produtoEditado = produtoService.findById(id);
        if (!produtoEditado.equals(produto)) {
            produtoEditado.setNome(produto.getNome());
            produtoEditado.setCategoria(produto.getCategoria());
            produtoEditado.setMarca(produto.getMarca());
            produtoEditado.setVol_max(produto.getVol_max());
            produtoEditado.setVol_min(produto.getVol_min());
            produtoEditado.setUltimaReposicao(reposicaoService.findById(id));
        }
        produtoService.save(produtoEditado); // Cadastra e atualiza
        return "redirect:/produtos";
    }

@GetMapping("/produtos/excluir/{id}")
public String excluirProduto(@PathVariable("id") long id){
    produtoService.deleteById(id);
    return "redirect:/produtos";
}

    @GetMapping("/produtos/listar/poucas-unidades")
    public ModelAndView listarProdutosPoucasUnidades(){
        ModelAndView mv = new ModelAndView("produtos");
        Iterable<Produto> produtos = estoqueService.listarProdutosComPoucasUnidades();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/produtos/listar/venc-prox")
    public ModelAndView listarProdutosVencimentoProximo(){
        ModelAndView mv = new ModelAndView("produtos");
        Iterable<Produto> produtos = estoqueService.listarProdutosComVencimentoProximo();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/produtos/listar/rep-recente")
    public ModelAndView listarProdutosReposicaoRecente(){
        ModelAndView mv = new ModelAndView("produtos");
        Iterable<Produto> produtos = estoqueService.listarProdutosComReposicaoRecente();
        mv.addObject("produtos", produtos);
        return mv;
    }

    @GetMapping("/produtos/listar/uni-vencidas")
    public ModelAndView listarProdutosReposicaoDistante(){
        ModelAndView mv = new ModelAndView("produtos");
        Iterable<Produto> produtos = estoqueService.listarProdutosComUnidadesVencidas();
        mv.addObject("produtos", produtos);
        return mv;
    }

*/



}
