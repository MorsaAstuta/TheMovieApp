package dii2dam.movieApp.controller;

import java.io.IOException;
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

public class LogIn {

    @FXML
    private Button btnContinue;

    @FXML
    private Button btnForgot;

    @FXML
    private Button btnSignUp;

    @FXML
    private Label lblPassword;

    @FXML
    private Label lblUsername;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private TextField txtUsername;

  @FXML
  void loadUser(ActionEvent event) {
	// Comprobamos que el usuario existe y abrimos ventana
	if(Manager.userByName.containsKey(txtUsername.getText())) {
	  // Si el usuario existe, iteramos para detectarlo y mostrar sus datos en la pantalla menú
	  User user = Manager.userByName.get(txtUsername.getText());
	  if (user.getUsername().equals(txtUsername.getText())) {
		if (user.getPassword().equals(txtPassword.getText())) {
		  Alert alert = new Alert(AlertType.INFORMATION);
		  alert.setTitle("Error");
		  alert.setHeaderText(null);
		  alert.setContentText("Access granted.");
		  alert.showAndWait();
		  Manager.logIn(user);
		} else {
		  Alert alert = new Alert(AlertType.ERROR);
		  alert.setTitle("Error");
		  alert.setHeaderText(null);
		  alert.setContentText("Wrong password.");
		  alert.showAndWait();
		}
	  }
	} else {
      Alert alert = new Alert(AlertType.ERROR);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("The input username is not associated with any account in our database.");
      alert.showAndWait();
	}
  }
  
  @FXML
  void signUp(ActionEvent event) {
	try {
	  App.setRoot("signUp");
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
  }
  
  @FXML
  void forgotPass(ActionEvent event) {
	try {
	  App.setRoot("forgotPass");
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setTitle("Error");
      alert.setHeaderText(null);
      alert.setContentText("This section is still a WIP - the Account Recovery system will change to become more secure in future updates.");
      alert.showAndWait();
	} catch (IOException e) {
	  // TODO Auto-generated catch block
	  e.printStackTrace();
	}
  }
}
