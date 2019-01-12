package com.zak.controller;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXComboBox;
import com.zak.metier.AgenceMetier;
import com.zak.metier.BanqueMetier;
import com.zak.metier.CategorieMetier;
import com.zak.metier.CompteMetier;
import com.zak.models.Agence;
import com.zak.models.Agent;
import com.zak.models.Categorie;
import com.zak.models.Compte;
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

public class CompteController implements Initializable {
	@FXML private Pane pnlServerStatus;
	@FXML private Label lblServerStatus;
	@FXML private TextField txtSearch;
	private ObservableList<Compte> compteList = FXCollections.observableArrayList();
	@FXML private TableView<Compte> compteTable;
	@FXML private TableColumn<Compte, Integer> id;
	@FXML private TableColumn<Compte, String> description;
	private final CompteController THIS = this;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
	compteList=CompteMetier.getAllComptes();
	id.setCellValueFactory(new PropertyValueFactory<Compte, Integer>("id"));
	description.setCellValueFactory(new PropertyValueFactory<Compte, String>("description"));
	compteTable.setItems(compteList);
	
	
	FilteredList<Compte> filteredData = new FilteredList<>(compteList, p -> true);
    
    // 2. Set the filter Predicate whenever the filter changes.
	txtSearch.textProperty().addListener((observable, oldValue, newValue) -> {
        filteredData.setPredicate(categorie -> {
            // If filter text is empty, display all persons.
            if (newValue == null || newValue.isEmpty()) {
                return true;
            }
            
            // Compare first name and last name of every person with filter text.
            String lowerCaseFilter = newValue.toLowerCase();
            
            if (categorie.getDescription().toLowerCase().contains(lowerCaseFilter)) {
                return true; // Filter matches first name.
            }
            return false; // Does not match.
        });
    });
    
    // 3. Wrap the FilteredList in a SortedList. 
    SortedList<Compte> sortedData = new SortedList<>(filteredData);
    
    // 4. Bind the SortedList comparator to the TableView comparator.
    sortedData.comparatorProperty().bind(compteTable.comparatorProperty());
    
    // 5. Add sorted (and filtered) data to the table.
    compteTable.setItems(sortedData);
	

	}
	
	
	public void modifEvent (ActionEvent event)
	{
		
		if( compteTable.getSelectionModel().getSelectedItem()!=null)
		{
			StageUtil.loadEditCompte(THIS, Modality.APPLICATION_MODAL).showAndWait();

			
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
				Compte selected = compteTable.getSelectionModel().getSelectedItem();
				CompteMetier.deleteCompte(selected.getId());
				//agenceTable.getItems().remove(agenceTable.getSelectionModel().getFocusedIndex());
				compteList.remove(compteTable.getSelectionModel().getFocusedIndex());
			} catch (Exception e) {
				DialogUtil.buildExceptionDialog("Erreur Supression","Ce TypeCompte a deja des Compte", e).showAndWait();
			}
		}
	}
	
	public void ajoutEvent (ActionEvent event)
	{
		StageUtil.loadAddCompte(THIS, Modality.APPLICATION_MODAL).showAndWait();

	}
	
	public TableView<Compte> getTable() {
		return compteTable;
	}

	public ObservableList<Compte> getList() {
		return compteList;
	}
	
	public void updateCompte(int i , Compte newCompte)
	{
		compteList.get(i).setCategorie(newCompte);
		compteTable.refresh();
	}
	
}