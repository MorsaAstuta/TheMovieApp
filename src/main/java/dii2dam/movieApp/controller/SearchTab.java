package dii2dam.movieApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dii2dam.movieApp.models.APIResponse;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.Connector;

public class SearchTab {
  
  private APIResponse response;

  	@FXML
  	private GridPane movie00;
    @FXML
    private ImageView poster00;
    @FXML
    private GridPane movieInfo00;
    @FXML
    private Label lblMovieTitle00;
    @FXML
    private Label lblMovieDesc00;
    @FXML
    private Label lblMovieGenre00;
    @FXML
    private Label lblMovieDate00;
    @FXML
    private ColumnConstraints movieColumn00;

  	@FXML
  	private GridPane movie01;
    @FXML
    private ImageView poster01;
    @FXML
    private GridPane movieInfo01;
    @FXML
    private Label lblMovieTitle01;
    @FXML
    private Label lblMovieDesc01;
    @FXML
    private Label lblMovieGenre01;
    @FXML
    private Label lblMovieDate01;
    @FXML
    private ColumnConstraints movieColumn01;

  	@FXML
  	private GridPane movie02;
    @FXML
    private ImageView poster02;
    @FXML
    private GridPane movieInfo02;
    @FXML
    private Label lblMovieTitle02;
    @FXML
    private Label lblMovieDesc02;
    @FXML
    private Label lblMovieGenre02;
    @FXML
    private Label lblMovieDate02;
    @FXML
    private ColumnConstraints movieColumn02;

  	@FXML
  	private GridPane movie03;
    @FXML
    private ImageView poster03;
    @FXML
    private GridPane movieInfo03;
    @FXML
    private Label lblMovieTitle03;
    @FXML
    private Label lblMovieDesc03;
    @FXML
    private Label lblMovieGenre03;
    @FXML
    private Label lblMovieDate03;
    @FXML
    private ColumnConstraints movieColumn03;

  	@FXML
  	private GridPane movie04;
    @FXML
    private ImageView poster04;
    @FXML
    private GridPane movieInfo04;
    @FXML
    private Label lblMovieTitle04;
    @FXML
    private Label lblMovieDesc04;
    @FXML
    private Label lblMovieGenre04;
    @FXML
    private Label lblMovieDate04;
    @FXML
    private ColumnConstraints movieColumn04;
    
  	@FXML
  	private GridPane movie05;
    @FXML
    private ImageView poster05;
    @FXML
    private GridPane movieInfo05;
    @FXML
    private Label lblMovieTitle05;
    @FXML
    private Label lblMovieDesc05;
    @FXML
    private Label lblMovieGenre05;
    @FXML
    private Label lblMovieDate05;
    @FXML
    private ColumnConstraints movieColumn05;

  	@FXML
  	private GridPane movie06;
    @FXML
    private ImageView poster06;
    @FXML
    private GridPane movieInfo06;
    @FXML
    private Label lblMovieTitle06;
    @FXML
    private Label lblMovieDesc06;
    @FXML
    private Label lblMovieGenre06;
    @FXML
    private Label lblMovieDate06;
    @FXML
    private ColumnConstraints movieColumn06;

  	@FXML
  	private GridPane movie07;
    @FXML
    private ImageView poster07;
    @FXML
    private GridPane movieInfo07;
    @FXML
    private Label lblMovieTitle07;
    @FXML
    private Label lblMovieDesc07;
    @FXML
    private Label lblMovieGenre07;
    @FXML
    private Label lblMovieDate07;
    @FXML
    private ColumnConstraints movieColumn07;

  	@FXML
  	private GridPane movie08;
    @FXML
    private ImageView poster08;
    @FXML
    private GridPane movieInfo08;
    @FXML
    private Label lblMovieTitle08;
    @FXML
    private Label lblMovieDesc08;
    @FXML
    private Label lblMovieGenre08;
    @FXML
    private Label lblMovieDate08;
    @FXML
    private ColumnConstraints movieColumn08;

  	@FXML
  	private GridPane movie09;
    @FXML
    private ImageView poster09;
    @FXML
    private GridPane movieInfo09;
    @FXML
    private Label lblMovieTitle09;
    @FXML
    private Label lblMovieDesc09;
    @FXML
    private Label lblMovieGenre09;
    @FXML
    private Label lblMovieDate09;
    @FXML
    private ColumnConstraints movieColumn09;

