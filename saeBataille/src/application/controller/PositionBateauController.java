package application.controller;

import java.io.IOException;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;

import jeu.plateau.Grille;
import jeu.plateau.Cellule;

public class PositionBateauController {
	
	final static private int TAILLE_GRILLE_PIXEL = 30;
	
	private boolean clicActive = false;
	
    @FXML
    private ImageView porteAvions ;
    
    @FXML
    private GridPane grille ;
    
    @FXML 
    ImageView croisseur;
    
    @FXML
    private Button retour;
    
    @FXML
    private ImageView torpilleur;
    
    @FXML
    private ImageView contreTorpilleur;
    
    private ImageView bateauCourant;
    private Grille grilleJoueur = new Grille(creerTableauGrille());    
    
    private Cellule[][] creerTableauGrille() {
    	Cellule[][] retour = new Cellule[10][10];
    
    	for (int i = 0; i < retour.length; i++) {
    		for (int j = 0; j < retour.length; j++) {
    			retour[i][j] = new Cellule(i,j);
    		}
    	}
    	
    	return retour;
    }
    
    
    @FXML
    private void personalisePartie() throws IOException {
        Main.activerPersonalisePartie();
    }
    
    @FXML
    private void clicPorteAvions() {
		if (!clicActive){
			activerClic();
		}
		bateauCourant = porteAvions ;
        System.out.println("clic porte avions");
        System.out.println(porteAvions);
        System.out.println(grille);
 //       grille.add(porteAvions , 0 , 5);
 //       grille.setRowSpan(porteAvions, 5);
        
    }


	@FXML
	private void clicTorpilleurs() {
		if (!clicActive){
			activerClic();
		}
		bateauCourant = torpilleur;
        System.out.println("torpilleurs");
        
    }

	@FXML
	private void clicContreTorpilleur() {
		if (!clicActive){
			activerClic();
		}
//		bateauCourant = ;
	    System.out.println("contre torpilleur");
	}
	
	@FXML
	private void clicCroiseur() {
		if (!clicActive){
			activerClic();
		}
		bateauCourant = croisseur;
	    System.out.println("croisseur");
	    System.out.println(croisseur);
//	    grille.add(croisseur, 2, 3); // TODO modfier les coordonnees par le retour de la fonction clic grille pane
//	    grille.setRowSpan(croisseur , 4);
	}
	
	@FXML
	private void clicGridPane() {
		for (Node elt : grille.getChildren()) {
			elt.setOnMouseExited((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
	        	@Override
	        	public void handle(MouseEvent event) {
	        		int x = (int) event.getX() / TAILLE_GRILLE_PIXEL;
	        		int y = (int) event.getY() / TAILLE_GRILLE_PIXEL;
	        		System.out.println("("+x+"; "+y+")");
//	        		placerBateau(bateauCourant, x, y);
	        	}
	        });
		}
		
	}
	
	
	private void activerClic() {
		
		grille.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent event) {
        		int x = (int) event.getX() / TAILLE_GRILLE_PIXEL;
        		int y = (int) event.getY() / TAILLE_GRILLE_PIXEL;
        		
        		placerBateau(bateauCourant, x, y);
        	}
        });
	}
	
	private void placerBateau(ImageView bateau ,int x, int y) {
		if (grille.getChildren().contains(bateau)) {
			grille.getChildren().remove(bateau);
		}
		grille.add(bateau, x, y);
	}
	
}
