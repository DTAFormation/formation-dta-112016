package fr.pizzeria.dao;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements IPizzaDao {

	List<Pizza> listPizzas = new ArrayList<Pizza>();

	public PizzaDaoTableau() {
		listPizzas.add(new Pizza(0, "PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		listPizzas.add(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		listPizzas.add(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		listPizzas.add(new Pizza(6, "ORI", "L�orientale", 13.50, CategoriePizza.POISSON));
		listPizzas.add(new Pizza(7, "IND", "L�indienne", 14.50, CategoriePizza.VIANDE));
		stockage(new Pizza(0, "PEP", "P�p�roni", 12.50, CategoriePizza.VIANDE));
		stockage(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.SANS_VIANDE));
		stockage(new Pizza(2, "REI", "La Reine", 11.50, CategoriePizza.VIANDE));
		stockage(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE));
		stockage(new Pizza(4, "CAN", "La cannibale", 12.50, CategoriePizza.VIANDE));
		stockage(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		stockage(new Pizza(6, "ORI", "L�orientale", 13.50, CategoriePizza.POISSON));
		stockage(new Pizza(7, "IND", "L�indienne", 14.50, CategoriePizza.VIANDE));
	}

	@Override
	public List<Pizza> findAllPizzas() {
		return listPizzas;
	}

	public List<Pizza> findAllPizzasCat() {
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getCatP);
		List<Pizza> list = listPizzas.stream().sorted(comp).collect(Collectors.toList());
		return list;
	}

	public Pizza findAllPizzasPrix() {
		Comparator<Pizza> comp = Comparator.comparing(Pizza::getPrix);
		Optional<Pizza> pizza = listPizzas.stream().max(comp);
		if (pizza.isPresent()) {
			return pizza.get();
		} else {
			return null;
		}
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		int id = listPizzas.size();
		Pizza p = listPizzas.get(id - 1);
		pizza.setId((p.getId()) + 1);
		listPizzas.add(pizza);
		int nbPizza = Pizza.getNbPizzas();
		nbPizza++;
		Pizza.setNbPizzas(nbPizza);
		stockage(pizza);
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {

		listPizzas.forEach(p -> {
			if (p.getCode().equals(codePizza)) {
				pizza.setId(p.getId());
				int a = listPizzas.indexOf(p);
				listPizzas.set(a, pizza);
				destockage(p);
				stockage(pizza);
			}
		});

	}

	@Override
	public void deletePizza(String codePizza) {

		Optional<Pizza> findFirst = listPizzas.stream().filter(p -> p.getCode().equals(codePizza)).findFirst();

		if (findFirst.isPresent()) {
			Pizza pizza = findFirst.get();
			listPizzas.remove(pizza);
			destockage(pizza);
		}

		int nbPizza = Pizza.getNbPizzas();
		nbPizza--;
		Pizza.setNbPizzas(nbPizza);

	}

	public void stockage(Pizza pizza) {
		DataOutputStream dos;

		try {

			dos = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(new File("data/" + pizza.getCode() + ".txt"))));

			dos.writeChars(pizza.getNom() + ";" + pizza.getPrix() + ";" + pizza.getCatP());

			dos.close();

		}

		catch (java.io.IOException e) {
			e.printStackTrace();
		}
	}

	public void destockage(Pizza pizza) {
		File fichier = new File("data/" + pizza.getCode() + ".txt");
		fichier.delete();
	}
}
