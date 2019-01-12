package com.zak.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.zak.metier.AgenceMetier;
import com.zak.metier.BanqueMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;
import com.zak.utils.DialogUtil;
import com.zak.utils.StageUtil;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;

public class AgenceController implements Initializable {
	@FXML private Pane pnlServerStatus;
	@FXML private Label lblServerStatus;
	@FXML private TextField txtSearch;
	private ObservableList<Agence> agenceList = FXCollections.observableArrayList();
	@FXML private TableView<Agence> agenceTable;
	@FXML private TableColumn<Agence, Integer> id;
	@FXML private TableColumn<Agence, String> nom;
	@FXML private TableColumn<Agence, String> adresse;
	@FXML private TableColumn<Agence, String> ville;
	@FXML private TableColumn<Agence, String> admin;
	private final AgenceController THIS = this;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	agenceList=AgenceMetier.getAllAgence();
	
	id.setCellValueFactory(new PropertyValueFactory<Agence, Integer>("id"));
	nom.setCellValueFactory(new PropertyValueFactory<Agence, String>("nom"));
	adresse.setCellValueFactory(new PropertyValueFactory<Agence, String>("adresse"));
	ville.setCellValueFactory(new PropertyValueFactory<Agence, String>("ville"));
	admin.setCellValueFactory(new PropertyValueFactory<Agence, String>("admin"));
	

	agenceTable.setItems(agenceList);
	
	
	FilteredList<Agence> filteredData = new FilteredList<>(agenceList, p -> true);
    
    // 2. Set the filter Predicate whenever the filter changes.
	txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(agence -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();
            
            if (agence.getNom().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            return false; // Does not match.
        });
    });
    
    // 3. Wrap the FilteredList in a SortedList. 
    SortedList<Agence> sortedData = new SortedList<>(filteredData);
    
    // 4. Bind the SortedList comparator to the TableView comparator.
    sortedData.comparatorProperty().bind(agenceTable.comparatorProperty());
    
    // 5. Add sorted (and filtered) data to the table.
    agenceTable.setItems(sortedData);
	

	}
	
	
	public void modifEvent (ActionEvent event)
	{
		
		if( agenceTable.getSelectionModel().getSelectedItem()!=null)
		{
			StageUtil.loadEditAgence(THIS, Modality.APPLICATION_MODAL).showAndWait();

			
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
				Agence selected = agenceTable.getSelectionModel().getSelectedItem();
				AgenceMetier.deleteAgent(selected.getId());
				//agenceTable.getItems().remove(agenceTable.getSelectionModel().getFocusedIndex());
				agenceList.remove(agenceTable.getSelectionModel().getFocusedIndex());
			} catch (Exception e) {
				DialogUtil.buildExceptionDialog("Erreur Supression","Cet Agences a des Agents", e).showAndWait();
			}
		}
	}
	
	public void ajoutEvent (ActionEvent event)
	{
		StageUtil.loadAddAgence(THIS, Modality.APPLICATION_MODAL).showAndWait();

	}
	
	public TableView<Agence> getTable() {
		return agenceTable;
	}

	public ObservableList<Agence> getList() {
		return agenceList;
	}
	
	public void updateAgence(int i , Agence newAgence)
	{
		agenceList.get(i).setAgence(newAgence);
		agenceTable.refresh();
	}
	
}