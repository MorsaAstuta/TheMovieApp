package dii2dam.movieApp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

import com.google.gson.Gson;

import dii2dam.movieApp.controller.ApiTest;
import dii2dam.movieApp.models.Pelicula;

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
	public static void response(String textField) {
		OkHttpClient client = new OkHttpClient();

		Request request = new Request.Builder()
				.url("https://api.themoviedb.org/3/search/movie?query="
						+ textField + "&include_adult=false&language=en-US&page=1")
				.get().addHeader("accept", "application/json")
				.addHeader("Authorization",
						"Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiIwYmZlMDRhMTMxNDAwZGFhOWY3ZTMyZjJiNjczODU4MyIsInN1YiI6IjY1NzgyM2NhZWM4YTQzMDBhYTZjY2UzYiIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.m7-gkyJOcn5Qfmr0iwEDauK8hArgI5cKE7BzPbTFIDA")
				.build();

		
		Response response = null;
		try {
			response = client.newCall(request).execute();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		String respuesta = response.body().toString();
		Gson gson = new Gson();
		RespuestaAPI respuestaApi = gson.fromJson(respuesta, RespuestaAPI.class);
		for(Pelicula res : respuestaApi.getResults()) {
			System.out.println(res.getTitle());
		}
	}

}