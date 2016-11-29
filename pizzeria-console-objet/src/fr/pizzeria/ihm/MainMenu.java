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

public class MainMenu extends Menu{

	List<Action> l;


	public MainMenu(IhmUtil utils){
		super(utils);
		 l = new ArrayList<Action>() ;
		l.add(new ListPizza(utils));
		l.add(new AddPizza(utils));
		l.add(new UpdatePizza(utils));
		l.add(new DeletePizza(utils));
		l.add(new ExitMenu());

		this.menu = l;
	}




}