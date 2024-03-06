package dii2dam.movieApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.GenreDaoImpl;
import dii2dam.movieApp.dao.MovieDaoImpl;
import dii2dam.movieApp.dao.MovieGenreDaoImpl;
import dii2dam.movieApp.models.Genre;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieGenre;
import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;

public class MyList {

	private MovieDaoImpl movieDao = new MovieDaoImpl(HibernateUtils.session);

	private GenreDaoImpl genreDao = new GenreDaoImpl(HibernateUtils.session);
	private MovieGenreDaoImpl movieGenreDao = new MovieGenreDaoImpl(HibernateUtils.session);

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
	private Label lblBar;

	@FXML
	private Label lblCurrentPage;

	@FXML
	private Label lblMovieDate0;

	@FXML
	private Label lblMovieDate1;

	@FXML
	private Label lblMovieDate2;

	@FXML
	private Label lblMovieDesc0;

	@FXML
	private Label lblMovieDesc1;

	@FXML
	private Label lblMovieDesc2;

	@FXML
	private Label lblMovieGenre0;

	@FXML
	private Label lblMovieGenre1;

	@FXML
	private Label lblMovieGenre2;

	@FXML
	private Label lblMovieTitle0;

	@FXML
	private Label lblMovieTitle1;

	@FXML
	private Label lblMovieTitle2;

	@FXML
	private Label lblPage;

	@FXML
	private Label lblTotalPages;

	@FXML
	private GridPane movieInfo0;

	@FXML
	private GridPane movieInfo1;

	@FXML
	private GridPane movieInfo2;

	@FXML
	private ImageView poster0;

	@FXML
	private ImageView poster1;

	@FXML
	private ImageView poster2;

	@FXML
	private BorderPane searchBar;

	@FXML
	private TextField txtSearch;

	Map<ImageView, Movie> movieByPoster = new HashMap<>();
	List<Movie> movies = new ArrayList<>();
	List<ImageView> posters = new ArrayList<>();
	String currentSearch = "";

	private Integer currentPage = 0;
	private Integer totalPages = 0;

	private String searchType = "";

	private Boolean isSearchByTitle = false;

	/**
	 * Searches a local movie by title
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	void searchByTitle(ActionEvent event) throws IOException {
		currentPage = 0;
		currentSearch = txtSearch.getText();
		if (currentSearch != null && !currentSearch.isEmpty()) {
			movies = movieDao.searchMoviesByUserIdAndName(Manager.getCurrentUser(), currentSearch);
			isSearchByTitle = true;
		} else {
			isSearchByTitle = false;
		}
		loadPage();
	}

	/**
	 * Loads the current page
	 */
	void loadPage() {

		// Search
		if (!isSearchByTitle) {
			movies = movieDao.searchMoviesByUser(Manager.getCurrentUser());
		} else {
			movies = movieDao.searchMoviesByUserIdAndName(Manager.getCurrentUser(), currentSearch);
		}

		// Get total pages
		if (movies.size() % 3 == 0)
			totalPages = movies.size() / 3;
		else
			totalPages = movies.size() / 3 + 1;

		// Delete movies from list depending on current page
		for (int i = 0; i < 3 * currentPage; i++) {
			if (!movies.isEmpty()) {
				movies.remove(0);
			}
		}

		// Reinitialize page labels and buttons
		btnPrevPage.setVisible(true);
		btnNextPage.setVisible(true);
		lblCurrentPage.setText((currentPage + 1) + "");
		lblTotalPages.setText(totalPages + "");

		// Reload
		movieDetails();

		// Conditions to show next page and previous page buttons
		if (currentPage == 0)
			btnPrevPage.setVisible(false);
		else if (!btnPrevPage.isVisible())
			btnPrevPage.setVisible(true);

		if (currentPage == totalPages - 1)
			btnNextPage.setVisible(false);
		else if (btnNextPage.isVisible())
			btnNextPage.setVisible(true);
	}

	/**
	 * Initializes the FXML
	 */
	@FXML
	void initialize() {

		lblMovieDesc0.setWrapText(true);
		lblMovieDesc1.setWrapText(true);
		lblMovieDesc2.setWrapText(true);

		posters.add(poster0);
		posters.add(poster1);
		posters.add(poster2);

		btnPrevPage.setVisible(false);
		btnNextPage.setVisible(false);

		ImageView btnSearchIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/lens.png").toExternalForm());
		btnSearchIcon.setFitHeight(32);
		btnSearchIcon.setFitWidth(32);
		btnSearch.setGraphic(btnSearchIcon);

		loadPage();
	}

