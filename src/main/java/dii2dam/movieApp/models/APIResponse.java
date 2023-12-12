package dii2dam.movieApp.models;

public class APIResponse {
  private Integer page;
  private Movie[] results;
  private Integer total_pages;
  private Integer total_results;
  
  public APIResponse(Integer page, Movie[] results, Integer total_pages, Integer total_results) {
	super();
	setPage(page);
	setResults(results);
	setTotal_pages(total_pages);
	setTotal_results(total_results);
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
  
  public Integer getTotal_pages() {
	return total_pages;
  }
  
  public void setTotal_pages(int total_pages) {
	this.total_pages = total_pages;
  }
  
  public Integer getTotal_results() {
	return total_results;
  }
  
  public void setTotal_results(int total_results) {
	this.total_results = total_results;
  }
}
