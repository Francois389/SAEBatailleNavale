package application.controller;

import java.awt.event.MouseEvent;
import java.io.IOException;

import application.Main;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class PositionBateauController {
    @FXML
    private ImageView porteAvions ;
    
    @FXML
    private GridPane grille ;
    
    @FXML 
    ImageView croisseur;
    
    @FXML
    private Button retour;
    
    @FXML
    private void personalisePartie() throws IOException {
        Main.activerPersonalisePartie();
    }
    
    @FXML
    private void clicPorteAvions() {
        System.out.println("clic porte avions");
        System.out.println(porteAvions);
        System.out.println(grille);
        grille.add(porteAvions , 0 , 5);
        grille.setRowSpan(porteAvions, 5);
        
    }


	@FXML
	private void clicTorpilleurs() {
        System.out.println("torpilleurs");
    }

	@FXML
	private void clicContreTorpilleur() {
	    System.out.println("contre torpilleur");
	}
	
	@FXML
	private void clicCroiseur() {
	    System.out.println("croisseur");
	    System.out.println(croisseur);
	    grille.add(croisseur, 2, 3); // TODO modfier les coordonnees par le retour de la fonction clic grille pane
	    grille.setRowSpan(croisseur , 4);
	}
	
	//@FXML
	//private void clicGridPane(MouseEvent event) {
		//System.out.println(event.getX());
		//System.out.println(event.getY());
		
        
	//}
}
