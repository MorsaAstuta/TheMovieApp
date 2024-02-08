package dii2dam.movieApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dii2dam.movieApp.App;
import dii2dam.movieApp.models.Actor;
import dii2dam.movieApp.models.Director;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieInfoResponse;
import dii2dam.movieApp.models.CreditsResponse;
import dii2dam.movieApp.models.Review;
import dii2dam.movieApp.models.ReviewResponse;
import dii2dam.movieApp.utils.Connector;
import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MovieRecord {
	private CreditsResponse creditsResponse;
	private MovieInfoResponse movieInfoResponse;
	private ReviewResponse reviewResponse;

	private List<Actor> actors = new ArrayList<>();
	private Integer actorPage = 1;
	
	private List<Director> directors = new ArrayList<>();
	
	private List<Review> reviews = new ArrayList<>();
	private Integer reviewPage = 1;

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

	public void getMovieDetails(String type, Integer id, Integer page) {
		try {
			creditsResponse = Connector.getMovieCredits(type, id);
			movieInfoResponse = Connector.getMovieInfo(type, id);
			reviewResponse = Connector.getMovieReviews(type, id, page);
			creditsResponse.revampArrays();
			actors = creditsResponse.getActors();
			directors = creditsResponse.getDirectors();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void initialize() {
		movie = Manager.movie;
		System.out.println(movie.getId());
		getMovieDetails(movie.getMedia_type(), Integer.parseInt(movie.getId().toString()), reviewPage);
		if (movie != null) {
			textTittle.setText(movie.getTitle() != null ? movie.getTitle() : "Titulo no especificado");
			textDate.setText(movie.getReleaseDate() != null ? movie.getReleaseDate() : "Fecha de estreno no especificada");
			if (movie != null && !directors.isEmpty()) {
				String output = "";
				for (Director director : directors) {
					output += director.getName();
					if (directors.indexOf(director) != directors.size() - 1) {
						output += ", ";
					}
				}
				textDirector.setText(output);
			} else {
				textDirector.setText("Director no disponible");
			}

			// No carga

			textTime.setText(movieInfoResponse.getRuntime().toString() + " min.");

			////////////
			textGenre.setText(movie.getGenre() != null ? movie.getGenre() : "Género no especificado");
			textSinopsis.setText(movie.getOverview() != null ? movie.getOverview() : "Sinopsis no especificada");

			String url = movie.getPosterPath();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
			Image image = new Image(urlPoster);
			posterMovie.setImage(image);

			rate.setText(movie.getRatingGlobal().toString() + " / 10");
			btnMyList.setVisible(false);
		}
		loadActors();
		loadReviews();

	}

	private void loadActors() {
		for (Actor actor : actors) {
			String url = actor.getProfilePath();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
			Image image = new Image(urlPoster);
			if (actors.indexOf(actor) == (actorPage-1)*4+0) {
				imgActor1.setImage(image);
			}
			if (actors.indexOf(actor) == (actorPage-1)*4+1) {
				imgActor2.setImage(image);
			}
			if (actors.indexOf(actor) == (actorPage-1)*4+2) {
				imgActor3.setImage(image);
			}
			if (actors.indexOf(actor) == (actorPage-1)*4+3) {
				imgActor4.setImage(image);
			}
		}
	}

	private void loadReviews() {
		reviews.clear();
		
		for (Review review : reviewResponse.getReviews()) {
			reviews.add(review);
		}
		
		for (Review review : reviews) {
			if (reviews.indexOf(review) == (reviewResponse.getPage()-1)*3+0) {
				textComment1.setText(review.getContent());
			}
			if (reviews.indexOf(review) == (reviewResponse.getPage()-1)*3+1) {
				textComment2.setText(review.getContent());
			}
			if (reviews.indexOf(review) == (reviewResponse.getPage()-1)*3+2) {
				textComment3.setText(review.getContent());
			}
		}
	}

}
