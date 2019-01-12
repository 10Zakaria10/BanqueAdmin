package com.zak.models;

public class Ville {

	
	private int id;
	
	private String ville;

	public Ville(int id, String ville) {
		super();
		this.id = id;
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}
	
	
	
}
