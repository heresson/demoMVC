package com.hmends.demoMVC.dao;

import java.util.List;

import com.hmends.demoMVC.domain.Departamento;

public interface DepartamentoDao {
	
	void save(Departamento departamento);
	
	void update(Departamento departamento);
	
	void delete(Long id);
	
	Departamento findById(Long id);
	
	List<Departamento> findAll();

}
