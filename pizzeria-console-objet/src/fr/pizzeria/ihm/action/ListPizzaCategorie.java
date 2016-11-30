package fr.pizzeria.ihm.action;

import java.util.Scanner;

import fr.pizzeria.dao.PizzaDao;
import fr.pizzeria.ihm.IhmUtil;
import fr.pizzeria.model.Pizza;
/**
 * Created by ETY8 on 29/11/2016.
 */
public class ListPizzaCategorie extends Action  {

    private IhmUtil utils;

    public ListPizzaCategorie(IhmUtil utils) {
        super();
        this.setDescription("Lister les pizzas par catégorie");
        this.utils = utils;
    }




    @Override
    public void do_action() {

        System.out.println("Options : ALL (Toutes), VIANDE, POISSON, SANSVP (sans viande et sans poisson");
        String choix = utils.getScanner().next();
        if ("ALL".equals(choix))
        {
            for (Pizza p: utils.getPizzaDao().findAllPizzas()) {
                System.out.println(p.getCode() + " -> " + p.getNom() + " (" + p.getPrix() + " €)");
            }
        }else
        {
            utils.getPizzaDao().findAllPizzas().stream()
                    .filter(p -> p.getCategorie().toString().equals(choix))
                    .forEach(piz -> System.out.println(piz.getCode() + " -> " + piz.getNom() + " (" + piz.getPrix() + " €)"));
        }

    }

    @Override
    public void describe_action() {
        System.out.println(this.getDescription());
    }
}
