package com.zak.models;

public class SousCategorie {

	private int id;
	private String description;
	private String categorie;
	
	
	public String getCategorie() {
		return categorie;
	}


	public void setCategorie(String categorie) {
		this.categorie = categorie;
	}


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


	public SousCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public SousCategorie(int id, String description) {
		super();
		this.id = id;
		this.description = description;
	}

	public void setSousCategorie(SousCategorie c) {
		this.id = c.id;
		this.description = c.description;
		this.categorie=c.categorie;
	}

	@Override
	public String toString() {
		return "Agence [id=" + id + ", description=" + description;
	}


	public SousCategorie(int id, String description, String categorie) {
		super();
		this.id = id;
		this.description = description;
		this.categorie = categorie;
	}
	
	
	
}
