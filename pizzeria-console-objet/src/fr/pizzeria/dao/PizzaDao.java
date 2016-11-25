package fr.pizzeria.dao;

import fr.pizzeria.Exception.*;
import fr.pizzeria.model.Pizza;

public interface PizzaDao {

	Pizza[]	findAllPizzas();
//	boolean saveNewPizza(Pizza pizza);
//	boolean updatePizza(String codePizza, Pizza pizza);
//	boolean deletePizza(String codePizza);

	boolean saveNewPizza(Pizza pizza) throws SavePizzaException;
	boolean updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException;
	boolean deletePizza(String codePizza) throws DeletePizzaException;
	
	int getPizzaIdFromCode(String codePizza);
}
