package com.zak.controller;

import java.time.LocalDate;

import com.zak.metier.AgenceMetier;
import com.zak.metier.BanqueMetier;
import com.zak.metier.CategorieMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;
import com.zak.models.Categorie;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class EditCategorieController {

	@FXML
	TextField txtDescription;
	@FXML
	Label labelStatus;
	
	private CategorieController fatherGUI;

	private int id;
	
	public void updateAction(ActionEvent e) {
		Categorie categorie = new Categorie();
		categorie.setDescription(txtDescription.getText());
		categorie.setId(id);
		
		try {
			CategorieMetier.updateCategorie(categorie);
			labelStatus.setVisible(false);
	        //fatherGUI.getTable().getItems().set(fatherGUI.getTable().getSelectionModel().getFocusedIndex(), agence);
			fatherGUI.updateCategorie(fatherGUI.getTable().getSelectionModel().getFocusedIndex(), categorie);
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

	public void setFatherGUI(CategorieController fatherGUI) {
		this.fatherGUI = fatherGUI;
		showData();
		
	}

	private void showData() {
		Categorie selected = getSelected();
		id=selected.getId();
		txtDescription.setText(selected.getDescription());	
	}
	
	 private Categorie getSelected() {
	    	return fatherGUI.getTable().getSelectionModel().getSelectedItem();
	    	
	    }

}
