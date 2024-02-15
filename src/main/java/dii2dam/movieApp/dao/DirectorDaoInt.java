package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Director;

public interface DirectorDaoInt extends CommonDaoInt<Director> {
	public List<Director> searchByDirectorId(final Long id);
	public Director searchByName(String name);
	Director searchById(Long id);
}
