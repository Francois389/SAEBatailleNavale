/**
 * 
 */
package application.controller;

import java.util.Optional;

import application.Main;
import application.modele.Modele;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.SVGPath;
import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Cellule;

/**
 * Le controlleur de la pageDeJeux.fxml
 * @author de Saint Palais François
 *
 */
public class PageDeJeuxControlleur {
    
	final static int TAILLE_GRILLE_PIXEL = 30;
	
	final static private int DIMENSION_MIN = 0 ;
	
	final static private int DIMENSION_MAX = 9 ;
	
        
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
    
    @FXML
    private Label nbTirs;
    
    private final int CIRCLE_RADIUS = 12;
    
    private Partie partieEnCours;

	private static PageDeJeuxControlleur controlleurCourant ;
    
    @FXML
    Label nomJoueur;
    
    @FXML
    public void initialize() {
		
		
    	PageDeJeuxControlleur.controlleurCourant = this ;
        partieEnCours = Modele.getPartieEnCours();
        printCrossCircle();
        printNbTirs();
        grilleEnnemie.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
        	@Override
        	public void handle(MouseEvent event) {
        		int x = (int) event.getX() / TAILLE_GRILLE_PIXEL;
        		int y = (int) event.getY() / TAILLE_GRILLE_PIXEL;
        			    			
        		if (DIMENSION_MIN<= x && x <= DIMENSION_MAX 
        			&& DIMENSION_MIN <= y && y <= DIMENSION_MAX)  {
        			tirCellule(x, y);
        		}
        	}
        });
        
    }

    
    public void printNbTirs() {
        Joueur joueurActuel = Modele.getPartieEnCours().getJoueurActuel();
        Joueur joueur1 = Modele.getPartieEnCours().getJoueur1();
        Joueur joueur2 = Modele.getPartieEnCours().getJoueur2();
        
        if (joueurActuel == joueur1) { 
            nbCircle.setText("  : " +  joueur1.getNbTouche());
            nbCross.setText("  : " +  joueur1.getTirRatés());
            nbTirs.setText("nombre de tirs : " + joueur1.getNbTouche() + joueur1.getTirRatés());
        } else {
            nbCircle.setText("  : " +  joueur2.getNbTouche());
            nbCross.setText("  : " +  joueur2.getTirRatés());
            nbTirs.setText("nombre de tirs : " + joueur2.getNbTouche() + joueur2.getTirRatés());
        }
        
        
    }
    public void printCrossCircle() {
        
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

                        printCross(j, i, grilleJoueur);
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

        
    }
    
    
    private void tirCellule(int x, int y) {
		boolean toutTouche;
		boolean touche;
    	Joueur joueurActuel = Modele.getPartieEnCours().getJoueurActuel();
        Joueur joueur1 = Modele.getPartieEnCours().getJoueur1();
        Joueur joueur2 = Modele.getPartieEnCours().getJoueur2();
        
        Cellule[][] bateauJ1 = joueur1.getGrilleBateaux().getQuadrillage();
        Cellule[][] bateauJ2 = joueur2.getGrilleBateaux().getQuadrillage();
        
        if (joueurActuel == joueur1) {
        	joueur1.tir(bateauJ2[x][y]);
        	touche = bateauJ2[x][y].isBateau();
        	if (touche) {
        		printCircle(x, y, grilleEnnemie);
        	} else {
        		printCross(x, y, grilleEnnemie);
        	}
        } else {
        	joueur2.tir(bateauJ1[x][y]);
        	touche = bateauJ2[x][y].isBateau();
        	if (touche) {
        		printCircle(x, y, grilleJoueur);
        	} else {
        		printCross(x, y, grilleEnnemie);
        	}
        }
        
        toutTouche = true;
        for (int i = 0; i < Modele.getPartieEnCours().getAutreJoueur().getGrilleBateaux().getQuadrillage().length; i++) {
			for (int j = 0; i < Modele.getPartieEnCours().getAutreJoueur().getGrilleBateaux().getQuadrillage().length; i++) {
				if (! Modele.getPartieEnCours().getAutreJoueur().getGrilleBateaux().getQuadrillage()[i][j].isTouche()) {
					toutTouche = false;
				}
			} 
		} 
        
        if (toutTouche) {
			Modele.setJoueurGagnant(joueurActuel);
			Main.activerResultat();
		}
        
        Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("résultat du tir");
		
		if (touche) {
			alert.setContentText("touché !");
			alert.showAndWait(); 
			
//			Main a = new Main();
//        	a.chargementChargerPartie();     
        	Main.activerPageDeJeux();
		} else {
			Modele.getPartieEnCours().incrementNbTour();
			alert.setContentText("loupé ...");
			alert.showAndWait();
			
//			Main a = new Main();
//        	a.chargementTranstion();     
        	Main.activerEcranTransition(); 

		}
		
		
        
    }
    
    // TODO afficher leur nombre dans la top bar
    
    
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
    void menuNouvellePartie() {
        if (!partieEnCours.isEstSauvegarder()) {
            Alert boiteAlerte = new Alert(Alert.AlertType.CONFIRMATION ,"",
                    ButtonType.YES, ButtonType.NO);
            
            boiteAlerte.setHeaderText("Attention votre partie n'est pas sauvegarder."
                    + "\nVoulez vous continuer sans sauvegarder ?"); 
            Optional<ButtonType> option = boiteAlerte.showAndWait(); 
            if (option.get() == ButtonType.YES) {
                Main.activerPersonalisePartie();
            }
        } else {
			Main.activerPersonalisePartie();
		}
    }
    
    @FXML
    void menuSauvegarder() {
        Main a = new Main();
        a.chargementSauvegardePartie();
        Main.activerSauvegardePartie();
    }
    
    @FXML
    void menuAbandonner() {
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
                Modele.setJoueurGagnant(gagnant);
                Main a = new Main ();
                a.chargementPageDependante();
                Main.activerResultat();
            }
        }
    }
    
    @FXML
    void menuCommentJouer() {
    }
    
    @FXML
    void menuCredit() {
    }

	public static void affichage() {
		controlleurCourant.nomJoueur.setText(Modele.getPartieEnCours().getJoueurActuel().getNom());	
	}

}
