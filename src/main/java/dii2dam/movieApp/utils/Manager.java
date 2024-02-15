package dii2dam.movieApp.utils;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dii2dam.movieApp.App;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.Review;
import dii2dam.movieApp.models.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Manager {
	public static Movie movie;
	public static Review review;
	public static User user;
	public static String discoveryType;
	public static Long currentUser = Long.parseLong("1");
	public static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public static List<Parent> parentval = new ArrayList<Parent>();

	// Movie genres
	public static HashMap<Integer, String> genreById = new HashMap<>();
	public static HashMap<String, Integer> idByGenre = new HashMap<>();

	public static List<Integer> genreIds = new ArrayList<>();
	public static List<String> genreNames = new ArrayList<>();
	

	public static void loadGenres() {
		genreIds.add(12);
		genreNames.add("Adventure");
		genreIds.add(14);
		genreNames.add("Fantasy");
		genreIds.add(16);
		genreNames.add("Animation");
		genreIds.add(18);
		genreNames.add("Drama");
		genreIds.add(27);
		genreNames.add("Horror");
		genreIds.add(28);
		genreNames.add("Action");
		genreIds.add(35);
		genreNames.add("Comedy");
		genreIds.add(36);
		genreNames.add("History");
		genreIds.add(37);
		genreNames.add("Western");
		genreIds.add(53);
		genreNames.add("Thriller");
		genreIds.add(80);
		genreNames.add("Crime");
		genreIds.add(99);
		genreNames.add("Documentary");
		genreIds.add(878);
		genreNames.add("Science Fiction");
		genreIds.add(9648);
		genreNames.add("Mystery");
		genreIds.add(10402);
		genreNames.add("Music");
		genreIds.add(10749);
		genreNames.add("Romance");
		genreIds.add(10751);
		genreNames.add("Family");
		genreIds.add(10752);
		genreNames.add("War");
		genreIds.add(10759);
		genreNames.add("Action & Adventure");
		genreIds.add(10762);
		genreNames.add("Kids");
		genreIds.add(10763);
		genreNames.add("News");
		genreIds.add(10764);
		genreNames.add("Reality");
		genreIds.add(10765);
		genreNames.add("Sci-Fi & Fantasy");
		genreIds.add(10766);
		genreNames.add("Soap");
		genreIds.add(10767);
		genreNames.add("Talk");
		genreIds.add(10768);
		genreNames.add("War & Politics");
		genreIds.add(10770);
		genreNames.add("TV Movie");
		for (int i = 0; i < genreIds.size(); i++) {
			genreById.put(genreIds.get(i), genreNames.get(i));
			idByGenre.put(genreNames.get(i), genreIds.get(i));
		}
	}
	
	public static Movie getMovie() {
		return movie;
	}

	public static void setMovie(Movie movie) {
		Manager.movie = movie;
	}

	public static HashMap<Integer, String> getMovieGenreById() {
		return genreById;
	}

	public static void setMovieGenreById(HashMap<Integer, String> movieGenreById) {
		Manager.genreById = movieGenreById;
	}

	public static List<Integer> getGenreIds() {
		return genreIds;
	}

	public static void setGenreIds(List<Integer> genreIds) {
		Manager.genreIds = genreIds;
	}

	public static List<String> getGenreNames() {
		return genreNames;
	}

	public static void setGenreNames(List<String> genreNames) {
		Manager.genreNames = genreNames;
	}

	public static Review getReview() {
		return review;
	}

	public static void setReview(Review review) {
		Manager.review = review;
	}

	public static String getDiscoveryType() {
		return discoveryType;
	}

	public static void setDiscoveryType(String discoveryType) {
		Manager.discoveryType = discoveryType;
	}

	public static void goToLastPage() {
		try {
			back(parentval.get(parentval.size() - 1));
		} catch (IOException e) {
			e.printStackTrace();
		}
		parentval.remove(parentval.size() - 1);
	}

	public static void back(Parent parent) throws IOException {
		try {
			App.loadLast(parent);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Long getCurrentUser() {
		return currentUser;
	}

	public static void setCurrentUser(Long currentUser) {
		Manager.currentUser = currentUser;
	}

	public static List<Parent> getParentval() {
		return parentval;
	}

	public static void setParentval(List<Parent> parentval) {
		Manager.parentval = parentval;
	}

	public static HashMap<Integer, String> getGenreById() {
		return genreById;
	}

	public static void setGenreById(HashMap<Integer, String> genreById) {
		Manager.genreById = genreById;
	}

	public static HashMap<String, Integer> getIdByGenre() {
		return idByGenre;
	}

	public static void setIdByGenre(HashMap<String, Integer> idByGenre) {
		Manager.idByGenre = idByGenre;
	}
	

	public static SimpleDateFormat getSdf() {
		return sdf;
	}

	public static void setSdf(SimpleDateFormat sdf) {
		Manager.sdf = sdf;
	}

}
