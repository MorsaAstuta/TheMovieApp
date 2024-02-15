package dii2dam.movieApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.ActorDaoImp;
import dii2dam.movieApp.dao.CastDaoImpl;
import dii2dam.movieApp.dao.DirectionDaoImpl;
import dii2dam.movieApp.dao.DirectorDaoImp;
import dii2dam.movieApp.dao.GenreDaoImp;
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
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MyListRecord {

	private Movie movie;
	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

	private ActorDaoImp actorDao = new ActorDaoImp(HibernateUtils.session);
	private CastDaoImpl castDao = new CastDaoImpl(HibernateUtils.session);
	private List<Actor> actors = new ArrayList<>();

	private DirectorDaoImp directorDao = new DirectorDaoImp(HibernateUtils.session);
	private DirectionDaoImpl directionDao = new DirectionDaoImpl(HibernateUtils.session);
	private List<Director> directors = new ArrayList<>();

	private GenreDaoImp genreDao = new GenreDaoImp(HibernateUtils.session);
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

	@FXML
	void goToAccount(MouseEvent event) {
		try {
			App.setRoot("accountPage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goToHomePage(MouseEvent event) {
		try {
			App.setRoot("homePage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goToMyList(MouseEvent event) {
		try {
			App.setRoot("myList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goBack(MouseEvent event) {
		Manager.goToLastPage();
	}

	@FXML
	void exportAsCSV(MouseEvent event) {
	}

	@FXML
	void retractMyList(MouseEvent event) {
		expMyList.setVisible(false);
	}

	@FXML
	void expandMyList(MouseEvent event) {
		expMyList.setVisible(true);

	}

	public void initialize() {
		movie = Manager.getMovie();

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
		btnEditIcon.setFitHeight(64);
		btnEditIcon.setFitWidth(64);
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
		
		if (movie.getPoster_path() != null) {
			posterMovie.setImage(new Image(movie.getPoster_path()));
		}

		String strDirector = "";
		for (Director director : directors) {
			if (directors.indexOf(director) != 0) {
				strDirector += ", ";
			}
			strDirector += director.getName();
		}
		txtDirector.setText(strDirector);

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

	private void visibleBtnLeft() {
		if (actorPage > 1)
			btnLeftActors.setVisible(true);
		else
			btnLeftActors.setVisible(false);
	}

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

	@FXML
	void pressedActorsLeft(MouseEvent event) {
		if (actorPage > 1) {
			actorPage--;
			loadActors();
		}
	}

	@FXML
	void pressedActorsRight(MouseEvent event) {
		if (actorPage >= 1) {
			actorPage++;
			loadActors();
		}
	}

	@FXML
	void saveStatusAndLocation(ActionEvent event) {
		movie.setStatus(cmbStatus.getValue());
		movie.setLocation_id(
				locationDao.searchLocationByUserIdAndName(Manager.getCurrentUser(), cmbLocations.getValue()).getId());
		movieDao.update(movie);
	}

	@FXML
	void editMovie(ActionEvent event) {
	}

	@FXML
	void deleteMovie(ActionEvent event) {
		movieDao.delete(movie);
		try {
			App.setRoot("myList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
