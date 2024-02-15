package dii2dam.movieApp.controller;

import java.io.IOException;

import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.UserDaoImpl;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfigureAccount {
	@FXML
	private Label idLabelEmail;

	@FXML
	private PasswordField idPasswordField;

	@FXML
	private Label idLabelUsername;

	@FXML
	private TextField textFieldEmail;
	@FXML
	private PasswordField passwordCheck;

	@FXML
	private TextField textFieldUsername;


	public void initialize() {

		if (Manager.user != null) {
			idLabelEmail.setText("Email: " + Manager.user.getMail());
			idPasswordField.setText(Manager.user.getPassword());
			idLabelUsername.setText("Username " + Manager.user.getUsername());
			textFieldUsername.setVisible(false);
			textFieldUsername.setText(Manager.user.getUsername());
			textFieldEmail.setVisible(false);
			textFieldEmail.setText(Manager.user.getMail());
			idPasswordField.setEditable(false);

		}

	}

	@FXML
	void changeEmailUser(MouseEvent event) {
		textFieldEmail.setVisible(true);

	}

	@FXML
	void changeLabelUsername(MouseEvent event) {
		textFieldUsername.setVisible(true);

	}

	@FXML
	void changePasswordUser(MouseEvent event) {
		idPasswordField.setEditable(true);

	}


	@FXML
	void saveAllChanges(MouseEvent event) {

		if (passwordCheck.getText().equals(Manager.user.getPassword())) {
			Manager.user.setMail(textFieldEmail.getText());
			Manager.user.setUsername(textFieldUsername.getText());
			Manager.user.setPassword(idPasswordField.getText());
			UserDaoImpl userDao = new UserDaoImpl(HibernateUtils.session);
			userDao.update(Manager.user);
			try {
				App.setRoot("accountPage");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			Stage popupStage = new Stage();
			popupStage.initModality(Modality.APPLICATION_MODAL); //
			popupStage.setTitle("Ventana Emergente");

			// Contenido de la ventana emergente
			Label label = new Label("Error, la contraseña es incorrecta,\n prueba de nuevo por favor.");
			Button closeButton = new Button("Cerrar");
			closeButton.setOnAction(e -> popupStage.close());
			VBox popupLayout = new VBox(10);
			popupLayout.setPadding(new Insets(20));
			popupLayout.getChildren().addAll(label, closeButton);

			// Escena de la ventana emergente
			Scene popupScene = new Scene(popupLayout, 300, 250);
			popupStage.setScene(popupScene);

			// Mostramos la ventana emergente
			popupStage.showAndWait();
		}

	}

	@FXML
	void goBack(MouseEvent event) {

		try {
			App.setRoot("accountPage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

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
