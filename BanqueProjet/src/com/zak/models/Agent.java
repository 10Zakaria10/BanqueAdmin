package com.zak.models;

public class Agent {
	
	private int id; 
	private String cin;
	private String nom;
	private String prenom;
	private String password;
	private String adresse;
	private String telephone;
	private String email;
	private String username;
	private boolean activated;
	private String agence;
	private String admin;
	
	
	
	
	public Agent(int id, String cin, String nom, String prenom, String adresse, String telephone, String email,
			String username, boolean activated, String agence, String admin,String password) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.email = email;
		this.username = username;
		this.activated = activated;
		this.agence = agence;
		this.admin = admin;
		this.password=password;
	}
	
	public void setAgent(Agent c) {
		
		this.id = c.id;
		this.cin = c.cin;
		this.nom = c.nom;
		this.prenom = c.prenom;
		this.adresse = c.adresse;
		this.telephone = c.telephone;
		this.email = c.email;
		this.username = c.username;
		this.activated = c.activated;
		this.agence = c.agence;
		this.admin = c.admin;
		this.password=c.password;
	}
	
	
	public Agent(int id, String nom, String adresse, String agence, String admin) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.agence = agence;
		this.admin = admin;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCin() {
		return cin;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public boolean isActivated() {
		return activated;
	}
	public void setActivated(boolean activated) {
		this.activated = activated;
	}
	public String getAgence() {
		return agence;
	}
	public void setAgence(String agence) {
		this.agence = agence;
	}
	

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public Agent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Agent [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", email=" + email + ", username=" + username + ", activated="
				+ activated + ", agence=" + agence + ", admin=" + admin + "]";
	}

	


}
