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

/**
 * Classe qui va lancer l'application de jeu.
 * 
 * @author Descriaud Lucas
 */
public class Main extends Application {
    
    
    /** largeur maximale de la fenetre*/
    private static final int LARGEUR = 720;
    
    /** hauteur maximale de la fenetre*/
    private static final int HAUTEUR = 480;

    /** Scene du menu principale*/
    private static Scene menuPrincipale;
    
    /** Scene du menu de positionnement des bateaux*/
    private static Scene positionBateau;
    
    /** Scene du menu de personnalisation de partie*/
    private static Scene personalisePartie;
    
    /** Scene de la page de sauvegarde de partie */
    private static Scene sauvegardePartie;
    
    /** Scene de la page de jeux */
    private static Scene pageDeJeux;
    
    /** Scene de la page de jeux */
    private static Scene chargerPartie;
    
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
    
    /** 
     * ferme la fenetre
     */
    public static void quitter() {
        fenetrePrincipale.close();
    }

    
    
	@Override
	public void start(Stage primaryStage) {
		try {
		    Parent conteneur;
		    
		    // Chargement de la vue Menu principale dans le conteneur
		    // et creation scene principale
			conteneur = getParentFromVue("vue/MenuPrincipal.fxml");
			menuPrincipale = new Scene(conteneur , LARGEUR , HAUTEUR);
			
			// Chargement de la vue postionBateau dans le conteneur
			conteneur = getParentFromVue("vue/pagePositionBateau.fxml");
            positionBateau = new Scene(conteneur , LARGEUR , HAUTEUR);
            
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
	    Modele.setPartieEnCours(Lecture.interprete(Lecture.lire("FvsQ")));
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
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Le chemin n'est pas bon");
        }
	}

}
