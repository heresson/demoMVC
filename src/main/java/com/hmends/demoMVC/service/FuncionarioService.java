package com.hmends.demoMVC.service;

import java.util.List;

import com.hmends.demoMVC.domain.Departamento;
import com.hmends.demoMVC.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar (Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();
}
