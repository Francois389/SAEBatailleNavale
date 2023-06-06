package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.partie.Joueur;

public class ControllerTransition {

	@FXML
	private Label pseudoJoueur1;
	
	@FXML
	private Label pseudoJoueur2;
	
	// TODO récupérer les noms des joueurs
	
	private Boolean bateauJ2place = false ;
	
	
	protected Joueur Joueur1 =  Modele.getPartieEnCours().getJoueur1(); 
	protected Joueur Joueur2 =  Modele.getPartieEnCours().getJoueur2(); 
	

	private static ControllerTransition controllerCourant;
	
	@FXML
	void initialize() {
		ControllerTransition.controllerCourant =  this;
	}
	@FXML
	private void tourSuivant() {
		Modele.getPartieEnCours().incrementNbTour();
		System.out.println(Modele.getPartieEnCours().getNbTour());
		//System.out.println(Joueur1 + " " + Joueur2);
		if (!bateauJ2place) {
			bateauJ2place = true ;
			Main.activerPositionBateau2();
			//joueurSuivant(Joueur2 , Joueur1);
		} else {
			Main.activerPageDeJeux();
			
			// TODO changer pour ecran jeu joueur2
		}
		
	}
	
	public static void affichage() {
		
		controllerCourant.pseudoJoueur1.setText(Modele.getPartieEnCours().getJoueurActuel().getNom());
		controllerCourant.pseudoJoueur2.setText(Modele.getPartieEnCours().getAutreJoueur().getNom());
	}
}
