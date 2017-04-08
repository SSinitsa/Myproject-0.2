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

import com.ssinitsa.training.culinary.dao.impl.db.IUserDao;
import com.ssinitsa.training.culinary.datamodel.User;

@Repository
public class UserDaoImpl implements IUserDao {
	@Inject
	private JdbcTemplate jdbcTemplate;

	@Override
	public User get(Integer id) {
		try {
			return jdbcTemplate.queryForObject("select * from \"user\" where \"id\" = ? ", new Object[] { id },
					new BeanPropertyRowMapper<User>(User.class));
		} catch (EmptyResultDataAccessException e) {
			return null;
		}
	}

	@Override
	public User insert(User entity) {
		final String INSERT_SQL = "insert into \"user\" (\"login\", \"password\", \"registrated\", \"first_name\", \"last_name\", \"email\", \"role\") values(?,?,?,?,?,?,?)";
		KeyHolder keyHolder = new GeneratedKeyHolder();

		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement(INSERT_SQL, new String[] { "id" });
				ps.setString(1, entity.getLogin());
				ps.setString(2, entity.getPassword());
				ps.setTimestamp(3, entity.getRegistrated());
				ps.setString(4, entity.getFirstName());
				ps.setString(5, entity.getLastName());
				ps.setString(6, entity.getEmail());
				ps.setString(7, entity.getRole());
				return ps;
			}
		}, keyHolder);
		entity.setId(keyHolder.getKey().intValue());

		return entity;
	}

	@Override
	public void delete(Integer id) {
		jdbcTemplate.update("delete from \"user\" where \"id\"=" + id);

	}

	@Override
	public List<User> getAll() {
		List<User> rs = jdbcTemplate.query("select * from \"user\" ", new BeanPropertyRowMapper<User>(User.class));
		return rs;
	}

	@Override
	public void update(User user) {
		jdbcTemplate.update(new PreparedStatementCreator() {
			@Override
			public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
				PreparedStatement ps = connection.prepareStatement("update \"user\" set "
						+ "\"login\"=?, \"password\"=?, \"registrated\"=?, \"first_name\"=?, \"last_name\"=?, \"email\"=?, \"role\"=? where \"id\"=?");
				ps.setString(1, user.getLogin());
				ps.setString(2, user.getPassword());
				ps.setTimestamp(3, user.getRegistrated());
				ps.setString(4, user.getFirstName());
				ps.setString(5, user.getLastName());
				ps.setString(6, user.getEmail());
				ps.setString(7, user.getRole());
				ps.setInt(8, user.getId());
				return ps;
			}
		});

	}

}
