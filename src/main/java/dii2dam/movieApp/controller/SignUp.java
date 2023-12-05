package dii2dam.movieApp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import dii2dam.movieApp.App;
import dii2dam.movieApp.models.User;
import dii2dam.movieApp.utils.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class SignUp {

    @FXML
    private Button btnContinue;

    @FXML
    private Button btnLogIn;

    @FXML
    private Label lblConfirm;

    @FXML
    private Label lblMail;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsername;

    @FXML
    private PasswordField txtConfirm;

    @FXML
    private TextField txtMail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

	@FXML
	void loadUser(ActionEvent event) {
		boolean error = false;
		String message = "";
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		// Regular text check: format □*
		if (!(txtUsername.getText().length() >= 1)) {
		  error = true;
		  message += "El nombre y/o el apellido no está ingresado." + "\n";
		}
		// Email check: format □*@□*.□□*
		if (!(txtMail.getText().contains("@") && txtMail.getText().contains(".") && txtMail.getText().length() >= 6)) {
		  error = true;
		  message += "El e-mail no tiene un formato correcto (□*@□*.□□*) o no está ingresado." + "\n";
		}
		// Email check: must not exist already
		if (Manager.emails.contains(txtMail.getText())) {
		  error = true;
		  message += "El e-mail con el que intenta registrarse ya está en uso." + "\n";
		}
		// Password check: format □*, must match
		if (!(txtPassword.getText().length() >= 1 && txtPassword.getText().equals(txtConfirm.getText()))) {
		  error = true;
		  message += "Las contraseñas no coinciden o no están ingresadas." + "\n";
		}
		if (!error) {
			User user = new User(txtUsername.getText(), txtPassword.getText(), sdf.format(new Date()), txtMail.getText());
			try {
			  App.setRoot("logIn");
			  System.out.println(user.getUsername() + "\n" + user.getPassword() + "\n" + user.getSignDate() + "\n" + user.getMail());
			} catch (IOException e) {
			  // TODO Auto-generated catch block
			  e.printStackTrace();
			}
		} else {
	      Alert alert = new Alert(AlertType.ERROR);
	      alert.setTitle("Error");
	      alert.setHeaderText(null);
	      alert.setContentText(message);
	      alert.showAndWait();
		}
	}
	
	@FXML
	void logIn(ActionEvent event) {
	  try {
		App.setRoot("logIn");
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
	}
}