package application;

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
    private void Annuler() {
        System.out.println("Annulation");
    }
    
    @FXML
    private void Valider() {
        System.out.println("Validation");
    }
    
 
    

}
