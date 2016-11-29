package fr.pizzeria.model;

import fr.pizzeria.dao.enumPizza;


public class Pizza {

	private int id;
	private String code;
	private String nom;
	private double prix;
	private enumPizza categorie;
	public static int nbPizzas;

	public Pizza() {
		super();
	}

	public Pizza(int id, String code, String nom, double prix, enumPizza categorie) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.categorie =  categorie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
	}

	public enumPizza getCategorie() {
		return categorie;
	}

	public void setCategorie(enumPizza categorie) {
		this.categorie = categorie;
	}

	public Pizza pizzaEnCour(){
		return this;
	}
	
}
