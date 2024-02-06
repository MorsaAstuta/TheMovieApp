package dii2dam.movieApp.controller;

import dii2dam.movieApp.models.Movie;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class MovieRecord {
	private static Movie movie;
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

	
    
    public static Movie getMovie() {
		return movie;
	}

	public static void setMovie(Movie movie) {
		MovieRecord.movie = movie;
	}
    
    
    
    
    
    
}
