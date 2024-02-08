package dii2dam.movieApp.models;

public class ReviewResponse {
	
	private Review[] results;
	private Integer total_pages;
	private Integer page;

	protected ReviewResponse() {
	}

	public ReviewResponse(Review[] results) {
		super();
		setReviews(results);
	}

	public Review[] getReviews() {
		return results;
	}

	public void setReviews(Review[] reviews) {
		this.results = reviews;
	}

	public Integer getTotal_pages() {
		return total_pages;
	}

	public void setTotal_pages(Integer total_pages) {
		this.total_pages = total_pages;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}
	
}