package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import jeu.partie.Joueur;

public class ControllerTransition {

	@FXML
	private Label pseudoJoueur1;
	
	@FXML
	private Label pseudoJoueur2;
	
	@FXML
	private Button boutonGo;
	
	
	private Boolean bateauJ2place = false ;
	
	
	protected Joueur Joueur1 =  Modele.getPartieEnCours().getJoueur1(); 
	protected Joueur Joueur2 =  Modele.getPartieEnCours().getJoueur2(); 
	

	private static ControllerTransition controllerCourant;
	
	@FXML
	void initialize() {
		
		ControllerTransition.controllerCourant =  this;
		
		for (int i = 0; i < Modele.getPartieEnCours().getJoueur2().getGrilleBateaux().getBateau().length; i++) {
			for (int j = 0; j < Modele.getPartieEnCours().getJoueur2().getGrilleBateaux().getBateau().length; j++) {
				if (Modele.getPartieEnCours().getJoueur2().getGrilleBateaux().getBateau()[i][j]) {
					bateauJ2place = true;
				}				
			}
		}		
	}
	@FXML
	private void tourSuivant() {
		Modele.getPartieEnCours().incrementNbTour();
		if (!bateauJ2place) {
			bateauJ2place = true ;
			Main a = new Main();
			a.positionBateau2();
			Main.activerPositionBateau2();
		} else {
			
			Main a = new Main();
       		a.chargementPageJeu();
       		Main.activerPageDeJeux();
		}
		
	}
	
	public static void affichage() {
		
		controllerCourant.pseudoJoueur1.setText(Modele.getPartieEnCours().getJoueurActuel().getNom());
		controllerCourant.pseudoJoueur2.setText(Modele.getPartieEnCours().getAutreJoueur().getNom());
	}
}
