package application;
	
import java.io.IOException;

import application.controller.PageDeJeuxControlleur;
import application.modele.Modele;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import sauvegarde.Lecture;
import javafx.scene.Parent;
import javafx.scene.Scene;

import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Grille;
import jeu.plateau.Cellule;

/**
 * Classe qui va lancer l'application de jeu.
 * 
 * @author Descriaud Lucas
 */
public class Main extends Application {
    
    
    /** largeur maximale de la fenêtre*/
    private static final int LARGEUR = 720;
    
    /** hauteur maximale de la fenêtre*/
    private static final int HAUTEUR = 480;

    /** Scene du menu principale*/
    private static Scene menuPrincipale;
    
    /** Scene du menu de positionnement des bateaux*/
    private static Scene positionBateau;
    
    private static Scene positionBateauJoueur2;
    
    /** Scene du menu de personnalisation de partie*/
    private static Scene personalisePartie;
    
    /** Scene de la page de sauvegarde de partie */
    private static Scene sauvegardePartie;
    
    /** Scene de la page de jeux */
    private static Scene pageDeJeux;
    
    private static Scene resultat;
    
    private static Scene chargerPartie;


    private static Scene EcranTransition;
    

    /** 
     * Fenêtre principale de l'application
     * La scène qui lui est associée sera modifiée en fonction
     * des clic sur les boutons
     */
    private static Stage fenetrePrincipale;



    
    
    /**
     * change la scene de la fenetre principale en menuPrincipale
     */
    public static void activerMenuPrincipale() {
        fenetrePrincipale.setScene(menuPrincipale);
    }
    
    /**
     * change la scene de la fenetre principale en positionBateau
     */
    public static  void activerPositionBateau() {
        fenetrePrincipale.setScene(positionBateau); 
    }
    
    /**
     * change la scene de la fenetre principale en positionBateau joueur2
     */
    public static  void activerPositionBateau2() {
        fenetrePrincipale.setScene(positionBateauJoueur2); 
    }
    
    
    /**
     * change la scene de la fenetre principale en personalisePartie
     */
    public static void activerPersonalisePartie() {
        fenetrePrincipale.setScene(personalisePartie); 
    }
    
    /**
     * change la scene de la fenetre principale en pageSauvegarde
     */
    public static void activerSauvegardePartie() {
        fenetrePrincipale.setScene(sauvegardePartie);
    }

    public static void activerChargerPartie() {
        fenetrePrincipale.setScene(chargerPartie);
    }
    
    /**
     * change la scene de la fenetre principale en page de jeux
     */
    public static void activerPageDeJeux() {
        fenetrePrincipale.setScene(pageDeJeux);
    }
    /*
     * change la scene de la fenetre principale en ecran transition
     */
    public static void activerEcranTransition() {
    	fenetrePrincipale.setScene(EcranTransition);
    }
    
    /** 
     * ferme la fenetre
     */
    public static void quitter() {
        fenetrePrincipale.close();
    }
    
    public static void activerResultat() {
        fenetrePrincipale.setScene(resultat);
    }

    
    
	@Override
	public void start(Stage primaryStage) {
		try {
		    Parent conteneur;
		    
		    // Chargement de la vue Menu principale dans le conteneur
		    // et creation scene principale
			conteneur = getParentFromVue("vue/MenuPrincipal.fxml");
			menuPrincipale = new Scene(conteneur , LARGEUR , HAUTEUR);
			
			
            
            
            conteneur = getParentFromVue("vue/pagePositionBateau2.fxml");
            positionBateauJoueur2 = new Scene(conteneur , LARGEUR , HAUTEUR);
            
            // Chargement de la vue personalisePartie
            conteneur = getParentFromVue("vue/personalisePartie.fxml");
            personalisePartie = new Scene(conteneur , LARGEUR  , HAUTEUR);
            
           // Chargement de la vue sauvegarde partie
            conteneur = getParentFromVue("vue/pageChargerPartie.fxml");
            sauvegardePartie = new Scene (conteneur , LARGEUR , HAUTEUR);

            //Page pour charger une partie
            conteneur = getParentFromVue("vue/pageChargerPartie.fxml");
            chargerPartie = new Scene (conteneur , LARGEUR , HAUTEUR);
            
            // Chargement de la vue en sauvegarde partie
            conteneur = getParentFromVue("vue/pageDeJeux.fxml");
            pageDeJeux = new Scene (conteneur , LARGEUR , HAUTEUR);
            
            conteneur = getParentFromVue("vue/PageTransition.fxml");
            EcranTransition = new Scene (conteneur , LARGEUR , HAUTEUR);
            
            
            primaryStage.setTitle("Bataille Navale");
            
            
            /* chargement de la vue de la scène principale 
             * dans le conteneur de type Parent
             */
			primaryStage.setScene(menuPrincipale);
			fenetrePrincipale = primaryStage;
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * @param chemin 
     * @return
     * @throws IOException
     */
    private Parent getParentFromVue(String chemin) throws IOException {
        Parent conteneur;
        FXMLLoader chargeurPageDeJeux = new FXMLLoader();
        chargeurPageDeJeux.setLocation(getClass().getResource(chemin));
        conteneur = chargeurPageDeJeux.load();
        return conteneur;
    }
	
	public static void main(String[] args) {
        
        Cellule[][] quadrillageBateau = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        
        Joueur j1 = new Joueur("Joueur1",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Joueur2",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
        
	    Modele.setPartieEnCours(partie);
		launch(args);
	}

	/**
	 * Certaine page on besoin d'une Partie initialisé
	 * or cela n'est fais qu'avec la page personaliserPartie 
	 * ou la page chargerPartie.
	 * Tenter de charger les pages dépendante sans Partie initialisé conduit 
	 * à une erreur et l'application de ce lancera pas.
	 */
	public void chargementPageDependante() {
        try {
            // Chargement de la vue sauvegarde partie
            sauvegardePartie = new Scene (getParentFromVue("vue/pageSauvegardePartie.fxml") , LARGEUR , HAUTEUR);
            resultat = new Scene (getParentFromVue("vue/pageResultat.fxml") , LARGEUR , HAUTEUR);
            // Chargement de la vue postionBateau dans le conteneur
            positionBateau = new Scene(getParentFromVue("vue/pagePositionBateau.fxml") , LARGEUR , HAUTEUR);
            pageDeJeux = new Scene(getParentFromVue("vue/pageDeJeux.fxml") , LARGEUR , HAUTEUR);
            chargerPartie = new Scene(getParentFromVue("vue/pageChargerPartie.fxml") , LARGEUR , HAUTEUR);
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
