package dii2dam.movieApp.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import dii2dam.movieApp.dao.ActorDaoImpl;
import dii2dam.movieApp.dao.CastDaoImpl;
import dii2dam.movieApp.dao.DirectionDaoImpl;
import dii2dam.movieApp.dao.DirectorDaoImpl;
import dii2dam.movieApp.dao.GenreDaoImpl;
import dii2dam.movieApp.dao.MovieGenreDaoImpl;
import dii2dam.movieApp.models.Cast;
import dii2dam.movieApp.models.Direction;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieGenre;
import javafx.scene.control.Alert;

/**
 * CSV file manager
 */
public class CSVUtils {
	
	private static MovieGenreDaoImpl movieGenreDao = new MovieGenreDaoImpl(HibernateUtils.session);
	private static CastDaoImpl castDao = new CastDaoImpl(HibernateUtils.session);
	private static DirectionDaoImpl directionDao = new DirectionDaoImpl(HibernateUtils.session);
	private static DirectorDaoImpl directorDao = new DirectorDaoImpl(HibernateUtils.session);
	private static ActorDaoImpl actorDao = new ActorDaoImpl(HibernateUtils.session);
	private static GenreDaoImpl genreDao = new GenreDaoImpl(HibernateUtils.session);

	public static void export(Movie movie) throws IOException {

		if (movie != null) {
			String downloadsDir = System.getProperty("user.home") + File.separator + "Desktop";

			String fileName = downloadsDir + File.separator + "movie.csv";
			File file = new File(fileName);

			exportCSV(file.getAbsolutePath(), movie);
			Alert alert = new Alert(Alert.AlertType.INFORMATION);
			alert.setTitle("Confirm");
			alert.setHeaderText(null);
			alert.setContentText("Data exported succesfully.");
			alert.showAndWait();
		} else {
			Alert alert = new Alert(Alert.AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText(null);
			alert.setContentText("Could not export data.");
			alert.showAndWait();
		}
	}

	static void exportCSV(String filename, Movie movie) {
		try (FileWriter writer = new FileWriter(filename)) {
			try {
				if (movie.getTitle() != null) writer.append(formatCSVEntry(movie.getTitle()) + ",");
				if (movie.getRelease_date() != null) writer.append(formatCSVEntry(movie.getRelease_date()) + ",");
				if (movie.getReview() != null) writer.append(formatCSVEntry(movie.getReview()) + ",");
				if (movie.getPoster_path() != null) writer.append(formatCSVEntry(movie.getPoster_path()) + ",");
				for (MovieGenre movieGenre : movieGenreDao.searchByMovieId(movie.getId())) {
					writer.append(formatCSVEntry(genreDao.searchByGenreId(movieGenre.getGenre_id()).get(0).getName()) + ",");
				}
				for (Cast cast : castDao.searchByMovieId(movie.getId())) {
					writer.append(formatCSVEntry(actorDao.searchByActorId(cast.getActor_id()).get(0).getName()) + ",");
				}
				for (Direction direction : directionDao.searchByMovieId(movie.getId())) {
					writer.append(formatCSVEntry(directorDao.searchByDirectorId(direction.getDirector_id()).get(0).getName()) + ",");
				}
				if (movie.getLocation_id() != null) writer.append(movie.getLocation_id() + ",");
				if (movie.getStatus() != null) writer.append(formatCSVEntry(movie.getStatus()) + ",");
				if (movie.getRuntime() != null) writer.append(movie.getRuntime() + ",");
				if (movie.getRating() != null) writer.append(movie.getRating() + ",");
				if (movie.getOverview() != null) writer.append(formatCSVEntry(movie.getOverview()) + ",");
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static String formatCSVEntry(String entry) {
		return "\"" + entry.replace("\"", "\"\"") + "\"";
	}
}
