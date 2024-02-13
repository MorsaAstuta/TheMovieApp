package dii2dam.movieApp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.ActorDaoImp;
import dii2dam.movieApp.dao.DirectorDaoImp;
import dii2dam.movieApp.dao.GenreDaoImp;
import dii2dam.movieApp.dao.LocationDaoImpl;
import dii2dam.movieApp.dao.MovieDaoImpl;
import dii2dam.movieApp.models.Actor;
import dii2dam.movieApp.models.Director;
import dii2dam.movieApp.models.Genre;
import dii2dam.movieApp.models.Location;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.Pane;

public class AddMovie {

	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

	private GenreDaoImp genreDao = new GenreDaoImp(HibernateUtils.session);

	private ActorDaoImp actorDao = new ActorDaoImp(HibernateUtils.session);

	private DirectorDaoImp directorDao = new DirectorDaoImp(HibernateUtils.session);

	private LocationDaoImpl locationDao = new LocationDaoImpl(HibernateUtils.session);

	@FXML
	private Pane btnHome;

	@FXML
	private Button btnSave;

	@FXML
	private Button btnAddActor;

	@FXML
	private Button btnAddDirector;

	@FXML
	private Button btnAddGenre;

	@FXML
	private TableColumn<Actor, String> clmActors;

	@FXML
	private TableColumn<Director, String> clmDirectors;

	@FXML
	private TableColumn<Genre, String> clmGenres;

	@FXML
	private ComboBox<String> cmbActors;

	@FXML
	private ComboBox<String> cmbDirectors;

	@FXML
	private ComboBox<String> cmbGenres;

	@FXML
	private ComboBox<String> cmbLocation;

	@FXML
	private DatePicker dateSelector;

	@FXML
	private ImageView posterMovie;

	@FXML
	private TableView<Genre> tblGenres;

	@FXML
	private TableView<Director> tblDirectors;

	@FXML
	private TableView<Actor> tblActors;

	@FXML
	private TextArea txtOverview;

	@FXML
	private TextField txtRuntime;

	@FXML
	private TextField txtTitle;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private List<Genre> genres = new ArrayList<>();
	private List<Actor> actors = new ArrayList<>();
	private List<Director> directors = new ArrayList<>();
	private List<Location> locations = new ArrayList<>();

	private ObservableList<String> genreNames = FXCollections.observableArrayList();
	private ObservableList<String> actorNames = FXCollections.observableArrayList();
	private ObservableList<String> directorNames = FXCollections.observableArrayList();
	private ObservableList<String> locationNames = FXCollections.observableArrayList();

	private ObservableList<Genre> addedGenres = FXCollections.observableArrayList();
	private ObservableList<Actor> addedActors = FXCollections.observableArrayList();
	private ObservableList<Director> addedDirectors = FXCollections.observableArrayList();

	@FXML
	void initialize() {

		clmGenres.setCellValueFactory(new PropertyValueFactory<Genre, String>("name"));
		clmActors.setCellValueFactory(new PropertyValueFactory<Actor, String>("name"));
		clmDirectors.setCellValueFactory(new PropertyValueFactory<Director, String>("name"));

		genres.addAll(genreDao.searchAll());
		actors.addAll(actorDao.searchAll());
		directors.addAll(directorDao.searchAll());
		locations.addAll(locationDao.searchLocationsByUser(Manager.getCurrentUser()));

		tblGenres.setItems(addedGenres);
		tblActors.setItems(addedActors);
		tblDirectors.setItems(addedDirectors);

		cmbGenres.setItems(genreNames);
		cmbActors.setItems(actorNames);
		cmbDirectors.setItems(directorNames);
		cmbLocation.setItems(locationNames);

		for (Genre genre : genres) {
			genreNames.add(genre.getName());
		}

		for (Actor actor : actors) {
			actorNames.add(actor.getName());
		}

		for (Director director : directors) {
			directorNames.add(director.getName());
		}

		for (Location location : locations) {
			locationNames.add(location.getName());
		}

		ImageView btnSaveIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/save.png").toExternalForm());
		btnSaveIcon.setFitHeight(32);
		btnSaveIcon.setFitWidth(32);
		btnSave.setGraphic(btnSaveIcon);

	}

	@FXML
	void goBack(MouseEvent event) {
		Manager.goToLastPage();
	}

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
	void goToSearchTab(MouseEvent event) {
		try {
			App.setRoot("searchTab");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void importAsCSV(MouseEvent event) {

	}

	@FXML
	void saveMovie(ActionEvent event) {
		if (!txtTitle.getText().isEmpty()) {
			if (cmbLocation.getValue() != null) {
				Movie movie = new Movie(txtTitle.getText(),
						sdf.format(Date.from(dateSelector.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())),
						txtOverview.getText(), Integer.parseInt(txtRuntime.getText()), null, Manager.getCurrentUser(),
						locationDao.searchLocationByUserIdAndName(Manager.getCurrentUser(), cmbLocation.getValue()).getId());
				movieDao.insert(movie);
				Manager.setMovie(movie);
			} else {
				Movie movie = new Movie(txtTitle.getText(),
						sdf.format(Date.from(dateSelector.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())),
						txtOverview.getText(), Integer.parseInt(txtRuntime.getText()), null, Manager.getCurrentUser());
				movieDao.insert(movie);
				Manager.setMovie(movie);
			}
			try {
				App.setRoot("myListRecord");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void addGenre() {
		if (cmbGenres.getValue() != null) {
			Genre genre = new Genre(cmbGenres.getValue());
			if (genreDao.searchByGenreName(cmbGenres.getValue()) != null) {
				addedGenres.add(genreDao.searchByGenreName(cmbGenres.getValue()));
			} else {
				genreDao.insert(genre);
				addedGenres.add(genre);
				genreNames.add(genre.getName());
			}
		}
	}

	@FXML
	void addActor() {
		if (cmbActors.getValue() != null) {
			Actor actor = new Actor(cmbActors.getValue());
			if (actorDao.searchByName(cmbActors.getValue()) != null) {
				addedActors.add(actorDao.searchByName(cmbActors.getValue()));
			} else {
				actorDao.insert(actor);
				addedActors.add(actor);
				actorNames.add(actor.getName());
			}
		}
	}

	@FXML
	void addDirector() {
		if (cmbDirectors.getValue() != null) {
			Director director = new Director(cmbDirectors.getValue());
			if (directorDao.searchByName(cmbDirectors.getValue()) != null) {
				addedDirectors.add(directorDao.searchByName(cmbDirectors.getValue()));
			} else {
				directorDao.insert(director);
				addedDirectors.add(director);
				directorNames.add(director.getName());
			}
		}
	}

}
