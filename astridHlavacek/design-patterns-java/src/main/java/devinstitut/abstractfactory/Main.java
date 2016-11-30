package devinstitut.abstractfactory;

import devinstitut.abstractfactory.service.AbstractFactory;
import devinstitut.abstractfactory.service.MySQLFactory;
import devinstitut.abstractfactory.service.OracleFactory;
import devinstitut.abstractfactory.service.PostgresFactory;

public class Main {

	public static void main(String[] args) {
		AbstractFactory factoryO = new OracleFactory();
		AbstractFactory factoryP = new PostgresFactory();
		AbstractFactory factory = new MySQLFactory();

		factory.getClientService().afficherDonneesClient();
		factory.getCommandeService().afficherDonneesCommande();
		factory.getPizzaService().afficherDonneesPizza();

		factoryO.getClientService().afficherDonneesClient();
		factoryO.getCommandeService().afficherDonneesCommande();
		factoryO.getPizzaService().afficherDonneesPizza();

		factoryP.getClientService().afficherDonneesClient();
		factoryP.getCommandeService().afficherDonneesCommande();
		factoryP.getPizzaService().afficherDonneesPizza();
	}
}
