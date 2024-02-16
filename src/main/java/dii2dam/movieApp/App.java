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
 * Starts the program and has multiple static methods to load FXML files
 */
public class App extends Application {

	private static Scene scene;

	/**
	 * Commences the program by loading the LOG IN fxml
	 */
	@Override
	public void start(Stage stage) throws IOException {

		// Initialization
		HibernateUtils.open();
		HibernateUtils.begin();
		Manager.loadGenres();

		scene = new Scene(loadFXML("logIn"), 1024, 1024);
		stage.setMinHeight(1024);
		stage.setMinWidth(1024);
		stage.setMaximized(true);
		stage.setScene(scene);
		stage.show();
	}

	/**
	 * Sets the FXML content to the page specified by loading a file
	 * @param fxml
	 * @throws IOException
	 */
	public static void setRoot(String fxml) throws IOException {
		Manager.parentval.add(scene.getRoot());
		scene.setRoot(loadFXML(fxml));
	}

	/**
	 * Loads the last screen seen
	 * @param parent
	 * @throws IOException
	 */
	public static void loadLast(Parent parent) throws IOException {
		scene.setRoot(parent);
	}

	/**
	 * Loads a FileChooser alert to return the file chosen
	 * @return
	 * @throws IOException
	 */
	public static File loadFileChooser() throws IOException {
		return (new FileChooser()).showOpenDialog(scene.getWindow());
	}

	/**
	 * Loads a specific FXML file
	 * @param fxml
	 * @return
	 * @throws IOException
	 */
	private static Parent loadFXML(String fxml) throws IOException {
		FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
		return fxmlLoader.load();
	}

	/**
	 * Closes Hibernate session when the App stops by any reason
	 */
	@Override
	public void stop() {
		HibernateUtils.close();
	}

	/**
	 * Main method: Launches the application
	 * @param args
	 */
	public static void main(String[] args) {
		launch();
	}

}