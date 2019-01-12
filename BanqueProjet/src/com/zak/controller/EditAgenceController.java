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

public class EditAgenceController {

	@FXML
	TextField txtNom;
	@FXML
	TextField txtAdresse;
	
	@FXML
	ComboBox<String> comboVille;
	@FXML
	ComboBox<String> comboAdmin;
	@FXML
	Label labelStatus;
	
	private AgenceController fatherGUI;

	private int id;
	
	public void updateAction(ActionEvent e) {
		Agence agence = new Agence();
		agence.setAdmin(comboAdmin.getValue());
		agence.setAdresse(txtAdresse.getText());
		agence.setVille(comboVille.getValue());
		agence.setNom(txtNom.getText());
		agence.setId(id);
		
		try {
			AgenceMetier.updateAgence(agence);
			labelStatus.setVisible(false);
	        //fatherGUI.getTable().getItems().set(fatherGUI.getTable().getSelectionModel().getFocusedIndex(), agence);
			fatherGUI.updateAgence(fatherGUI.getTable().getSelectionModel().getFocusedIndex(), agence);
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
		Agence selected = getSelected();
		id=selected.getId();
		txtNom.setText(selected.getNom());
		txtAdresse.setText(selected.getAdresse());
		
		comboVille.setItems(AgenceMetier.getAllVilles());
		comboVille.setValue(selected.getVille());
		
		comboAdmin.setItems(AgenceMetier.getAllAdmins());
		comboAdmin.setValue(selected.getAdmin());
	}
	
	 private Agence getSelected() {
	    	return fatherGUI.getTable().getSelectionModel().getSelectedItem();
	    	
	    }

}
