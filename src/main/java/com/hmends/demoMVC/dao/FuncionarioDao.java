package com.hmends.demoMVC.dao;

import java.time.LocalDate;
import java.util.List;

import com.hmends.demoMVC.domain.Funcionario;

public interface FuncionarioDao {
	
	void save(Funcionario funcionario);
	
	void update(Funcionario funcionario);
	
	void delete(Long id);
	
	Funcionario findById(Long id);
	
	List<Funcionario> findAll();

	List<Funcionario> findByNome(String nome);

	List<Funcionario> findByCargo(Long id);

	List<Funcionario> findByEntradaAndSaida(LocalDate entrada, LocalDate saida);

	List<Funcionario> findByDataEntrada(LocalDate entrada);

	List<Funcionario> findByDataSaida(LocalDate saida);

}
