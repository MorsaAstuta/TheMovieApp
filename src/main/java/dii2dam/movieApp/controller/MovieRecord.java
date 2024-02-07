package dii2dam.movieApp.controller;

import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MovieRecord {
	@FXML
    private ImageView imgActor1;

    @FXML
    private ImageView imgActor2;

    @FXML
    private ImageView imgActor3;

    @FXML
    private ImageView imgActor4;

    @FXML
    private ImageView posterMovie;

    @FXML
    private Label textDate;

    @FXML
    private Label textDirector;

    @FXML
    private Label textGenre;

    @FXML
    private Label textSinopsis;

    @FXML
    private Label textTime;

    @FXML
    private Label textTittle;
    private Movie movie;
   
    public void initialize() {
    	movie = Manager.movie;
    	if (movie != null) {
            textTittle.setText(movie.getTitle());
            textDate.setText(movie.getReleaseDate());
            textDirector.setText(movie.getDirector());
            textGenre.setText(movie.getGenre());
            textSinopsis.setText(movie.getOverview());
        }
    }
    
    
    
    
    
}
