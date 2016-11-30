package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDaoTableau;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.Menu;

public class PizzeriaAdminConsoleApp {
	public static void main(String[] args) {
		IhmUtil ihmUtil = new IhmUtil(new Scanner(System.in), new PizzaDaoTableau());
		Menu menu = new Menu(ihmUtil);
		menu.start();
	}
}
