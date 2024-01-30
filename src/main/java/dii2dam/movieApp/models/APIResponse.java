package dii2dam.movieApp.models;

public class APIResponse {
  private Integer page;
  private Movie[] results;
  private Integer total_pages;
  private Integer totalResults;
  
  protected APIResponse() {
  }

  public APIResponse(Integer page, Movie[] results, Integer total_pages, Integer total_results) {
	super();
	setPage(page);
	setResults(results);
	setTotalPages(total_pages);
	setTotalResults(total_results);
  }
  
  public Integer getPage() {
	return page;
  }
  
  public void setPage(int page) {
	this.page = page;
  }
  
  public Movie[] getResults() {
	return results;
  }
  
  public void setResults(Movie[] results) {
	this.results = results;
  }
  
  public Integer getTotalPages() {
	return total_pages;
  }
  
  public void setTotalPages(int total_pages) {
	this.total_pages = total_pages;
  }
  
  public Integer getTotalResults() {
	return totalResults;
  }
  
  public void setTotalResults(int total_results) {
	this.totalResults = total_results;
  }
}
