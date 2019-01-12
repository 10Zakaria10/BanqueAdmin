package com.zak.utils;

import java.io.IOException;

import com.zak.controller.AddAgenceController;
import com.zak.controller.AddAgentController;
import com.zak.controller.AddCategorieController;
import com.zak.controller.AddCompteController;
import com.zak.controller.AddSousCategorieController;
import com.zak.controller.AgenceController;
import com.zak.controller.AgentController;
import com.zak.controller.CategorieController;
import com.zak.controller.CompteController;
import com.zak.controller.EditAgenceController;
import com.zak.controller.EditAgentController;
import com.zak.controller.EditCategorieController;
import com.zak.controller.EditCompteController;
import com.zak.controller.EditSousCategorieService;
import com.zak.controller.SousCategorieController;

import application.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class StageUtil {
	
//    public static Stage loadNewCustomer(final MainController FATHER, final Modality MODALITY) {
//        Stage stage = new Stage();
//        try {
//            final FXMLLoader LOADER = new FXMLLoader();
//            LOADER.setLocation(Main.class.getResource("NewCustomer.fxml"));
//            AnchorPane root = (AnchorPane) LOADER.load();
//            Scene scene = new Scene(root);
//            stage.setScene(scene);
//            stage.setTitle("Nuevo cliente");
//            stage.getIcons().add(new Image(Main.class.getResourceAsStream("img/ico.png")));
//            stage.initModality(MODALITY);
//            stage.setResizable(false);
//            stage.sizeToScene();
//            NewCustomerController newCustomerController = LOADER.getController();
//            newCustomerController.setFatherGUI(FATHER);
//        } catch (IOException e) {
//            e.getMessage();
//        }
//        
//        return stage;
//    }
    public static Stage loadEditAgent(final AgentController FATHER, final Modality MODALITY) {
        Stage stage = new Stage();
        try {
        	final FXMLLoader LOADER = new FXMLLoader();
        	LOADER.setLocation(Main.class.getResource("/com/zak/views/EditAgent.fxml"));
            AnchorPane root = (AnchorPane) LOADER.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Agent");
            stage.initModality(MODALITY);
            stage.setResizable(false);
            stage.sizeToScene();
            EditAgentController editCustomerController = LOADER.getController();
            editCustomerController.setFatherGUI(FATHER);
        } catch (IOException e) {
            e.getMessage();
        }
        
        return stage;
    }
    public static Stage loadAddAgent(final AgentController FATHER, final Modality MODALITY) {
    	Stage stage = new Stage();
    	try {
    		final FXMLLoader LOADER = new FXMLLoader();
    		LOADER.setLocation(Main.class.getResource("/com/zak/views/AddAgent.fxml"));
    		AnchorPane root = (AnchorPane) LOADER.load();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("Ajout Agent");
    		stage.initModality(MODALITY);
    		stage.setResizable(false);
    		stage.sizeToScene();
    		AddAgentController addAgentController = LOADER.getController();
    		addAgentController.setFatherGUI(FATHER);
    	} catch(IOException e) {
    		e.getMessage();
    	}
    	
    	return stage;
    }
    
    
    
    
    public static Stage loadEditAgence(final AgenceController FATHER, final Modality MODALITY) {
        Stage stage = new Stage();
        try {
        	final FXMLLoader LOADER = new FXMLLoader();
        	LOADER.setLocation(Main.class.getResource("/com/zak/views/EditAgence.fxml"));
            AnchorPane root = (AnchorPane) LOADER.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Agence");
            stage.initModality(MODALITY);
            stage.setResizable(false);
            stage.sizeToScene();
            EditAgenceController editAgenceController = LOADER.getController();
            editAgenceController.setFatherGUI(FATHER);
        } catch (IOException e) {
            e.getMessage();
        }
        
        return stage;
    }
    
    
    public static Stage loadAddAgence(final AgenceController FATHER, final Modality MODALITY) {
    	Stage stage = new Stage();
    	try {
    		final FXMLLoader LOADER = new FXMLLoader();
    		LOADER.setLocation(Main.class.getResource("/com/zak/views/AddAgence.fxml"));
    		AnchorPane root = (AnchorPane) LOADER.load();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("Ajout Agence");
    		stage.initModality(MODALITY);
    		stage.setResizable(false);
    		stage.sizeToScene();
    		AddAgenceController addAgenceController = LOADER.getController();
    		addAgenceController.setFatherGUI(FATHER);
    	} catch(IOException e) {
    		e.getMessage();
    	}
    	
    	return stage;
    }  
    
    public static Stage loadEditCategorie(final CategorieController FATHER, final Modality MODALITY) {
        Stage stage = new Stage();
        try {
        	final FXMLLoader LOADER = new FXMLLoader();
        	LOADER.setLocation(Main.class.getResource("/com/zak/views/EditCategorie.fxml"));
            AnchorPane root = (AnchorPane) LOADER.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Categorie");
            stage.initModality(MODALITY);
            stage.setResizable(false);
            stage.sizeToScene();
            EditCategorieController editCategorieController = LOADER.getController();
            editCategorieController.setFatherGUI(FATHER);
        } catch (IOException e) {
            e.getMessage();
        }
        
        return stage;
    }

    
    public static Stage loadAddCategorie(final CategorieController FATHER, final Modality MODALITY) {
    	Stage stage = new Stage();
    	try {
    		final FXMLLoader LOADER = new FXMLLoader();
    		LOADER.setLocation(Main.class.getResource("/com/zak/views/AddCategorie.fxml"));
    		AnchorPane root = (AnchorPane) LOADER.load();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("Ajout Categorie");
    		stage.initModality(MODALITY);
    		stage.setResizable(false);
    		stage.sizeToScene();
    		AddCategorieController addACategorieController = LOADER.getController();
    		addACategorieController.setFatherGUI(FATHER);
    	} catch(IOException e) {
    		e.getMessage();
    	}
    	
    	return stage;
    }  
    
    
    public static Stage loadEditSousCategorie(final SousCategorieController FATHER, final Modality MODALITY) {
        Stage stage = new Stage();
        try {

        	final FXMLLoader LOADER = new FXMLLoader();
        	LOADER.setLocation(Main.class.getResource("/com/zak/views/EditSousCategorie.fxml"));
            AnchorPane root = (AnchorPane) LOADER.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit SousCategorie");
            stage.initModality(MODALITY);
            stage.setResizable(false);
            stage.sizeToScene();
            EditSousCategorieService editCategorieController = LOADER.getController();
            editCategorieController.setFatherGUI(FATHER);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return stage;
    }

    
    public static Stage loadAddSousCategorie(final SousCategorieController FATHER, final Modality MODALITY) {
    	Stage stage = new Stage();
    	try {
    		final FXMLLoader LOADER = new FXMLLoader();
    		LOADER.setLocation(Main.class.getResource("/com/zak/views/AddSousCategorie.fxml"));
    		AnchorPane root = (AnchorPane) LOADER.load();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("Ajout Sous Categorie");
    		stage.initModality(MODALITY);
    		stage.setResizable(false);
    		stage.sizeToScene();
    		AddSousCategorieController addACategorieController = LOADER.getController();
    		addACategorieController.setFatherGUI(FATHER);
    	} catch(IOException e) {
    		e.getMessage();
    	}
    	
    	return stage;
    }  

    public static Stage loadEditCompte(final CompteController FATHER, final Modality MODALITY) {
        Stage stage = new Stage();
        try {

        	final FXMLLoader LOADER = new FXMLLoader();
        	LOADER.setLocation(Main.class.getResource("/com/zak/views/EditCompte.fxml"));
            AnchorPane root = (AnchorPane) LOADER.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Edit Compte");
            stage.initModality(MODALITY);
            stage.setResizable(false);
            stage.sizeToScene();
            EditCompteController editCompteController = LOADER.getController();
            editCompteController.setFatherGUI(FATHER);
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
        return stage;
    }

    
    public static Stage loadAddCompte(final CompteController FATHER, final Modality MODALITY) {
    	Stage stage = new Stage();
    	try {
    		final FXMLLoader LOADER = new FXMLLoader();
    		LOADER.setLocation(Main.class.getResource("/com/zak/views/AddCompte.fxml"));
    		AnchorPane root = (AnchorPane) LOADER.load();
    		Scene scene = new Scene(root);
    		stage.setScene(scene);
    		stage.setTitle("Ajout Type Compte");
    		stage.initModality(MODALITY);
    		stage.setResizable(false);
    		stage.sizeToScene();
    		AddCompteController addCompteController = LOADER.getController();
    		addCompteController.setFatherGUI(FATHER);
    	} catch(IOException e) {
    		e.getMessage();
    	}
    	
    	return stage;
    }  
}
