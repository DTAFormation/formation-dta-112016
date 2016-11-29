package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.ihm.action.Action;



/**
 * Created by ETY8 on 29/11/2016.
 */
public abstract class Menu {


    //Action[] menu = new Action[5];
    public List<Action> menu = new ArrayList<>();
    IhmUtil utils;

    public Menu(IhmUtil utils) {

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
            this.menu.get(Integer.parseInt(input) -1).do_action();
            return true;
        }
        else if (Integer.parseInt(input) == 99)
            this.menu.get(4).do_action();
        return false;
    }

    public void start(){

        do {
            this.displayMenu();
        } while (this.parseAndExec());
    }
}