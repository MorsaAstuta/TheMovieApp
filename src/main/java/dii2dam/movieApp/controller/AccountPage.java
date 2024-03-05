package dii2dam.movieApp.controller;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.MovieDaoImpl;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class AccountPage {

	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

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

	/**
	 * Initializes the FXML file
	 */
	@FXML
	public void initialize() {
		if (Manager.user != null) {

			// Sets user information
			idUsername.setText(Manager.user.getUsername());
			idEmail.setText(Manager.user.getMail());
			idLastConnect.setText(Manager.user.getRegister_date());

			// Shows highest rated movies
			List<Movie> movies = movieDao.searchMoviesByUserIdOrderByRating(Manager.getCurrentUser());
			if (movies.size() >= 1 && movies.get(0).getPoster_path() != null) {
				idImgPoster1.setImage(new Image(movies.get(0).getPoster_path()));
			}
			if (movies.size() >= 2 && movies.get(1).getPoster_path() != null) {
				idImgPoster2.setImage(new Image(movies.get(1).getPoster_path()));
			}
			if (movies.size() >= 3 && movies.get(2).getPoster_path() != null) {
				idImgPoster3.setImage(new Image(movies.get(2).getPoster_path()));
			}
			if (movies.size() >= 4 && movies.get(3).getPoster_path() != null) {
				idImgPoster4.setImage(new Image(movies.get(3).getPoster_path()));
			}
		}
	}

	/**
	 * Loads the homePage FXML
	 * 
	 * @param event
	 */
	@FXML
	void loadHomePage(MouseEvent event) {
		try {
			App.setRoot("homePage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the addMovie FXML
	 * 
	 * @param event
	 */
	@FXML
	void addMovie(MouseEvent event) {
		try {
			App.setRoot("addMovie");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the myList FXML
	 * 
	 * @param event
	 */
	@FXML
	void myList(MouseEvent event) {
		try {
			App.setRoot("myList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the configureAccount FXML
	 * 
	 * @param event
	 */
	@FXML
	void pageConfig(MouseEvent event) {
		try {
			App.setRoot("configureAccount");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the signOut FXML
	 * 
	 * @param event
	 */
	@FXML
	void signOut(MouseEvent event) {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Sign Out");
		alert.setHeaderText(null);
		alert.setContentText("Do you really want to finish your session and sign out?");
		Optional<ButtonType> buttonType = alert.showAndWait();
		if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
			try {
				App.setRoot("logIn");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Loads the last screen
	 */
	@FXML
	void goBack() {
		Manager.goToLastPage();
	}
}
