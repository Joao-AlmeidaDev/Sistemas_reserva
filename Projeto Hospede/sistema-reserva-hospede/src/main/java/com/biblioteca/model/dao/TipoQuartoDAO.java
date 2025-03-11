package com.biblioteca.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.config.DatabaseConnection;
import com.biblioteca.model.TipoQuarto;

public class TipoQuartoDAO {

    public List<TipoQuarto> getAllTipoQuartos() {
        List<TipoQuarto> tipoQuartos = new ArrayList<>();
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "SELECT * FROM Tipo_Quarto";
            PreparedStatement stmt = connection.prepareStatement(query);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                TipoQuarto tipoQuarto = new TipoQuarto(
                        rs.getInt("id_tipo"),
                        rs.getString("caracteristica"),
                        rs.getString("descricao"),
                        rs.getInt("capacidade"),
                        rs.getDouble("preco_noite")
                );
                tipoQuartos.add(tipoQuarto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tipoQuartos;
    }

    public void addTipoQuarto(TipoQuarto tipoQuarto) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "INSERT INTO Tipo_Quarto (caracteristica, descricao, capacidade, preco_noite) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = connection.prepareStatement(query, PreparedStatement.RETURN_GENERATED_KEYS);
            stmt.setString(1, tipoQuarto.getCaracteristica());
            stmt.setString(2, tipoQuarto.getDescricao());
            stmt.setInt(3, tipoQuarto.getCapacidade());
            stmt.setDouble(4, tipoQuarto.getPrecoNoite());

            int affectedRows = stmt.executeUpdate();

            if (affectedRows > 0) {
                try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                    if (generatedKeys.next()) {
                        tipoQuarto.setIdTipo(generatedKeys.getInt(1));
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateTipoQuarto(TipoQuarto tipoQuarto) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "UPDATE Tipo_Quarto SET caracteristica = ?, descricao = ?, capacidade = ?, preco_noite = ? WHERE id_tipo = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setString(1, tipoQuarto.getCaracteristica());
            stmt.setString(2, tipoQuarto.getDescricao());
            stmt.setInt(3, tipoQuarto.getCapacidade());
            stmt.setDouble(4, tipoQuarto.getPrecoNoite());
            stmt.setInt(5, tipoQuarto.getIdTipo());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteTipoQuarto(int idTipo) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String query = "DELETE FROM Tipo_Quarto WHERE id_tipo = ?";
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, idTipo);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