	/**
	 * Goes to the previous page
	 */
	@FXML
	void prevPage() {
		if (currentPage > 0) {
			currentPage--;
			loadPage();
		}
	}

	/**
	 * Goes to the next page
	 */
	@FXML
	void nextPage() {
		if (currentPage < totalPages - 1) {
			currentPage++;
			loadPage();
		}
	}

	/**
	 * Loads the accountPage FXML
	 */
	@FXML
	void goToAccount() {
		try {
			App.setRoot("accountPage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the addMovie FXML
	 */
	@FXML
	void goToAddMovie() {
		try {
			App.setRoot("addMovie");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the searchTab FXML
	 */
	@FXML
	void goToSearchTab() {
		try {
			App.setRoot("searchTab");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the homePage FXML
	 */
	@FXML
	void goToHome() {
		try {
			App.setRoot("homePage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Loads the last screen
	 */
	@FXML
	void goBack(MouseEvent event) {
		Manager.goToLastPage();
	}

	/**
	 * Loads the myListRecord FXML with the selected movie
	 * 
	 * @param i
	 */
	void visitMoviePageGeneral(Integer i) {
		try {
			Manager.setMovie(movies.get(i));
			Manager.setDiscoveryType(searchType);
			App.setRoot("myListRecord");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void visitMoviePage0() {
		visitMoviePageGeneral(0);
	}

	@FXML
	void visitMoviePage1() {
		visitMoviePageGeneral(1);
	}

	@FXML
	void visitMoviePage2() {
		visitMoviePageGeneral(2);
	}

	/**
	 * Loads all the page's movies details
	 */
	void movieDetails() {
		// Clear details
		movieDetails(poster0, lblMovieTitle0, lblMovieDesc0, lblMovieGenre0, lblMovieDate0);
		movieDetails(poster1, lblMovieTitle1, lblMovieDesc1, lblMovieGenre1, lblMovieDate1);
		movieDetails(poster2, lblMovieTitle2, lblMovieDesc2, lblMovieGenre2, lblMovieDate2);

		// Fill details if movie exists
		if (movies.size() >= 1) {
			movieDetails(movies.get(0), poster0, lblMovieTitle0, lblMovieDesc0, lblMovieGenre0, lblMovieDate0);
		}
		if (movies.size() >= 2) {
			movieDetails(movies.get(1), poster1, lblMovieTitle1, lblMovieDesc1, lblMovieGenre1, lblMovieDate1);
		}
		if (movies.size() >= 3) {
			movieDetails(movies.get(2), poster2, lblMovieTitle2, lblMovieDesc2, lblMovieGenre2, lblMovieDate2);
		}
	}

	/**
	 * Loads the selected movie details
	 * 
	 * @param movie
	 * @param poster
	 * @param movieTitle
	 * @param movieDesc
	 * @param movieGenre
	 * @param movieDate
	 */
	void movieDetails(Movie movie, ImageView poster, Label movieTitle, Label movieDesc, Label movieGenre,
			Label movieDate) {
		poster.setImage(null);
		movieTitle.setText("");
		movieDesc.setText("");
		movieGenre.setText("");
		movieDate.setText("");

		if (movie.getPoster_path() != null) {
			poster.setImage(new Image("file:" + movie.getPoster_path()));
		}
		movieTitle.setText(movie.getTitle());
		movieDesc.setText(movie.getOverview());

		String genreText = "";
		List<Genre> genres = new ArrayList<>();
		for (MovieGenre thisMovieGenre : movieGenreDao.searchByMovieId(movie.getId())) {
			genres.add(genreDao.searchById(thisMovieGenre.getGenre_id()));
		}
		for (Genre genre : genres) {
			if (genres.indexOf(genre) != 0) {
				genreText += ", ";
			}
			genreText += genre.getName();
		}
		movieGenre.setText(genreText);
		movieDate.setText(movie.getRelease_date());
	}

	/**
	 * Clears the movie details
	 * 
	 * @param poster
	 * @param movieTitle
	 * @param movieDesc
	 * @param movieGenre
	 * @param movieDate
	 */
	void movieDetails(ImageView poster, Label movieTitle, Label movieDesc, Label movieGenre, Label movieDate) {
		poster.setImage(null);
		movieTitle.setText("");
		movieDesc.setText("");
		movieGenre.setText("");
		movieDate.setText("");
	}
}
