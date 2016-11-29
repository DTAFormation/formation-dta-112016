package fr.pizzeria.ihm.action;

import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;

import java.util.Comparator;

/**
 * Created by ETY8 on 29/11/2016.
 */
public class AffichierPizzaTarifEleve extends Action{

    private IhmUtil utils;

    public AffichierPizzaTarifEleve(IhmUtil utils) {
        super();
        this.setDescription("2. Afficher la pizza au tarif le plus élevé");
        this.utils = utils;
    }


    @Override
    public void do_action() {


        Pizza p = utils.getPizzaDao().findAllPizzas().stream().max((p1, p2) -> Double.compare( p1.getPrix(), p2.getPrix())).get();
        System.out.println(p.getCode() + " -> " + p.getNom() + "( " + p.getPrix() +" )" );



    }

    @Override
    public void describe_action() {
        System.out.println(this.getDescription());
    }
}
