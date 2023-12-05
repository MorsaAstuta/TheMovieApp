package dii2dam.movieApp.controller;

import java.io.IOException;

import dii2dam.movieApp.App;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
