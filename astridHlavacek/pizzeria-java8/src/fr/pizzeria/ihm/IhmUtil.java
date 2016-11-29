package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.dao.IPizzaDao;

public class IhmUtil {
	
	private Scanner scanner;
	private IPizzaDao pizzaDao;
	
	public IhmUtil(Scanner scanner, IPizzaDao pizzaDao) {
		super();
		this.scanner = scanner;
		this.pizzaDao = pizzaDao;
	}

	public Scanner getScanner() {
		return this.scanner;
	}


	public IPizzaDao getPizzaDao() {
		return this.pizzaDao;
	}

	
	
}
