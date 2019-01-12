package com.zak.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import org.apache.commons.io.IOUtils;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;

public class MainController{

	@FXML
	Parent categorieContent;
	
	@FXML
	Parent agentnContent;
	
	@FXML
	Parent agenceContent;
	
	@FXML
	Parent clientContent;
	
	@FXML
	Parent SoutCatContent;

	@FXML
	Parent CompteContent;

	public void GenerateMethode(ActionEvent event)
 	{
		categorieContent.setVisible(true);
		agentnContent.setVisible(false);
		agenceContent.setVisible(false);
		clientContent.setVisible(false);
		SoutCatContent.setVisible(false);

 	}
	
	public void agentGenerator(ActionEvent event)
 	{
		categorieContent.setVisible(false);
		agentnContent.setVisible(true);
		agenceContent.setVisible(false);
		clientContent.setVisible(false);
		SoutCatContent.setVisible(false);
		CompteContent.setVisible(false);

 	}

	public void agenceGenerator(ActionEvent event)
 	{
		categorieContent.setVisible(false);
		agentnContent.setVisible(false);
		agenceContent.setVisible(true);
		clientContent.setVisible(false);
		SoutCatContent.setVisible(false);
		CompteContent.setVisible(false);

 	}
	
	public void clientGenerate (ActionEvent event)
	{
		categorieContent.setVisible(false);
		agentnContent.setVisible(false);
		agenceContent.setVisible(false);
		clientContent.setVisible(true);
		SoutCatContent.setVisible(false);
		CompteContent.setVisible(false);
	}

	public void SousCatGenerat (ActionEvent event)
	{
		categorieContent.setVisible(false);
		agentnContent.setVisible(false);
		agenceContent.setVisible(false);
		clientContent.setVisible(false);
		SoutCatContent.setVisible(true);
		CompteContent.setVisible(false);
	}
	
	public void CompteGenerat (ActionEvent event)
	{
		categorieContent.setVisible(false);
		agentnContent.setVisible(false);
		agenceContent.setVisible(false);
		clientContent.setVisible(false);
		SoutCatContent.setVisible(false);
		CompteContent.setVisible(true);
	}
	
	
	
}
