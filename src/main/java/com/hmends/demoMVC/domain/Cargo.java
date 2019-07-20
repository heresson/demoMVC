package com.hmends.demoMVC.domain;

import java.util.List;

import javax.persistence.*;

@Entity
@Table(name="CARGOS")
public class Cargo extends AbstractEntity<Long> {
	
	@Column(name="nome", nullable = false, unique = true, length = 60)
	private String nome;
	
	//muitos cargos para um departamento
	@ManyToOne
	@JoinColumn(name="id_departamento_fk")
	private Departamento departamento;
	
	@OneToMany(mappedBy = "cargo")
	private List<Funcionario> funcionarios;

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	public void setFuncionarios(List<Funcionario> funcionarios) {
		this.funcionarios = funcionarios;
	}
	
	 

}
