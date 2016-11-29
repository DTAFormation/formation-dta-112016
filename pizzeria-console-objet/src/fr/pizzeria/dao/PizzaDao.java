package fr.pizzeria.dao;

import fr.pizzeria.Exception.*;
import fr.pizzeria.model.Pizza;

import java.util.List;

public interface PizzaDao {

	List<Pizza> findAllPizzas();
//	boolean saveNewPizza(Pizza pizza);
//	boolean updatePizza(String codePizza, Pizza pizza);
//	boolean deletePizza(String codePizza);

	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	boolean updatePizza(String codePizza, Pizza pizza) ;
	boolean deletePizza(String codePizza);
	
	int getPizzaIdFromCode(String codePizza);
}
