package dii2dam.movieApp.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.IOException;



import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.utils.Connector;

public class ApiTest {
	

	  @FXML
	    private TextArea idFecha;

	    @FXML
	     private ImageView idPoster;

	   @FXML
	    private TextArea idResumen;

	    @FXML
	    private TextArea idTitulo;

	    @FXML
	    private TextField textPelicula;


    @FXML
    void buscarPressed(ActionEvent event) throws IOException {
        String busqueda = textPelicula.getText();
        Connector.Connect(busqueda);
        
        Movie[] todasLasPeliculas = Connector.getTodasLasPeliculas();

        if (todasLasPeliculas != null && todasLasPeliculas.length > 0) {
         
        	Movie primeraPelicula = todasLasPeliculas[0];
            String url = primeraPelicula.getPoster_url();
            
            
            idTitulo.setText(primeraPelicula.getTitle());
            idFecha.setText(primeraPelicula.getRelease_date());
            idResumen.setText(primeraPelicula.getSummary());
            String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
            Image image = new Image(urlPoster);
            idPoster.setImage(image);

        } else {
            // No movies found
            textPelicula.setText("No se encontraron películas");
        }
        
    }

}

