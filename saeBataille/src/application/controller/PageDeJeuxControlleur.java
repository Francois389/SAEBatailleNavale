/**
 * 
 */
package application.controller;

import java.util.Optional;

import application.Main;
import application.modele.Modele;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import jeu.partie.Joueur;
import jeu.partie.Partie;

/**
 * Le controlleur de la pageDeJeux.fxml
 * @author de Saint Palais François
 *
 */
//TODO enlever l'héritage d'Application, on n'en a pas besoin
public class PageDeJeuxControlleur {
    
    private Partie partieEnCours;
    private static PageDeJeuxControlleur controlleurCourant ;
    
    @FXML
    Label nomJoueur;
    @FXML
    public void initialize() {
    	PageDeJeuxControlleur.controlleurCourant = this ;
        partieEnCours = Modele.getPartieEnCours();
    }

    
    @FXML
    void menuChargerUnePartie() {
        System.out.println("Charger une partie");
        if (!partieEnCours.isEstSauvegarder()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
                    ButtonType.YES, ButtonType.NO);
            
            boiteAlerte.setHeaderText("Attention votre partie n'est pas sauvegarder."
                    + "\nVoulez vous continuer sans sauvegarder ?"); 
            Optional<ButtonType> option = boiteAlerte.showAndWait(); 
            if (option.get() == ButtonType.YES) {
                Main.activerSauvegardePartie();
            }
        }
    }
    
    @FXML
    void menuRetourAuMenu() {
        System.out.println("Retour au menu");
        if (!partieEnCours.isEstSauvegarder()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
                    ButtonType.YES, ButtonType.NO);
            
            boiteAlerte.setHeaderText("Attention votre partie n'est pas sauvegarder."
                    + "\nVoulez vous continuer sans sauvegarder ?"); 
            Optional<ButtonType> option = boiteAlerte.showAndWait(); 
            if (option.get() == ButtonType.YES) {
                Main.activerMenuPrincipale();
            }
        }
    }
    
    @FXML
    void menuQuitter() {
        System.out.println("Quitter");
        if (!partieEnCours.isEstSauvegarder()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
                    ButtonType.YES, ButtonType.NO);
            
            boiteAlerte.setHeaderText("Attention votre partie n'est pas sauvegarder."
                    + "\nVoulez vous continuer sans sauvegarder ?"); 
            Optional<ButtonType> option = boiteAlerte.showAndWait(); 
            if (option.get() == ButtonType.YES) {
                Main.quitter();
            }
        }
    }
    
    @FXML
    void menuNouvellePartie() {
        System.out.println("Nouvelle partie");
        if (!partieEnCours.isEstSauvegarder()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
                    ButtonType.YES, ButtonType.NO);
            
            boiteAlerte.setHeaderText("Attention votre partie n'est pas sauvegarder."
                    + "\nVoulez vous continuer sans sauvegarder ?"); 
            Optional<ButtonType> option = boiteAlerte.showAndWait(); 
            if (option.get() == ButtonType.YES) {
                Main.activerPersonalisePartie();
            }
        }
    }
    
    @FXML
    void menuSauvegarder() {
        System.out.println("sauvegarde");
        Main.activerSauvegardePartie();
    }
    
    @FXML
    void menuAbandonner() {
        System.out.println("Abandonner");
        ButtonType btnAbandonner = new ButtonType("Abandonner");
        ButtonType btnAnnuler = new ButtonType("Annuler");
        if (!partieEnCours.isEstSauvegarder()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
                    btnAbandonner, btnAnnuler);
            
            boiteAlerte.setHeaderText("Êtes vous sur de vouloir abandonner ?"); 
            Optional<ButtonType> option = boiteAlerte.showAndWait(); 
            if (option.get() == btnAbandonner) {
                Joueur perdant = Modele.getPartieEnCours().getJoueurActuel();
                Joueur gagnant = Modele.getPartieEnCours().getAutreJoueur();
                System.out.println(perdant.getNom() + " abandonne.");
                Modele.setJoueurGagnant(gagnant);
                System.out.println(gagnant.getNom() + " gagne !");
                Main.activerResultat();
            }
        }
    }
    
    @FXML
    void menuCommentJouer() {
        System.out.println("Comment jouer");
    }
    
    @FXML
    void menuCredit() {
        System.out.println("Credit");
    }


	public static void affichage() {
		controlleurCourant.nomJoueur.setText(Modele.getPartieEnCours().getJoueur1().getNom());
	}

}
