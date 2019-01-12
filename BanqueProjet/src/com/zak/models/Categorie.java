package com.zak.models;

public class Categorie {

	private int id;
	private String description;
	public int getId() {
		return id;
	}
	
	
	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public void setId(int id) {
		this.id = id;
	}


	public Categorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Categorie(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public void setCategorie(Categorie c) {
		this.id = c.id;
		this.description = c.description;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", description=" + description;
	}
	

	
}
