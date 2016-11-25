package fr.pizzeria.ihm;

import fr.pizzeria.dao.IPizzaDao;
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
		for (Pizza p : this.ihmUtil.getPizzaDao().findAllPizzas()){
			System.out.println(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix());
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
