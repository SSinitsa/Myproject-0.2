package com.ssinitsa.training.culinary.services;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ssinitsa.training.culinary.datamodel.Ingredient;

public class SaveMultipleIngredientsServiceTest extends AbstractTest {

	@Inject
	private IIngredientService service;

	private Integer savedIngredientId;
	private Integer savedIngredientId2;

	Ingredient ingredient = new Ingredient();
	Ingredient ingredient2 = new Ingredient();

	@After
	public void deleteCreatedIngredient() {
		service.delete(savedIngredientId);
		service.delete(savedIngredientId2);
	}

	@Before
	public void createTest() {
		ingredient.setName("new ingredient from java");
		ingredient.setCalories(1);
		ingredient.setFats(0.2);
		ingredient.setProteins(0.3);
		ingredient.setCarbohydrates(0.4);
		ingredient.setCategory("new category");
		service.save(ingredient);
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

		service.saveMultiple(ingredient, ingredient2);

		Assert.notNull(ingredient, "ingredients must be saved");
		Assert.notNull(ingredient2, "ingredients must be saved");
		Assert.isTrue(!ingredient.equals(ingredient2), "ingredients must be different");

	}

}
