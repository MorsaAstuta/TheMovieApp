package dii2dam.movieApp.controller;

import java.io.IOException;
import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.UserDaoImpl;
import dii2dam.movieApp.utils.HibernateUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class ForgotPass {

	private UserDaoImpl userDao = new UserDaoImpl(HibernateUtils.session);
	
	@FXML
	private Button btnCheck;

	@FXML
	private Button btnLogIn;

	@FXML
	private Label lblMail;

	@FXML
	private Label lblPass;

	@FXML
	private Label lblUsername;

	@FXML
	private Label lblDesc;

	@FXML
	private TextField txtMail;

	@FXML
	private TextField txtPass;

	@FXML
	private TextField txtUsername;

	@FXML
	void loadPass(ActionEvent event) {
		boolean error = false;
		String message = "";
		// Regular text check: format □*
		if (!(txtUsername.getText().length() >= 1)) {
			error = true;
			message += "The user field is empty." + "\n";
		}
		// Email check: format □*@□*.□□*
		if (!(txtMail.getText().contains("@") && txtMail.getText().contains(".") && txtMail.getText().length() >= 6)) {
			error = true;
			message += "The e-mail is not formatted correctly (□*@□*.□□*) or its field is empty." + "\n";
		}
		if (!error) {
			if (userDao.searchByEmail(txtMail.getText()).getPassword()
					.equals(userDao.searchByUsername(txtUsername.getText()).getPassword())) {
				txtPass.setText(userDao.searchByEmail(txtMail.getText()).getPassword());
			} else {
				Alert alert = new Alert(AlertType.ERROR);
				alert.setTitle("Error");
				alert.setHeaderText(null);
				alert.setContentText("Could not find a password for this username/e-mail combination.");
				alert.showAndWait();
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
			e.printStackTrace();
		}
	}
}
