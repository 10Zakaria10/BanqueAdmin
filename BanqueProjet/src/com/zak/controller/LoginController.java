package com.zak.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.zak.metier.BanqueMetier;
import com.zak.metier.ValidTockenStuff;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController {
	
	@FXML
	JFXTextField txtUsername;
	
	@FXML
	JFXPasswordField txtPass;
	
	@FXML
	Label labelStatis;
	
	
	//BanqueMetier metier = new BanqueMetier();
	
	public void Login(ActionEvent event)
	{
	
		try {
			boolean status = BanqueMetier.Login(txtUsername.getText(), txtPass.getText());
			
			if(status)
			{
				labelStatis.setVisible(false);
				if(ValidTockenStuff.checkToken()) {
				Parent main_page_parent = FXMLLoader.load(getClass().getResource("/com/zak/views/Main.fxml"));
				Scene main_page_scene = new Scene(main_page_parent);
				Stage app_stage = (Stage) ( (Node) event.getSource() ).getScene().getWindow();
				app_stage.hide();
				app_stage.setScene(main_page_scene);
				app_stage.show();
				}else
				{
					labelStatis.setText("bad credentials");
					labelStatis.setVisible(true);
					
				}
				
			}
			else {
				
				labelStatis.setText("erreur externe");
				labelStatis.setVisible(true);					
			}
		}
		catch(Exception e)
		{	labelStatis.setText(e.getMessage());
			labelStatis.setVisible(true);
	
		}
			
			
		
	}
	
	
}
