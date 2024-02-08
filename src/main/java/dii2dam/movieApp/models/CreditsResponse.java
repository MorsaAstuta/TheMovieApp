package dii2dam.movieApp.models;

import java.util.ArrayList;
import java.util.List;

public class CreditsResponse {
	private Actor[] cast;
	private Director[] crew;
	private List<Actor> actors = new ArrayList<>();
	private List<Director> directors = new ArrayList<>();

	protected CreditsResponse() {
	}

	public CreditsResponse(Actor[] cast, Director[] crew) {
		super();
		setCast(cast);
		setCrew(crew);
	}

	public void revampArrays() {
		if (cast != null) {
			for (int i = 0; i < cast.length; i++) {
				if (cast[i].getKnownForDepartment().equals("Acting")) {
					actors.add(cast[i]);
				}
			}
		}
		if (crew != null) {
			for (int i = 0; i < crew.length; i++) {
				if (crew[i].getKnownForDepartment().equals("Directing")) {
					directors.add(crew[i]);
				}
			}
		}
	}

	public Actor[] getCast() {
		return cast;
	}

	public void setCast(Actor[] cast) {
		this.cast = cast;
	}

	public Director[] getCrew() {
		return crew;
	}

	public void setCrew(Director[] crew) {
		this.crew = crew;
	}

	public List<Actor> getActors() {
		return actors;
	}

	public void setActors(List<Actor> actors) {
		this.actors = actors;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

}