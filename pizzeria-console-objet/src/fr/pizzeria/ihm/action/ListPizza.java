package fr.pizzeria.ihm.action;

import fr.pizzeria.exception.PizzaException;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class ListPizza extends Action {

	private IhmUtil utils;

	public ListPizza(IhmUtil utils) {
		super();
		this.setDescription("1. Lister les pizzas");
		this.utils = utils;
	}

	@Override
	public void doAction() throws PizzaException {

		for (Pizza p : utils.getPizzaDao().findAllPizzas()) {
			System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + " �)");
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
