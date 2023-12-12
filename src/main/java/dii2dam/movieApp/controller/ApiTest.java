package dii2dam.movieApp.controller;

import dii2dam.movieApp.App;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApiTest {
	
	@FXML
	public static TextField textPelicula;

	@FXML
	void buscarPressed(ActionEvent event) {
		App.response(textPelicula.getText());
	}
}
