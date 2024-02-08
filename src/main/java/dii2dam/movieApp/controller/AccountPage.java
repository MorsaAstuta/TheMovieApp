package dii2dam.movieApp.controller;

import java.io.IOException;

import dii2dam.movieApp.App;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
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
  @FXML
  void loadHomePage(MouseEvent event) {
	  try {
		App.setRoot("SearchTab");
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }

  @FXML
  void addMovie(MouseEvent event) {

  }

  @FXML
  void myList(MouseEvent event) {

  }

  @FXML
  void pageConfig(MouseEvent event) {

  }

  @FXML
  void signOut(MouseEvent event) {

  }
}
