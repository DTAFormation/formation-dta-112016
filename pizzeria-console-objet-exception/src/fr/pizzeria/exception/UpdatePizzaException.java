package fr.pizzeria.exception;

public class UpdatePizzaException extends Exception{

	
	@Override
	public String getMessage() {
		System.out.println("La pizza que vous avez rentr�e n'a pas pu �tre"
				+ " mise � jour � la liste");
		return super.getMessage();
	}
}
