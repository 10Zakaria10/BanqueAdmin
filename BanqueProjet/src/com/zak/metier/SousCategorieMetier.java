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
import com.zak.models.SousCategorie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;

public class SousCategorieMetier {
	
	
	
	public static String addSCategorie(SousCategorie categorie) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/addNewSousCategorie");
				
			JSONObject json = new JSONObject();
			json.put("description",categorie.getDescription());
			json.put("categorie",categorie.getCategorie());
					
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
	
	public static void updateSCategorie(SousCategorie categorie) throws Exception
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/updateSousCategorie");
				
			JSONObject json = new JSONObject();
			json.put("description",categorie.getDescription());
			json.put("categorie",categorie.getCategorie());
			json.put("id",categorie.getId());
					
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

	public static void deleteSCategorie(int i) throws Exception
	{
		URL url;

			url = new URL("http://localhost:8080/Admin/deleteSousCategoroe/"+i);
			
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",ValidTockenStuff.token);
			conn.setRequestMethod("POST");
			conn.getInputStream();		
			
	}

		
		
	
	public static ObservableList<SousCategorie> getAllSCategorie()
	{
		ObservableList<SousCategorie> listCategorie = FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getSousCategories");
			
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
			    SousCategorie categorie = objectMapper.readValue(object.toString(), SousCategorie.class); 
			    listCategorie.add(categorie);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCategorie;
		
	}
	
	public static ObservableList<String> getAllCategories()
	{
		ObservableList<String> listCategories = FXCollections.observableArrayList();
		URL url;
		try {
			url = new URL("http://localhost:8080/Admin/getCategories");
			
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
				listCategories.add(jsonObject.get("description").toString());
			}
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return listCategories;

	}

	
	
}
