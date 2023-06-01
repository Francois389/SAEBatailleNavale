/**
 * 
 */
package application.controller;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.stage.Stage;

/**
 * Le controlleur de la pageDeJeux.fxml
 * @author de Saint Palais François
 *
 */
public class PageDeJeuxControlleur extends Application {

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
    }
    
    @FXML
    void menuChargerUnePartie() {
        System.out.println("Charger une partie");
    }
    
    @FXML
    void menuRetourAuMenu() {
        System.out.println("Retour au menu");
    }
    
    @FXML
    void menuSauvegarder() {
        System.out.println("sauvegarde");
    }
    
    @FXML
    void menuAbandonner() {
        System.out.println("Abandonner");
    }
    
    @FXML
    void menuCommentJouer() {
        System.out.println("Comment jouer");
    }
    
    @FXML
    void menuCredit() {
        System.out.println("Credit");
    }

}
