package com.zak.models;

public class Agence {

	private int id;
	private String nom;
	private String adresse;
	private String ville;
	private String admin;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Agence(int id, String nom, String adresse, String ville, String admin) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.ville = ville;
		this.admin = admin;
	}
	
	public void setAgence(Agence c) {
	
		this.id = c.id;
		this.nom = c.nom;
		this.adresse = c.adresse;
		this.ville = c.ville;
		this.admin = c.admin;
	}
	
	public Agence() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Agence [id=" + id + ", nom=" + nom + ", adresse=" + adresse + ", ville=" + ville + ", admin=" + admin
				+ "]";
	}
	

	
}
