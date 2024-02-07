package dii2dam.movieApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import dii2dam.movieApp.utils.HibernateUtils;
import dii2dam.movieApp.utils.Manager;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene; // cambio

	@Override
	public void start(Stage stage) throws IOException {
	  
	  // Initialization
	  HibernateUtils.open();
	  HibernateUtils.begin();
	  Manager.loadGenres();
	  
	  scene = new Scene(loadFXML("searchTab"), 1024, 1024);
	  stage.setMinHeight(1024);
	  stage.setMinWidth(1024);
	  stage.setMaximized(true);
	  stage.setScene(scene);
	  stage.show();
	}

	public static void setRoot(String fxml) throws IOException {
		scene.setRoot(loadFXML(fxml));
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}
	@Override
	public void stop () {
		HibernateUtils.close();
	}
	
	public static void main(String[] args) {
		launch();
	}

}