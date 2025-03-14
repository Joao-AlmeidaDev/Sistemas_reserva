package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.config.DatabaseConnection;
import com.biblioteca.model.Hospede;

public class HospedeDAO {
    public List<Hospede> getAllHospedes() {
        List<Hospede> hospedes = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Hospedes";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Hospede hospede = new Hospede(
                        rs.getInt("id_hospedes"),
                        rs.getString("nome_completo"),
                        rs.getDate("dt_nascimento"),
                        rs.getString("endereco"),
                        rs.getString("telefone"),
                        rs.getString("email"),
                        rs.getString("cpf")
                );
                hospedes.add(hospede);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return hospedes;
    }

    public void addHospede(Hospede hospede) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Hospedes (nome_completo, dt_nascimento, endereco, telefone, email, cpf) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, hospede.getNomeCompleto());
            stmt.setDate(2, new java.sql.Date(hospede.getDtNascimento().getTime()));
            stmt.setString(3, hospede.getEndereco());
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());
            stmt.setString(6, hospede.getCpf());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        hospede.setIdHospedes(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateHospede(Hospede hospede) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Hospedes SET nome_completo = ?, dt_nascimento = ?, endereco = ?, telefone = ?, email = ?, cpf = ? WHERE id_hospedes = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, hospede.getNomeCompleto());
            stmt.setDate(2, new java.sql.Date(hospede.getDtNascimento().getTime()));
            stmt.setString(3, hospede.getEndereco());
            stmt.setString(4, hospede.getTelefone());
            stmt.setString(5, hospede.getEmail());
            stmt.setString(6, hospede.getCpf());
            stmt.setInt(7, hospede.getIdHospedes());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteHospede(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Hospedes WHERE id_hospedes = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
