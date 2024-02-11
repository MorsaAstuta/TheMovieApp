package dii2dam.movieApp.models;

public class MovieInfoResponse {
	
	private String runtime;

	protected MovieInfoResponse() {
	}

	public MovieInfoResponse(String runtime) {
		super();
		setRuntime(runtime);
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	
}