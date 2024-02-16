package dii2dam.movieApp.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
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
import dii2dam.movieApp.models.Direction;
import dii2dam.movieApp.models.Director;
import dii2dam.movieApp.models.Genre;
import dii2dam.movieApp.models.Location;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieGenre;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class AddMovie {

	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

	private GenreDaoImp genreDao = new GenreDaoImp(HibernateUtils.session);

	private ActorDaoImp actorDao = new ActorDaoImp(HibernateUtils.session);

	private DirectorDaoImp directorDao = new DirectorDaoImp(HibernateUtils.session);

	private LocationDaoImpl locationDao = new LocationDaoImpl(HibernateUtils.session);

	private CastDaoImpl castDao = new CastDaoImpl(HibernateUtils.session);

	private DirectionDaoImpl directionDao = new DirectionDaoImpl(HibernateUtils.session);

	private MovieGenreDaoImpl movieGenreDao = new MovieGenreDaoImpl(HibernateUtils.session);

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

	@FXML
	private TextField txtRating;

	@FXML
	private TextArea txtReview;

	private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	private List<Location> locations = new ArrayList<>();

	private ObservableList<String> genreNames = FXCollections.observableArrayList();
	private ObservableList<String> actorNames = FXCollections.observableArrayList();
	private ObservableList<String> directorNames = FXCollections.observableArrayList();
	private ObservableList<String> locationNames = FXCollections.observableArrayList();

	private ObservableList<Genre> addedGenres = FXCollections.observableArrayList();
	private ObservableList<Actor> addedActors = FXCollections.observableArrayList();
	private ObservableList<Director> addedDirectors = FXCollections.observableArrayList();

	private String posterPath;

	@FXML
	void initialize() {

		clmGenres.setCellValueFactory(new PropertyValueFactory<Genre, String>("name"));
		clmActors.setCellValueFactory(new PropertyValueFactory<Actor, String>("name"));
		clmDirectors.setCellValueFactory(new PropertyValueFactory<Director, String>("name"));

		locations.addAll(locationDao.searchLocationsByUser(Manager.getCurrentUser()));

		tblGenres.setItems(addedGenres);
		tblActors.setItems(addedActors);
		tblDirectors.setItems(addedDirectors);

		cmbGenres.setItems(genreNames);
		cmbActors.setItems(actorNames);
		cmbDirectors.setItems(directorNames);
		cmbLocation.setItems(locationNames);

		for (Genre genre : genreDao.searchAll()) {
			genreNames.add(genre.getName());
		}

		for (Actor actor : actorDao.searchAll()) {
			actorNames.add(actor.getName());
		}

		for (Director director : directorDao.searchAll()) {
			directorNames.add(director.getName());
		}

		for (Location location : locations) {
			locationNames.add(location.getName());
		}

		ImageView btnSaveIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/save.png").toExternalForm());
		btnSaveIcon.setFitHeight(40);
		btnSaveIcon.setFitWidth(40);
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
			Movie movie;

			// Comprobamos si se ha añadido una imagen para crear una copia próxima cuya
			// dirección almacene la base de datos
			String newPath = null;
			String actualPath = null;
			if (posterPath != null) {
				String[] extension = posterPath.split("\\.");
				for (String string : extension) {
					System.out.println(string);
				}
				if ((extension[extension.length - 1].equals("png") || extension[extension.length - 1].equals("jpg")
						|| extension[extension.length - 1].equals("jpeg"))) {
					String[] fileName = posterPath.split("/");
					newPath = ("./src/main/resources/dii2dam/movieApp/posters/" + fileName[fileName.length - 1]);
					actualPath = ("/dii2dam/movieApp/posters/" + fileName[fileName.length - 1]);
					try {
						Files.copy(Paths.get(posterPath.replace("file:///", "")), Paths.get(newPath));
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}

			// Creamos el objeto Movie con los datos insertados en los campos de la
			// mitad izquierda de una forma u otra dependiendo de si se ha indicado
			// ubicación
			// física o no
			if (cmbLocation.getValue() != null) {
				if (locationDao.searchLocationByUserIdAndName(Manager.getCurrentUser(), cmbLocation.getValue()) == null) {
					locationDao.insert(new Location(cmbLocation.getValue()));
				}
				movie = new Movie(txtTitle.getText(),
						sdf.format(Date.from(dateSelector.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())),
						txtOverview.getText(), Integer.parseInt(txtRuntime.getText()), actualPath, Manager.getCurrentUser(),
						locationDao.searchLocationByUserIdAndName(Manager.getCurrentUser(), cmbLocation.getValue()).getId(),
						txtReview.getText(), Double.parseDouble(txtRating.getText()));
			} else {
				movie = new Movie(txtTitle.getText(),
						sdf.format(Date.from(dateSelector.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant())),
						txtOverview.getText(), Integer.parseInt(txtRuntime.getText()), actualPath, Manager.getCurrentUser(),
						txtReview.getText(), Double.parseDouble(txtRating.getText()));
			}
			movieDao.insert(movie);

			// Añadimos los actores, directores y géneros de la mitad derecha a las tablas
			// manyToMany acompañados del id autogenerado de esta nueva película
			for (Actor actor : addedActors) {
				castDao.insert(new Cast(movie.getId(), actor.getId()));
			}
			for (Director director : addedDirectors) {
				directionDao.insert(new Direction(movie.getId(), director.getId()));
			}
			for (Genre genre : addedGenres) {
				movieGenreDao.insert(new MovieGenre(movie.getId(), genre.getId()));
			}

			// Lanzamos automáticamente la pantalla para visualizar esta nueva película
			// insertada
			Manager.setMovie(movie);
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Information");
			alert.setHeaderText(null);
			alert.setContentText("Movie successfully added.");
			alert.showAndWait();
			try {
				App.setRoot("myListRecord");
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	@FXML
	void openPhotoSelector(ActionEvent event) {
		try {
			posterPath = "file:///" + App.loadFileChooser().getPath().replaceAll("\\\\", "/");
			posterMovie.setImage(new Image(posterPath));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void addGenre() {
		if (cmbGenres.getValue() != null) {
			Genre genre = new Genre(cmbGenres.getValue());
			if (genreDao.searchByGenreName(cmbGenres.getValue()) != null) {
				addedGenres.add(genreDao.searchByGenreName(cmbGenres.getValue()));
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText(null);
				alert.setContentText("New Genre successfully created.");
				alert.showAndWait();
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText(null);
				alert.setContentText("New Actor successfully created.");
				alert.showAndWait();
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
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Information");
				alert.setHeaderText(null);
				alert.setContentText("New Director successfully created.");
				alert.showAndWait();
			} else {
				directorDao.insert(director);
				addedDirectors.add(director);
				directorNames.add(director.getName());
			}
		}
	}

}
