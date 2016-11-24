package fr.pizzeria.ihm;
import fr.pizzeria.ihm.action.Action;
import fr.pizzeria.ihm.action.AddPizza;
import fr.pizzeria.ihm.action.DeletePizza;
import fr.pizzeria.ihm.action.ExitMenu;
import fr.pizzeria.ihm.action.ListPizza;
import fr.pizzeria.ihm.action.UpdatePizza;

public class MainMenu {

	Action[] menu = new Action[5];
	private IhmUtil ihmUtil;

	public MainMenu(IhmUtil ihmUtil) {
		this.menu[0] = new ListPizza(ihmUtil);
		this.menu[1] = new AddPizza(ihmUtil);
		this.menu[2] = new UpdatePizza();
		this.menu[3] = new DeletePizza();
		this.menu[4] = new ExitMenu();
		this.ihmUtil = ihmUtil;
		}

	public void displayMenu() {
		for (int i = 0; i < this.menu.length; ++i) {
			this.menu[i].describeAction();
		}
	}
	
	public void parseAndExec() {
		String input = ihmUtil.getScanner().next();

		if (Integer.parseInt(input) < 4)
			this.menu[Integer.parseInt(input) - 1].doAction();
		else if (Integer.parseInt(input) == 99) {
			this.menu[4].doAction();
		}
	}
}
