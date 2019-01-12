package com.zak.controller;

import java.time.LocalDate;

import com.zak.metier.AgenceMetier;
import com.zak.metier.BanqueMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAgenceController {

	@FXML
	TextField txtNom;
	@FXML
	TextField txtAdresse;
	
	@FXML
	ComboBox<String> comboVille;

	@FXML
	Label labelStatus;
	
	private AgenceController fatherGUI;

	
	public void updateAction(ActionEvent e) {
		Agence agence = new Agence();
		agence.setAdresse(txtAdresse.getText());
		agence.setVille(comboVille.getValue());
		agence.setNom(txtNom.getText());
		
		try {
			Agence agenceR= AgenceMetier.addAgence(agence);
			labelStatus.setVisible(false);
		    System.out.println(agenceR);

			//fatherGUI.getTable().getItems().add(agenceR);
			fatherGUI.getList().add(agenceR);
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
		((Stage) txtNom.getScene().getWindow()).close();
	 }

	public void setFatherGUI(AgenceController fatherGUI) {
		this.fatherGUI = fatherGUI;
		showData();
		
	}

	private void showData() {
		
		comboVille.setItems(AgenceMetier.getAllVilles());
		
	}
	

}
