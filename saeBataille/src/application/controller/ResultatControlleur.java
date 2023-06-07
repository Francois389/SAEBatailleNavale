/**
 * 
 */
package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/**
 * Controlleur de la page victoire qui 
 * affiche le resultat de la partie
 * @author de Saint Palais François
 *
 */
public class ResultatControlleur {

    @FXML
    private Text textResultat;
    
    @FXML
    private Button btnNouvellePartie;

    @FXML
    private Button btnRetourMenu;
    
    
    @FXML
    void retourMenu() {
        Main.activerMenuPrincipale();
    }

    @FXML
    void nouvellePartie() {
        Main.activerPersonalisePartie();
    }
    
    @FXML
    void initialize() {
    	if (Modele.getJoueurGagnant() != null) {
	        textResultat.setText(Modele.getJoueurGagnant().getNom() + " a gagné!");
    	}
        textResultat.setText(Modele.getJoueurGagnant().getNom() + " a gagné!");
        btnNouvellePartie.getStyleClass().add("btnBleue");
        btnRetourMenu.getStyleClass().add("btnGris");
    }
}
