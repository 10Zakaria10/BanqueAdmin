package com.zak.metier;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import org.apache.commons.io.IOUtils;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ValidTockenStuff {

	public static String token;
	
	public static void readin() throws IOException
	{
		try(FileInputStream inputStream = new FileInputStream("tokenFile.txt")) {     
		    token = IOUtils.toString(inputStream);
		    System.out.println(token);
		    // do something with everything string
		}
	}
	
	public static void testToken() throws IOException
	{
		URL url;
			url = new URL("http://localhost:8080/Admin/tokenTest");
				
			JSONObject json = new JSONObject();
	
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			conn.setUseCaches(false);
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Authorization",token);
			conn.setRequestMethod("GET");
			conn.getInputStream();
				
	
	}
	
	public static boolean checkToken() {
		try {
			readin();
			testToken();
			return true;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			return false;
		}
		
	}
	
}
