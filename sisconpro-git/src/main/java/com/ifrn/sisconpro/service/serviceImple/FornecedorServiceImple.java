package com.ifrn.sisconpro.service.serviceImple;


import com.ifrn.sisconpro.model.Fornecedor;
import com.ifrn.sisconpro.service.FornecedorService;
import com.ifrn.sisconpro.repository.FornecerdorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FornecedorServiceImple implements FornecedorService{

    @Autowired
    FornecerdorRepository repository;

    @Override
    public List<Fornecedor> findAll() {
        return repository.findAll();
    }

    @Override
    public Fornecedor findById(Long id) {
        return null;
    }


    @Override
    public Fornecedor save(Fornecedor fornecedor) {
        return repository.save(fornecedor);
    }

    @Override
    public void deleteById(Long id) { repository.deleteById(id); }

}
