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

import java.io.IOException;

import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.Connector;

public class ApiTest {

  @FXML
  private Button btnSearch;

  @FXML
  private TableView<Movie> tblMovie;
  
  private ObservableList<Movie> movieList = FXCollections.observableArrayList();

  @FXML
  private TableColumn<Movie, String> clmTitle;
  @FXML
  private TableColumn<Movie, String> clmRelease;
  @FXML
  private TableColumn<Movie, String> clmOverview;
  @FXML
  private TableColumn<Movie, String> clmRating;

  @FXML
  private ImageView idPoster;

  @FXML
  private TextField txtSearch;

  @FXML
  private FlowPane searchResults;

  @FXML
  void searchByTitle(ActionEvent event) {
	movieList.clear();
	idPoster.setImage(null);
	String query = txtSearch.getText();
	try {
	  Movie[] movies = Connector.connect(query);
	  if (movies != null && movies.length > 0) {
		for (Movie movie: movies) {
		  movieList.add(movie);
		  clmTitle.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getTitle()));
		  clmRelease.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getRelease_date()));
		  clmOverview.setCellValueFactory(f -> new SimpleStringProperty(f.getValue().getOverview()));
		}
	  }
	} catch (IOException e) {
	  e.printStackTrace();
	}
  }

  @FXML
  void selectMovie(MouseEvent event) {
	String url = tblMovie.getSelectionModel().getSelectedItem().getPoster_url();
	String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
	Image image = new Image(urlPoster);
	idPoster.setImage(image);
  }

  @FXML
  void initialize() {
	
	tblMovie.setItems(movieList);
	
	ImageView btnSearchIcon = new ImageView(getClass().getResource("/dii2dam/movieApp/img/icon/lens.png").toExternalForm());
	btnSearchIcon.setFitHeight(32);
	btnSearchIcon.setFitWidth(32);
	btnSearch.setGraphic(btnSearchIcon);
  }
}

