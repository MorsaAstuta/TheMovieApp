package dii2dam.movieApp.controller;

import java.io.File;
import java.io.IOException;

import dii2dam.movieApp.App;
import dii2dam.movieApp.models.Director;
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

	@FXML
	private Label textSinopsis;
	@FXML
	private Pane btnMyList;
	
	@FXML
	private ImageView ratingMovie;

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

			//textTime.setText(String.valueOf(movie.getTime()));

			////////////
			textGenre.setText(movie.getGenre() != null ? movie.getGenre() : "Género no especificado");
			textSinopsis.setText(movie.getOverview() != null ? movie.getOverview() : "Sinopsis no especificada");
			textComment1.setText(movie.getReview());

			String url = movie.getPosterPath();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
			Image image = new Image(urlPoster);
			posterMovie.setImage(image);
			
			btnMyList.setVisible(false);
			
			Double ratingGlobal = movie.getRatingGlobal();
			// Cargar imagen del rating
			if (ratingGlobal == 1.0) {
				try {
					File file = new File("");
					String localUrl = file.toURI().toURL().toString();
					Image image1 = new Image(localUrl);
					ratingMovie.setImage(image1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ratingGlobal == 2.0) {
				try {
					File file = new File("");
					String localUrl = file.toURI().toURL().toString();
					Image image1 = new Image(localUrl);
					ratingMovie.setImage(image1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ratingGlobal == 3.0) {
				try {
					File file = new File("");
					String localUrl = file.toURI().toURL().toString();
					Image image1 = new Image(localUrl);
					ratingMovie.setImage(image1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ratingGlobal == 4.0) {
				try {
					File file = new File("");
					String localUrl = file.toURI().toURL().toString();

					Image image1 = new Image(localUrl);

					ratingMovie.setImage(image1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			if (ratingGlobal == 5.0) {
				try {
					File file = new File("");
					String localUrl = file.toURI().toURL().toString();

					Image image1 = new Image(localUrl);

					ratingMovie.setImage(image1);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		 

	}

}
