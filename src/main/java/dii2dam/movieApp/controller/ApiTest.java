package dii2dam.movieApp.controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dii2dam.movieApp.models.APIResponse;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.Connector;

public class ApiTest {
  
  private APIResponse response;

    @FXML
    private FlowPane movie00;

    @FXML
    private FlowPane movie01;

    @FXML
    private FlowPane movie02;

    @FXML
    private FlowPane movie03;

    @FXML
    private FlowPane movie04;

    @FXML
    private FlowPane movie05;

    @FXML
    private FlowPane movie06;

    @FXML
    private FlowPane movie07;

    @FXML
    private FlowPane movie08;

    @FXML
    private FlowPane movie09;

    @FXML
    private FlowPane movie10;

    @FXML
    private FlowPane movie11;

    @FXML
    private FlowPane movie12;

    @FXML
    private FlowPane movie13;

    @FXML
    private FlowPane movie14;

    @FXML
    private FlowPane movie15;

    @FXML
    private FlowPane movie16;

    @FXML
    private FlowPane movie17;

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
    private TextFlow text00;

    @FXML
    private TextFlow text01;

    @FXML
    private TextFlow text02;

    @FXML
    private TextFlow text03;

    @FXML
    private TextFlow text04;

    @FXML
    private TextFlow text05;

    @FXML
    private TextFlow text06;

    @FXML
    private TextFlow text07;

    @FXML
    private TextFlow text08;

    @FXML
    private TextFlow text09;

    @FXML
    private TextFlow text10;

    @FXML
    private TextFlow text11;

    @FXML
    private TextFlow text12;

    @FXML
    private TextFlow text13;

    @FXML
    private TextFlow text14;

    @FXML
    private TextFlow text15;

    @FXML
    private TextFlow text16;

    @FXML
    private TextFlow text17;

  @FXML
  private Button btnSearch;

  @FXML
  private Button btnNextPage;

  @FXML
  private Button btnPrevPage;

  @FXML
  private TextField txtSearch;

  @FXML
  private FlowPane searchResults;
  
  Map<ImageView, Movie> movieByPoster = new HashMap<>();
  Movie[] movies = null;
  List<ImageView> posters = new ArrayList<>();
  String currentSearch = "";
  
  private Integer currentPage = 0;
  private Integer totalPages = 0;
  
  private void query(String query) {
	  try {
		response = Connector.connect(query);
		totalPages = response.getTotalPages();
		movies = response.getResults();
	  } catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	  }
  }

  @FXML
  void searchByTitle(ActionEvent event) throws IOException {
	currentSearch = txtSearch.getText();
	query(currentSearch);
	loadPage();
  }
  
  void loadPage() {
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
		String url = movies[i+18*currentPage].getPosterPath();
		String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
		System.out.println(url);
		Image image = new Image(urlPoster);
		posters.get(i).setImage(image);
		movieByPoster.put(posters.get(i), movies[i+18*currentPage]);
	  } catch (Exception e) {
		totalPages = currentPage;
	  }
	}
	
	if(currentPage == 0) btnPrevPage.setVisible(false);
	else if (!btnPrevPage.isVisible()) btnPrevPage.setVisible(true);
	
	if (currentPage == totalPages) btnNextPage.setVisible(false);
	else if (btnNextPage.isVisible()) btnNextPage.setVisible(true);
  }

  @FXML
  void initialize() {
	posters.add(poster00); posters.add(poster01); posters.add(poster02); posters.add(poster03); posters.add(poster04); posters.add(poster05);
	posters.add(poster06); posters.add(poster07); posters.add(poster08); posters.add(poster09); posters.add(poster10); posters.add(poster11);
	posters.add(poster12); posters.add(poster13); posters.add(poster14); posters.add(poster15); posters.add(poster16); posters.add(poster17);

	btnPrevPage.setVisible(false);
	btnNextPage.setVisible(false);
	
	ImageView btnSearchIcon = new ImageView(getClass().getResource("/dii2dam/movieApp/img/icon/lens.png").toExternalForm());
	btnSearchIcon.setFitHeight(32);
	btnSearchIcon.setFitWidth(32);
	btnSearch.setGraphic(btnSearchIcon);
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
  void movieDetails00() {
	Movie movie = movieByPoster.get(poster00);
	Text title = new Text(movie.getTitle());
	Text desc = new Text(movie.getOverview());
	Text genre = new Text(movie.getGenre());
	Text date = new Text(movie.getReleaseDate());
	Text a = new Text(currentPage.toString());
	Text b = new Text(response.getTotalPages().toString());
	text00.getChildren().addAll(title, desc, genre, date, a, b);
  }
}

