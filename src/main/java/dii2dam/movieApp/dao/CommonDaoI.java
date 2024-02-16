package dii2dam.movieApp.dao;

import java.util.List;

public interface CommonDaoI<T> {

	public void insert(final T paramT);

	public void update(final T paramT);

	public void delete(final T paramT);

	public List<T> searchAll();

}
