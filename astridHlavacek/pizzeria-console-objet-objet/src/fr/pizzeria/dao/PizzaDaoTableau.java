package fr.pizzeria.dao;

import fr.pizzeria.model.Pizza;

public class PizzaDaoTableau implements IPizzaDao {
	private Pizza[] Pizzas = {
			new Pizza(0,"PEP","Pépéroni",12.50),
			new Pizza(1,"MAR","Margherita",14.00),
			new Pizza(2,"REI","La Reine",11.50),
			new Pizza(3,"FRO","La 4 fromages",12.00),
			new Pizza(4,"CAN","La cannibale",12.50),
			new Pizza(5,"SAV","La savoyarde",13.00),
			new Pizza(6,"ORI","L’orientale",13.50),
			new Pizza(7,"IND","L’indienne",14.00)};

	@Override
	public Pizza[] findAllPizzas() {
		return Pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		Pizza[] Etape=new Pizza[(Pizzas.length)+1];
		for(int i=0;i<Pizzas.length;i++){
			Etape[i] = Pizzas[i];
		}
		Etape[Pizzas.length] = pizza;
		Pizzas = Etape;
	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		for(int i=0;i<Pizzas.length;i++){
			if((Pizzas[i].getCode()).equals(codePizza)==true){
				Pizzas[i] = new Pizza(Pizzas[i].getId(),pizza.getCode(),pizza.getNom(),pizza.getPrix());
			} 
		}
	}

	@Override
	public void deletePizza(String codePizza) {
		int j = 0;
		for(int i=0;i<Pizzas.length;i++){
			if((Pizzas[i].getCode()).equals(codePizza)==true){
				j = i;
			}
		}
		Pizza[] EtapeS=new Pizza[(Pizzas.length)-1];
		for(int k=0;k<Pizzas.length;k++){
			if(k<j){
				EtapeS[k] = Pizzas[k];
			}else if(k==j){

			}else{
				EtapeS[k-1] = Pizzas[k];
			}
		}
		int nbPizza = Pizza.getNbPizzas();	
		nbPizza--;
		Pizza.setNbPizzas(nbPizza);
		Pizzas = EtapeS;
	}

}
