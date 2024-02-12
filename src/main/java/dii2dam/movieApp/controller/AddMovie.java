package dii2dam.movieApp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
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
import dii2dam.movieApp.models.a;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
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
	private ColumnConstraints clmMyList;

	@FXML
	private Button btnSave;

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
	private Pane expMyList;

	@FXML
	private ImageView posterMovie;

	@FXML
	private TableView<Actor> tblActors;

	@FXML
	private TableView<Director> tblDirectors;

	@FXML
	private TableView<Genre> tblGenres;

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
	private List<a> locations = new ArrayList<>();

	@FXML
	void initialize() {
		expMyList.setVisible(false);
		clmMyList.setMaxWidth(1);

		genres.addAll(genreDao.searchAll());
		actors.addAll(actorDao.searchAll());
		directors.addAll(directorDao.searchAll());
		locations.addAll(locationDao.searchLocationsByUser(Manager.getCurrentUser()));

		ObservableList<String> genreNames = FXCollections.observableArrayList();
		ObservableList<String> actorNames = FXCollections.observableArrayList();
		ObservableList<String> directorNames = FXCollections.observableArrayList();
		ObservableList<String> locationNames = FXCollections.observableArrayList();

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

		for (a location : locations) {
			locationNames.add(location.getName());
		}
	}

	@FXML
	void expandMyList(MouseEvent event) {
		expMyList.setVisible(true);
		clmMyList.setMaxWidth(160);
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
	void retractMyList(MouseEvent event) {
		expMyList.setVisible(false);
		clmMyList.setMaxWidth(1);
	}

	@FXML
	void saveMovie() {
		if (!txtTitle.getText().isEmpty()) {
			movieDao.insert(new Movie(txtTitle.getText(), sdf.format(dateSelector.getValue()), txtOverview.getText(),
					Integer.parseInt(txtRuntime.getText()), null, Manager.getCurrentUser(),
					locationDao.searchLocationByUserIdAndName(Manager.getCurrentUser(), cmbLocation.getValue()).getId()));
		}
	}

}
