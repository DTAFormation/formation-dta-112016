package fr.pizzeria.dao;


import java.util.ArrayList;
import java.util.List;

import fr.pizzeria.exception.DeletePizzaException;
import fr.pizzeria.exception.SavePizzaException;
import fr.pizzeria.exception.UpdatePizzaException;
import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements IPizzaDao {

	List<Pizza> listPizzas = new ArrayList<Pizza>();


	public PizzaDaoTableau(){
		listPizzas.add(new Pizza(0,"PEP","Pépéroni",12.50));
		listPizzas.add(new Pizza(1,"MAR","Margherita",14.00));
		listPizzas.add(new Pizza(2,"REI","La Reine",11.50));
		listPizzas.add(new Pizza(3,"FRO","La 4 fromages",12.00));
		listPizzas.add(new Pizza(4,"CAN","La cannibale",12.50));
		listPizzas.add(new Pizza(5,"SAV","La savoyarde",13.00));
		listPizzas.add(new Pizza(6,"ORI","L’orientale",13.50));
		listPizzas.add(new Pizza(7,"IND","L’indienne",14.00));
	}


	@Override
	public List<Pizza> findAllPizzas() {
		return listPizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) throws SavePizzaException {
		if(isValidPizza(pizza)){
			throw new SavePizzaException();
		}else{
			int id = listPizzas.size();
			Pizza p = listPizzas.get(id-1);
			pizza.setId((p.getId())+1);
			listPizzas.add(pizza);
			int nbPizza = Pizza.getNbPizzas();	
			nbPizza++;
			Pizza.setNbPizzas(nbPizza);
		}
	}

	private boolean isValidPizza(Pizza pizza) {
		if(pizza.getCode() == "" && pizza.getNom() == ""){
			return true;
		}
		else{
			return false;
		}
	}


	@Override
	public void updatePizza(String codePizza, Pizza pizza) throws UpdatePizzaException {
		if(isValid(codePizza)){
			throw new UpdatePizzaException();
		}else{
			int a=0;
			for (int i=0;i<listPizzas.size();i++){
				Pizza p = listPizzas.get(i);
				if(p.getCode().equals(codePizza)){
					pizza.setId(p.getId());
					listPizzas.set(a, pizza);
				}
				a++;
			}
		}
	}

	@Override
	public void deletePizza(String codePizza) throws DeletePizzaException {
		if(isValid(codePizza)){
			throw new DeletePizzaException();
		}else{
			int b=0;
			for (int i=0;i<listPizzas.size();i++){
				Pizza p2 = listPizzas.get(i);
				if(p2.getCode().equals(codePizza)){
					listPizzas.remove(b);
				}
				b++;
			}
			int nbPizza = Pizza.getNbPizzas();	
			nbPizza--;
			Pizza.setNbPizzas(nbPizza);
		}
	}


	private boolean isValid(String codePizza) {
		if(codePizza == "" || codePizza == null){
			return true;
		}else{
			return false;
		}
	}

}
