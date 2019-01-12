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

import com.zak.models.Agence;
import com.zak.models.Agent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class AgenceMetier {
	
	
	
	public static Agence addAgence(Agence agence) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/addNewAgence");
				
			JSONObject json = new JSONObject();
			json.put("nom",agence.getNom());
			json.put("adresse",agence.getAdresse());
			json.put("ville",agence.getVille());
					
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
		//		JSONObject jsonObject=(JSONObject) parser.parse(in.readLine().toString());
		
		    ObjectMapper objectMapper = new ObjectMapper();

		    Agence agenceR = objectMapper.readValue(in.readLine().toString(), Agence.class); 

		    return agenceR;
		
	}
	
	public static void updateAgence(Agence agence) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/updateAgence");
				
			JSONObject json = new JSONObject();
			json.put("id",agence.getId());
			json.put("nom",agence.getNom());
			json.put("adresse",agence.getAdresse());
			json.put("ville",agence.getVille());
			json.put("admin",agence.getAdmin());	
					
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

	public static void deleteAgent(int i) throws Exception
	{
		URL url;

			url = new URL("http://localhost:8080/Admin/deleteAgence/"+i);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("POST");
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

	public static ObservableList<String> getAllVilles()
	{
		ObservableList<String> listVilles = FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getVilles");
			
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
				listVilles.add(jsonObject.get("nom").toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listVilles;

	}

	
	

	
	
	public static ObservableList<Agence> getAllAgence()
	{
		ObservableList<Agence> listAgence = FXCollections.observableArrayList();
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
			    ObjectMapper objectMapper = new ObjectMapper();
			    Agence agence = objectMapper.readValue(object.toString(), Agence.class); 
			    listAgence.add(agence);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listAgence;
		
	}
	
	
	
}
