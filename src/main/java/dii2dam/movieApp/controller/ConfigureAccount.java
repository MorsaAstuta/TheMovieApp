package dii2dam.movieApp.controller;

import java.io.IOException;

import dii2dam.movieApp.App;

import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;

import javafx.scene.input.MouseEvent;

public class ConfigureAccount {
	@FXML
	private Label idLabelEmail;

	@FXML
    private PasswordField idPasswordField;

	@FXML
	private Label idLabelUsername;


	public void initialize() {

		if (Manager.user != null) {
			idLabelEmail.setText("Email: "+Manager.user.getMail());
			idPasswordField.setText(Manager.user.getPassword());
			idLabelUsername.setText("Username "+Manager.user.getUsername());
		}

	}

	@FXML
	void changeEmailUser(MouseEvent event) {
		changeLabelToTextField(idLabelEmail);
	}

	@FXML
	void changeLabelUsername(MouseEvent event) {
		changeLabelToTextField(idLabelUsername);

	}

	@FXML
	void changePasswordUser(MouseEvent event) {

	}

	private void changeLabelToTextField(Label label) {
		
	}

	@FXML
	void saveAllChanges(MouseEvent event) {

	}

	@FXML
	void goBack(MouseEvent event) {

		Manager.goToLastPage();

	}

	@FXML
	void loadHomePage(MouseEvent event) {
		try {
			App.setRoot("homePage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
