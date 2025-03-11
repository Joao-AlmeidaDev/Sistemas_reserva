package com.biblioteca.controller;

import java.util.List;
import com.biblioteca.model.Hospede;
import com.biblioteca.model.dao.HospedeDAO;

public class HospedeController {
    private HospedeDAO hospedeDAO;

    public HospedeController() {
        hospedeDAO = new HospedeDAO();
    }

    public void addHospede(Hospede hospede) {
        hospedeDAO.addHospede(hospede);
    }

    public List<Hospede> getAllHospedes() {
        return hospedeDAO.getAllHospedes();
    }

    public void updateHospede(Hospede hospede) {
        hospedeDAO.updateHospede(hospede);
    }

    public void deleteHospede(int idHospede) {
        hospedeDAO.deleteHospede(idHospede);
    }
}
