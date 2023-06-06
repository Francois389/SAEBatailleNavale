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
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Cellule;

/**
 * Le controlleur de la pageDeJeux.fxml
 * @author de Saint Palais François
 *
 */
//TODO enlever l'héritage d'Application, on n'en a pas besoin
public class PageDeJeuxControlleur extends Application {
    
    private Partie partieEnCours;
    
    @FXML
    private GridPane grilleEnnemie ;
    
    @FXML
    private GridPane grilleJoueur;
    
    @FXML
    private SVGPath cross;
    
    @FXML
    private Circle circle;
    
    @FXML
    public void initialize() {
        System.out.println("initialize controler page jeux");
        
        // SVGPath temp = new SVGPath();
        // temp.setContent(cross.getContent());
        
        Circle a = new Circle();
        a.setRadius(circle.getRadius());
        
        grilleEnnemie.add(a, 1, 1);
        
        if (Modele.getPartieEnCours().getJoueurActuel() == Modele.getPartieEnCours().getJoueur1()) {
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && Modele.getPartieEnCours().getJoueur2().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        
                        grilleEnnemie.add(temp, i, j);
                        System.out.println("rond en " + i + "; "+ j);
                    }
                }
            }
            
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && ! Modele.getPartieEnCours().getJoueur2().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleEnnemie.add(temp, i, j);
                        System.out.println("croix en " + i + "; "+ j);
                    }
                }
            }
            
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && Modele.getPartieEnCours().getJoueur1().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        
                        grilleJoueur.add(temp, i, j);
                        System.out.println("rond en " + i + "; "+ j);
                    }
                }
            }
            
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && ! Modele.getPartieEnCours().getJoueur1().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleJoueur.add(temp, i, j);
                        System.out.println("croix en " + i + "; "+ j);
                    }
                }
            }
            
            
            
            
        } else {
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && Modele.getPartieEnCours().getJoueur1().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        
                        grilleEnnemie.add(temp, i, j);
                        System.out.println("rond en " + i + "; "+ j);
                    }
                }
            }
            
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur2().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && ! Modele.getPartieEnCours().getJoueur1().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleEnnemie.add(temp, i, j);
                        System.out.println("croix en " + i + "; "+ j);
                    }
                }
            }
            
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && Modele.getPartieEnCours().getJoueur2().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        
                        grilleJoueur.add(temp, i, j);
                        System.out.println("rond en " + i + "; "+ j);
                    }
                }
            }
            
            for (int i = 0; i < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage().length; i++) {
                for (int j = 0; j < Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i].length; j++) {
                    if (   Modele.getPartieEnCours().getJoueur1().getGrilleTirs().getQuadrillage()[i][j].isTouche() 
                        && ! Modele.getPartieEnCours().getJoueur2().getGrilleBateaux().getQuadrillage()[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleJoueur.add(temp, i, j);
                        System.out.println("croix en " + i + "; "+ j);
                    }
                }
            }
        }
        
        
    }

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
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

}
