package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.config.DatabaseConnection;
import com.biblioteca.model.Quarto;

public class QuartoDAO {
    public List<Quarto> getAllQuartos() {
        List<Quarto> quartos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Quarto";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                Quarto quarto = new Quarto(
                        rs.getInt("id_quarto"),
                        rs.getInt("num_quarto"),
                        rs.getString("tipo"),
                        rs.getDouble("preco"),
                        rs.getInt("id_tipo")
                );
                quartos.add(quarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quartos;
    }

    public void addQuarto(Quarto quarto) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Quarto (num_quarto, tipo, preco, id_tipo) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, quarto.getNumQuarto());
            stmt.setString(2, quarto.getTipo());
            stmt.setDouble(3, quarto.getPreco());
            stmt.setInt(4, quarto.getIdTipo());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        quarto.setIdQuarto(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateQuarto(Quarto quarto) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Quarto SET num_quarto = ?, tipo = ?, preco = ?, id_tipo = ? WHERE id_quarto = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, quarto.getNumQuarto());
            stmt.setString(2, quarto.getTipo());
            stmt.setDouble(3, quarto.getPreco());
            stmt.setInt(4, quarto.getIdTipo());
            stmt.setInt(5, quarto.getIdQuarto());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteQuarto(int id) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Quarto WHERE id_quarto = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
