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
 * //TODO Commenter la responsabiliter de la classe
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
        System.out.println("Retour Menu");
        Main.activerMenuPrincipale();
    }

    @FXML
    void nouvellePartie() {
        System.out.println("Nouvelle Partie");
        Main.activerPersonalisePartie();
    }
    
    @FXML
    void initialize() {
    	if (Modele.getJoueurGagnant() != null) {
	        textResultat.setText(Modele.getJoueurGagnant().getNom() + " a gagné!");
    	}
        //TODO retirer le STUB
        //Modele.creerUneNouvellePartie("François", "Quentin");//STUB
        textResultat.setText(Modele.getJoueurGagnant().getNom() + " a gagné!");
        btnNouvellePartie.getStyleClass().add("btnBleue");
        btnRetourMenu.getStyleClass().add("btnGris");
    }
}
