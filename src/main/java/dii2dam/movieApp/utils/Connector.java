package dii2dam.movieApp.utils;

import java.io.IOException;

import com.google.gson.Gson;

import dii2dam.movieApp.models.APIResponse;
import dii2dam.movieApp.models.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Connector {

  public static APIResponse connect(String search) throws IOException {
	OkHttpClient client = new OkHttpClient();
	
	String apiUrl = "https://api.themoviedb.org/3/search/multi?query=" + search + "&include_adult=true&api_key=c2c8d3abe04e48336f9ab967e975df53";
	System.out.println(apiUrl);
	Request request = new Request.Builder()
		.url(apiUrl)
		.get()
		.addHeader("accept", "application/json")
		.build();
	Response response = client.newCall(request).execute();
	String responseBody = response.body().string();
	Gson gson = new Gson();
	APIResponse api = gson.fromJson(responseBody, APIResponse.class);
	
	for (Movie movie: api.getResults()) {
	  movie.getGenre();
	  
      
	}
	return api;
  }
  

}