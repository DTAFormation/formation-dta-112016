package fr.pizzeria.ihm;


import java.util.HashMap;
import java.util.Map;

import fr.pizzeria.ihm.Action;

public class MainMenu {

	Map<Integer,Action>	actions = new HashMap<Integer, Action>();
	private IhmUtil ihmUtil;

	public MainMenu(IhmUtil ihmUtil) {
		actions.put(0,new ListPizza(ihmUtil));
		actions.put(1,new AddPizza(ihmUtil));
		actions.put(2,new UpdatePizza(ihmUtil));
		actions.put(3,new DeletePizza(ihmUtil));
		actions.put(4,new ExitMenu());
		this.ihmUtil = ihmUtil;
	}

	public void displayMenu() {
		for (int i = 0; i <actions.size(); ++i) {
			actions.get(i).describeAction();
		}
		parseAndExec();
	}

	private void parseAndExec() {
		String input = ihmUtil.getScanner().next();

		if (Integer.parseInt(input) <= 4){
			actions.get((Integer.parseInt(input)) - 1).doAction();
			displayMenu();
			}
		else if (Integer.parseInt(input) == 99) {
			actions.get(4).doAction();
		}
	}
}
