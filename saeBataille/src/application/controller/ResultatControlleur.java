/**
 * 
 */
package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
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
 
        textResultat.setText(Modele.getJoueurGagnant().getNom() + " a gagné!");
    }
}
