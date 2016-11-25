package fr.pizzeria.ihm;


import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.model.Pizza;

public class AddPizza extends Action {


	private IhmUtil ihmUtil;

	public AddPizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("2. Ajouter une nouvelle pizza");
	}

	@Override
	public void doAction() {
		System.out.println("Créez votre Pizza. \nCode de la Pizza");
		String code = ihmUtil.getScanner().next();
		System.out.println("Nom de la Pizza");
		String nom = ihmUtil.getScanner().next();
		System.out.println("Prix de la Pizza");
		String prix = ihmUtil.getScanner().next();
		Pizza pizza = new Pizza(code,nom,Double.parseDouble(prix));
		try {
			ihmUtil.getPizzaDao().saveNewPizza(pizza);
		} catch (SavePizzaException e) {
			e.messageException();
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
