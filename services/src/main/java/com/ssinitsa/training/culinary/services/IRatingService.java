package com.ssinitsa.training.culinary.services;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.ssinitsa.training.culinary.datamodel.Rating;

public interface IRatingService {

	Rating get(Integer id);

	@Transactional
	void save(Rating rating);

	@Transactional
	void saveMultiple(Rating... rating);

	List<Rating> getAll();

	@Transactional
	void delete(Integer id);
}
