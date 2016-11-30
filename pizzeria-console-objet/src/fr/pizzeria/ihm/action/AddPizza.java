package fr.pizzeria.ihm.action;

import fr.pizzeria.Exception.*;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

public class AddPizza extends Action {

	private IhmUtil utils;

	public AddPizza(IhmUtil utils) {
		super();
		this.setDescription("Ajouter une nouvelle pizza");
		this.utils = utils;
	}

	@Override
	public void do_action() {

		
	try {
		System.out.println("Veuillez saisir le code");
		String code = this.utils.getScanner().next();

		System.out.println("Veuillez saisir le nom (sans espace)");
		String name = this.utils.getScanner().next();

		System.out.println("Veuillez saisir le prix");
		String price = this.utils.getScanner().next();

		Pizza newPizza = new Pizza();
		newPizza.setId((int)(this.utils.getPizzaDao().findAllPizzas().stream().count()));
		newPizza.setCode(code);
		newPizza.setNom(name);
		try {
			newPizza.setPrix(Double.parseDouble(price));
		} catch (Exception e) {
			System.out.println("Invalid price");
		}
		
		utils.getPizzaDao().saveNewPizza(newPizza);
	} catch (SavePizzaException | NumberFormatException a ) {

	}
		

		
	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}

}
