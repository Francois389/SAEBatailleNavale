package application.controller;

import java.io.IOException;
import java.util.Optional;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

/**
 * Gère l'interactivité entre le menu et l'utilisateur.
 * @author François de Saint Palais
 */
public class MenuPrincipalControlleur {

	@FXML
	private Button btnNouvellePartie;
	
	@FXML
	private Button btnChargerPartie;
	
	@FXML
	private Button btnQuitter;
	
	@FXML
	private void creerNouvellePartie() throws IOException {
	    Main.activerPersonalisePartie();
    }
	    
	
	@FXML
	private void chargerPartie() {
		System.out.println("Charger une partie cliqué");
		System.out.println(btnChargerPartie.getWidth());
	}
	
	@FXML
	private void quitter() {
	    Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
	                                  ButtonType.YES, ButtonType.NO);
	    boiteAlerte.setHeaderText("Voulez-vous vraiment quitter ?"); 
	    Optional<ButtonType> option = boiteAlerte.showAndWait(); 
	    if (option.get() == ButtonType.YES) {
	        Main.quitter();
	    }
	}
	
	/**S'éxécute aux démarrage de l'application */
	@FXML
	private void initialize() {
		btnNouvellePartie.setPrefWidth(300);
		btnQuitter.setPrefWidth(300);
		btnChargerPartie.setPrefWidth(300);
	}
}
