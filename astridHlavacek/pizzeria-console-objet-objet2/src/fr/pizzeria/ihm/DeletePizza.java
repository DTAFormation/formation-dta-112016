package fr.pizzeria.ihm;

import fr.pizzeria.exception.DeletePizzaException;

public class DeletePizza extends Action {

	private IhmUtil ihmUtil;
	
	public DeletePizza(IhmUtil ihmUtil) {
		super();
		this.ihmUtil = ihmUtil;
		this.setDescription("4. Supprimer une pizza");
	}

	@Override
	public void doAction() {
		System.out.println("Supprimer votre Pizza. \nCode de la Pizza que vous voulez supprimer");
		String codeS =  ihmUtil.getScanner().next();
		try {
			ihmUtil.getPizzaDao().deletePizza(codeS);
		} catch (DeletePizzaException e) {
			e.messageException();
		}
	}

	@Override
	public void describeAction() {
		System.out.println(this.getDescription());
	}

}
