package com.zak.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.zak.metier.BanqueMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;
import com.zak.models.Client;
import com.zak.utils.DialogUtil;
import com.zak.utils.StageUtil;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

public class ClientController implements Initializable{
	@FXML private Pane pnlServerStatus;
	@FXML private Label lblServerStatus;
	@FXML private TextField txtSearch;
	@FXML private TextField txtLimite;
	private ObservableList<Client> clientList = FXCollections.observableArrayList();
	@FXML private TableView<Client> clientTable;
	@FXML private TableColumn<Client, Integer> id;
	@FXML private TableColumn<Client, String> cin;
	@FXML private TableColumn<Client, String> nom;
	@FXML private TableColumn<Client, String> telephone;
	@FXML private TableColumn<Client, String> username;
	@FXML private TableColumn<Client, String> email;
	@FXML private TableColumn<Client, Boolean> activated;
	@FXML private TableColumn<Client, String> agent;
	@FXML private TableColumn<Client, Double> limite;
	private final ClientController THIS = this;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	clientList=BanqueMetier.getAllClients();
	
	id.setCellValueFactory(new PropertyValueFactory<Client, Integer>("id"));
	cin.setCellValueFactory(new PropertyValueFactory<Client, String>("cin"));
	nom.setCellValueFactory(new PropertyValueFactory<Client, String>("nom"));
	telephone.setCellValueFactory(new PropertyValueFactory<Client, String>("telephone"));
	username.setCellValueFactory(new PropertyValueFactory<Client, String>("username"));
	email.setCellValueFactory(new PropertyValueFactory<Client, String>("email"));
	activated.setCellValueFactory(new PropertyValueFactory<Client, Boolean>("activated"));
	agent.setCellValueFactory(new PropertyValueFactory<Client, String>("agent"));
	limite.setCellValueFactory(new PropertyValueFactory<Client, Double>("limite"));
	
	clientTable.setItems(clientList);
	
	// FILTRING DATA
	FilteredList<Client> filteredData = new FilteredList<>(clientList, p -> true);
    
    // 2. Set the filter Predicate whenever the filter changes.
	txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(client -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();
            
            if (client.getNom().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            if (client.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            return false; // Does not match.
        });
    });
    
    // 3. Wrap the FilteredList in a SortedList. 
    SortedList<Client> sortedData = new SortedList<>(filteredData);
    
    // 4. Bind the SortedList comparator to the TableView comparator.
    sortedData.comparatorProperty().bind(clientTable.comparatorProperty());
    
    // 5. Add sorted (and filtered) data to the table.
    clientTable.setItems(sortedData);
	
	}
	
	
	public void modifEvent (ActionEvent event)
	{
		
		if( clientTable.getSelectionModel().getSelectedItem()!=null)
		{
			try {
				double limiteVirement = Double.parseDouble( txtLimite.getText());	
				BanqueMetier.setLimiteClient(clientTable.getSelectionModel().getSelectedItem().getId(),limiteVirement );
				clientList.get(clientTable.getSelectionModel().getFocusedIndex() ).setLimite(limiteVirement);
				clientTable.refresh();
				
				
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		else
		{		
        	DialogUtil.buildSimpleDialog("Erreur", null, "Veuillez selectione un item", AlertType.WARNING).showAndWait();        	
		}
		
	}
	






}
