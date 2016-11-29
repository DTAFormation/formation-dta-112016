package fr.pizzeria.ihm;

import java.util.List;

import fr.pizzeria.model.Pizza;

public class ListPizza extends Action {

	private IhmUtil ihmUtil;

	public ListPizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("1. Lister les pizzas");
	}

	@Override
	public void doAction() {
		List<Pizza> list = this.ihmUtil.getPizzaDao().findAllPizzas();
		list.forEach(p -> {
			System.out
					.println(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCatP());
		});
		System.out.println(Pizza.getNbPizzas() + " Pizzas enregistrées");
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
