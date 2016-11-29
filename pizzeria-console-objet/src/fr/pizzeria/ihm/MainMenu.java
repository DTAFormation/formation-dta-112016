package fr.pizzeria.ihm;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.DeletePizza;
import fr.pizzeria.ihm.action.ExitMenu;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.UpdatePizza;

public class MainMenu {

	//Action[] menu = new Action[5];
	List<Action> menu = new ArrayList<>();
	IhmUtil utils;

	public MainMenu(IhmUtil utils) {
		menu.add(new ListPizza(utils));
		menu.add(new AddPizza(utils));
		menu.add(new UpdatePizza(utils));
		menu.add(new DeletePizza(utils));
		menu.add(new ExitMenu());

		this.utils = utils;
	}

	private void displayMenu() {

		System.out.println("***** Pizzeria Administration *****");
/*		for (int i = 0; i < this.menu.length; ++i) {
			this.menu[i].describe_action();
		}*/
		//menu.stream().forEach(m -> m.describe_action());

		menu.stream().forEach(p -> p.describe_action());
	}

	private boolean parseAndExec() {

		String input = utils.getScanner().next();

		if (Integer.parseInt(input) < menu.stream().count()) {
			//this.menu[Integer.parseInt(input) - 1].do_action();
			this.menu.get(Integer.parseInt(input) -1).do_action();
			return true;
		}
		else if (Integer.parseInt(input) == 99)
			//this.menu[4].do_action();
			this.menu.get(4).do_action();
		return false;
	}

	public void start(){

		do {
			this.displayMenu();
		} while (this.parseAndExec());
	}
}