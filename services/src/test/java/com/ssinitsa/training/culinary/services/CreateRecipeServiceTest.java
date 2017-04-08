package com.ssinitsa.training.culinary.services;

import java.sql.Timestamp;
import java.util.Date;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ssinitsa.training.culinary.datamodel.Recipe;
import com.ssinitsa.training.culinary.datamodel.User;

public class CreateRecipeServiceTest extends AbstractTest {

	@Inject
	private IRecipeService service;
	
	@Inject
	private IUserService serviceUser;
	private Integer savedUserId;
	private User savedUser;
	
	private Integer savedRecipeId;
	
	@Before
	public void createUserTest() {
		User user = new User();
		user.setLogin("new login");
		user.setPassword("new password");
		user.setRegistrated(new Timestamp(new Date().getTime()));
		user.setFirstName("new FN");
		user.setLastName("new LN");
		user.setEmail ("new e-mail");
		user.setRole("admin");
		serviceUser.save(user);
		savedUserId=user.getId();
		savedUser = serviceUser.get(savedUserId);
		System.out.println(savedUser.toString());

	}
	
	@After
	public void deleteCreatedRecipe(){
		//service.delete(savedRecipeId);
	}

	@Test
	public void createTest() {
		Recipe recipe = new Recipe();
		recipe.setName("new recipe");
		recipe.setDescription("something");
		recipe.setAuthorId(savedUserId);
		recipe.setCreated(new Timestamp (new Date().getTime()));
		recipe.setCategoryId(null);
		service.save(recipe);

		savedRecipeId = recipe.getId();
		Recipe recipeFromDb = service.get(savedRecipeId);
		System.out.println(recipeFromDb.toString());

		/*Assert.notNull(ingredientFromDb, "ingredient must be saved");

		Assert.notNull(ingredientFromDb.getCalories(), "calories column must not me empty");

		Assert.isTrue(ingredientFromDb.getCalories().equals(recipe.getCalories()), "calories must be equals");

		Assert.notNull(ingredientFromDb.getFats(), "fats column must not me empty");

		Assert.isTrue(ingredientFromDb.getFats() == (recipe.getFats()), "fats must be equals");

		Assert.notNull(ingredientFromDb.getProteins(), "proteins column must not me empty");

		Assert.isTrue(ingredientFromDb.getProteins() == (recipe.getProteins()), "proteins must be equals");

		Assert.notNull(ingredientFromDb.getCarbohydrates(), "carbohydrates column must not me empty");

		Assert.isTrue(ingredientFromDb.getCarbohydrates() == (recipe.getCarbohydrates()),
				"carbohydrates must be equals");

		Assert.notNull(ingredientFromDb.getCategory(), "category column must not me empty");

		Assert.isTrue(ingredientFromDb.getCategory().equals(recipe.getCategory()), "category must be equals");*/

	}
	
	

}
