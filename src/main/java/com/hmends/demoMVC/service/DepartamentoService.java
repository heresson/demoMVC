package com.hmends.demoMVC.service;

import java.util.List;

import com.hmends.demoMVC.domain.Departamento;

public interface DepartamentoService {
	

	void salvar(Departamento departamento);
	
	void editar(Departamento departamento);
	
	void excluir(Long id);
	
	Departamento buscarPorId(Long id);
	
	List<Departamento> buscarTodos();


}
