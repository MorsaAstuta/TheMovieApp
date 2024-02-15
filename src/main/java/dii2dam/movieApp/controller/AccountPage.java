package dii2dam.movieApp.controller;

import java.io.IOException;

import dii2dam.movieApp.App;
import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
	private ImageView idImgPoster1;

    @FXML
    private ImageView idImgPoster2;

    @FXML
    private ImageView idImgPoster3;

    @FXML
    private ImageView idImgPoster4;

	public void initialize() {
		if (Manager.user != null) {
			idUsername.setText(Manager.user.getUsername());
			idEmail.setText(Manager.user.getMail());
			idLastConnect.setText(Manager.user.getRegister_date());
		}
		if (Manager.movie != null) {
			String poster = Manager.movie.getPoster_path();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + poster;
			Image image = new Image(urlPoster);
			idImgPoster1.setImage(image);
			idImgPoster2.setImage(image);
			idImgPoster3.setImage(image);
			idImgPoster4.setImage(image);
		}

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
		try {
			App.setRoot("configureAccount");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void signOut(MouseEvent event) {

	}

	@FXML
	void goBack() {
		Manager.goToLastPage();
	}
}
