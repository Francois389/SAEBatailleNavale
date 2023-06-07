package application.controller;

import java.io.File;
import java.io.IOException;

import application.Main;
import application.modele.Modele;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import jeu.partie.Partie;
import sauvegarde.Lecture;

/**
 * Gère l'interactivité entre le menu et l'utilisateur.
 * @author François de Saint Palais
 */
public class ChargerPartieController {
    
    final String STYLE_BOUTTONS = "-fx-background-color: blue; -fx-background-radius: 10;";
    @FXML
    private Button retour;
    
    @FXML
    private Button buttonPartie1;
    
    @FXML
    private Button buttonPartie2;
    
    @FXML
    private Button buttonPartie3;
    
    @FXML
    private Button buttonPartie4;
    
    @FXML
    private Button buttonPartie5;
    
    private String partie1;
    private String partie2;
    private String partie3;
    private String partie4;
    private String partie5;
    
    Main lanceurApplication = new Main();
    
    
    /**S'éxécute aux démarrage de l'application */
    @FXML
    private void initialize() {
        retour.getStyleClass().add("btnRouge");
        
        buttonPartie1.getStyleClass().add("btnDesactiver");
        buttonPartie2.getStyleClass().add("btnDesactiver");
        buttonPartie3.getStyleClass().add("btnDesactiver");
        buttonPartie4.getStyleClass().add("btnDesactiver");
        buttonPartie5.getStyleClass().add("btnDesactiver");

        String[] files;
        File f = new File("sauvegardes");

        files = f.list();
       
        for (int i = 0; i < files.length; i++) {
            switch (i) {
            case 0: {   
                partie1 = files[i].substring(0, files[i].lastIndexOf("."));
                buttonPartie1.setText(partie1);
                buttonPartie1.getStyleClass().add("btnPartieSauvegarder");
                buttonPartie1.getStyleClass().remove("btnDesactiver");
                buttonPartie1.setDisable(false);
                break;
            }
            case 1: {
                partie2 = files[i].substring(0, files[i].lastIndexOf("."));
                buttonPartie2.setText(partie2);
                buttonPartie2.getStyleClass().add("btnPartieSauvegarder");
                buttonPartie2.getStyleClass().remove("btnDesactiver");
                buttonPartie2.setDisable(false);
                break;
            }
            case 2: {
                partie3 = files[i].substring(0, files[i].lastIndexOf("."));
                buttonPartie3.setText(partie3);
                buttonPartie3.getStyleClass().add("btnPartieSauvegarder");
                buttonPartie3.getStyleClass().remove("btnDesactiver");
                buttonPartie3.setDisable(false);
                break;
            }
            case 3: {
                partie4 = files[i].substring(0, files[i].lastIndexOf("."));
                buttonPartie4.setText(partie4);
                buttonPartie4.getStyleClass().add("btnPartieSauvegarder");
                buttonPartie4.getStyleClass().remove("btnDesactiver");
                buttonPartie4.setDisable(false);
                break;
            }
            case 4: {
                partie5 = files[i].substring(0, files[i].lastIndexOf("."));
                buttonPartie5.setText(partie5);
                buttonPartie5.getStyleClass().add("btnPartieSauvegarder");
                buttonPartie5.getStyleClass().remove("btnDesactiver");
                buttonPartie5.setDisable(false);
                break;
            }
            }
        }
    }
    
    
    
    @FXML
    private void retourMainMenu() throws IOException {
        Main.activerMenuPrincipale();
    }
    
    @FXML
    private void loadPartie1() {
       Partie partie = Lecture.interprete(Lecture.lire(partie1));
       Modele.setPartieEnCours(partie);
       lanceurApplication.chargementPageJeu();
       lanceurApplication.chargementPageDependante();
       Main.activerPageDeJeux();
    }
    
    @FXML
    private void loadPartie2() {
        Partie partie = Lecture.interprete(Lecture.lire(partie2));
        Modele.setPartieEnCours(partie);
        lanceurApplication.chargementPageJeu();
        lanceurApplication.chargementPageDependante();
        Main.activerPageDeJeux();
    }
    
    @FXML
    private void loadPartie3() {
        Partie partie = Lecture.interprete(Lecture.lire(partie3));
        Modele.setPartieEnCours(partie);
		lanceurApplication.chargementPageJeu();
        lanceurApplication.chargementPageDependante();
        Main.activerPageDeJeux();
    }
    
    @FXML
    private void loadPartie4() {
        Partie partie = Lecture.interprete(Lecture.lire(partie4));
        Modele.setPartieEnCours(partie);

        lanceurApplication.chargementPageJeu();
        lanceurApplication.chargementPageDependante();
        Main.activerPageDeJeux();
    }
    
    @FXML
    private void loadPartie5() {
        Partie partie = Lecture.interprete(Lecture.lire(partie5));
        Modele.setPartieEnCours(partie);
        lanceurApplication.chargementPageJeu();
        lanceurApplication.chargementPageDependante();
        Main.activerPageDeJeux();
    }
}
