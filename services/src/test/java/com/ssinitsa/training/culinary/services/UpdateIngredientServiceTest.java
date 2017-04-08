package com.ssinitsa.training.culinary.services;

import javax.inject.Inject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.Assert;

import com.ssinitsa.training.culinary.datamodel.Ingredient;

public class UpdateIngredientServiceTest extends AbstractTest {

	@Inject
	private IIngredientService service;
	
	private Integer savedIngredientId;
	private Ingredient savedIngredient;
	
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
		savedIngredientId = ingredient.getId();
		savedIngredient = service.get(savedIngredientId);
		System.out.println(savedIngredient.toString());

	}
	
	@After
	public void deleteCreatedIngredient(){
		service.delete(savedIngredientId);
		
	}

	@Test
	public void updateTest() {
		Ingredient ingredient2 = new Ingredient();
		ingredient2.setName("2new ingredient from java");
		ingredient2.setCalories(12);
		ingredient2.setFats(0.22);
		ingredient2.setProteins(0.32);
		ingredient2.setCarbohydrates(0.42);
		ingredient2.setCategory("2new category");
		ingredient2.setId(savedIngredientId);
		service.save(ingredient2);

		Ingredient updatedIngredient = service.get(savedIngredientId);
		System.out.println(updatedIngredient.toString());

		Assert.notNull(updatedIngredient, "ingredient must be saved and updated");


		Assert.isTrue(!savedIngredient.equals(updatedIngredient), "ingredients must be not equals");


	}
	
	

}
