package dii2dam.movieApp.controller;

import java.io.IOException;

import dii2dam.movieApp.App;
import dii2dam.movieApp.utils.Connector;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ApiTest {
	
	@FXML
	public static TextField textPelicula;

	@FXML
	void buscarPressed(ActionEvent event) throws IOException {
	  Connector.Connect(textPelicula.getText());
	}
}
