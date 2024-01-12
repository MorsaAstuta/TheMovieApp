package dii2dam.movieApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	
	@Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Account"), 1024, 1024);
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

	public static void main(String[] args) {
		launch();
	}

	

}