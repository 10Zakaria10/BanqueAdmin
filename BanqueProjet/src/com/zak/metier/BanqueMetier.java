package com.zak.metier;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.codehaus.jackson.map.ObjectMapper;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.zak.models.Agent;
import com.zak.models.Client;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class BanqueMetier {

	public static boolean Login(String txtUSername, String txtPass)
	{
	
		URL url;
		try {
			url = new URL("http://localhost:8080/login");
				
			JSONObject json = new JSONObject();
			json.put("username", txtUSername);
			json.put("password",txtPass);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type","application/json");
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
		
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();
			wr.flush();
			wr.close();
			conn.getInputStream();
			
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JSONParser parser = new JSONParser();
				String autorization = conn.getHeaderField("authorization");
					
				if(saveToken(autorization)) 
					return true;
									
				else
					return false;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			throw new RuntimeException("bad credantials");
			
		}
		
	}
	
	
	
	private static boolean saveToken(String token)
	{
		try (BufferedWriter bw = new BufferedWriter(new FileWriter("tokenFile.txt"))) {

			bw.write(token);
			
			// no need to close it.
			//bw.close();
			ValidTockenStuff.token=token;
			System.out.println("Done");
			
			return true;
	
		} catch (IOException e) {

			//e.printStackTrace();
			return false;
		}
        
	}
	
	public static String addAgent(Agent agent) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/addNewAgent");
				
			JSONObject json = new JSONObject();
			json.put("cin", agent.getCin());
			json.put("nom",agent.getNom());
			json.put("prenom", agent.getPrenom());
			json.put("password",agent.getPassword());
			json.put("adresse",agent.getAdresse());
			json.put("telephone", agent.getTelephone());
			json.put("email",agent.getEmail());
			json.put("username", agent.getUsername());
			json.put("activated",agent.isActivated());
			json.put("agence",agent.getAgence());
			json.put("admin",agent.getAdmin());	
					
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type","application/json");
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();
			wr.flush();
			wr.close();
			conn.getInputStream();
		
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JSONParser parser = new JSONParser();
			JSONObject jsonObject=(JSONObject) parser.parse(in.readLine().toString());
		
			return jsonObject.get("id").toString();
	
	}

	
	public static void deleteAgent(int i) throws Exception
	{
		URL url;

			url = new URL("http://localhost:8080/Admin/deleteAgent/"+i);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("POST");
			conn.getInputStream();		
			
	}

	
	public static void updateAgent(Agent agent) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/updateAgent");
				
			JSONObject json = new JSONObject();
			json.put("id",agent.getId());
			json.put("cin", agent.getCin());
			json.put("nom",agent.getNom());
			json.put("prenom", agent.getPrenom());
			json.put("adresse",agent.getAdresse());
			json.put("telephone", agent.getTelephone());
			json.put("email",agent.getEmail());
			json.put("username", agent.getUsername());
			json.put("activated",agent.isActivated());
			json.put("agence",agent.getAgence());
			json.put("admin",agent.getAdmin());	
					
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setRequestProperty("Content-Type","application/json");
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setDoOutput(true);
			conn.setRequestMethod("POST");
			
			OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
			wr.write(json.toString());
			wr.flush();
			wr.flush();
			wr.close();
			conn.getInputStream();
	}
	
	
	public static ObservableList<String> getAllAdmins()
	{
		ObservableList<String> listAdmins = FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getAllAdmins");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("GET");
			conn.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JSONParser parser = new JSONParser();
			
			JSONArray jsonArray= (JSONArray) parser.parse(in.readLine());
	
			for(Object object : jsonArray)
			{
				JSONObject jsonObject=(JSONObject) parser.parse(object.toString());
				listAdmins.add(jsonObject.get("username").toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAdmins;

	}

	
	
	public static ObservableList<String> getAllAgences()
	{
		ObservableList<String> listAgences = FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getAgences");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("GET");
			conn.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JSONParser parser = new JSONParser();
			
			JSONArray jsonArray= (JSONArray) parser.parse(in.readLine());
	
			for(Object object : jsonArray)
			{
				JSONObject jsonObject=(JSONObject) parser.parse(object.toString());
				listAgences.add(jsonObject.get("nom").toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAgences;

	}

	
	
	public static ObservableList<Agent> getAllAgents()
	{
		ObservableList<Agent> listAgent = FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getAllAgents");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("GET");
			conn.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JSONParser parser = new JSONParser();
			
			JSONArray jsonArray= (JSONArray) parser.parse(in.readLine());
	
			for(Object object : jsonArray)
			{
			    ObjectMapper objectMapper = new ObjectMapper();
			    Agent agent = objectMapper.readValue(object.toString(), Agent.class); 
			    listAgent.add(agent);
			    System.out.println(agent);
				//JSONObject jsonObject=(JSONObject) parser.parse(object.toString());
				//System.out.println(jsonObject.get("nom").toString());
			    
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAgent;
		
	}
	
	public static ObservableList<Client> getAllClients()
	{
		ObservableList<Client> listClient = FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getClients");
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("GET");
			conn.getInputStream();
			BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			JSONParser parser = new JSONParser();
			
			JSONArray jsonArray= (JSONArray) parser.parse(in.readLine());
	
			for(Object object : jsonArray)
			{
			    ObjectMapper objectMapper = new ObjectMapper();
			    Client client = objectMapper.readValue(object.toString(), Client.class); 
			    listClient.add(client);
			    System.out.println(client);
				//JSONObject jsonObject=(JSONObject) parser.parse(object.toString());
				//System.out.println(jsonObject.get("nom").toString());
			    
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listClient;
		
	}
	
	public static void setLimiteClient(int id, double limite) throws Exception
	{
		URL url;

			url = new URL("http://localhost:8080/Admin/setLimite/"+id+"/"+limite);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("POST");
			conn.getInputStream();		
			
	}
	
}
