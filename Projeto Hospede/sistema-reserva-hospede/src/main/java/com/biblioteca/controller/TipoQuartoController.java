package com.biblioteca.controller;

import java.util.List;

import com.biblioteca.model.TipoQuarto;
import com.biblioteca.model.dao.TipoQuartoDAO;

public class TipoQuartoController {
    private TipoQuartoDAO tipoQuartoDAO;

    public TipoQuartoController() {
        tipoQuartoDAO = new TipoQuartoDAO();
    }

    public List<TipoQuarto> getAllTipoQuartos() {
        return tipoQuartoDAO.getAllTipoQuartos();
    }

    public void addTipoQuarto(TipoQuarto tipoQuarto) {
        tipoQuartoDAO.addTipoQuarto(tipoQuarto);
    }

    public void updateTipoQuarto(TipoQuarto tipoQuarto) {
        tipoQuartoDAO.updateTipoQuarto(tipoQuarto);
    }

    public void deleteTipoQuarto(int id) {
        tipoQuartoDAO.deleteTipoQuarto(id);
    }
}
