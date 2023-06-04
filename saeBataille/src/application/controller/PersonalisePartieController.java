package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

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
    private TextField joueur1;
    @FXML
    private TextField joueur2;
    
    @FXML
    private void menuPrincipal() {
        Main.activerMenuPrincipale();
    }
    
    @FXML
    private void positionBateau() {
        Main a = new Main();
        a.chargementPageDependante();

        Modele.creerUneNouvellePartie(joueur1.getText(), joueur2.getText());
        Main.activerPositionBateau();
    }    
}