  	@FXML
  	private GridPane movie10;
    @FXML
    private ImageView poster10;
    @FXML
    private GridPane movieInfo10;
    @FXML
    private Label lblMovieTitle10;
    @FXML
    private Label lblMovieDesc10;
    @FXML
    private Label lblMovieGenre10;
    @FXML
    private Label lblMovieDate10;
    @FXML
    private ColumnConstraints movieColumn10;

  	@FXML
  	private GridPane movie11;
    @FXML
    private ImageView poster11;
    @FXML
    private GridPane movieInfo11;
    @FXML
    private Label lblMovieTitle11;
    @FXML
    private Label lblMovieDesc11;
    @FXML
    private Label lblMovieGenre11;
    @FXML
    private Label lblMovieDate11;
    @FXML
    private ColumnConstraints movieColumn11;

  	@FXML
  	private GridPane movie12;
    @FXML
    private ImageView poster12;
    @FXML
    private GridPane movieInfo12;
    @FXML
    private Label lblMovieTitle12;
    @FXML
    private Label lblMovieDesc12;
    @FXML
    private Label lblMovieGenre12;
    @FXML
    private Label lblMovieDate12;
    @FXML
    private ColumnConstraints movieColumn12;

  	@FXML
  	private GridPane movie13;
    @FXML
    private ImageView poster13;
    @FXML
    private GridPane movieInfo13;
    @FXML
    private Label lblMovieTitle13;
    @FXML
    private Label lblMovieDesc13;
    @FXML
    private Label lblMovieGenre13;
    @FXML
    private Label lblMovieDate13;
    @FXML
    private ColumnConstraints movieColumn13;

  	@FXML
  	private GridPane movie14;
    @FXML
    private ImageView poster14;
    @FXML
    private GridPane movieInfo14;
    @FXML
    private Label lblMovieTitle14;
    @FXML
    private Label lblMovieDesc14;
    @FXML
    private Label lblMovieGenre14;
    @FXML
    private Label lblMovieDate14;
    @FXML
    private ColumnConstraints movieColumn14;

  	@FXML
  	private GridPane movie15;
    @FXML
    private ImageView poster15;
    @FXML
    private GridPane movieInfo15;
    @FXML
    private Label lblMovieTitle15;
    @FXML
    private Label lblMovieDesc15;
    @FXML
    private Label lblMovieGenre15;
    @FXML
    private Label lblMovieDate15;
    @FXML
    private ColumnConstraints movieColumn15;

  	@FXML
  	private GridPane movie16;
    @FXML
    private ImageView poster16;
    @FXML
    private GridPane movieInfo16;
    @FXML
    private Label lblMovieTitle16;
    @FXML
    private Label lblMovieDesc16;
    @FXML
    private Label lblMovieGenre16;
    @FXML
    private Label lblMovieDate16;
    @FXML
    private ColumnConstraints movieColumn16;

  	@FXML
  	private GridPane movie17;
    @FXML
    private ImageView poster17;
    @FXML
    private GridPane movieInfo17;
    @FXML
    private Label lblMovieTitle17;
    @FXML
    private Label lblMovieDesc17;
    @FXML
    private Label lblMovieGenre17;
    @FXML
    private Label lblMovieDate17;
    @FXML
    private ColumnConstraints movieColumn17;
    
