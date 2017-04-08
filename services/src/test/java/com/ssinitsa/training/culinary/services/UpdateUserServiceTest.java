package com.ssinitsa.training.culinary.services;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ssinitsa.training.culinary.datamodel.User;

public class UpdateUserServiceTest extends AbstractTest {

	@Inject
	private IUserService service;
	
	private Integer savedUserId;
	private User savedUser;
	
	@Before
	public void createTest() {
		User user = new User();
		user.setLogin("new login");
		user.setPassword("new password");
		user.setRegistrated(new Timestamp(new Date().getTime()));
		user.setFirstName("new FN");
		user.setLastName("new LN");
		user.setEmail ("new e-mail");
		user.setRole("admin");
		service.save(user);
		savedUserId=user.getId();
		savedUser = service.get(savedUserId);
		System.out.println(savedUser.toString());

	}
	
	@After
	public void deleteCreatedIngredient(){
		//service.delete(savedUserId);
		
	}

	@Test
	public void updateTest() {
		User user2 = new User();
		user2.setLogin("2new login");
		user2.setPassword("2new password");
		user2.setRegistrated(new Timestamp(new Date().getTime()));
		user2.setFirstName("2new FN");
		user2.setLastName("2new LN");
		user2.setEmail ("2new e-mail");
		user2.setRole("admin");
		user2.setId(savedUserId);
		service.save(user2);
		User updatedUser = service.get(savedUserId);
		System.out.println(updatedUser.toString());

		Assert.notNull(updatedUser, "user must be saved and updated");


		Assert.isTrue(!savedUser.equals(updatedUser), "users must be not equals");


	}
	
	

}
