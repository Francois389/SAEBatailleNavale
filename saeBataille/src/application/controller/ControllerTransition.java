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
		System.out.println(Joueur1 + " " + Joueur2);
		if (!bateauJ2place) {
			bateauJ2place = true ;
			Main.activerPositionBateau2();
			joueurSuivant(Joueur2 , Joueur1);
		} else {
			if (Modele.getPartieEnCours().getAutreJoueur().equals(Joueur1))  {
				Main a = new Main();
       			a.chargementPageDependante();
       			Main.activerPageDeJeux();
			}
		}
	}
	
	private void joueurSuivant(Joueur suivant , Joueur actuel) {
		pseudoJoueur1.setText(actuel.getNom());
		pseudoJoueur2.setText(suivant.getNom());
		System.out.println("pseudo changer");
	
	}
}
