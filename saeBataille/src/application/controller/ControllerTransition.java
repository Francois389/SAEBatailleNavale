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
		
		for (int i = 0; i < Modele.getPartieEnCours().getAutreJoueur().getGrilleBateaux().getBateau().length; i++) {
			
		}
		if (Modele.getPartieEnCours().getAutreJoueur().getGrilleBateaux().getBateau().length != 0) {
			System.out.println("tg quentin");
			bateauJ2place = true;
		}
		
	}
	@FXML
	private void tourSuivant() {
		Modele.getPartieEnCours().incrementNbTour();
		System.out.println(Modele.getPartieEnCours().getNbTour());
		//System.out.println(Joueur1 + " " + Joueur2);
		if (!bateauJ2place) {
			bateauJ2place = true ;
			Main.activerPositionBateau2();
		} else {
			
			Main a = new Main();
       		a.chargementPageDependante();
       		Main.activerPageDeJeux();
		}
		
	}
	
	public static void affichage() {
		
		controllerCourant.pseudoJoueur1.setText(Modele.getPartieEnCours().getJoueurActuel().getNom());
		controllerCourant.pseudoJoueur2.setText(Modele.getPartieEnCours().getAutreJoueur().getNom());
	}
}
