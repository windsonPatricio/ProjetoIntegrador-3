package com.ifrn.sisconpro.service;


import com.ifrn.sisconpro.model.Departamento;


import java.util.List;

public interface DepartamentoService {

    List<Departamento> findAll();
   Departamento findById(Long id);
    Departamento save(Departamento departamento);
    void deleteById(Long id);
}
