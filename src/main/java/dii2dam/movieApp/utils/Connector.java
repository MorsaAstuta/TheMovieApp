package dii2dam.movieApp.utils;

import java.io.IOException;

import com.google.gson.Gson;

import dii2dam.movieApp.models.APIResponse;
import dii2dam.movieApp.models.Movie;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Connector {
  public static void Connect() throws IOException {
	OkHttpClient client = new OkHttpClient();

	Request request = new Request.Builder()
	  .url("https://api.themoviedb.org/3/search/movie?query=house&include_adult=true&api_key=c2c8d3abe04e48336f9ab967e975df53")
	  .get()
	  .addHeader("accept", "application/json")
	  .addHeader("Authorization", "Bearer c2c8d3abe04e48336f9ab967e975df53")
	  .build();

	Response response = client.newCall(request).execute();
	Gson gson = new Gson();
	APIResponse api = gson.fromJson(response.body().string(), APIResponse.class);
	System.out.println(api.getTotal_pages());
	for (Movie movie: api.getResults()) {
	  System.out.println(movie.getTitle());
	}
  }
  public static void Connect(String search) throws IOException {
	OkHttpClient client = new OkHttpClient();

	Request request = new Request.Builder()
	  .url("https://api.themoviedb.org/3/search/movie?query=" + search + "&include_adult=true")
	  .get()
	  .addHeader("accept", "application/json")
	  .addHeader("Authorization", "Bearer c2c8d3abe04e48336f9ab967e975df53")
	  .build();

	Response response = client.newCall(request).execute();
	Gson gson = new Gson();
	APIResponse api = gson.fromJson(response.body().string(), APIResponse.class);
	for (Movie movie: api.getResults()) {
	  System.out.println(movie.getTitle());
	}
  }
}