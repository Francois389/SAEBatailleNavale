package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
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
    
    /** Scene du menu de personalisation de partie*/
    private static Scene personalisePartie;
    
    /** Scene de la page de sauvegarde de partie */
    private static Scene sauvegardePartie;
    
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
    public static void activerPositionBateau() {
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
    
    /** 
     * ferme la fenetre
     */
    public static void quitter() {
        fenetrePrincipale.close();
    }
    
    
    
    
	@Override
	public void start(Stage primaryStage) {
		try {
		    // Chargement de la vue Menu principale dans le conteneur
			FXMLLoader chargeurFXML = new FXMLLoader();
			chargeurFXML.setLocation(getClass().getResource("vue/MenuPrincipal.fxml"));  
			Parent conteneur = chargeurFXML.load();
			
			// Creation scene principale
			menuPrincipale = new Scene(conteneur , LARGEUR , HAUTEUR);
			
			// Chargment de la vue postionBateau dans le conteneur
			FXMLLoader chargeurFXMLPositionBateau = new FXMLLoader();
            chargeurFXMLPositionBateau.setLocation(getClass().getResource("vue/pagePositionBateau.fxml"));  
            conteneur = chargeurFXMLPositionBateau.load();
            
            positionBateau = new Scene(conteneur , LARGEUR , HAUTEUR);
            
            // Chargement de la vue personalisePartie
            FXMLLoader chargeurFXMLPersonalisePartie = new FXMLLoader();
            chargeurFXMLPersonalisePartie.setLocation(getClass().getResource("vue/personalisePartie.fxml"));
            conteneur = chargeurFXMLPersonalisePartie.load();
         
            personalisePartie = new Scene(conteneur , LARGEUR  , HAUTEUR);
            
           // Chargement de la vue en sauvegarde partie
            FXMLLoader chargeurSauvegardePartie = new FXMLLoader();
            chargeurSauvegardePartie.setLocation(getClass().getResource("vue/pageSauvegarde.fxml"));
            conteneur = chargeurSauvegardePartie.load();
            
            sauvegardePartie = new Scene (conteneur , LARGEUR , HAUTEUR);
            
            
            primaryStage.setTitle("Bataille Navale");
            
            
            /* chargement de la vue de la scène principale 
             * dans le conteneu de type Parent
             */
			primaryStage.setScene(menuPrincipale);
			fenetrePrincipale = primaryStage;
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
