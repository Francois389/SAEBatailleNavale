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
    
    /** Scene du menu principale*/
    private static Scene menuPrincipale;
    
    /** Scene du menu de positionnement des bateaux*/
    private static Scene positionBateau;
    
    /** 
     * Fenêtre principale de l'application
     * La scène qui lui est associée sera modifiée en fonction
     * des clic sur les boutons
     */
    private static Stage fenetrePrincipale;
    
    
    /**
     * Les methodes suivant change la scene de
     * la fenetre principale
     */
    public static void activerMenuPrincipale() {
        fenetrePrincipale.setScene(menuPrincipale);
    }
    
    public static void activerPositionBateau() {
        fenetrePrincipale.setScene(positionBateau); 
    }
	@Override
	public void start(Stage primaryStage) {
		try {
		    // Chargement de la vue Menu principale dans le conteneur
			FXMLLoader chargeurFXML = new FXMLLoader();
			chargeurFXML.setLocation(getClass().getResource("vue/MenuPrincipal.fxml"));  
			Parent conteneur = chargeurFXML.load();
			
			// Creation scene principale
			menuPrincipale = new Scene(conteneur , 720 , 480);
			
			// Chargment de la vue postionBateau dans le conteneur
			FXMLLoader chargeurFXMLPositionBateau = new FXMLLoader();
            chargeurFXMLPositionBateau.setLocation(getClass().getResource("vue/pagePositionBateau.fxml"));  
            conteneur = chargeurFXMLPositionBateau.load();
            
            positionBateau = new Scene(conteneur , 720 , 480);
            
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
