package fr.pizzeria.action;

public class Update extends MenuInterface{

	public Update() {
		super();
		this.setLibelle("Mettre � jour une pizza");
	}

	@Override
	public void executeAction() {
		
	}

	@Override
	public void show() {
		System.out.println(this.getLibelle());
	}

}
