package application.controller;

import java.io.File;
import java.io.IOException;
import sauvegarde.Lecture;

import java.util.Iterator;
import java.util.Optional;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

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
    
    
    /**S'éxécute aux démarrage de l'application */
    @FXML
    private void initialize() {

        String[] files;
        File f = new File("sauvegardes");

        files = f.list();
       
        for (int i = 0; i < files.length; i++) {
            switch (i) {
            case 0: {   
                buttonPartie1.setText(files[i].substring(0, files[i].lastIndexOf(".")));
                buttonPartie1.setStyle(STYLE_BOUTTONS);
                break;
            }
            case 1: {
                buttonPartie2.setText(files[i].substring(0, files[i].lastIndexOf(".")));
                buttonPartie2.setStyle(STYLE_BOUTTONS);
                break;
            }
            case 2: {
                buttonPartie3.setText(files[i].substring(0, files[i].lastIndexOf(".")));
                buttonPartie3.setStyle(STYLE_BOUTTONS);
                break;
            }
            case 3: {
                buttonPartie4.setText(files[i].substring(0, files[i].lastIndexOf(".")));
                buttonPartie4.setStyle(STYLE_BOUTTONS);
                break;
            }
            case 4: {
                buttonPartie5.setText(files[i].substring(0, files[i].lastIndexOf(".")));
                buttonPartie5.setStyle(STYLE_BOUTTONS);
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
        System.out.println("charger partie 1");
    }
    
    @FXML
    private void loadPartie2() {
        System.out.println("charger partie 2");
    }
    
    @FXML
    private void loadPartie3() {
        System.out.println("charger partie 3");
    }
    
    @FXML
    private void loadPartie4() {
        System.out.println("charger partie 4");
    }
    
    @FXML
    private void loadPartie5() {
        System.out.println("charger partie 5");
    }
}