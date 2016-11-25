package fr.pizzeria.ihm;

import fr.pizzeria.model.Pizza;

public class UpdatePizza extends Action {
	
	private IhmUtil ihmUtil;

	public UpdatePizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("3. Mettre à jour une pizza");
	}

	@Override
	public void doAction() {
		System.out.println("Modifiez votre Pizza. \nCode de la Pizza que vous voulez modifier");
		String codePizza = ihmUtil.getScanner().next();
		System.out.println("Nouveau Code de la Pizza");
		String codeU = ihmUtil.getScanner().next();
		System.out.println("Nouveau Nom de la Pizza");
		String nomU = ihmUtil.getScanner().next();
		System.out.println("Nouveau Prix de la Pizza");
		String prixU = ihmUtil.getScanner().next();
		Pizza pizza = new Pizza(codeU,nomU,Double.parseDouble(prixU));
		ihmUtil.getPizzaDao().updatePizza(codePizza, pizza);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
