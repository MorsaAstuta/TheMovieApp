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
import dii2dam.movieApp.models.APIResponse;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.Connector;
import dii2dam.movieApp.utils.Manager;

public class MyList {

	private APIResponse response;

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
	private Label lblMovieDate01;

	@FXML
	private Label lblMovieDate02;

	@FXML
	private Label lblMovieDate03;

	@FXML
	private Label lblMovieDate04;

	@FXML
	private Label lblMovieDate05;

	@FXML
	private Label lblMovieDate06;

	@FXML
	private Label lblMovieDate07;

	@FXML
	private Label lblMovieDate08;

	@FXML
	private Label lblMovieDate09;

	@FXML
	private Label lblMovieDate10;

	@FXML
	private Label lblMovieDate11;

	@FXML
	private Label lblMovieDate12;

	@FXML
	private Label lblMovieDate13;

	@FXML
	private Label lblMovieDate14;

	@FXML
	private Label lblMovieDate15;

	@FXML
	private Label lblMovieDate16;

	@FXML
	private Label lblMovieDate17;

	@FXML
	private Label lblMovieDesc00;

	@FXML
	private Label lblMovieDesc01;

	@FXML
	private Label lblMovieDesc02;

	@FXML
	private Label lblMovieDesc03;

	@FXML
	private Label lblMovieDesc04;

	@FXML
	private Label lblMovieDesc05;

	@FXML
	private Label lblMovieDesc06;

	@FXML
	private Label lblMovieDesc07;

	@FXML
	private Label lblMovieDesc08;

	@FXML
	private Label lblMovieDesc09;

	@FXML
	private Label lblMovieDesc10;

	@FXML
	private Label lblMovieDesc11;

	@FXML
	private Label lblMovieDesc12;

	@FXML
	private Label lblMovieDesc13;

	@FXML
	private Label lblMovieDesc14;

	@FXML
	private Label lblMovieDesc15;

	@FXML
	private Label lblMovieDesc16;

	@FXML
	private Label lblMovieDesc17;

	@FXML
	private Label lblMovieGenre00;

	@FXML
	private Label lblMovieGenre01;

	@FXML
	private Label lblMovieGenre02;

	@FXML
	private Label lblMovieGenre03;

	@FXML
	private Label lblMovieGenre04;

	@FXML
	private Label lblMovieGenre05;

	@FXML
	private Label lblMovieGenre06;

	@FXML
	private Label lblMovieGenre07;

	@FXML
	private Label lblMovieGenre08;

	@FXML
	private Label lblMovieGenre09;

	@FXML
	private Label lblMovieGenre10;

	@FXML
	private Label lblMovieGenre11;

	@FXML
	private Label lblMovieGenre12;

	@FXML
	private Label lblMovieGenre13;

	@FXML
	private Label lblMovieGenre14;

	@FXML
	private Label lblMovieGenre15;

	@FXML
	private Label lblMovieGenre16;

	@FXML
	private Label lblMovieGenre17;

	@FXML
	private Label lblMovieTitle00;

	@FXML
	private Label lblMovieTitle01;

	@FXML
	private Label lblMovieTitle02;

	@FXML
	private Label lblMovieTitle03;

	@FXML
	private Label lblMovieTitle04;

	@FXML
	private Label lblMovieTitle05;

	@FXML
	private Label lblMovieTitle06;

	@FXML
	private Label lblMovieTitle07;

	@FXML
	private Label lblMovieTitle08;

	@FXML
	private Label lblMovieTitle09;

	@FXML
	private Label lblMovieTitle10;

	@FXML
	private Label lblMovieTitle11;

	@FXML
	private Label lblMovieTitle12;

	@FXML
	private Label lblMovieTitle13;

	@FXML
	private Label lblMovieTitle14;

	@FXML
	private Label lblMovieTitle15;

	@FXML
	private Label lblMovieTitle16;

	@FXML
	private Label lblMovieTitle17;

	@FXML
	private Label lblPage;

	@FXML
	private Label lblTotalPages;

	@FXML
	private GridPane movie00;

	@FXML
	private GridPane movie01;

