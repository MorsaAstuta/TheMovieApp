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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

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

public class HomePage {

	private APIResponse response;

	@FXML
	private ImageView fmPoster;

	@FXML
	private Label fmOverview;

	@FXML
	private Label fmGenre;

	@FXML
	private Label fmTitle;

	@FXML
	private Label fmRelease;

	@FXML
	private Label fmRuntime;

	@FXML
	private Label fmScore;

	@FXML
	private Pane btnAccount;

	@FXML
	private Pane btnMyList;

	@FXML
	private Pane btnMyListExp;

	@FXML
	private Button btnReload;

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
	private BorderPane searchBar;

	@FXML
	private TextField txtSearch;

	Map<ImageView, Movie> movieByPoster = new HashMap<>();
	Movie[] movies = null;
	List<ImageView> posters = new ArrayList<>();
	String currentSearch = "";

	List<ComboBox<String>> genreBoxes = new ArrayList<>();
	
	private String searchType = "";

	private void query() {
		try {
				if (chkMovies.isSelected()) {
					response = Connector.discoverMovie(filter());
					searchType = "movie";
				} else if (chkSeries.isSelected()) {
					response = Connector.discoverSeries(filter());
					searchType = "tv";
				}
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
	void reloadPage(ActionEvent event) throws IOException {
		loadPage();
	}

	void loadPage() {
		query();
		closeAllDetails();

		// Clean
		for (int i = 0; i < 13; i++) {
			posters.get(i).setImage(null);
			movieByPoster.clear();
		}

		// Reload
		for (int i = 0; i < 13; i++) {
			try {
				String url = movies[i].getPosterPath();
				String urlPoster = "";
				if (url != null && url != "null") {
					urlPoster = "https://image.tmdb.org/t/p/w500" + url;
				} else {
					urlPoster = "/dii2dam/movieApp/img/background/x.png";
				}
				Image image = new Image(urlPoster);
				posters.get(i).setImage(image);
				movieByPoster.put(posters.get(i), movies[i]);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		fmScore.setText(movies[0].getVote_average().toString());
		fmGenre.setText(movies[0].getGenre());
		fmOverview.setText(movies[0].getOverview());
		fmRelease.setText(movies[0].getRelease_date());
		if (chkMovies.isSelected()) {
			fmTitle.setText(movies[0].getTitle());
		} else if (chkSeries.isSelected()) {
			fmTitle.setText(movies[0].getName());
		}
	}

	@FXML
	void initialize() {
		closeAllDetails();
		
		fmOverview.setWrapText(true);
		lblMovieDesc00.setWrapText(true);
		lblMovieDesc01.setWrapText(true);
		lblMovieDesc02.setWrapText(true);
		lblMovieDesc03.setWrapText(true);
		lblMovieDesc04.setWrapText(true);
		lblMovieDesc05.setWrapText(true);
		lblMovieDesc06.setWrapText(true);
		lblMovieDesc07.setWrapText(true);
		lblMovieDesc08.setWrapText(true);
		lblMovieDesc09.setWrapText(true);
		lblMovieDesc10.setWrapText(true);
		lblMovieDesc11.setWrapText(true);

		posters.add(fmPoster);
		posters.add(poster00);
		posters.add(poster01);
		posters.add(poster02);
		posters.add(poster03);
		posters.add(poster04);
		posters.add(poster05);
		posters.add(poster06);
		posters.add(poster07);
		posters.add(poster08);
		posters.add(poster09);
		posters.add(poster10);
		posters.add(poster11);

		btnMyListExp.setVisible(false);

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

		ImageView btnReloadIcon = new ImageView(
				getClass().getResource("/dii2dam/movieApp/img/icon/reload.png").toExternalForm());
		btnReloadIcon.setFitHeight(32);
		btnReloadIcon.setFitWidth(32);
		btnReload.setGraphic(btnReloadIcon);
		
		cmbSorter.getSelectionModel().select(1);
		loadPage();
	}

	@FXML
	void goToSearch() {
		try {
			App.setRoot("searchTab");
		} catch (IOException e) {
			e.printStackTrace();
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
	void goToMyList() {
		try {
			App.setRoot("myList");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void expandMyList() {
		btnMyListExp.setVisible(true);
	}

	@FXML
	void retractMyList() {
		btnMyListExp.setVisible(false);
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
	void visitMoviePageFM() {
		visitMoviePageGeneral(0);
	}

	@FXML
	void visitMoviePage00() {
		visitMoviePageGeneral(1);
	}

	@FXML
	void visitMoviePage01() {
		visitMoviePageGeneral(2);
	}

	@FXML
	void visitMoviePage02() {
		visitMoviePageGeneral(3);
	}

	@FXML
	void visitMoviePage03() {
		visitMoviePageGeneral(4);
	}

	@FXML
	void visitMoviePage04() {
		visitMoviePageGeneral(5);
	}

	@FXML
	void visitMoviePage05() {
		visitMoviePageGeneral(6);
	}

	@FXML
	void visitMoviePage06() {
		visitMoviePageGeneral(7);
	}

	@FXML
	void visitMoviePage07() {
		visitMoviePageGeneral(8);
	}

	@FXML
	void visitMoviePage08() {
		visitMoviePageGeneral(9);
	}

	@FXML
	void visitMoviePage09() {
		visitMoviePageGeneral(10);
	}

	@FXML
	void visitMoviePage10() {
		visitMoviePageGeneral(11);
	}

	@FXML
	void visitMoviePage11() {
		visitMoviePageGeneral(12);
	}

	void closeAllDetails() {

		movieColumn00.setMaxWidth(1);
		movieColumn01.setMaxWidth(1);
		movieColumn02.setMaxWidth(1);
		movieColumn03.setMaxWidth(1);
		movieColumn04.setMaxWidth(1);
		movieColumn05.setMaxWidth(1);
		movieColumn06.setMaxWidth(1);
		movieColumn07.setMaxWidth(1);
		movieColumn08.setMaxWidth(1);
		movieColumn09.setMaxWidth(1);
		movieColumn10.setMaxWidth(1);
		movieColumn11.setMaxWidth(1);

		movieInfo00.setVisible(false);
		movieInfo01.setVisible(false);
		movieInfo02.setVisible(false);
		movieInfo03.setVisible(false);
		movieInfo04.setVisible(false);
		movieInfo05.setVisible(false);
		movieInfo06.setVisible(false);
		movieInfo07.setVisible(false);
		movieInfo08.setVisible(false);
		movieInfo09.setVisible(false);
		movieInfo10.setVisible(false);
		movieInfo11.setVisible(false);

		movie02.toBack();
		movie01.toBack();
		movie00.toBack();
		movie03.toBack();
		movie04.toBack();
		movie05.toBack();
		movie08.toBack();
		movie07.toBack();
		movie06.toBack();
		movie09.toBack();
		movie10.toBack();
		movie11.toBack();
	}

	void movieDetails(GridPane moviePane, ImageView poster, GridPane movieInfo, Label movieTitle, Label movieDesc,
			Label movieGenre, Label movieDate, ColumnConstraints movieColumn) {
		Movie movie = movieByPoster.get(poster);
		if (movieColumn.getMaxWidth() != 400) {
			closeAllDetails();
			
			moviePane.toFront();
			movieColumn.setMaxWidth(400);
			movieInfo.setVisible(true);
			
			switch(searchType) {
			case "movie":
				movieTitle.setText(movie.getTitle());
				movieDesc.setText(movie.getOverview());
				movieGenre.setText(movie.getGenre());
				movieDate.setText(movie.getReleaseDate());
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
					movieDate.setText(movie.getReleaseDate());
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
	void movieDetails01() {
		movieDetails(movie01, poster01, movieInfo01, lblMovieTitle01, lblMovieDesc01, lblMovieGenre01, lblMovieDate01,
				movieColumn01);
	}

	@FXML
	void movieDetails02() {
		movieDetails(movie02, poster02, movieInfo02, lblMovieTitle02, lblMovieDesc02, lblMovieGenre02, lblMovieDate02,
				movieColumn02);
	}

	@FXML
	void movieDetails03() {
		movieDetails(movie03, poster03, movieInfo03, lblMovieTitle03, lblMovieDesc03, lblMovieGenre03, lblMovieDate03,
				movieColumn03);
	}

	@FXML
	void movieDetails04() {
		movieDetails(movie04, poster04, movieInfo04, lblMovieTitle04, lblMovieDesc04, lblMovieGenre04, lblMovieDate04,
				movieColumn04);
	}

	@FXML
	void movieDetails05() {
		movieDetails(movie05, poster05, movieInfo05, lblMovieTitle05, lblMovieDesc05, lblMovieGenre05, lblMovieDate05,
				movieColumn05);
	}

	@FXML
	void movieDetails06() {
		movieDetails(movie06, poster06, movieInfo06, lblMovieTitle06, lblMovieDesc06, lblMovieGenre06, lblMovieDate06,
				movieColumn06);
	}

	@FXML
	void movieDetails07() {
		movieDetails(movie07, poster07, movieInfo07, lblMovieTitle07, lblMovieDesc07, lblMovieGenre07, lblMovieDate07,
				movieColumn07);
	}

	@FXML
	void movieDetails08() {
		movieDetails(movie08, poster08, movieInfo08, lblMovieTitle08, lblMovieDesc08, lblMovieGenre08, lblMovieDate08,
				movieColumn08);
	}

	@FXML
	void movieDetails09() {
		movieDetails(movie09, poster09, movieInfo09, lblMovieTitle09, lblMovieDesc09, lblMovieGenre09, lblMovieDate09,
				movieColumn09);
	}

	@FXML
	void movieDetails10() {
		movieDetails(movie10, poster10, movieInfo10, lblMovieTitle10, lblMovieDesc10, lblMovieGenre10, lblMovieDate10,
				movieColumn10);
	}

	@FXML
	void movieDetails11() {
		movieDetails(movie11, poster11, movieInfo11, lblMovieTitle11, lblMovieDesc11, lblMovieGenre11, lblMovieDate11,
				movieColumn11);
	}
}
