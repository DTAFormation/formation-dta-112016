package fr.pizzeria.exception;

public class DeletePizzaException extends Exception{

	@Override
	public String getMessage() {
		System.out.println("La pizza que vous avez rentr�e n'a pas pu �tre"
				+ " supprim� de la liste");
		return super.getMessage();
	}
}
