package devinstitut.abstractfactory.service;

import devinstitut.abstractfactory.service.client.ClientService;
import devinstitut.abstractfactory.service.commande.CommandeService;
import devinstitut.abstractfactory.service.pizza.PizzaService;

public abstract class AbstractFactory {
	public abstract ClientService getClientService();

	public abstract CommandeService getCommandeService();

	public abstract PizzaService getPizzaService();
	// TODO : implémenter le pattern Abstract Factory

	/*
	 * public ClientService getClientService() { return null; }
	 * 
	 * public CommandeService getCommandeService() { return null; }
	 * 
	 * public PizzaService getPizzaService() { return null; }
	 */
}
