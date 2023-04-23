package application;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
	private void creerNouvellePartie() {
		System.out.println("Nouvelle partie cliqué");
	}
	
	@FXML
	private void chargerPartie() {
		System.out.println("Charger une partie cliqué");
	}
	
	@FXML
	private void quitter() {
		System.out.println("Quitter cliqué");
	}
}
