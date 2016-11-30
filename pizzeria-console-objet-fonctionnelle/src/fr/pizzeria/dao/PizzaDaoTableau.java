package fr.pizzeria.dao;

import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements PizzaDao {

	private List<Pizza> pizza = new ArrayList<Pizza>();

	@Override
	public List<Pizza> findAll() {
		return pizza;
	}

	@Override
	public void save(Pizza p) {
		pizza.add(p);
	}

	@Override
	public void updatePizza(int id, Pizza p) {
		pizza.get(id).setCode(p.getCode());
		pizza.get(id).setNom(p.getNom());
		pizza.get(id).setPrix(p.getPrix());
		pizza.get(id).setCategoriePizza(p.getCategoriePizza());
	}

	@Override
	public void deletePizza(int id) {
		pizza.remove(id);
	}

}