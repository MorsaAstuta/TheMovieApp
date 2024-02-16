package dii2dam.movieApp.dao;

import java.util.List;

import dii2dam.movieApp.models.Location;

public interface LocationDaoI extends CommonDaoI<Location> {
	public List<Location> searchLocationsByUser(Long id);
	Location searchLocationByUserIdAndName(Long currentUser, String value);
	Location searchById(Long id);
}
