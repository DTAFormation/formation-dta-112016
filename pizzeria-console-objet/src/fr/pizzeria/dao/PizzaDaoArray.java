package fr.pizzeria.dao;

import fr.pizzeria.Exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PizzaDaoArray implements PizzaDao {

	private List<Pizza> pizzas = new ArrayList<>() ;
	/*{
			,
			,
			,
			,
			,
			,
			,
			,
	};
*/
	@Override
	public List<Pizza> findAllPizzas() {
		return pizzas;
	}

	@Override
	public boolean saveNewPizza(Pizza pizza) throws SavePizzaException {
/*
		List<Pizza> newMenu = new ArrayList<Pizza>();

		for (int i = 0; i < pizzas.length; ++i) {
			newMenu[i] = new Pizza();
			newMenu[i].setId(pizzas[i].getId());
			newMenu[i].setCode(pizzas[i].getCode());
			newMenu[i].setNom(pizzas[i].getNom());
			newMenu[i].setPrix(pizzas[i].getPrix());
		}

		newMenu[pizzas.length] = new Pizza();
		newMenu[pizzas.length].setId(pizza.getId());
		newMenu[pizzas.length].setCode(pizza.getCode());
		newMenu[pizzas.length].setNom(pizza.getNom());
		newMenu[pizzas.length].setPrix(pizza.getPrix());

		pizzas = newMenu;
*/

		boolean pOK = false;
		if (pizza!=null) {


			pizzas.add(pizza);


			Pizza.nbPizzas++;
			pOK =  true;
		}else
		{
			throw new SavePizzaException("la pizza n'est pas valide ! ");

		}
		return pOK;
	}

	@Override
	public boolean updatePizza(String codePizza, Pizza pizza) {
		return false;
	}

	@Override
	public boolean deletePizza(String codePizza) {
	/*
		Pizza[] newMenu = new Pizza[pizzas.length - 1];

		for (int i = 0; i < pizzas.length - 1; i++) {

			if (!codePizza.equals(pizzas[i].getCode())) {
				newMenu[i] = new Pizza();
				newMenu[i].setId(pizzas[i].getId());
				newMenu[i].setCode(pizzas[i].getCode());
				newMenu[i].setNom(pizzas[i].getNom());
				newMenu[i].setPrix(pizzas[i].getPrix());
			}
		}

		pizzas = newMenu;

		Pizza.nbPizzas--;
		return true;
	*/

		;
		boolean action = false;
		if (!pizzas.remove(pizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst().get()) == true)
		{
		 action = true;
		}
		return action;
	}

	@Override
	public int getPizzaIdFromCode(String codePizza) {

		/*for (int i = 0; i < this.pizzas.length; ++i) {
			if (this.pizzas[i].getCode().equals(codePizza)) {
				return this.pizzas[i].getId();
			}
		}*/
		Optional<Pizza> o =   pizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();
		if (o.isPresent())
		{
			System.out.println("saluti ez");
			return o.get().getId();
		}
		return -1;
	}

	public PizzaDaoArray()
	{
		super();
		pizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, enumPizza.VIANDE));
		pizzas.add(new Pizza( 1, "MAR", "Margherita", 14.00, enumPizza.VIANDE));
		pizzas.add(new Pizza(2, "REI", "La Reine", 11.50, enumPizza.VIANDE));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00,enumPizza.SANSVP));
		pizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, enumPizza.VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, enumPizza.VIANDE));
		pizzas.add(new Pizza(6, "ORI", "L’orientale", 13.50, enumPizza.VIANDE));
		pizzas.add(new Pizza(7, "IND", "L’indienne", 14.00, enumPizza.POISSON));

	}
}
