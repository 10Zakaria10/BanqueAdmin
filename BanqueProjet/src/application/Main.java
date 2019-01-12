package application;
	
import com.zak.metier.ValidTockenStuff;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Parent root;
		try {
			if(ValidTockenStuff.checkToken()) {
				root  = FXMLLoader.load(getClass().getResource("/com/zak/views/Main.fxml"));
			}
			else {
				root  = FXMLLoader.load(getClass().getResource("/com/zak/views/Login2.fxml"));
			}

		//	root  = FXMLLoader.load(getClass().getResource("/com/zak/views/EditAgent.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
			primaryStage.show();
			
			
		} catch(Exception e) {
			
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
