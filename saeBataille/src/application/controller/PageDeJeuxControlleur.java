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
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Cellule;
import jeu.plateau.Grille;

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
    
    private final int CIRCLE_RADIUS = 12;
    
    
    @FXML
    public void initialize() {
        
        System.out.println("initialize controler page jeux");
        
        // SVGPath temp = new SVGPath();
        // temp.setContent(cross.getContent());
        
        
        Joueur joueurActuel = Modele.getPartieEnCours().getJoueurActuel();
        Joueur joueur1 = Modele.getPartieEnCours().getJoueur1();
        Joueur joueur2 = Modele.getPartieEnCours().getJoueur2();
        
        Cellule[][] tirJ1 = joueur1.getGrilleTirs().getQuadrillage();
        Cellule[][] tirJ2 = joueur2.getGrilleTirs().getQuadrillage();
        Cellule[][] bateauJ1 = joueur1.getGrilleBateaux().getQuadrillage();
        Cellule[][] bateauJ2 = joueur2.getGrilleBateaux().getQuadrillage();
        
        
        
        
        for (int i = 0; i < tirJ1.length; i++) {
            for (int j = 0; j < tirJ1[i].length; j++) {
            	// c'est le joueur 1
                if (joueurActuel == joueur1) {	                    
                    if (tirJ1[i][j].isTouche() 
                     && bateauJ2[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        temp.setStroke(Color.rgb(255, 33, 33));
                        
                        grilleEnnemie.add(temp, i, j);
                    }
                    
                    if (tirJ1[i][j].isTouche() 
                    && !bateauJ2[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleEnnemie.add(temp, i, j);
                    }
                    
                    if (tirJ2[i][j].isTouche() 
                     && bateauJ1[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        temp.setStroke(Color.rgb(255, 33, 33));
                        
                        grilleJoueur.add(temp, i, j);
                    }
                    if (tirJ2[i][j].isTouche() 
                    && !bateauJ1[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleJoueur.add(temp, i, j);
                    }
            	} else  { // c'est le joueur 2
            		if (tirJ2[i][j].isTouche() 
                     && bateauJ1[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        temp.setStroke(Color.rgb(255, 33, 33));
                        
                        grilleEnnemie.add(temp, i, j);
                    }
            	
            		if (tirJ2[i][j].isTouche() 
                    && !bateauJ1[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleEnnemie.add(temp, i, j);
                    }
                    
                    if (tirJ1[i][j].isTouche() 
                     && bateauJ2[i][j].isBateau()) {
                        
                        Circle temp = new Circle();
                        temp.setRadius(circle.getRadius());
                        temp.setStroke(Color.rgb(255, 33, 33));
                        
                        grilleJoueur.add(temp, i, j);
                    }
                    
                    if (tirJ1[i][j].isTouche() 
                    && !bateauJ2[i][j].isBateau()) {
                        
                        SVGPath temp = new SVGPath();
                        temp.setContent(cross.getContent());
                        
                        grilleJoueur.add(temp, i, j);
                    }
            		
            	}
            }
        }   
        
    }
    
    // TODO sous programme 
    // TODO afficher leur nombre dans la top bar
    
  

    @Override
    public void start(Stage arg0) throws Exception {
        // TODO Auto-generated method stub
    }
    
    public void printCircle(int x, int y, GridPane grille) {
        Circle temp = new Circle();
        temp.setRadius(CIRCLE_RADIUS);
        temp.setFill(Color.rgb(255, 33, 33));
        temp.setTranslateX(3);
        
        grille.add(temp, x, y);
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