    @FXML
    private Label lblPage;
    @FXML
    private Label lblCurrentPage;
    @FXML
    private Label lblBar;
    @FXML
    private Label lblTotalPages;

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
		response = Connector.connect(query+"&page="+(currentPage+1));
		totalPages = response.getTotalPages();
		movies = response.getResults();
	  } catch (IOException e) {
		e.printStackTrace();
	  }
  }

  @FXML
  void searchByTitle(ActionEvent event) throws IOException {
	currentPage = 0;
	currentSearch = txtSearch.getText();
	query(currentSearch);
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
		String url = movies[i].getPosterPath();
		String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
		Image image = new Image(urlPoster);
		posters.get(i).setImage(image);
		movieByPoster.put(posters.get(i), movies[i]);
		
		lblCurrentPage.setText(((Integer)(currentPage+1)).toString());
		lblTotalPages.setText(((Integer)(totalPages+1)).toString());
	  } catch (Exception e) {
		e.printStackTrace();
		totalPages = currentPage;
		lblCurrentPage.setText(((Integer)(currentPage+1)).toString());
		lblTotalPages.setText(((Integer)(totalPages+1)).toString());
	  }
	}
	
	if(currentPage == 0) btnPrevPage.setVisible(false);
	else if (!btnPrevPage.isVisible()) btnPrevPage.setVisible(true);
	
	if (currentPage == totalPages) btnNextPage.setVisible(false);
	else if (btnNextPage.isVisible()) btnNextPage.setVisible(true);
  }

  @FXML
  void initialize() {
	closeAllDetails();
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
	lblMovieDesc12.setWrapText(true);
	lblMovieDesc13.setWrapText(true);
	lblMovieDesc14.setWrapText(true);
	lblMovieDesc15.setWrapText(true);
	lblMovieDesc16.setWrapText(true);
	lblMovieDesc17.setWrapText(true);
	
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
  void visitMoviePage00() {
  }

  @FXML
  void visitMoviePage01() {
  }

  @FXML
  void visitMoviePage02() {
  }

  @FXML
  void visitMoviePage03() {
  }

  @FXML
  void visitMoviePage04() {
  }

  @FXML
  void visitMoviePage05() {
  }

  @FXML
  void visitMoviePage06() {
  }

  @FXML
  void visitMoviePage07() {
  }

  @FXML
  void visitMoviePage08() {
  }

  @FXML
  void visitMoviePage09() {
  }

  @FXML
  void visitMoviePage10() {
  }

  @FXML
  void visitMoviePage11() {
  }

  @FXML
  void visitMoviePage12() {
  }

  @FXML
  void visitMoviePage13() {
  }

  @FXML
  void visitMoviePage14() {
  }

  @FXML
  void visitMoviePage15() {
  }

  @FXML
  void visitMoviePage16() {
  }

  @FXML
  void visitMoviePage17() {
  }
  
  void closeAllDetails() {
	movieColumn00.setMaxWidth(1); movieColumn01.setMaxWidth(1); movieColumn02.setMaxWidth(1);
	movieColumn03.setMaxWidth(1); movieColumn04.setMaxWidth(1); movieColumn05.setMaxWidth(1);
	movieColumn06.setMaxWidth(1); movieColumn07.setMaxWidth(1); movieColumn08.setMaxWidth(1);
	movieColumn09.setMaxWidth(1); movieColumn10.setMaxWidth(1); movieColumn11.setMaxWidth(1);
	movieColumn12.setMaxWidth(1); movieColumn13.setMaxWidth(1); movieColumn14.setMaxWidth(1);
	movieColumn15.setMaxWidth(1); movieColumn16.setMaxWidth(1); movieColumn17.setMaxWidth(1);
	movieInfo00.setVisible(false); movieInfo01.setVisible(false); movieInfo02.setVisible(false);
	movieInfo03.setVisible(false); movieInfo04.setVisible(false); movieInfo05.setVisible(false);
	movieInfo06.setVisible(false); movieInfo07.setVisible(false); movieInfo08.setVisible(false);
	movieInfo09.setVisible(false); movieInfo10.setVisible(false); movieInfo11.setVisible(false);
	movieInfo12.setVisible(false); movieInfo13.setVisible(false); movieInfo14.setVisible(false);
	movieInfo15.setVisible(false); movieInfo16.setVisible(false); movieInfo17.setVisible(false);
	movie02.toBack(); movie01.toBack(); movie00.toBack(); movie03.toBack(); movie04.toBack(); movie05.toBack();
	movie08.toBack(); movie07.toBack(); movie06.toBack(); movie09.toBack(); movie10.toBack(); movie11.toBack();
	movie14.toBack(); movie13.toBack(); movie12.toBack(); movie15.toBack(); movie16.toBack(); movie17.toBack();
  }
  
  void movieDetails(GridPane moviePane, ImageView poster, GridPane movieInfo, Label movieTitle, Label movieDesc, Label movieGenre, Label movieDate, ColumnConstraints movieColumn) {
	Movie movie = movieByPoster.get(poster);
	if (movieColumn.getMaxWidth() != 400) {
	  closeAllDetails();
	  moviePane.toFront();
	  movieColumn.setMaxWidth(400);
	  movieInfo.setVisible(true);
	  
	  movieTitle.setText(movie.getTitle());
	  movieDesc.setText(movie.getOverview());
	  movieGenre.setText(movie.getGenre());
	  movieDate.setText(movie.getReleaseDate());
	} else closeAllDetails();
  }
  
  @FXML
  void movieDetails00() {
	movieDetails(movie00, poster00, movieInfo00, lblMovieTitle00, lblMovieDesc00, lblMovieGenre00, lblMovieDate00, movieColumn00);
  }
  
  @FXML
  void movieDetails01() {
	movieDetails(movie01, poster01, movieInfo01, lblMovieTitle01, lblMovieDesc01, lblMovieGenre01, lblMovieDate01, movieColumn01);
  }
  
  @FXML
  void movieDetails02() {
	movieDetails(movie02, poster02, movieInfo02, lblMovieTitle02, lblMovieDesc02, lblMovieGenre02, lblMovieDate02, movieColumn02);
  }
  
  @FXML
  void movieDetails03() {
	movieDetails(movie03, poster03, movieInfo03, lblMovieTitle03, lblMovieDesc03, lblMovieGenre03, lblMovieDate03, movieColumn03);
  }
  
  @FXML
  void movieDetails04() {
	movieDetails(movie04, poster04, movieInfo04, lblMovieTitle04, lblMovieDesc04, lblMovieGenre04, lblMovieDate04, movieColumn04);
  }
  
  @FXML
  void movieDetails05() {
	movieDetails(movie05, poster05, movieInfo05, lblMovieTitle05, lblMovieDesc05, lblMovieGenre05, lblMovieDate05, movieColumn05);
  }
  
  @FXML
  void movieDetails06() {
	movieDetails(movie06, poster06, movieInfo06, lblMovieTitle06, lblMovieDesc06, lblMovieGenre06, lblMovieDate06, movieColumn06);
  }
  
  @FXML
  void movieDetails07() {
	movieDetails(movie07, poster07, movieInfo07, lblMovieTitle07, lblMovieDesc07, lblMovieGenre07, lblMovieDate07, movieColumn07);
  }
  
  @FXML
  void movieDetails08() {
	movieDetails(movie08, poster08, movieInfo08, lblMovieTitle08, lblMovieDesc08, lblMovieGenre08, lblMovieDate08, movieColumn08);
  }
  
  @FXML
  void movieDetails09() {
	movieDetails(movie09, poster09, movieInfo09, lblMovieTitle09, lblMovieDesc09, lblMovieGenre09, lblMovieDate09, movieColumn09);
  }
  
  @FXML
  void movieDetails10() {
	movieDetails(movie10, poster10, movieInfo10, lblMovieTitle10, lblMovieDesc10, lblMovieGenre10, lblMovieDate10, movieColumn10);
  }
  
  @FXML
  void movieDetails11() {
	movieDetails(movie11, poster11, movieInfo11, lblMovieTitle11, lblMovieDesc11, lblMovieGenre11, lblMovieDate11, movieColumn11);
  }
  
  @FXML
  void movieDetails12() {
	movieDetails(movie12, poster12, movieInfo12, lblMovieTitle12, lblMovieDesc12, lblMovieGenre12, lblMovieDate12, movieColumn12);
  }
  
  @FXML
  void movieDetails13() {
	movieDetails(movie13, poster13, movieInfo13, lblMovieTitle13, lblMovieDesc13, lblMovieGenre13, lblMovieDate13, movieColumn13);
  }
  
  @FXML
  void movieDetails14() {
	movieDetails(movie14, poster14, movieInfo14, lblMovieTitle14, lblMovieDesc14, lblMovieGenre14, lblMovieDate14, movieColumn14);
  }
  
  @FXML
  void movieDetails15() {
	movieDetails(movie15, poster15, movieInfo15, lblMovieTitle15, lblMovieDesc15, lblMovieGenre15, lblMovieDate15, movieColumn15);
  }
  
  @FXML
  void movieDetails16() {
	movieDetails(movie16, poster16, movieInfo16, lblMovieTitle16, lblMovieDesc16, lblMovieGenre16, lblMovieDate16, movieColumn16);
  }
  
  @FXML
  void movieDetails17() {
	movieDetails(movie17, poster17, movieInfo17, lblMovieTitle17, lblMovieDesc17, lblMovieGenre17, lblMovieDate17, movieColumn17);
  }
}

