package fr.pizzeria.ihm;


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
		Pizza[] Pizzas = ihmUtil.getPizzaDao().findAllPizzas();
		String prix = ihmUtil.getScanner().next();
		int idF =  (Pizzas[(Pizzas.length)-1].getId())+1;
		Pizza pizza = new Pizza(idF,code,nom,Double.parseDouble(prix));
		ihmUtil.getPizzaDao().saveNewPizza(pizza);
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
