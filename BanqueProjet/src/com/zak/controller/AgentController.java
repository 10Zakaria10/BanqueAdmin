package com.zak.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.zak.metier.BanqueMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;
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

public class AgentController implements Initializable{
	@FXML private Pane pnlServerStatus;
	@FXML private Label lblServerStatus;
	@FXML private TextField txtSearch;
	private ObservableList<Agent> agentList = FXCollections.observableArrayList();
	@FXML private TableView<Agent> agentTable;
	@FXML private TableColumn<Agent, Integer> id;
	@FXML private TableColumn<Agent, String> cin;
	@FXML private TableColumn<Agent, String> nom;
	@FXML private TableColumn<Agent, String> telephone;
	@FXML private TableColumn<Agent, String> username;
	@FXML private TableColumn<Agent, String> email;
	@FXML private TableColumn<Agent, Boolean> activated;
	@FXML private TableColumn<Agent, String> agence;
	@FXML private TableColumn<Agent, String> admin;
	private final AgentController THIS = this;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	agentList=BanqueMetier.getAllAgents();
	
	id.setCellValueFactory(new PropertyValueFactory<Agent, Integer>("id"));
	cin.setCellValueFactory(new PropertyValueFactory<Agent, String>("cin"));
	nom.setCellValueFactory(new PropertyValueFactory<Agent, String>("nom"));
	telephone.setCellValueFactory(new PropertyValueFactory<Agent, String>("telephone"));
	username.setCellValueFactory(new PropertyValueFactory<Agent, String>("username"));
	email.setCellValueFactory(new PropertyValueFactory<Agent, String>("email"));
	activated.setCellValueFactory(new PropertyValueFactory<Agent, Boolean>("activated"));
	agence.setCellValueFactory(new PropertyValueFactory<Agent, String>("agence"));
	admin.setCellValueFactory(new PropertyValueFactory<Agent, String>("admin"));
	
	agentTable.setItems(agentList);
	
	// FILTRING DATA
	FilteredList<Agent> filteredData = new FilteredList<>(agentList, p -> true);
    
    // 2. Set the filter Predicate whenever the filter changes.
	txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(agent -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();
            
            if (agent.getNom().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            if (agent.getUsername().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            return false; // Does not match.
        });
    });
    
    // 3. Wrap the FilteredList in a SortedList. 
    SortedList<Agent> sortedData = new SortedList<>(filteredData);
    
    // 4. Bind the SortedList comparator to the TableView comparator.
    sortedData.comparatorProperty().bind(agentTable.comparatorProperty());
    
    // 5. Add sorted (and filtered) data to the table.
    agentTable.setItems(sortedData);
	
	}
	
	
	public void modifEvent (ActionEvent event)
	{
		
		if( agentTable.getSelectionModel().getSelectedItem()!=null)
		{
			//Agent agentSelected=agentTable.getSelectionModel().getSelectedItem();
			StageUtil.loadEditAgent(THIS, Modality.APPLICATION_MODAL).showAndWait();

			
		}
		else
		{
        	DialogUtil.buildSimpleDialog("Erreur", null, "Veuillez selectione un item", AlertType.WARNING).showAndWait();
        	
		}
		
	}
	
	public void removeAction(ActionEvent event)
	{
		Optional<ButtonType> decision = DialogUtil.buildConfirmationDialog(
				"Supression Agent", null, "Ete vous sur de supprimez cet Agent ?").showAndWait();
		if (decision.get() == ButtonType.OK) {
			try {
				Agent selected = agentTable.getSelectionModel().getSelectedItem();
				BanqueMetier.deleteAgent(selected.getId());
				//agentTable.getItems().remove(agentTable.getSelectionModel().getFocusedIndex());
				agentList.remove(agentTable.getSelectionModel().getFocusedIndex());

			} catch (Exception e) {
				DialogUtil.buildExceptionDialog("Erreur Supression","Cet Agent a des clients", e).showAndWait();
			}
		}
	}
	
	public void ajoutEvent (ActionEvent event)
	{
		StageUtil.loadAddAgent(THIS, Modality.APPLICATION_MODAL).showAndWait();

	}
	
	public TableView<Agent> getTable() {
		return agentTable;
	}
	
	public ObservableList<Agent> getList()
	{
		return agentList;
	}

	public void updateAgent(int i , Agent newAgent)
	{
		agentList.get(i).setAgent(newAgent);
		agentTable.refresh();
	}
	









}
