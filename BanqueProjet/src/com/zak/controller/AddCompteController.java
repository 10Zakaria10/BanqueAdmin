package com.zak.controller;

import java.time.LocalDate;

import com.zak.metier.AgenceMetier;
import com.zak.metier.BanqueMetier;
import com.zak.metier.CategorieMetier;
import com.zak.metier.CompteMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;
import com.zak.models.Categorie;
import com.zak.models.Compte;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddCompteController {

	@FXML
	TextField txtDescription;

	@FXML
	Label labelStatus;
	
	private CompteController fatherGUI;

	
	public void updateAction(ActionEvent e) {
		Compte compte = new Compte();
		compte.setDescription(txtDescription.getText());
		
		try {
			String id= CompteMetier.addCompte(compte);
			labelStatus.setVisible(false);
			compte.setId(Integer.parseInt(id));
			//fatherGUI.getTable().getItems().add(agenceR);
			fatherGUI.getList().add(compte);
		    closeStage();	
			
		} catch (Exception e1) {
		//	e1.printStackTrace();
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

	public void setFatherGUI(CompteController fatherGUI) {
		this.fatherGUI = fatherGUI;
	}

	

}
