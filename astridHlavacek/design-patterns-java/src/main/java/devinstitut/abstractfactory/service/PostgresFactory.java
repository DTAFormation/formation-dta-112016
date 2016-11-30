package devinstitut.abstractfactory.service;

import devinstitut.abstractfactory.service.client.ClientService;
import devinstitut.abstractfactory.service.client.ClientServicePostgresImpl;
import devinstitut.abstractfactory.service.commande.CommandeService;
import devinstitut.abstractfactory.service.commande.CommandeServicePostgresImpl;
import devinstitut.abstractfactory.service.pizza.PizzaService;
import devinstitut.abstractfactory.service.pizza.PizzaServicePostgresImpl;

public class PostgresFactory extends AbstractFactory {

	@Override
	public ClientService getClientService() {
		return new ClientServicePostgresImpl();
	}

	@Override
	public CommandeService getCommandeService() {
		return new CommandeServicePostgresImpl();
	}

	@Override
	public PizzaService getPizzaService() {
		return new PizzaServicePostgresImpl();
	}

}