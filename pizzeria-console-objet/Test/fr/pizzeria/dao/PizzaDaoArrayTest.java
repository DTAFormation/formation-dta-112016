package fr.pizzeria.dao;

import static org.junit.Assert.*;

import java.util.logging.Logger;

import org.junit.Test;

import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoArrayTest {

	private static final Logger LOG = Logger.getLogger("TestCRUDPizzaLog");
	
	@Test
	public void testAddPizza() throws SavePizzaException {
		
		LOG.info("Instanciation de la classe PizzaDaoArray");
		PizzaDaoArray pizzaDaoArray = new PizzaDaoArray();
		 
		LOG.info("ajout d'une pizza dans la liste");
		Pizza pizza = new Pizza(1, "TEST", "PIZZA DE TEST", 15.45D, enumPizza.VIANDE);
		pizzaDaoArray.saveNewPizza(pizza);
		
		LOG.info("Vérifiation pizza ajouté");
		
		assertEquals("PIZZA DE TEST", pizzaDaoArray.findAllPizzas().stream().filter(p -> p.getNom().equals(pizza.getNom())).findFirst().get().getNom());
		
	}

}
