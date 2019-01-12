package com.zak.controller;

import java.time.LocalDate;

import com.zak.metier.AgenceMetier;
import com.zak.metier.BanqueMetier;
import com.zak.metier.CategorieMetier;
import com.zak.metier.SousCategorieMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;
import com.zak.models.SousCategorie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddSousCategorieController {

	@FXML
	TextField txtDescription;
	
	@FXML
	ComboBox<String> comboCategorie;
	
	@FXML
	Label labelStatus;
	
	private SousCategorieController fatherGUI;

	
	public void updateAction(ActionEvent e) {
		SousCategorie sousCategorie = new SousCategorie();
		sousCategorie.setDescription(txtDescription.getText());
		sousCategorie.setCategorie(comboCategorie.getValue());
		
		try {
			String id= SousCategorieMetier.addSCategorie(sousCategorie);
			labelStatus.setVisible(false);
			sousCategorie.setId(Integer.parseInt(id));
	        //fatherGUI.getTable().getItems().set(fatherGUI.getTable().getSelectionModel().getFocusedIndex(), agence);
			fatherGUI.getList().add(sousCategorie);
			closeStage();	
			
			
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			labelStatus.setVisible(true);
		}
	}

	public void cancelAction(ActionEvent e) {
        closeStage();

	}
	
	protected void closeStage() {
		((Stage) txtDescription.getScene().getWindow()).close();
	 }

	public void setFatherGUI(SousCategorieController fatherGUI) {
		this.fatherGUI = fatherGUI;
		showData();
		
	}

	private void showData() {
		comboCategorie.setItems(SousCategorieMetier.getAllCategories());
	}
	
	

}
