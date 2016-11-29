package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class ListPizzaPrix extends Action {

	private IhmUtil ihmUtil;

	public ListPizzaPrix(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("6. Afficher la Pizza la plus cher");
	}

	@Override
	public void doAction() {
		Pizza p = this.ihmUtil.getPizzaDao().findAllPizzasPrix();
		System.out.println(p.getId() + " " + p.getCode() + " " + p.getNom() + " " + p.getPrix() + " " + p.getCatP());

		// System.out.println(Pizza.getNbPizzas() + " Pizzas enregistrées");
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
