package com.biblioteca.controller;

import java.util.List;
import com.biblioteca.model.Funcionario;
import com.biblioteca.model.dao.FuncionarioDAO;

public class FuncionarioController {
    private FuncionarioDAO funcionarioDAO;

    public FuncionarioController() {
        funcionarioDAO = new FuncionarioDAO();
    }

    public List<Funcionario> getAllFuncionarios() {
        return funcionarioDAO.getAllFuncionarios();
    }

    // Atualização do método addFuncionario para não aceitar o parâmetro de ID
    public void addFuncionario(Funcionario funcionario) {
        funcionarioDAO.addFuncionario(funcionario);
    }

    public void updateFuncionario(Funcionario funcionario) {
        funcionarioDAO.updateFuncionario(funcionario);
    }

    public void deleteFuncionario(int id) {
        funcionarioDAO.deleteFuncionario(id);
    }
}

