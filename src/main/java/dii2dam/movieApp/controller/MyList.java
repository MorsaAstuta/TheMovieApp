package dii2dam.movieApp.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.GenreDaoImp;
import dii2dam.movieApp.dao.MovieDaoImpl;
import dii2dam.movieApp.dao.MovieGenreDaoImpl;
import dii2dam.movieApp.models.Genre;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;

public class MyList {
	
	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

	private GenreDaoImp genreDao = new GenreDaoImp(HibernateUtils.session);
	private MovieGenreDaoImpl movieGenreDao = new MovieGenreDaoImpl(HibernateUtils.session);
	private List<Genre> genres = new ArrayList<>();

	@FXML
	private Pane btnAccount;

	@FXML
	private Pane btnReturn;

	@FXML
	private Button btnNextPage;

	@FXML
	private Button btnPrevPage;

	@FXML
	private Button btnSearch;

	@FXML
	private ComboBox<String> cmbSorter = new ComboBox<>();

	@FXML
	private CheckBox chkSeries;

	@FXML
	private CheckBox chkMovies;

	@FXML
	private ComboBox<String> cmbGenre1 = new ComboBox<>();

	@FXML
	private ComboBox<String> cmbGenre2 = new ComboBox<>();

	@FXML
	private ComboBox<String> cmbGenre3 = new ComboBox<>();

	@FXML
	private ComboBox<String> cmbGenre4 = new ComboBox<>();

	@FXML
	private ComboBox<Integer> cmbLengthMax = new ComboBox<>();

	@FXML
	private ComboBox<Integer> cmbLengthMin = new ComboBox<>();

	@FXML
	private ComboBox<Integer> cmbScoreMax = new ComboBox<>();

	@FXML
	private ComboBox<Integer> cmbScoreMin = new ComboBox<>();

	@FXML
	private BorderPane filterTab;

	@FXML
	private RowConstraints filterTabRow;

	@FXML
	private Label lblBar;

	@FXML
	private Label lblCurrentPage;

	@FXML
	private Label lblMovieDate00;

	@FXML
	private Label lblMovieDate06;

	@FXML
	private Label lblMovieDate12;

	@FXML
	private Label lblMovieDesc00;

	@FXML
	private Label lblMovieDesc06;

	@FXML
	private Label lblMovieDesc12;

	@FXML
	private Label lblMovieGenre00;

	@FXML
	private Label lblMovieGenre06;

	@FXML
	private Label lblMovieGenre12;

	@FXML
	private Label lblMovieTitle00;

	@FXML
	private Label lblMovieTitle06;

	@FXML
	private Label lblMovieTitle12;

	@FXML
	private Label lblPage;

	@FXML
	private Label lblTotalPages;

	@FXML
	private GridPane movie00;

	@FXML
	private GridPane movie06;

	@FXML
	private GridPane movie12;

	@FXML
	private ColumnConstraints movieColumn00;

	@FXML
	private ColumnConstraints movieColumn06;

	@FXML
	private ColumnConstraints movieColumn12;

	@FXML
	private GridPane movieInfo00;

	@FXML
	private GridPane movieInfo06;

	@FXML
	private GridPane movieInfo12;

	@FXML
	private ColumnConstraints myListExtension;

	@FXML
	private ImageView poster00;

	@FXML
	private ImageView poster06;

	@FXML
	private ImageView poster12;

	@FXML
	private BorderPane searchBar;

	@FXML
	private TextField txtSearch;

	Map<ImageView, Movie> movieByPoster = new HashMap<>();
	List<Movie> movies = new ArrayList<>();
	List<ImageView> posters = new ArrayList<>();
	String currentSearch = "";

	List<ComboBox<String>> genreBoxes = new ArrayList<>();

	private Integer currentPage = 0;
	private Integer totalPages = 0;

	private String searchType = "";

	private void query(String query) {
	}

	@FXML
	void searchByTitle(ActionEvent event) throws IOException {
		currentPage = 0;
		currentSearch = txtSearch.getText();
		loadPage();
	}

	void loadPage() {
		query(currentSearch);
		closeAllDetails();
		btnPrevPage.setVisible(true);
		btnNextPage.setVisible(true);

		// Clean
		for (int i = 0; i < 3; i++) {
			posters.get(i).setImage(null);
			movieByPoster.clear();
		}

		// Reload
		for (int i = 0; i < 3; i++) {
			try {
				String url = movies.get(i).getPoster_path();
				String urlPoster = "";
				if (url != null && url != "null") {
					urlPoster = url;
				} else {
					urlPoster = "/dii2dam/movieApp/img/background/x.png";
				}
				Image image = new Image(urlPoster);
				posters.get(i).setImage(image);
				movieByPoster.put(posters.get(i), movies.get(i));

				lblCurrentPage.setText(((Integer) (currentPage + 1)).toString());
				lblTotalPages.setText(((Integer) (totalPages + 1)).toString());
			} catch (Exception e) {
				e.printStackTrace();
				totalPages = currentPage;
				lblCurrentPage.setText(((Integer) (currentPage + 1)).toString());
				lblTotalPages.setText(((Integer) (totalPages + 1)).toString());
			}
		}

		if (currentPage == 0)
			btnPrevPage.setVisible(false);
		else if (!btnPrevPage.isVisible())
			btnPrevPage.setVisible(true);

		if (currentPage == totalPages)
			btnNextPage.setVisible(false);
		else if (btnNextPage.isVisible())
			btnNextPage.setVisible(true);
	}

