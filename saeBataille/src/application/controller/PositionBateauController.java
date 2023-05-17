package application.controller;

import javafx.geometry.Point2D;


import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.input.*;

public class PositionBateauController {

    @FXML
    private ImageView porteAvions;

    // Variables pour enregistrer les positions initiales
    private double initialMouseX;
    private double initialMouseY;
    private double initialTranslateX;
    private double initialTranslateY;

    @FXML
    private void dragPorteAvions(MouseEvent event) {
        // Enregistrer la position initiale de la souris et de l'image
        initialMouseX = event.getSceneX();
        initialMouseY = event.getSceneY();

        // Convertir les coordonnées de la souris en coordonnées locales de l'image
        Point2D imagePosition = porteAvions.localToScene(0, 0);
        initialTranslateX = imagePosition.getX();
        initialTranslateY = imagePosition.getY();

        porteAvions.startFullDrag();
        event.consume();
    }

    @FXML
    private void onDragOver(DragEvent event) {
        if (event.getGestureSource() != porteAvions && event.getDragboard().hasImage()) {
            event.acceptTransferModes(TransferMode.MOVE);

            // Mettre à jour la position de l'image en fonction du mouvement de la souris
            double offsetX = event.getSceneX() - initialMouseX;
            double offsetY = event.getSceneY() - initialMouseY;
            double newTranslateX = initialTranslateX + offsetX;
            double newTranslateY = initialTranslateY + offsetY;

            // Déplacer l'image en fonction des nouvelles coordonnées locales
            porteAvions.setTranslateX(newTranslateX - porteAvions.getLayoutX());
            porteAvions.setTranslateY(newTranslateY - porteAvions.getLayoutY());
        }
        event.consume();
    }


    @FXML
    private void dragPorteAvionsDone(DragEvent event) {
        if (event.getTransferMode() == TransferMode.MOVE) {
            // L'opération de glisser-déposer a réussi
            // Effectuez des opérations supplémentaires si nécessaire
        }
        event.consume();
    }

    @FXML
    private void onDragEntered(DragEvent event) {
        if (event.getGestureSource() != porteAvions) {
            // Mettez en évidence la zone cible si nécessaire
        }
        event.consume();
    }
    @FXML
    private void onDragExited(DragEvent event) {
        if (event.getGestureSource() != porteAvions) {
            // Réinitialisez l'apparence de la zone cible si nécessaire
        }
        event.consume();
    }



    @FXML
    private void onDragDetected(MouseEvent event) {
        porteAvions.startFullDrag();
        event.consume();
    }

    @FXML
    private void onDragDropped(DragEvent event) {
        Dragboard dragboard = event.getDragboard();
        boolean success = false;
        if (dragboard.hasImage()) {
            // Récupérez les données de l'image et effectuez les opérations nécessaires pour placer l'image dans la GridPane
            // Image image = dragboard.getImage();
            // Effectuez les opérations de placement de l'image dans la GridPane
            success = true;
        }
        event.setDropCompleted(success);
        event.consume();
    }

    @FXML
    private void onDragReleased(MouseEvent event) {
        event.consume();
    }

    @FXML
    private void onDragDone(DragEvent event) {
        event.consume();
    }
}
