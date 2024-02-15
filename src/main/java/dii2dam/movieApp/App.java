package dii2dam.movieApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
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

		scene = new Scene(loadFXML("configureAccount"), 1024, 1024);
		stage.setMinHeight(1024);
		stage.setMinWidth(1024);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}

	public static void setRoot(String fxml) throws IOException {
		Manager.parentval.add(scene.getRoot());
		scene.setRoot(loadFXML(fxml));
	}

	public static void loadLast(Parent parent) throws IOException {
		scene.setRoot(parent);
	}

	public static File loadFileChooser() throws IOException {
		return (new FileChooser()).showOpenDialog(scene.getWindow());
	}

	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	@Override
	public void stop() {
		HibernateUtils.close();
	}

	public static void main(String[] args) {
		launch();
	}

}