	@FXML
	void initialize() {
		movies = movieDao.searchMoviesByUser(Manager.getCurrentUser());
		
		closeAllDetails();
		lblMovieDesc00.setWrapText(true);
		lblMovieDesc06.setWrapText(true);
		lblMovieDesc12.setWrapText(true);

		posters.add(poster00);
		posters.add(poster06);
		posters.add(poster12);

		btnPrevPage.setVisible(false);
		btnNextPage.setVisible(false);

		ObservableList<String> genreNames = FXCollections.observableArrayList();
		ObservableList<Integer> lengthRange = FXCollections.observableArrayList();
		ObservableList<Integer> scoreRange = FXCollections.observableArrayList();
		ObservableList<String> sortings = FXCollections.observableArrayList();

		cmbGenre1.setItems(genreNames);
		cmbGenre2.setItems(genreNames);
		cmbGenre3.setItems(genreNames);
		cmbGenre4.setItems(genreNames);
		cmbLengthMin.setItems(lengthRange);
		cmbLengthMax.setItems(lengthRange);
		cmbScoreMin.setItems(scoreRange);
		cmbScoreMax.setItems(scoreRange);
		cmbSorter.setItems(sortings);

		genreBoxes.add(cmbGenre1);
		genreBoxes.add(cmbGenre2);
		genreBoxes.add(cmbGenre3);
		genreBoxes.add(cmbGenre4);

		genreNames.add(null);
		for (String genre : Manager.getGenreNames()) {
			genreNames.add(genre);
		}

		lengthRange.add(null);
		for (Integer i = 0; i < 601; i++) {
			lengthRange.add(i);
		}

		scoreRange.add(null);
		for (Integer i = 0; i < 11; i++) {
			scoreRange.add(i);
		}

		sortings.add(null);
		sortings.add("Popularity (Desc.)");
		sortings.add("Popularity (Asc.)");
		sortings.add("Title (Desc.)");
		sortings.add("Title (Asc.)");
		sortings.add("Score (Desc.)");
		sortings.add("Score (Asc.)");
		sortings.add("Release (Desc.)");
		sortings.add("Release (Asc.)");

		ImageView btnSearchIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/lens.png").toExternalForm());
		btnSearchIcon.setFitHeight(32);
		btnSearchIcon.setFitWidth(32);
		btnSearch.setGraphic(btnSearchIcon);
	}

	@FXML
	void showFilterTab() {
		if (!filterTab.isVisible()) {
			filterTab.setVisible(true);
			filterTabRow.setMaxHeight(64);
		} else {
			filterTab.setVisible(false);
			filterTabRow.setMaxHeight(1);
		}
	}

	@FXML
	void prevPage() {
		if (currentPage > 0) {
			currentPage--;
			loadPage();
		}
	}

	@FXML
	void nextPage() {
		if (currentPage < totalPages) {
			currentPage++;
			loadPage();
		}
	}

	@FXML
	void goToAccount() {
		try {
			App.setRoot("accountPage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goToAddMovie() {
		try {
			App.setRoot("addMovie");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goToSearchTab() {
		try {
			App.setRoot("searchTab");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goToHome() {
		try {
			App.setRoot("homePage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goBack(MouseEvent event) {
		Manager.goToLastPage();
	}

	void visitMoviePageGeneral(int id) {
		try {
			Manager.setMovie(movies.get(id));
			Manager.setDiscoveryType(searchType);
			App.setRoot("movieRecord");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void visitMoviePage00() {
		visitMoviePageGeneral(0);
	}

	@FXML
	void visitMoviePage06() {
		visitMoviePageGeneral(1);
	}

	@FXML
	void visitMoviePage12() {
		visitMoviePageGeneral(2);
	}

	void closeAllDetails() {
		filterTab.setVisible(false);
		filterTabRow.setMaxHeight(1);
	}

	void movieDetails(GridPane moviePane, ImageView poster, GridPane movieInfo, Label movieTitle, Label movieDesc,
			Label movieGenre, Label movieDate, ColumnConstraints movieColumn) {
		Movie movie = movieByPoster.get(poster);
		if (movieColumn.getMaxWidth() != 400) {
			closeAllDetails();

			moviePane.toFront();
			movieColumn.setMaxWidth(400);
			movieInfo.setVisible(true);

			switch (searchType) {
			case "movie":
				movieTitle.setText(movie.getTitle());
				movieDesc.setText(movie.getOverview());
				movieGenre.setText(movie.getGenre());
				movieDate.setText(movie.getRelease_date());
				break;
			case "tv":
				movieTitle.setText(movie.getName());
				movieDesc.setText(movie.getOverview());
				movieGenre.setText(movie.getGenre());
				movieDate.setText(movie.getFirst_air_date());
				break;
			case "multi":
				if (movie.getMedia_type().equals("movie")) {
					movieTitle.setText(movie.getTitle());
					movieDesc.setText(movie.getOverview());
					movieGenre.setText(movie.getGenre());
					movieDate.setText(movie.getRelease_date());
				} else if (movie.getMedia_type().equals("tv")) {
					movieTitle.setText(movie.getName());
					movieDesc.setText(movie.getOverview());
					movieGenre.setText(movie.getGenre());
					movieDate.setText(movie.getFirst_air_date());
				}
				break;
			}
		} else {
			closeAllDetails();
		}
	}

	@FXML
	void movieDetails00() {
		movieDetails(movie00, poster00, movieInfo00, lblMovieTitle00, lblMovieDesc00, lblMovieGenre00, lblMovieDate00,
				movieColumn00);
	}

	@FXML
	void movieDetails06() {
		movieDetails(movie06, poster06, movieInfo06, lblMovieTitle06, lblMovieDesc06, lblMovieGenre06, lblMovieDate06,
				movieColumn06);
	}

	@FXML
	void movieDetails12() {
		movieDetails(movie12, poster12, movieInfo12, lblMovieTitle12, lblMovieDesc12, lblMovieGenre12, lblMovieDate12,
				movieColumn12);
	}
}
