package fr.pizzeria.ihm.action;

import fr.pizzeria.dao.enumPizza;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.ihm.ListMenu;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Pizza;

import java.util.ArrayList;
import java.util.List;

public class ListPizza extends Action {

	private IhmUtil utils;
	private List<Action> ListsousAction = new ArrayList<Action>();

	public ListPizza(IhmUtil utils) {
		super();
		this.utils = utils;
		this.setDescription("1. Lister les pizzas");

	}

	@Override
	public void do_action() {
		/*
		for (Pizza p: utils.getPizzaDao().findAllPizzas()) {
			System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + " €)");
		}*/

/*		boolean b = false;
		do {
			this.ListsousAction.stream().forEach(a -> a.describe_action());
			System.out.println("99 - Retour");
			b =  this.do_sousaction();
		}while(!b);*/

		Menu sm = new ListMenu(this.utils);
		System.out.println("Retour" + sm.menu.stream().count() + 1);
		sm.start();
	}

	@Override
	public void describe_action() {
		System.out.println(this.getDescription());
	}


	public boolean do_sousaction(){

		String input = utils.getScanner().next();

		if (Integer.parseInt(input) <= ListsousAction.stream().count()) {
			//this.menu[Integer.parseInt(input) - 1].do_action();

			this.ListsousAction.get(Integer.parseInt(input) -1).do_action();
			return true;
		}
			return false;


	}

}
