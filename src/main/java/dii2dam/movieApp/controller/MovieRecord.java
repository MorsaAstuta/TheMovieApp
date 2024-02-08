package dii2dam.movieApp.controller;

import java.io.IOException;

import java.util.Set;

import dii2dam.movieApp.App;
import dii2dam.movieApp.models.Actor;

import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MovieRecord {
	@FXML
	private ImageView imgActor1;

	@FXML
	private ImageView imgActor2;

	@FXML
	private ImageView imgActor3;

	@FXML
	private ImageView imgActor4;

	@FXML
	private ImageView posterMovie;

	@FXML
	private Label textComment1;

	@FXML
	private Label textComment2;

	@FXML
	private Label textComment3;

	@FXML
	private Label textDate;

	@FXML
	private Label textDirector;

	@FXML
	private Label textGenre;
	private Actor actor;

	@FXML
	private Label textSinopsis;
	@FXML
	private Pane btnMyList;

	@FXML
	private Label rate;

	@FXML
	private Label textTime;

	@FXML
	private Label textTittle;

	private Movie movie;

	@FXML
	void goToAccount(MouseEvent event) {
		try {
			App.setRoot("accountPage");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void goToHomePage(MouseEvent event) {

		try {
			App.setRoot("SearchTab");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void retractMyList(MouseEvent event) {
		btnMyList.setVisible(false);
	}

	@FXML
	void expandMyList(MouseEvent event) {
		btnMyList.setVisible(true);

	}

	public void initialize() {
		movie = Manager.movie;
		if (movie != null) {
			textTittle.setText(movie.getTitle() != null ? movie.getTitle() : "Titulo no especificado");
			textDate.setText(
					movie.getReleaseDate() != null ? movie.getReleaseDate() : "Fecha de estreno no especificada");
			if (movie != null && movie.getDirector() != null) {
				textDirector.setText(movie.getDirector().getName());
			} else {
				textDirector.setText("Director no disponible");
			}

			// No carga

			// textTime.setText(String.valueOf(movie.getTime()));

			////////////
			textGenre.setText(movie.getGenre() != null ? movie.getGenre() : "Género no especificado");
			textSinopsis.setText(movie.getOverview() != null ? movie.getOverview() : "Sinopsis no especificada");
			textComment1.setText(movie.getReview());

			String url = movie.getPosterPath();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
			Image image = new Image(urlPoster);
			posterMovie.setImage(image);

			rate.setText(movie.getRatingGlobal().toString() + " / 10");
			btnMyList.setVisible(false);

		}
		Set<Actor> actors = movie.getActors();

		int i = 1;
		for (Actor actor : actors) {
			String actorImageUrl = actor.getActor_path();
			ImageView currentImageView = null;
			switch (i) {
			case 1:
				currentImageView = imgActor1;
				break;
			case 2:
				currentImageView = imgActor2;
				break;
			case 3:
				currentImageView = imgActor3;
				break;
			case 4:
				currentImageView = imgActor4;
				break;
			default:
				break;
			}
			if (currentImageView != null) {
				Image image = new Image(actorImageUrl);
				currentImageView.setImage(image);
			}
			i++;
		}

	}

}
