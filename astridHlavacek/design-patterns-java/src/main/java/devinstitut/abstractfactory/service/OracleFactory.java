package devinstitut.abstractfactory.service;

import devinstitut.abstractfactory.service.client.ClientService;
import devinstitut.abstractfactory.service.client.ClientServiceOracleImpl;
import devinstitut.abstractfactory.service.commande.CommandeService;
import devinstitut.abstractfactory.service.commande.CommandeServiceOracleImpl;
import devinstitut.abstractfactory.service.pizza.PizzaService;
import devinstitut.abstractfactory.service.pizza.PizzaServiceOracleImpl;

public class OracleFactory extends AbstractFactory {

	@Override
	public ClientService getClientService() {
		return new ClientServiceOracleImpl();
	}

	@Override
	public CommandeService getCommandeService() {
		return new CommandeServiceOracleImpl();
	}

	@Override
	public PizzaService getPizzaService() {
		return new PizzaServiceOracleImpl();
	}

}