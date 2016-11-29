package fr.pizzeria.model;

public class Pizza {
	int id;
	String code;
	String nom;
	double prix;
	static int nbPizzas;
	CategoriePizza catP;

	public Pizza(int id, String code, String nom, double prix, CategoriePizza catP) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		nbPizzas++;
		this.catP = catP;
	}

	public Pizza(String code, String nom, double prix, CategoriePizza catP) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.catP = catP;
	}

	public String getCatP() {
		return catP.toString();
	}

	public void setCatP(CategoriePizza catP) {
		this.catP = catP;
	}

	public static int getNbPizzas() {
		return nbPizzas;
	}

	public static void setNbPizzas(int nbPizzas) {
		Pizza.nbPizzas = nbPizzas;
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
}
