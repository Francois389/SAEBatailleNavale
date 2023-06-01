package application;
    
import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Classe qui va lancer une page précise
 * Il faut indiquer en dur dans le code la page voulue.
 * 
 * @author Descriaud Lucas
 */
public class DebugGoToPage extends Application {
    
    
    /** largeur maximale de la fenêtre*/
    private static final int LARGEUR = 720;
    
    /** hauteur maximale de la fenêtre*/
    private static final int HAUTEUR = 480;
    
    private static Scene pageVoulue;
    
    @Override
    public void start(Stage primaryStage) {
        try {
            Parent conteneur;
            
            conteneur = getParentFromVue("vue/pageDeJeux.fxml");
            pageVoulue = new Scene(conteneur , LARGEUR  , HAUTEUR);
            
            primaryStage.setTitle("Bataille Navale");
            
            
            /* chargement de la vue de la scène principale 
             * dans le conteneur de type Parent
             */
            primaryStage.setScene(pageVoulue);
            primaryStage.show();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * @param chemin
     * @return
     * @throws IOException
     */
    private Parent getParentFromVue(String chemin) throws IOException {
        Parent conteneur;
        FXMLLoader chargeurFXMLPersonalisePartie = new FXMLLoader();
        chargeurFXMLPersonalisePartie.setLocation(getClass().getResource(chemin));
        conteneur = chargeurFXMLPersonalisePartie.load();
        return conteneur;
    }
    
    public static void main(String[] args) {
        launch(args);
    }
}
