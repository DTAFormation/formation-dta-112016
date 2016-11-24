package fr.pizzeria.ihm.action;

public abstract class Action {

	private String description;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public abstract void doAction();
	public abstract void describeAction();
}