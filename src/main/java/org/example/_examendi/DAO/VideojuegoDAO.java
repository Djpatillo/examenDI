package org.example._examendi.DAO;

import org.example._examendi.Modelo.Videojuego;
import org.example._examendi.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VideojuegoDAO {

    public static List<Videojuego> obtenerTodos() {
        List <Videojuego> videojuegos = new ArrayList<>();
        try(Connection conn = DatabaseConnection.getConnection()){
            try(PreparedStatement statement = conn.prepareStatement("SELECT * FROM videojuegos")){
                ResultSet rs = statement.executeQuery();
                while(rs.next()){
                    videojuegos.add(new Videojuego(rs.getString("titulo"), rs.getBoolean("completado"), rs.getDate("fechaLanzamiento")));
                    return videojuegos;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public static void anadirVideojuego(String text, boolean selected, LocalDate value) {
        try(Connection conn = DatabaseConnection.getConnection()){
            try(PreparedStatement statement = conn.prepareStatement("INSERT INTO videojuegos VALUES (?,?,?)")){
                statement.setString(1, text);
                statement.setBoolean(2, selected);
                statement.setDate(3, java.sql.Date.valueOf(value));
                statement.executeUpdate();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void marcarFavorito(String username, String tituloJuego) {
        String sql = "UPDATE usuarios SET juego_favorito = ? WHERE username = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, tituloJuego);
            statement.setString(2, username);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void eliminarVideojuego(String titulo) {
        String sql = "DELETE FROM videojuegos WHERE titulo = ?";

        try (Connection connection = DatabaseConnection.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setString(1, titulo);
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
