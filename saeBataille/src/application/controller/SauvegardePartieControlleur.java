/**
 * 
 */
package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import sauvegarde.Ecriture;

/**
 * //TODO Commenter la responsabilité de la classe
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
    void initialize() {
//        //TODO remove STUB
//        Modele.creerUneNouvellePartie("test", "AZERTYUIOP"); //STUB
        affichageJoueur1.setText(Modele.getPartieEnCours().getJoueur1().getNom());
        affichageJoueur2.setText(Modele.getPartieEnCours().getJoueur2().getNom());
        nomSauvegarde.setText(affichageJoueur1.getText() 
                              + "Vs" + affichageJoueur2.getText());
    }
    
    @FXML
    void validerNom() {
        String nomChoisie = nomSauvegarde.getText().replaceAll(" ", "_");
        System.out.println(nomChoisie);
        Ecriture.ecrire(Modele.getPartieEnCours(), nomChoisie);
        Main.activerMenuPrincipale();
    }
    
}
