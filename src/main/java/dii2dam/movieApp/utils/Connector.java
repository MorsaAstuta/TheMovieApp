package dii2dam.movieApp.utils;

import java.io.IOException;

import com.google.gson.Gson;

import dii2dam.movieApp.models.APIResponse;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieInfoResponse;
import dii2dam.movieApp.models.ReviewResponse;
import dii2dam.movieApp.models.CreditsResponse;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class Connector {

  public static APIResponse searchMulti(String search) throws IOException {
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
	
	return api;
  }

  public static APIResponse searchMovie(String search) throws IOException {
	OkHttpClient client = new OkHttpClient();
	
	String apiUrl = "https://api.themoviedb.org/3/search/movie?query=" + search + "&include_adult=true&api_key=c2c8d3abe04e48336f9ab967e975df53";
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
	
	return api;
  }

  public static APIResponse searchSeries(String search) throws IOException {
	OkHttpClient client = new OkHttpClient();
	
	String apiUrl = "https://api.themoviedb.org/3/search/tv?query=" + search + "&include_adult=true&api_key=c2c8d3abe04e48336f9ab967e975df53";
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
	
	return api;
  }

  public static CreditsResponse getMovieCredits(String type, Integer id) throws IOException {
	OkHttpClient client = new OkHttpClient();
	
	String apiUrl = "https://api.themoviedb.org/3/" + type + "/" + id + "/credits?api_key=c2c8d3abe04e48336f9ab967e975df53";
	System.out.println(apiUrl);
	Request request = new Request.Builder()
		.url(apiUrl)
		.get()
		.addHeader("accept", "application/json")
		.build();
	Response response = client.newCall(request).execute();
	String responseBody = response.body().string();
	Gson gson = new Gson();
	CreditsResponse api = gson.fromJson(responseBody, CreditsResponse.class);
	
	return api;
  }

  public static MovieInfoResponse getMovieInfo(String type, Integer id) throws IOException {
	OkHttpClient client = new OkHttpClient();
	
	String apiUrl = "https://api.themoviedb.org/3/" + type + "/" + id + "?api_key=c2c8d3abe04e48336f9ab967e975df53";
	System.out.println(apiUrl);
	Request request = new Request.Builder()
		.url(apiUrl)
		.get()
		.addHeader("accept", "application/json")
		.build();
	Response response = client.newCall(request).execute();
	String responseBody = response.body().string();
	Gson gson = new Gson();
	MovieInfoResponse api = gson.fromJson(responseBody, MovieInfoResponse.class);
	
	return api;
  }

  public static ReviewResponse getMovieReviews(String type, Integer id, Integer page) throws IOException {
	OkHttpClient client = new OkHttpClient();
	
	String apiUrl = "https://api.themoviedb.org/3/" + type + "/" + id + "/reviews?api_key=c2c8d3abe04e48336f9ab967e975df53&page=" + page;
	System.out.println(apiUrl);
	Request request = new Request.Builder()
		.url(apiUrl)
		.get()
		.addHeader("accept", "application/json")
		.build();
	Response response = client.newCall(request).execute();
	String responseBody = response.body().string();
	Gson gson = new Gson();
	ReviewResponse api = gson.fromJson(responseBody, ReviewResponse.class);
	
	return api;
  }
  

}