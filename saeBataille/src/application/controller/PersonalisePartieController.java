package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class PersonalisePartieController {
    
    @FXML
    private Button boutonAnnuler;
    
    @FXML
    private Button boutonValider;
    
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
    void initialize() {
        ToggleGroup groupePlacementBateau = new ToggleGroup();
        ToggleGroup jouerContre = new ToggleGroup();
        radioAutomatique.setToggleGroup(groupePlacementBateau);
        radioManuel.setToggleGroup(groupePlacementBateau);
        radioAutreJoueur.setToggleGroup(jouerContre);
        radioOrdinateur.setToggleGroup(jouerContre);
        boutonAnnuler.getStyleClass().add("btnRouge");
        boutonValider.getStyleClass().add("btnBleue");
    }
    
    @FXML
    private void menuPrincipal() {
        Main.activerMenuPrincipale();
    }
    
    @FXML
    private void positionBateau() {
        Main a = new Main();
        Modele.creerUneNouvellePartie(joueur1.getText(), joueur2.getText());
        a.positionBateau();
        Main.activerPositionBateau();
    }    
}
