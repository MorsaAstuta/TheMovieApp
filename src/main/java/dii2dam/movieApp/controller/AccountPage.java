package dii2dam.movieApp.controller;

import java.io.IOException;

import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.UserDaoImpl;
import dii2dam.movieApp.models.User;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class AccountPage {

	@FXML
	private Pane btnAdd;

	@FXML
	private Pane btnConfig;

	@FXML
	private Pane btnMyList;

	@FXML
	private Pane btnSignOut;

	@FXML
	private Label idEmail;

	@FXML
	private Label idLastConnect;

	@FXML
	private Label idUsername;

	@FXML
	private Label ifFullUsername;


	

	public void initialize() {
		TextField txtUsernameField = Manager.getTxtUsername();
		String username = txtUsernameField.getText();
		idUsername.setText(username);
		String txtEmailField = Manager.getUser();
		System.out.println(txtEmailField);

		idEmail.setText(txtEmailField);

	}

	@FXML
	void loadHomePage(MouseEvent event) {
		try {
			App.setRoot("HomePage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void addMovie(MouseEvent event) {
		try {
			App.setRoot("addMovie");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void myList(MouseEvent event) {
		try {
			App.setRoot("myList");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void pageConfig(MouseEvent event) {

	}

	@FXML
	void signOut(MouseEvent event) {

	}

	@FXML
	void goBack() {
		Manager.goToLastPage();
	}
}
