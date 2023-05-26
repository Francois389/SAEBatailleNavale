package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.InputEvent;
import javafx.scene.input.MouseEvent;
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
	
	@FXML
	private void clicGridPane() {
        grille.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent event) {
        		int x = (int) event.getX() / 30;
        		int y = (int) event.getY() / 30;
        		
        		System.out.println("("+x+"; "+y+")");
        	}
        });
		
	}
	
	
}
