package dii2dam.movieApp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import dii2dam.movieApp.App;
import dii2dam.movieApp.dao.ActorDaoImp;
import dii2dam.movieApp.models.Actor;
import dii2dam.movieApp.models.Director;
import dii2dam.movieApp.models.Movie;
import dii2dam.movieApp.models.MovieInfoResponse;
import dii2dam.movieApp.models.CreditsResponse;
import dii2dam.movieApp.models.Review;
import dii2dam.movieApp.models.ReviewResponse;
import dii2dam.movieApp.utils.Manager;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class MyListRecord {
	private CreditsResponse creditsResponse;
	private MovieInfoResponse movieInfoResponse;
	private ReviewResponse reviewResponse;

	private List<Actor> actors = new ArrayList<>();
	private Integer actorPage = 1;

	private List<Director> directors = new ArrayList<>();

	private List<Review> reviews = new ArrayList<>();
	private Integer reviewPage = 1;

	@FXML
	private ImageView imgActor1;

	@FXML
	private ImageView imgActor2;

	@FXML
	private ImageView imgActor3;

	@FXML
	private ImageView imgActor4;

	@FXML
	private ImageView posterMovie;

	@FXML
	private Label textComment1;

	@FXML
	private Label textComment2;

	@FXML
	private Label textComment3;

	@FXML
	private Label textDate;

	@FXML
	private Label textDirector;

	@FXML
	private Label textGenre;

	@FXML
	private Label textSinopsis;
	@FXML
	private Pane btnMyList;

	@FXML
	private Label rate;

	@FXML
	private Label textTime;

	@FXML
	private Label textTittle;

	private Movie movie;

	@FXML
	private Button btnLeftActors;

	@FXML
	private Button btnRightActor;

	@FXML
	private Label labelNameAct1;

	@FXML
	private Label labelNameAct2;

	@FXML
	private Label labelNameAct3;

	@FXML
	private Label labelNameAct4;

	@FXML
	private Label labelUsernameReview1;

	@FXML
	private Label labelUsernameReview2;

	@FXML
	private Label labelUsernameReview3;

	@FXML
	private ImageView imgUserReview1;

	@FXML
	private ImageView imgUserReview2;

	@FXML
	private ImageView imgUserReview3;

	@FXML
	private ComboBox<String> comboBoxStateMovie;

	private ActorDaoImp actorDaoImpl;

	@FXML
	void goToAccount(MouseEvent event) {
		try {
			App.setRoot("accountPage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goToHomePage(MouseEvent event) {
		try {
			App.setRoot("homePage");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goToMyList(MouseEvent event) {
		try {
			App.setRoot("");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@FXML
	void goBack(MouseEvent event) {
		Manager.goToLastPage();
	}

	@FXML
	void exportAsCSV(MouseEvent event) {
	}

	@FXML
	void retractMyList(MouseEvent event) {
		btnMyList.setVisible(false);
	}

	@FXML
	void expandMyList(MouseEvent event) {
		btnMyList.setVisible(true);

	}

	public void initialize() {
		movie = Manager.getMovie();

		actors = actorDaoImpl.searchByMovieId(movie.getId());

		ObservableList<String> items = FXCollections.observableArrayList();
		items.add("State: ");
		items.add("Watching");
		items.add("Unwatched");
		items.add("Drop");
		items.add("On Hold");
		comboBoxStateMovie.setItems(items);
		comboBoxStateMovie.getSelectionModel().selectFirst();
		textComment1.setText(movie.getReview());

		visibleBtnLeft();
		loadActors();

	}

	private void loadActors() {
		for (Actor actor : actors) {
			String url = actor.getProfilePath();
			String urlPoster = "https://image.tmdb.org/t/p/w500" + url;
			Image image = new Image(urlPoster);
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 0) {
				imgActor1.setImage(image);
				labelNameAct1.setText(actor.getName());
			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 1) {
				imgActor2.setImage(image);
				labelNameAct2.setText(actor.getName());

			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 2) {
				imgActor3.setImage(image);
				labelNameAct3.setText(actor.getName());

			}
			if (actors.indexOf(actor) == (actorPage - 1) * 4 + 3) {
				imgActor4.setImage(image);
				labelNameAct4.setText(actor.getName());

			}
			visibleBtnLeft();
			visibleBtnRight();
		}
	}

	private void visibleBtnLeft() {
		if (actorPage > 1)
			btnLeftActors.setVisible(true);
		else
			btnLeftActors.setVisible(false);
	}

	private void visibleBtnRight() {
		Integer actorTotalPages = actors.size() / 4;
		if (actors.size() % 4 != 0) {
			actorTotalPages++;
		}
		if (actorPage < actorTotalPages)
			btnRightActor.setVisible(true);
		else
			btnRightActor.setVisible(false);
	}

	@FXML
	void pressedActorsLeft(MouseEvent event) {
		if (actorPage > 1) {
			actorPage--;
			loadActors();
		}
	}

	@FXML
	void pressedActorsRight(MouseEvent event) {
		if (actorPage >= 1) {
			actorPage++;
			loadActors();
		}

	}

}
