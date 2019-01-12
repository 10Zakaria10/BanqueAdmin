package com.zak.controller;

import java.time.LocalDate;

import com.zak.metier.BanqueMetier;
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

public class EditAgentController {

	@FXML
	TextField txtCin;
	@FXML
	TextField txtNom;
	@FXML
	TextField txtPrenom;
	@FXML
	TextField txtAdresse;
	@FXML
	TextField txtEmail;
	@FXML
	TextField txtUsername;
	@FXML
	TextField txtTelephone;
	@FXML
	ComboBox<String> comboAgence;
	@FXML
	ComboBox<String> comboAdmin;
	@FXML
	CheckBox checkActive;
	@FXML
	Label labelStatus;
	
	private AgentController fatherGUI;
	private int id;
	public void updateAction(ActionEvent e) {
		Agent agent = new Agent();
		agent.setId(id);
		agent.setActivated(checkActive.isSelected());
		agent.setAdmin(comboAdmin.getValue());
		agent.setAdresse(txtAdresse.getText());
		agent.setAgence(comboAgence.getValue());
		agent.setCin(txtCin.getText());
		agent.setEmail(txtEmail.getText());
		agent.setNom(txtNom.getText());
		agent.setPrenom(txtPrenom.getText());
		agent.setTelephone(txtTelephone.getText());
		agent.setUsername(txtUsername.getText());

		try {
			BanqueMetier.updateAgent(agent);
			labelStatus.setVisible(false);
	       // fatherGUI.getTable().getItems().set(fatherGUI.getTable().getSelectionModel().getFocusedIndex(), agent);
			fatherGUI.updateAgent(fatherGUI.getTable().getSelectionModel().getFocusedIndex(), agent);
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

	public void setFatherGUI(AgentController fatherGUI) {
		this.fatherGUI = fatherGUI;
		showData();
		
	}

	private void showData() {
		Agent selected = getSelected();
		id=selected.getId();
		txtCin.setText(selected.getCin());
		txtNom.setText(selected.getNom());
		txtPrenom.setText(selected.getPrenom());
		txtAdresse.setText(selected.getAdresse());
		txtEmail.setText(selected.getEmail());
		txtTelephone.setText(selected.getTelephone());
		txtUsername.setText(selected.getUsername());

		comboAgence.setItems(BanqueMetier.getAllAgences());
		comboAgence.setValue(selected.getAgence());
		
		comboAdmin.setItems(BanqueMetier.getAllAdmins());
		comboAdmin.setValue(selected.getAdmin());
		checkActive.setSelected(selected.isActivated());
	}
	
	 private Agent getSelected() {
	    	return fatherGUI.getTable().getSelectionModel().getSelectedItem();
	    	
	    }

}
