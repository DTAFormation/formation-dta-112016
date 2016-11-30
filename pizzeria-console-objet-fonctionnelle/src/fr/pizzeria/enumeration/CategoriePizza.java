package fr.pizzeria.enumeration;

public enum CategoriePizza {

	VIANDE("Viande"), POISSON("Poisson"), SANS_VIANDE("Sans Viande");
	
	private String value;
	
	private CategoriePizza(String value){
		this.setValue(value);
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
}
