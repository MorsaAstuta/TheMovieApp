package dii2dam.movieApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.MovieDaoImpl;
import dii2dam.movieApp.models.Actor;
import dii2dam.movieApp.models.Director;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieInfoResponse;
import dii2dam.movieApp.models.CreditsResponse;
import dii2dam.movieApp.models.Review;
import dii2dam.movieApp.models.ReviewResponse;
import dii2dam.movieApp.utils.CSVUtils;
import dii2dam.movieApp.utils.Connector;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
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

	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

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
	private Button btnLeftActors;

	@FXML
	private Button btnRightActor;

	@FXML
	private Label labelNameAct1;

	@FXML
	private Label labelNameAct2;

	@FXML
	private Label labelNameAct3;

	@FXML
	private Label labelNameAct4;

	@FXML
	private Label labelUsernameReview1;

	@FXML
	private Label labelUsernameReview2;

	@FXML
	private Label labelUsernameReview3;

	@FXML
	private ImageView imgUserReview1;

	@FXML
	private ImageView imgUserReview2;

	@FXML
	private ImageView imgUserReview3;

	@FXML
	private Button btnAdd;

	/**
	 * Loads the accountPage FXML
	 * 
	 * @param event
	 */
	@FXML
	void goToAccount(MouseEvent event) {
		try {
			App.setRoot("accountPage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the homePage FXML
	 * 
	 * @param event
	 */
	@FXML
	void goToHomePage(MouseEvent event) {
		try {
			App.setRoot("homePage");
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
	void goToMyList(MouseEvent event) {
		try {
			App.setRoot("myList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the last screen
	 * 
	 * @param event
	 */
	@FXML
	void goBack(MouseEvent event) {
		Manager.goToLastPage();
	}

	/**
	 * Exports this entry as CSV file
	 * 
	 * @param event
	 */
	@FXML
	void exportAsCSV(MouseEvent event) {
		try {
			CSVUtils.export(movie);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Hides the My List text
	 * 
	 * @param event
	 */
	@FXML
	void retractMyList(MouseEvent event) {
		btnMyList.setVisible(false);
	}

	/**
	 * Shows the My List text
	 * 
	 * @param event
	 */
	@FXML
	void expandMyList(MouseEvent event) {
		btnMyList.setVisible(true);
	}

	/**
	 * Loads the movie details
	 * 
	 * @param type
	 * @param id
	 * @param page
	 */
	public void getMovieDetails(String type, Integer id, Integer page) {
		try {
			creditsResponse = Connector.getMovieCredits(type, id);
			movieInfoResponse = Connector.getMovieInfo(type, id);
			reviewResponse = Connector.getMovieReviews(type, id, page);

			reviews.clear();
			for (Review review : reviewResponse.getReviews()) {
				reviews.add(review);
			}
			creditsResponse.revampArrays();
			actors = creditsResponse.getActors();
			directors = creditsResponse.getDirectors();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Initializes the FXML
	 */
	@FXML
	public void initialize() {
		movie = Manager.getMovie();
		if (Manager.getDiscoveryType() != "multi") {
			getMovieDetails(Manager.getDiscoveryType(), Integer.parseInt(movie.getId().toString()), reviewPage);
		} else {
			getMovieDetails(movie.getMedia_type(), Integer.parseInt(movie.getId().toString()), reviewPage);
		}
		if (movie != null) {
			textTittle.setText(movie.getTitle() != null ? movie.getTitle() : "Titulo no especificado");
			textDate.setText(movie.getRelease_date() != null ? movie.getRelease_date() : "Fecha de estreno no especificada");
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

			textTime.setText(movieInfoResponse.getRuntime() + " min.");

			textGenre.setText(movie.getGenre());

			if (movie.getOverview() != null) {
				textSinopsis.setText(movie.getOverview());
			}

			String url = movie.getPoster_path();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
			Image image = new Image(urlPoster);
			posterMovie.setImage(image);

			rate.setText(movie.getVote_average().toString() + " / 10");
			btnMyList.setVisible(false);
		}

		ImageView btnSaveIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/save.png").toExternalForm());
		btnSaveIcon.setFitHeight(32);
		btnSaveIcon.setFitWidth(32);
		btnAdd.setGraphic(btnSaveIcon);

		visibleBtnLeft();
		loadActors();
		loadReviews();

	}

	/**
	 * Loads the current page of actors
	 */
	private void loadActors() {
		// Clear
		imgActor1.setImage(null);
		labelNameAct1.setText("");
		imgActor2.setImage(null);
		labelNameAct2.setText("");
		imgActor3.setImage(null);
		labelNameAct3.setText("");
		imgActor4.setImage(null);
		labelNameAct4.setText("");

		// Check button visibility
		visibleBtnLeft();
		visibleBtnRight();

		// Fill with next batch of actors
		for (Actor actor : actors) {
			String url = actor.getProfilePath();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
			Image image = new Image(urlPoster);
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 0) {
				imgActor1.setImage(image);
				labelNameAct1.setText(actor.getName());
			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 1) {
				imgActor2.setImage(image);
				labelNameAct2.setText(actor.getName());
			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 2) {
				imgActor3.setImage(image);
				labelNameAct3.setText(actor.getName());

			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 3) {
				imgActor4.setImage(image);
				labelNameAct4.setText(actor.getName());

			}
		}
	}

	/**
	 * Loads the top reviews
	 */
	private void loadReviews() {

		for (Review review : reviewResponse.getReviews()) {
			if (reviews.indexOf(review) == (reviewPage - 1) * 3 + 0) {
				labelUsernameReview1.setText(review.getUsername());
				textComment1.setText(review.getContent());
				String url1 = review.getAvatar_path();
				String urlAvatar = "https://image.tmdb.org/t/p/w500" + url1;
				Image image1 = new Image(urlAvatar);
				imgUserReview1.setImage(image1);
			}
			if (reviews.indexOf(review) == (reviewPage - 1) * 3 + 1) {
				labelUsernameReview2.setText(review.getUsername());
				textComment2.setText(review.getContent());
				String url2 = review.getAvatar_path();
				String urlAvatar = "https://image.tmdb.org/t/p/w500" + url2;
				Image image2 = new Image(urlAvatar);
				imgUserReview2.setImage(image2);
			}
			if (reviews.indexOf(review) == (reviewPage - 1) * 3 + 2) {
				labelUsernameReview3.setText(review.getUsername());
				textComment3.setText(review.getContent());
				String url3 = review.getAvatar_path();
				String urlAvatar = "https://image.tmdb.org/t/p/w500" + url3;
				Image image3 = new Image(urlAvatar);
				imgUserReview3.setImage(image3);
			}
		}
	}

	/**
	 * Shows or hides the right button depending on current page
	 */
	private void visibleBtnRight() {
		Integer actorTotalPages = actors.size() / 4;
		if (actors.size() % 4 != 0) {
			actorTotalPages++;
		}
		if (actorTotalPages == 0) {
			actorTotalPages++;
		}
		if (actorPage < actorTotalPages) {
			btnRightActor.setVisible(true);
		} else {
			btnRightActor.setVisible(false);
		}
	}

	/**
	 * Shows or hides the left button depending on current page
	 */
	private void visibleBtnLeft() {
		if (actorPage > 1) {
			btnLeftActors.setVisible(true);
		} else {
			btnLeftActors.setVisible(false);
		}
	}

	/**
	 * Saves the API entry as a local entry
	 * 
	 * @param event
	 */
	@FXML
	private void saveMovie(ActionEvent event) {

		// If movie is instance of TV series, set Title as Name
		if (movie.getTitle() == null) {
			movie.setTitle(movie.getName());
		}

		// Insert movie on database
		try {
			Movie newMovie = new Movie(movie.getTitle(), movie.getRelease_date(), movie.getOverview(), movie.getRuntime(),
					null, Manager.getCurrentUser(), "", 0.0);
			movieDao.insert(newMovie);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Movie successfully added to My List.");
			alert.showAndWait();
			// Loads myListRecord FXML to visualize the new entry
			Manager.setMovie(newMovie);
			try {
				App.setRoot("myListRecord");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (Exception e) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Movie could not be added to My List.");
			alert.showAndWait();
		}
	}

	/**
	 * Loads previous actor page
	 * 
	 * @param event
	 */
	@FXML
	void pressedActorsLeft(MouseEvent event) {
		if (actorPage > 1) {
			actorPage--;
			loadActors();
		}
	}

	/**
	 * Loads next actor page
	 * 
	 * @param event
	 */
	@FXML
	void pressedActorsRight(MouseEvent event) {
		if (actorPage >= 1) {
			actorPage++;
			loadActors();
		}

	}

}