package com.hmends.demoMVC.service;

import java.time.LocalDate;
import java.util.List;

import com.hmends.demoMVC.domain.Departamento;
import com.hmends.demoMVC.domain.Funcionario;

public interface FuncionarioService {
	
	void salvar (Funcionario funcionario);
	
	void editar(Funcionario funcionario);
	
	void excluir(Long id);
	
	Funcionario buscarPorId(Long id);
	
	List<Funcionario> buscarTodos();

	List<Funcionario> buscarPorNome(String nome);

	List<Funcionario> buscarPorCargo(Long id);

	List<Funcionario> buscarPorData(LocalDate entrada, LocalDate saida);
}
