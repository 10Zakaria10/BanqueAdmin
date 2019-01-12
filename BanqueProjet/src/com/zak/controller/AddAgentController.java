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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddAgentController {

	@FXML
	TextField txtCin;
	@FXML
	TextField txtNom;
	@FXML
	PasswordField passField;
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
	
	public void addAction(ActionEvent e) {
		Agent agent = new Agent();
		agent.setActivated(checkActive.isSelected());
		agent.setAdmin(comboAdmin.getValue());
		agent.setAdresse(txtAdresse.getText());
		agent.setAgence(comboAgence.getValue());
		agent.setCin(txtCin.getText());
		agent.setEmail(txtEmail.getText());
		agent.setNom(txtNom.getText());
		agent.setPassword(passField.getText());
		agent.setPrenom(txtPrenom.getText());
		agent.setTelephone(txtTelephone.getText());
		agent.setUsername(txtUsername.getText());

		try {
			String stringId=BanqueMetier.addAgent(agent);
			agent.setId(Integer.parseInt(stringId));
			labelStatus.setVisible(false);
	        //fatherGUI.getTable().getItems().add(agent);
			fatherGUI.getList().add(agent);
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

	public void showData() {
		
	comboAgence.setItems(BanqueMetier.getAllAgences());
	comboAdmin.setItems(BanqueMetier.getAllAdmins());

	}

	
		
}
