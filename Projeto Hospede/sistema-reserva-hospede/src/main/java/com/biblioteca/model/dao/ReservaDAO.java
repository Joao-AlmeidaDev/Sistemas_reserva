package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.config.DatabaseConnection;
import com.biblioteca.model.Reserva;

public class ReservaDAO {

    public List<Reserva> getAllReservas() {
        List<Reserva> reservas = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Reservas";
            try (PreparedStatement stmt = connection.prepareStatement(query);
                 ResultSet rs = stmt.executeQuery()) {
                while (rs.next()) {
                    Reserva reserva = new Reserva(
                            rs.getInt("id_reservas"),
                            rs.getDate("data_checkin"),
                            rs.getDate("data_checkout"),
                            rs.getString("status"),
                            rs.getInt("id_hospedes"),
                            rs.getInt("id_funcionario"),
                            rs.getInt("id_quarto")
                    );
                    reservas.add(reserva);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return reservas;
    }

    public void addReserva(Reserva reserva) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Reservas (data_checkin, data_checkout, status, id_hospedes, id_funcionario, id_quarto) VALUES (?, ?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS)) {
                stmt.setDate(1, java.sql.Date.valueOf(reserva.getDataInicio()));
                stmt.setDate(2, java.sql.Date.valueOf(reserva.getDataFim()));
                stmt.setString(3, reserva.getStatus());
                stmt.setInt(4, reserva.getIdHospedes());
                stmt.setInt(5, reserva.getIdFuncionario());
                stmt.setInt(6, reserva.getIdQuarto());

                int affectedRows = stmt.executeUpdate();

                if (affectedRows > 0) {
                    try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                        if (generatedKeys.next()) {
                            reserva.setIdReservas(generatedKeys.getInt(1));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateReserva(Reserva reserva) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Reservas SET data_checkin = ?, data_checkout = ?, status = ?, id_hospedes = ?, id_funcionario = ?, id_quarto = ? WHERE id_reservas = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setDate(1, java.sql.Date.valueOf(reserva.getDataInicio()));
                stmt.setDate(2, java.sql.Date.valueOf(reserva.getDataFim()));
                stmt.setString(3, reserva.getStatus());
                stmt.setInt(4, reserva.getIdHospedes());
                stmt.setInt(5, reserva.getIdFuncionario());
                stmt.setInt(6, reserva.getIdQuarto());
                stmt.setInt(7, reserva.getIdReservas());
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteReserva(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Reservas WHERE id_reservas = ?";
            try (PreparedStatement stmt = connection.prepareStatement(query)) {
                stmt.setInt(1, id);
                stmt.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
