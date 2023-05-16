package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

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
			System.out.println("view folder: " + Main.class.getResource("saeBataille/src/application/vue/image/porteAvions.png"));     
			chargeurFXML.setLocation(getClass().getResource("saeBataille\\src\\application\\vue\\image\\porteAvions.png"));
			
			Parent racine = chargeurFXML.load();
	        // Charger une image à partir d'un fichier
	        Image image = new Image("vue/image/porteAvions.png");

	        // Obtenir la référence à votre ImageView à partir du fichier FXML
	        ImageView imageView = (ImageView) chargeurFXML.getNamespace().get("porteAvions");

	        // Assigner l'image à l'ImageView
	        imageView.setImage(image);
	        
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
