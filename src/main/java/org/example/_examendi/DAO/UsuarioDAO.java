package org.example._examendi.DAO;

import com.mysql.cj.protocol.Resultset;
import javafx.scene.control.TextField;
import org.example._examendi.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UsuarioDAO {
    public static Boolean validarCredenciales(TextField username, TextField password) {
        try(Connection connection = DatabaseConnection.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM usuarios WHERE username = ? AND password = ?")){
                statement.setString(1, username.getText());
                statement.setString(2, password.getText());
                ResultSet rs = statement.executeQuery();
                if(((java.sql.ResultSet) rs).next()){
                    return true;
                }
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

    public static void registrarUsuario(TextField usernameRegistro, TextField passwordRegistro1) {
        try(Connection connection = DatabaseConnection.getConnection()){
            try(PreparedStatement statement = connection.prepareStatement("INSERT INTO usuarios VALUES (?,?)")){
                statement.setString(1, usernameRegistro.getText());
                statement.setString(2, passwordRegistro1.getText());
                statement.executeUpdate();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
