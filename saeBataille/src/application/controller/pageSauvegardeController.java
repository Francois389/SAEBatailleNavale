package application.controller;

import java.io.IOException;
import java.util.Optional;

import application.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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
public class pageSauvegardeController {

    @FXML
    private Button retour;
    
    @FXML
    private Button partie1;
    
    @FXML
    private Button partie2;
    
    @FXML
    private Button partie3;
    
    @FXML
    private Button partie4;
    
    @FXML
    private Button partie5;
    
    
    
    @FXML
    private void retourMainMenu() throws IOException {
        Main.activerMenuPrincipale();
    }
}
