package com.ifrn.sisconpro.service.serviceImple;

import com.ifrn.sisconpro.model.Departamento;
import com.ifrn.sisconpro.repository.DepartamentoRepository;
import com.ifrn.sisconpro.service.DepartamentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoServiceImpl implements DepartamentoService {

    @Autowired
    DepartamentoRepository repository;


    @Override
    public List<Departamento> findAll() { return repository.findAll();}

    @Override
    public Departamento findById(Long id) {
        return repository.findById(id).get();
    }

    @Override
    public Departamento save(Departamento departamento) {
        return repository.save(departamento);
    }

    @Override
    public void deleteById(Long id) { repository.deleteById(id); }

}
