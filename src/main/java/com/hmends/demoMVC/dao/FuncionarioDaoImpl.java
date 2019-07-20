package com.hmends.demoMVC.dao;

import org.springframework.stereotype.Repository;

import com.hmends.demoMVC.domain.Funcionario;

@Repository
public class FuncionarioDaoImpl extends AbstractDao<Funcionario, Long> implements FuncionarioDao {

}
