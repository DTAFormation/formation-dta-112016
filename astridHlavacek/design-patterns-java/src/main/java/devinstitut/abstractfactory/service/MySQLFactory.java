package devinstitut.abstractfactory.service;

import devinstitut.abstractfactory.service.client.ClientService;
import devinstitut.abstractfactory.service.client.ClientServiceMySQLImpl;
import devinstitut.abstractfactory.service.commande.CommandeService;
import devinstitut.abstractfactory.service.commande.CommandeServiceMysqlImpl;
import devinstitut.abstractfactory.service.pizza.PizzaService;
import devinstitut.abstractfactory.service.pizza.PizzaServiceMySQLImpl;

public class MySQLFactory extends AbstractFactory {

	public ClientService getClientService() {
		return new ClientServiceMySQLImpl();
	}

	public CommandeService getCommandeService() {
		return new CommandeServiceMysqlImpl();
	}

	public PizzaService getPizzaService() {
		return new PizzaServiceMySQLImpl();
	}

}