	@FXML
	private GridPane movie02;

	@FXML
	private GridPane movie03;

	@FXML
	private GridPane movie04;

	@FXML
	private GridPane movie05;

	@FXML
	private GridPane movie06;

	@FXML
	private GridPane movie07;

	@FXML
	private GridPane movie08;

	@FXML
	private GridPane movie09;

	@FXML
	private GridPane movie10;

	@FXML
	private GridPane movie11;

	@FXML
	private GridPane movie12;

	@FXML
	private GridPane movie13;

	@FXML
	private GridPane movie14;

	@FXML
	private GridPane movie15;

	@FXML
	private GridPane movie16;

	@FXML
	private GridPane movie17;

	@FXML
	private ColumnConstraints movieColumn00;

	@FXML
	private ColumnConstraints movieColumn01;

	@FXML
	private ColumnConstraints movieColumn02;

	@FXML
	private ColumnConstraints movieColumn03;

	@FXML
	private ColumnConstraints movieColumn04;

	@FXML
	private ColumnConstraints movieColumn05;

	@FXML
	private ColumnConstraints movieColumn06;

	@FXML
	private ColumnConstraints movieColumn07;

	@FXML
	private ColumnConstraints movieColumn08;

	@FXML
	private ColumnConstraints movieColumn09;

	@FXML
	private ColumnConstraints movieColumn10;

	@FXML
	private ColumnConstraints movieColumn11;

	@FXML
	private ColumnConstraints movieColumn12;

	@FXML
	private ColumnConstraints movieColumn13;

	@FXML
	private ColumnConstraints movieColumn14;

	@FXML
	private ColumnConstraints movieColumn15;

	@FXML
	private ColumnConstraints movieColumn16;

	@FXML
	private ColumnConstraints movieColumn17;

	@FXML
	private GridPane movieInfo00;

	@FXML
	private GridPane movieInfo01;

	@FXML
	private GridPane movieInfo02;

	@FXML
	private GridPane movieInfo03;

	@FXML
	private GridPane movieInfo04;

	@FXML
	private GridPane movieInfo05;

	@FXML
	private GridPane movieInfo06;

	@FXML
	private GridPane movieInfo07;

	@FXML
	private GridPane movieInfo08;

	@FXML
	private GridPane movieInfo09;

	@FXML
	private GridPane movieInfo10;

	@FXML
	private GridPane movieInfo11;

	@FXML
	private GridPane movieInfo12;

	@FXML
	private GridPane movieInfo13;

	@FXML
	private GridPane movieInfo14;

	@FXML
	private GridPane movieInfo15;

	@FXML
	private GridPane movieInfo16;

	@FXML
	private GridPane movieInfo17;

	@FXML
	private ColumnConstraints myListExtension;

	@FXML
	private ImageView poster00;

	@FXML
	private ImageView poster01;

	@FXML
	private ImageView poster02;

	@FXML
	private ImageView poster03;

	@FXML
	private ImageView poster04;

	@FXML
	private ImageView poster05;

	@FXML
	private ImageView poster06;

	@FXML
	private ImageView poster07;

	@FXML
	private ImageView poster08;

	@FXML
	private ImageView poster09;

	@FXML
	private ImageView poster10;

	@FXML
	private ImageView poster11;

	@FXML
	private ImageView poster12;

	@FXML
	private ImageView poster13;

	@FXML
	private ImageView poster14;

	@FXML
	private ImageView poster15;

	@FXML
	private ImageView poster16;

	@FXML
	private ImageView poster17;

	@FXML
	private BorderPane searchBar;

	@FXML
	private TextField txtSearch;

	Map<ImageView, Movie> movieByPoster = new HashMap<>();
	Movie[] movies = null;
	List<ImageView> posters = new ArrayList<>();
	String currentSearch = "";

	List<ComboBox<String>> genreBoxes = new ArrayList<>();

	private Integer currentPage = 0;
	private Integer totalPages = 0;

	private String searchType = "";

