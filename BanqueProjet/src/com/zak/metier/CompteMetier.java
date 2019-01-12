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
import com.zak.models.Categorie;
import com.zak.models.Compte;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class CompteMetier {
	
	
	
	public static String addCompte(Compte compte) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/addNewTypeCompte");
				
			JSONObject json = new JSONObject();
			json.put("description",compte.getDescription());
					
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
	
	public static void updateCompte(Compte compte) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/updateTypeCompte");
				
			JSONObject json = new JSONObject();
			json.put("id",compte.getId());
			json.put("description",compte.getDescription());
					
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

	public static void deleteCompte(int i) throws Exception
	{
		URL url;

			url = new URL("http://localhost:8080/Admin/deleteTypeCompte/"+i);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("POST");
			conn.getInputStream();		
			
	}

		
		
	
	public static ObservableList<Compte> getAllComptes()
	{
		ObservableList<Compte> listCompte= FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getTypeComptes");
			
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
			    Compte compte = objectMapper.readValue(object.toString(), Compte.class); 
			    listCompte.add(compte);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCompte;
		
	}
	
	
	
}
