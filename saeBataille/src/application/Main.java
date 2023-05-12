package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Classe qui va lancer l'application de jeu.
 * 
 * @author François de Saint Palais
 */
public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			FXMLLoader chargeurFXML = new FXMLLoader();
			System.out.println("view folder: " + Main.class.getResource("vue/MenuPrincipal.fxml"));     // returns null
			chargeurFXML.setLocation(getClass().getResource("vue/MenuPrincipal.fxml"));
			
			Parent racine = chargeurFXML.load();
			
			Scene scene = new Scene(racine);
//			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
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
