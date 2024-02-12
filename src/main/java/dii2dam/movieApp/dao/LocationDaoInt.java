package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.a;

public interface LocationDaoInt extends CommonDaoInt<a> {
	public List<a> searchLocationsByUser(Long id);
	a searchLocationByUserIdAndName(Long currentUser, String value);
}
