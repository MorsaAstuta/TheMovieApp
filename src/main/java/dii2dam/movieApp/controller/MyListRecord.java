package dii2dam.movieApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.ActorDaoImpl;
import dii2dam.movieApp.dao.CastDaoImpl;
import dii2dam.movieApp.dao.DirectionDaoImpl;
import dii2dam.movieApp.dao.DirectorDaoImpl;
import dii2dam.movieApp.dao.GenreDaoImpl;
import dii2dam.movieApp.dao.LocationDaoImpl;
import dii2dam.movieApp.dao.MovieDaoImpl;
import dii2dam.movieApp.dao.MovieGenreDaoImpl;
import dii2dam.movieApp.models.Actor;
import dii2dam.movieApp.models.Cast;
import dii2dam.movieApp.models.Director;
import dii2dam.movieApp.models.Genre;
import dii2dam.movieApp.models.Location;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieGenre;
import dii2dam.movieApp.models.Direction;
import dii2dam.movieApp.utils.CSVUtils;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MyListRecord {

	private Movie movie;
	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

	private ActorDaoImpl actorDao = new ActorDaoImpl(HibernateUtils.session);
	private CastDaoImpl castDao = new CastDaoImpl(HibernateUtils.session);
	private List<Actor> actors = new ArrayList<>();

	private DirectorDaoImpl directorDao = new DirectorDaoImpl(HibernateUtils.session);
	private DirectionDaoImpl directionDao = new DirectionDaoImpl(HibernateUtils.session);
	private List<Director> directors = new ArrayList<>();

	private GenreDaoImpl genreDao = new GenreDaoImpl(HibernateUtils.session);
	private MovieGenreDaoImpl movieGenreDao = new MovieGenreDaoImpl(HibernateUtils.session);
	private List<Genre> genres = new ArrayList<>();

	private LocationDaoImpl locationDao = new LocationDaoImpl(HibernateUtils.session);
	private List<Location> locations = new ArrayList<>();

	private Integer actorPage = 1;

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
	private Label txtDate;

	@FXML
	private Label txtDirector;

	@FXML
	private Label txtGenre;

	@FXML
	private Label txtOverview;

	@FXML
	private Label txtRelease;

	@FXML
	private Label txtRating;

	@FXML
	private Label txtRuntime;

	@FXML
	private Label txtReview;

	@FXML
	private Label txtTitle;

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
	private ComboBox<String> cmbLocations;

	@FXML
	private ComboBox<String> cmbStatus;

	@FXML
	private Pane expMyList;

	@FXML
	private Button btnEdit;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnDelete;

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
		expMyList.setVisible(false);
	}

	/**
	 * Shows the My List text
	 * 
	 * @param event
	 */
	@FXML
	void expandMyList(MouseEvent event) {
		expMyList.setVisible(true);

	}

	/**
	 * Initializes the FXML
	 */
	@FXML
	public void initialize() {
		movie = Manager.getMovie();

		expMyList.setVisible(false);

		ImageView btnDeleteIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/rem.png").toExternalForm());
		btnDeleteIcon.setFitHeight(32);
		btnDeleteIcon.setFitWidth(32);
		btnDelete.setGraphic(btnDeleteIcon);

		ImageView btnSaveIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/save.png").toExternalForm());
		btnSaveIcon.setFitHeight(32);
		btnSaveIcon.setFitWidth(32);
		btnSave.setGraphic(btnSaveIcon);

		ImageView btnEditIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/edit.png").toExternalForm());
		btnEditIcon.setFitHeight(48);
		btnEditIcon.setFitWidth(48);
		btnEdit.setGraphic(btnEditIcon);

		for (Cast cast : castDao.searchByMovieId(movie.getId())) {
			actors.add(actorDao.searchById(cast.getActor_id()));
		}

		for (Direction direction : directionDao.searchByMovieId(movie.getId())) {
			directors.add(directorDao.searchById(direction.getDirector_id()));
		}

		for (MovieGenre movieGenre : movieGenreDao.searchByMovieId(movie.getId())) {
			genres.add(genreDao.searchById(movieGenre.getGenre_id()));
		}

		// Cargamos el combobox de ubicaciones
		locations.addAll(locationDao.searchLocationsByUser(Manager.getCurrentUser()));
		ObservableList<String> locationNames = FXCollections.observableArrayList();
		locationNames.add(null);
		for (Location location : locations) {
			locationNames.add(location.getName());
		}
		cmbLocations.setItems(locationNames);

		// Cargamos el combobox de estados
		ObservableList<String> statuses = FXCollections.observableArrayList();
		statuses.add(null);
		statuses.add("Unwatched");
		statuses.add("Watching");
		statuses.add("On hold");
		statuses.add("Dropped");
		cmbStatus.setItems(statuses);

		// Load status if it's not null
		if (movie.getStatus() != null) {
			cmbStatus.getSelectionModel().select(movie.getStatus());
		}

		// Load location if it's not null
		if (movie.getLocation_id() != null) {
			cmbLocations.getSelectionModel().select(locationDao.searchById(movie.getLocation_id()).getName());
		}

		// Load poster if it's not null
		if (movie.getPoster_path() != null) {
			posterMovie.setImage(new Image(movie.getPoster_path()));
		}

		// Load directors
		String strDirector = "";
		for (Director director : directors) {
			if (directors.indexOf(director) != 0) {
				strDirector += ", ";
			}
			strDirector += director.getName();
		}
		txtDirector.setText(strDirector);

		// Load genres
		String strGenre = "";
		for (Genre genre : genres) {
			if (genres.indexOf(genre) != 0) {
				strGenre += ", ";
			}
			strGenre += genre.getName();
		}
		txtGenre.setText(strGenre);

		txtTitle.setText(movie.getTitle());
		txtRuntime.setText(movie.getRuntime() + "");
		txtOverview.setText(movie.getOverview());
		txtRating.setText(movie.getRating() + " / 10");
		txtRelease.setText(movie.getRelease_date());
		txtReview.setText(movie.getReview());

		visibleBtnLeft();
		loadActors();

	}

	/**
	 * Loads the current actor page
	 */
	private void loadActors() {
		for (Actor actor : actors) {
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 0) {
				labelNameAct1.setText(actor.getName());
			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 1) {
				labelNameAct2.setText(actor.getName());
			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 2) {
				labelNameAct3.setText(actor.getName());
			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 3) {
				labelNameAct4.setText(actor.getName());
			}
			visibleBtnLeft();
			visibleBtnRight();
		}
	}

	/**
	 * Shows or hides the left button depending on current page
	 */
	private void visibleBtnLeft() {
		if (actorPage > 1)
			btnLeftActors.setVisible(true);
		else
			btnLeftActors.setVisible(false);
	}

	/**
	 * Shows or hides the right button depending on current page
	 */
	private void visibleBtnRight() {
		Integer actorTotalPages = actors.size() / 4;
		if (actors.size() % 4 != 0) {
			actorTotalPages++;
		}
		if (actorPage < actorTotalPages)
			btnRightActor.setVisible(true);
		else
			btnRightActor.setVisible(false);
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

	/**
	 * Saves selected status and location
	 * 
	 * @param event
	 */
	@FXML
	void saveStatusAndLocation(ActionEvent event) {
		movie.setStatus(cmbStatus.getValue());
		movie.setLocation_id(
				locationDao.searchLocationByUserIdAndName(Manager.getCurrentUser(), cmbLocations.getValue()).getId());
		movieDao.update(movie);
	}

	/**
	 * Deletes entry
	 * 
	 * @param event
	 */
	@FXML
	void deleteMovie(ActionEvent event) {
		movieDao.delete(movie);
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Information");
		alert.setHeaderText(null);
		alert.setContentText("Entry successfully deleted.");
		alert.showAndWait();
		try {
			App.setRoot("myList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
