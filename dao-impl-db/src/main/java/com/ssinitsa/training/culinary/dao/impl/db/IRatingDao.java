package com.ssinitsa.training.culinary.dao.impl.db;

import java.util.List;

import com.ssinitsa.training.culinary.datamodel.Rating;

public interface IRatingDao {

	Rating get(Integer id);

	Rating insert(Rating rating);

	void update(Rating rating);

	List<Rating> getAll();

	void delete(Integer id);

}
