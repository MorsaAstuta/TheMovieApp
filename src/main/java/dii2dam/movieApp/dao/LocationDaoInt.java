package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Location;

public interface LocationDaoInt extends CommonDaoInt<Location> {
	public List<Location> searchLocationsByUser(Long id);
	Location searchLocationByUserIdAndName(Long currentUser, String value);
}
