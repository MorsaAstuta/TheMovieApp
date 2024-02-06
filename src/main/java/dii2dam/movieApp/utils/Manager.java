package dii2dam.movieApp.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dii2dam.movieApp.models.Movie;

public class Manager {
  public static Movie movie;
  
  // Movie genres
  public static HashMap<Integer, String> movieGenreById = new HashMap<>();
  
  // TV genres
  public static HashMap<Integer, String> tvGenreById = new HashMap<>();
  
  public static void loadGenres() {
	List<Integer> genreIds = new ArrayList<>();
	List<String> genreNames = new ArrayList<>();
	genreIds.add(12); genreNames.add("Adventure");
	genreIds.add(14); genreNames.add("Fantasy");
	genreIds.add(16); genreNames.add("Animation");
	genreIds.add(18); genreNames.add("Drama");
	genreIds.add(27); genreNames.add("Horror");
	genreIds.add(28); genreNames.add("Action");
	genreIds.add(35); genreNames.add("Comedy");
	genreIds.add(36); genreNames.add("History");
	genreIds.add(37); genreNames.add("Western");
	genreIds.add(53); genreNames.add("Thriller");
	genreIds.add(80); genreNames.add("Crime");
	genreIds.add(99); genreNames.add("Documentary");
	genreIds.add(878); genreNames.add("Science Fiction");
	genreIds.add(9648); genreNames.add("Mystery");
	genreIds.add(10402); genreNames.add("Music");
	genreIds.add(10749); genreNames.add("Romance");
	genreIds.add(10751); genreNames.add("Family");
	genreIds.add(10759); genreNames.add("Action & Adventure");
	genreIds.add(10762); genreNames.add("Kids");
	genreIds.add(10763); genreNames.add("News");
	genreIds.add(10764); genreNames.add("Reality");
	genreIds.add(10765); genreNames.add("Sci-Fi & Fantasy");
	genreIds.add(10766); genreNames.add("Soap");
	genreIds.add(10767); genreNames.add("Talk");
	genreIds.add(10768); genreNames.add("War & Politics");
	genreIds.add(10770); genreNames.add("TV Movie");
	genreIds.add(10752); genreNames.add("War");
	for (int i = 0; i < genreIds.size(); i++) {
	  movieGenreById.put(genreIds.get(i), genreNames.get(i));
	}
	
	genreIds.clear();
	genreNames.clear();
	for (int i = 0; i < genreIds.size(); i++) {
	  movieGenreById.put(genreIds.get(i), genreNames.get(i));
	}
	
	
	
  }
  
}
