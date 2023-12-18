package dii2dam.movieApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import dii2dam.movieApp.utils.Connector;

/**
 * JavaFX App
 */
public class App extends Application {

	private static Scene scene;
	private Stage stage;
	
	
    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        

        scene = new Scene(loadFXML("apiTest"), 1024, 1024);
        stage.setMinHeight(1024);
        stage.setMinWidth(1024);
        stage.setMaximized(true);
        stage.setScene(scene);
        Connector.Connect(); 
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