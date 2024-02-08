package dii2dam.movieApp.models;

public class MovieInfoResponse {
	
	private Integer runtime;

	protected MovieInfoResponse() {
	}

	public MovieInfoResponse(Integer runtime) {
		super();
		setRuntime(runtime);
	}

	public Integer getRuntime() {
		return runtime;
	}

	public void setRuntime(Integer runtime) {
		this.runtime = runtime;
	}
	
}