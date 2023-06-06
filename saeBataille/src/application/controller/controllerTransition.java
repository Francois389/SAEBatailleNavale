package application.controller;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import jeu.partie.Joueur;

public class controllerTransition {

	@FXML
	private Label pseudoJoueur1;
	
	@FXML
	private Label pseudoJoueur2;
	
	// TODO récupérer les noms des joueurs
	
	private Boolean bateauJ2place = false ;
	
	
	private Joueur Joueur1 =  Modele.getPartieEnCours().getJoueur1(); 
	private Joueur Joueur2 =  Modele.getPartieEnCours().getJoueur2(); 
	
	// Par defaut le joueur 1  commencee
	private Joueur joueurSuivant = Joueur1;
	
	@FXML
	private void tourSuivant() {
		if (!bateauJ2place) {
			Main.activerPositionBateau2();
		} else if (joueurSuivant.equals(Joueur1)){
			joueurSuivant = Joueur2;
			// TODO changer pour ecran jeu joueur1
		} else if (joueurSuivant.equals(Joueur2)) {
			joueurSuivant = Joueur1;
			// TODO changer pour ecran jeu joueur2
		}
		
	}
}
