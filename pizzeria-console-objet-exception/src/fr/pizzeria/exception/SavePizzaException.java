package fr.pizzeria.exception;

public class SavePizzaException extends Exception{

	@Override
	public String getMessage() {
		System.out.println("La pizza que vous avez rentr�e n'a pas pu �tre"
				+ " ajout� � la liste");
		return super.getMessage();
	}
}
