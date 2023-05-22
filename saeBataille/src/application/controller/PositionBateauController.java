package application.controller;

import java.io.IOException;

import application.Main;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class PositionBateauController {
    
    @FXML
    private Button retour;
    
    @FXML
    private void personalisePartie() throws IOException {
        Main.activerPersonalisePartie();
    }
}
