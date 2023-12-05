package dii2dam.movieApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;

import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.*;
import dii2dam.movieApp.utils.*;

public class SignUp {

	@FXML
	private TextField txtUsername;
	
	@FXML
	private PasswordField txtPassword;

	@FXML
	private PasswordField txtConfirm;

	@FXML
	private Button btnLogIn;

	@FXML
	private Button btnContinue;

	@FXML
	void loadUser(ActionEvent event) {
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