package com.ssinitsa.training.culinary.services;

import java.util.List;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ssinitsa.training.culinary.datamodel.Ingredient;

public class GetAllIngredientsServiceTest extends AbstractTest {

	@Inject
	private IIngredientService service;

	private Integer savedIngredientId;
	private Integer savedIngredientId2;

	@After
	public void deleteCreatedIngredient() {
		service.delete(savedIngredientId);
		service.delete(savedIngredientId2);
	}

	@Before
	public void createTest() {
		Ingredient ingredient = new Ingredient();
		ingredient.setName("new ingredient from java");
		ingredient.setCalories(1);
		ingredient.setFats(0.2);
		ingredient.setProteins(0.3);
		ingredient.setCarbohydrates(0.4);
		ingredient.setCategory("new category");
		service.save(ingredient);
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setName("2new ingredient from java");
		ingredient2.setCalories(1);
		ingredient2.setFats(0.2);
		ingredient2.setProteins(0.3);
		ingredient2.setCarbohydrates(0.4);
		ingredient2.setCategory("2new category");
		service.save(ingredient2);
		savedIngredientId = ingredient.getId();
		savedIngredientId2 = ingredient2.getId();

	}

	@Test
	public void getTest() {

		List<Ingredient> ingredients = service.getAll();

		Assert.notNull(ingredients, "ingredients must be saved");
		Assert.isTrue(ingredients.size() >= 2, "number of ingredients must be more then 1");
	}

}
