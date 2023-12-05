package dii2dam.movieApp.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.stage.Modality;

import dii2dam.movieApp.dao.*;

public class Validations {

	public static boolean empty(String email, String password) {
        return email.isBlank() || password.isBlank();
    }

    public static void mostrarVentanaError(String mensaje) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
    public static boolean mostrarConfirmacion(String mensaje) {
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.initModality(Modality.APPLICATION_MODAL);
        alert.setTitle("Confirmación");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);

        alert.getButtonTypes().setAll(ButtonType.YES, ButtonType.NO);

        ButtonType resultado = alert.showAndWait().orElse(ButtonType.NO);

        return resultado == ButtonType.YES;
    }
    public static boolean existeUser(String username) {
    	ResultSet result = Sentencias.selectUserbyUsername(username);
    	try {
			return result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    }
    
    public static boolean comprobarUserContraseña(String username, String pass) {
    	ResultSet result = Sentencias.selectUserbyUsernameAndPass(username,pass);
    	try {
			return result.next();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
    }
}
