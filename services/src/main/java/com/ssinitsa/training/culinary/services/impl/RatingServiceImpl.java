package com.ssinitsa.training.culinary.services.impl;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.ssinitsa.training.culinary.dao.impl.db.IRatingDao;
import com.ssinitsa.training.culinary.datamodel.Rating;
import com.ssinitsa.training.culinary.services.IRatingService;

@Service
public class RatingServiceImpl implements IRatingService {

	@Inject
	private IRatingDao ratingDao;

	@Override
	public Rating get(Integer id) {
		return ratingDao.get(id);
	}

	@Override
	public List<Rating> getAll() {
		return ratingDao.getAll();
	}

	@Override
	public void save(Rating rating) {
		if (rating.getId() == null) {
			System.out.println("Insert new Rating");
			ratingDao.insert(rating);
		} else {
			ratingDao.update(rating);
		}
	}

	@Override
	public void delete(Integer id) {
		ratingDao.delete(id);

	}

	@Override
	public void saveMultiple(Rating... ratingAray) {

		for (Rating rating : ratingAray) {
			save(rating);
		}

	}
}
