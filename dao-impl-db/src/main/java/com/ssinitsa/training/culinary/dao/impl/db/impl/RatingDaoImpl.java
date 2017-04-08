package com.ssinitsa.training.culinary.dao.impl.db.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import javax.inject.Inject;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.ssinitsa.training.culinary.dao.impl.db.IRatingDao;
import com.ssinitsa.training.culinary.datamodel.Rating;


@Repository
public class RatingDaoImpl implements IRatingDao {

	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public Rating get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from rating where id = ? ", new Object[] { id },
					new BeanPropertyRowMapper<Rating>(Rating.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public Rating insert(Rating entity) {
		final String INSERT_SQL = "insert into rating (user_id, recipe_id, voice) values(?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setInt (1, entity.getUserId());
				ps.setInt (2, entity.getRecipeId());
				ps.setInt (3, entity.getVoice());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from rating where id=" + id);

	}

	@Override
	public List<Rating> getAll() {
		List<Rating> rs = jdbcTemplate.query("select * from rating ",
				new BeanPropertyRowMapper<Rating>(Rating.class));
		return rs;
	}

	@Override
	public void update(Rating rating) {
		// TODO

	}

	

}
