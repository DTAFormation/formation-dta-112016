package fr.pizzeria.exception;

public class DeletePizzaException extends Exception {
	
	
	public void messageException(){
		System.out.println("Veuillez saisir un code valid");
	}

}
