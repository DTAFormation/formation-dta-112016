package fr.pizzeria.ihm;

import fr.pizzeria.ihm.action.*;

import java.util.ArrayList;
import java.util.List;
import fr.pizzeria.ihm.action.Action;

/**
 * Created by ETY8 on 29/11/2016.
 */
public class ListMenu extends Menu {

    List<Action> l;

    public ListMenu(IhmUtil utils){
        super(utils);
        l = new ArrayList<Action>() ;
        l.add(new ListPizzaCategorie(utils));
        l.add(new AffichierPizzaTarifEleve(utils));
        this.menu = l;



    }

}
