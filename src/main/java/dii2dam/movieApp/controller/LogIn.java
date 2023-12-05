package dii2dam.movieApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

import dii2dam.movieApp.App;
import dii2dam.movieApp.utils.*;

public class LogIn {

  @FXML
  private TextField txtUsername;

  @FXML
  private PasswordField txtPassword;
  
  @FXML
  private Button btnSignUp;
  
  @FXML
  private Button btnContinue;

  @FXML
  void loadUser(ActionEvent event) {
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
}
