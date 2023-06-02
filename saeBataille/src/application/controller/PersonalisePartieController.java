package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;

public class PersonalisePartieController {
    
    @FXML
    private Button buttonAnnuler;
    
    @FXML
    private Button buttonValider;
    
    @FXML
    private RadioButton radioAutomatique;
    
    @FXML
    private RadioButton radioManuel;
    
    @FXML
    private RadioButton radioAutreJoueur;
    
    @FXML
    private RadioButton radioOrdinateur;
    
    @FXML
    private void menuPrincipal() {
        Main.activerMenuPrincipale();
    }
    
    @FXML
    private void positionBateau() {
        Main a = new Main();
        a.chargementPageDependante();
        Main.activerPositionBateau();
    }
    
 
    

}