	private void query(String query) {
		try {
			if (!filter().isEmpty()) {
				if (chkMovies.isSelected()) {
					response = Connector.discoverMovie(filter() + "&page=" + (currentPage + 1));
					searchType = "movie";
				} else if (chkSeries.isSelected()) {
					response = Connector.discoverSeries(filter() + "&page=" + (currentPage + 1));
					searchType = "tv";
				}
			} else {
				if ((chkMovies.isSelected() && chkSeries.isSelected())) {
					response = Connector.searchMulti(query + "&page=" + (currentPage + 1));
					searchType = "multi";
				} else if (chkMovies.isSelected()) {
					response = Connector.searchMovie(query + "&page=" + (currentPage + 1));
					searchType = "movie";
				} else if (chkSeries.isSelected()) {
					response = Connector.searchSeries(query + "&page=" + (currentPage + 1));
					searchType = "tv";
				}
			}
			totalPages = response.getTotalPages();
			movies = response.getResults();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String filter() {
		String modifiedQuery = "";

		// Genre filters
		boolean firstItem = true;
		for (ComboBox<String> cmbGenre : genreBoxes) {
			if (cmbGenre.getValue() != null) {
				if (firstItem) {
					modifiedQuery += "&with_genres=";
					firstItem = false;
				} else {
					modifiedQuery += ",";
				}
				modifiedQuery += Manager.idByGenre.get(cmbGenre.getValue());
			}
		}

		// Score/Runtime filters
		if (cmbScoreMin.getValue() != null) {
			modifiedQuery += "&vote_average.gte=" + cmbScoreMin.getValue();
		}
		if (cmbScoreMax.getValue() != null) {
			modifiedQuery += "&vote_average.lte=" + cmbScoreMax.getValue();
		}
		if (cmbLengthMin.getValue() != null) {
			modifiedQuery += "&with_runtime.gte=" + cmbLengthMin.getValue();
		}
		if (cmbLengthMax.getValue() != null) {
			modifiedQuery += "&with_runtime.lte=" + cmbLengthMax.getValue();
		}

		// Sorter
		String sorter = "";
		if (cmbSorter.getValue() != null) {
			modifiedQuery += "&sort_by=";
			switch (cmbSorter.getValue()) {
			case "Popularity (Desc.)":
				modifiedQuery += "popularity.desc";
				break;
			case "Popularity (Asc.)":
				modifiedQuery += "popularity.asc";
				break;
			case "Title (Desc.)":
				if (chkMovies.isSelected()) {
					modifiedQuery += "title.desc";
				} else if (chkSeries.isSelected()) {
					modifiedQuery += "name.desc";
				}
				break;
			case "Title (Asc.)":
				if (chkMovies.isSelected()) {
					modifiedQuery += "title.asc";
				} else if (chkSeries.isSelected()) {
					modifiedQuery += "name.asc";
				}
				break;
			case "Score (Desc.)":
				modifiedQuery += "vote_average.desc";
				break;
			case "Score (Asc.)":
				modifiedQuery += "vote_average.asc";
				break;
			case "Release (Desc.)":
				if (chkMovies.isSelected()) {
					modifiedQuery += "primary_release_date.desc";
				} else if (chkSeries.isSelected()) {
					modifiedQuery += "first_air_date.desc";
				}
				break;
			case "Release (Asc.)":
				if (chkMovies.isSelected()) {
					modifiedQuery += "primary_release_date.asc";
				} else if (chkSeries.isSelected()) {
					modifiedQuery += "first_air_date.asc";
				}
				break;
			}
		}
		modifiedQuery += sorter;

		return modifiedQuery;
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
		for (int i = 0; i < 18; i++) {
			posters.get(i).setImage(null);
			movieByPoster.clear();
		}

		// Reload
		for (int i = 0; i < 18; i++) {
			try {
				String url = movies[i].getPoster_url();
				String urlPoster = "";
				if (url != null && url != "null") {
					urlPoster = "https://image.tmdb.org/t/p/w500" + url;
				} else {
					urlPoster = "/dii2dam/movieApp/img/background/x.png";
				}
				Image image = new Image(urlPoster);
				posters.get(i).setImage(image);
				movieByPoster.put(posters.get(i), movies[i]);

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
			Manager.setMovie(movies[id]);
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
