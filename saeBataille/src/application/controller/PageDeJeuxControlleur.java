/**
 * 
 */
package application.controller;

import java.util.Optional;

import application.Main;
import application.modele.Modele;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    
	final static int TAILLE_GRILLE_PIXEL = 30;
	
	final static private int DIMENSION_MIN = 0 ;
	
	final static private int DIMENSION_MAX = 9 ;
	
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
    private Label nbCircle;
    
    @FXML
    private Label nbCross;
    
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
                        
                        printCircle(i, j, grilleEnnemie);
                    }
                    
                    if (tirJ1[i][j].isTouche() 
                    && !bateauJ2[i][j].isBateau()) {
                        
                        printCross(j, i, grilleEnnemie);
                    }
                    
                    if (tirJ2[i][j].isTouche() 
                     && bateauJ1[i][j].isBateau()) {
                        
                        printCircle(i, j, grilleJoueur);
                        
                    }
                    if (tirJ2[i][j].isTouche() 
                    && !bateauJ1[i][j].isBateau()) {

                        printCross(j, i, grilleEnnemie);
                    }
            	} else  { // c'est le joueur 2
            		if (tirJ2[i][j].isTouche() 
                     && bateauJ1[i][j].isBateau()) {
                        
                        printCircle(i, j, grilleJoueur);
                    }
            	
            		if (tirJ2[i][j].isTouche() 
                    && !bateauJ1[i][j].isBateau()) {
                        
                       printCross(i, j, grilleEnnemie);
                    }
                    
                    if (tirJ1[i][j].isTouche() 
                     && bateauJ2[i][j].isBateau()) {
                        
                        printCircle(i, j, grilleEnnemie);
                    }
                    
                    if (tirJ1[i][j].isTouche() 
                    && !bateauJ2[i][j].isBateau()) {
                        
                        printCross(i, j, grilleJoueur);
                    }
            		
            	}
            }
        }   
    
        for (Node elt : grilleEnnemie.getChildren()) {
			elt.setOnMouseExited((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
	        	@Override
	        	public void handle(MouseEvent event) {
	        		int x = (int) event.getX() / TAILLE_GRILLE_PIXEL;
	        		int y = (int) event.getY() / TAILLE_GRILLE_PIXEL;
	        		//System.out.println("("+x+"; "+y+")");
	        			    			
	        		if (DIMENSION_MIN<= x && x <= DIMENSION_MAX 
	        			&& DIMENSION_MIN <= y && y <= DIMENSION_MAX)  {
	        			tirCellule(x, y);
	        		}
	        	}
	        });
			
			
		}
        
    }
    
    
    private void tirCellule(int x, int y) {
    	Joueur joueurActuel = Modele.getPartieEnCours().getJoueurActuel();
        Joueur joueur1 = Modele.getPartieEnCours().getJoueur1();
        Joueur joueur2 = Modele.getPartieEnCours().getJoueur2();
        
        Cellule[][] tirJ1 = joueur1.getGrilleTirs().getQuadrillage();
        Cellule[][] tirJ2 = joueur2.getGrilleTirs().getQuadrillage();
        Cellule[][] bateauJ1 = joueur1.getGrilleBateaux().getQuadrillage();
        Cellule[][] bateauJ2 = joueur2.getGrilleBateaux().getQuadrillage();
        
        if (joueurActuel == joueur1) {
        	joueur1.tir(bateauJ2[x][y]);
        } else {
        	joueur2.tir(bateauJ1[x][y]);
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
    
    public void printCross(int x, int y, GridPane grille) {
        SVGPath temp = new SVGPath();
        temp.setContent(cross.getContent());
        temp.setScaleX(3);
        temp.setScaleY(3);
        temp.setTranslateX(10);
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
