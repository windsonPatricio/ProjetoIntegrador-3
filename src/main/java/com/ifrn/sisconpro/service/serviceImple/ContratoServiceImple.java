package com.ifrn.sisconpro.service.serviceImple;

import com.ifrn.sisconpro.model.Contrato;
import com.ifrn.sisconpro.model.QContrato;
import com.ifrn.sisconpro.repository.ContratoRepository;
import com.ifrn.sisconpro.service.ContratoService;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.List;


@Service
public class ContratoServiceImple implements ContratoService {

    @Autowired
    ContratoRepository repository;

    @Autowired
    EntityManager manager;


    @Override
    public List<Contrato> findAll() {
        return repository.findAll();
    }


    @Override
    public Contrato findById(Long id) {
        // findById() retorna um Option, para obter o Produto é necessário
        // adicionar o .get()
        return repository.findById(id).get();
    }

    @Override
    public Contrato save(Contrato contrato) {
        return repository.save(contrato);
    }

    @Override
    public void deleteById(Long id) { repository.deleteById(id); }


    @Override
    public Iterable<Contrato> listarContratoProximoVencimento() {
        QContrato qContrato = QContrato.contrato;
        BooleanExpression contrProxVenc = qContrato.dataFimVigencia.goe(LocalDate.now());
               return repository.findAll(contrProxVenc);
    }

    @Override
    public Iterable<Contrato> contarContratosConfirmados(){
        QContrato qContrato = QContrato.contrato;
        BooleanExpression listaDeConfirmados = qContrato.status.eq(1);
        return repository.findAll(listaDeConfirmados);
    }


}
        /*
        Expressão que retorna as unidades de produtos que estão com data de
        validade entre a data atual e os próximos 3 meses.
         */
    /*
        BooleanExpression unidProxVenc = qUnidade.dataDeValidade
                .between(LocalDate.now(), LocalDate.now().plusMonths(3L));

        /*
        Cria uma query para coletar o id dos produtos (select)
        na tabela Unidade (from) de todas as unidades que vão vencer nos próximos
        3 meses (where).
        O fetch retorna a lista de ids que é passado para o produto repository
        buscar os produtos pelos ids.
         */
     /*   List<Long> listaDeIds = new JPAQueryFactory(manager)
                .select(qUnidade.produto.id) //Selecione o ID de todos os produtos
                .from(qUnidade) //... da tabela Unidades
                .where(unidProxVenc) // Que estão com o vencimento próximo
                .fetch();

        return produtoRepository.findAllById(listaDeIds);*/