/**
 * 
 */
package application.controller;

import java.util.Optional;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sauvegarde.Ecriture;

/**
 * Controlleur de la page ssauvegarde
 * @author de Saint Palais François
 *
 */
public class SauvegardePartieControlleur {

    @FXML
    Text affichageJoueur1;
    
    @FXML
    Text affichageJoueur2;
    
    @FXML
    TextField nomSauvegarde;
    
    @FXML
    private Button btnValider;

    @FXML
    private Button btnRetour;
    
    @FXML
    void initialize() {
        btnRetour.getStyleClass().add("btnGris");
        btnValider.getStyleClass().add("btnBleue");
        affichageJoueur1.setText(Modele.getPartieEnCours().getJoueur1().getNom());
        affichageJoueur2.setText(Modele.getPartieEnCours().getJoueur2().getNom());
        nomSauvegarde.setText(affichageJoueur1.getText() 
                              + "Vs" + affichageJoueur2.getText());
    }
    
    @FXML
    void validerNom() {
        String nomChoisie = nomSauvegarde.getText().replaceAll(" ", "_");
        Ecriture.ecrire(Modele.getPartieEnCours(), nomChoisie);
        Main.activerMenuPrincipale();
    }
    
    @FXML
    void retour() {
        Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
                ButtonType.YES, ButtonType.NO);
        boiteAlerte.setHeaderText("Si vous retournez au menu votre partie, sera perdu."
                                  + "Êtes vous sur de quitter sans sauvegarder"); 
        Optional<ButtonType> option = boiteAlerte.showAndWait(); 
        if (option.get() == ButtonType.YES) {
            Main.activerMenuPrincipale();
        }
    }
    
}
