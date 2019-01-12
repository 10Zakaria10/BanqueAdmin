package com.zak.models;

public class Client {
	
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
	private String agent;
	private double limite;
	
	
	
	
	public Client(int id, String cin, String nom, String prenom, String adresse, String telephone, String email,
			String username, boolean activated, String agent, double limite,String password) {
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
		this.agent = agent;
		this.limite = limite;
		this.password=password;
	}
	
	public void setClient(Client c) {
		
		this.id = c.id;
		this.cin = c.cin;
		this.nom = c.nom;
		this.prenom = c.prenom;
		this.adresse = c.adresse;
		this.telephone = c.telephone;
		this.email = c.email;
		this.username = c.username;
		this.activated = c.activated;
		this.agent = c.agent;
		this.limite = c.limite;
		this.password=c.password;
	}
	
	
	public Client(int id, String nom, String adresse, String agent , double limite) {
		super();
		this.id = id;
		this.nom = nom;
		this.adresse = adresse;
		this.agent = agent;
		this.limite = limite;
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
	
	

	public String getAgent() {
		return agent;
	}

	public void setAgent(String agent) {
		this.agent = agent;
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Agent [id=" + id + ", cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse
				+ ", telephone=" + telephone + ", email=" + email + ", username=" + username + ", activated="
				+ activated + ", agent=" + agent + ", limite=" + limite + "]";
	}

	


}
