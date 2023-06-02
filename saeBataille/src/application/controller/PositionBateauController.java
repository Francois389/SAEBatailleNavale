package application.controller;

import java.awt.Image;
import java.io.IOException;

import application.Main;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;

import jeu.plateau.Grille;
import jeu.plateau.Cellule;

public class PositionBateauController {
	
	final static private int TAILLE_GRILLE_PIXEL = 30;
	
	final static private int COLONNE_MIN = 0 ;
	
	final static private int COLONNE_MAX = 9 ;
	
	final static private int LIGNE_MIN = 0;
	
	final static private int LIGNE_MAX = 9;
	
	private boolean clicActive = false;
	
	private boolean bateauSelectionne = false;
	
    @FXML
    private ImageView porteAvions ;
    
    @FXML
    private GridPane grille ;
    
    @FXML 
    private ImageView croisseur;
    
    @FXML
    private Button retour;
    
    @FXML
    private ImageView torpilleur1;
    
    @FXML
    private ImageView torpilleur2;
    
    @FXML
    private ImageView contreTorpilleur;
    
    @FXML
    private Label labelPorteAvions;
    
    @FXML
    private Label labelCroisseur ;
    
    @FXML
    private Label labelContreTorpilleur;
    
    @FXML
    private Label labelTorpilleur;
    
    boolean porteAvionsPivote = false ;
    boolean croiseurPivote = false ;
    boolean contreTorpilleurPivote = false ;

    boolean torpilleurPivote1 = false ;
    boolean torpilleurPivote2 = false ; 
    
    boolean torpilleur1Place = false ;
    boolean torpilleur2Place = false ;

    
    private ImageView bateauCourant;
    private Grille grilleJoueur = new Grille(creerTableauGrille());

	
    private Cellule[][] creerTableauGrille() {
    	Cellule[][] retour = new Cellule[10][10];
    
    	for (int i = 0; i < retour.length; i++) {
    		for (int j = 0; j < retour.length; j++) {
    			retour[i][j] = new Cellule(i,j);
    		}
    	}
    	
    	return retour;
    }
    
    
    @FXML
    private void personalisePartie() throws IOException {
        Main.activerPersonalisePartie();
    }
    
    @FXML
    private void clicPorteAvions() {
    	if (!clicActive){
			activerClic();
		}
    	bateauSelectionne = true;
		bateauCourant = porteAvions ;
        //System.out.println("clic porte avions");
        //System.out.println(porteAvions);
        //System.out.println(grille);
        porteAvions.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
      	@Override
        public void handle(MouseEvent event) {
        	if (event.getButton() == MouseButton.SECONDARY && !porteAvionsPivote) {
        		porteAvions.setRotate(90);
        		porteAvionsPivote = true ;
        	} else if (event.getButton() == MouseButton.SECONDARY && porteAvionsPivote) {
        		porteAvions.setRotate(0);
        		porteAvionsPivote = false ;
        	} else if (event.getButton() == MouseButton.PRIMARY) {
        		bateauSelectionne = !bateauSelectionne;
        		if (!bateauSelectionne) {
        			labelPorteAvions.setText("0/1");
        		} else {
        			labelPorteAvions.setText("1/1");
        		}
			}
		}
      	
        });
    }

   

	@FXML
	private void clicTorpilleurs() {
		if (!clicActive){
			activerClic();
		}
		bateauSelectionne = true;
		bateauCourant = torpilleur1;
        torpilleur1.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
      	@Override
        public void handle(MouseEvent event) {
        	if (event.getButton() == MouseButton.SECONDARY && !torpilleurPivote1) {
        		torpilleur1.setRotate(90);
        		torpilleurPivote1 = true ;
        	} else if (event.getButton() == MouseButton.SECONDARY && torpilleurPivote1) {
        		torpilleur1.setRotate(0);
        		torpilleurPivote1 = false ;
        	} else if (event.getButton() == MouseButton.PRIMARY) {
        		bateauSelectionne = !bateauSelectionne;
        		if (!bateauSelectionne) {
        			torpilleur1Place = true;
        			affichageTorpilleur();
        		} else {
        			torpilleur1Place = false ;
        			affichageTorpilleur();
        		}
			}
		}
      	
        });
		
	}
        
   
	
	@FXML
	private void clicTorpilleurs2() {
		if (!clicActive){
			activerClic();
		}
		bateauSelectionne = true;
		bateauCourant = torpilleur2;
        torpilleur2.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
      	@Override
        public void handle(MouseEvent event) {
        	if (event.getButton() == MouseButton.SECONDARY && !torpilleurPivote2) {
        		torpilleur2.setRotate(90);
        		torpilleurPivote2 = true ;
        	} else if (event.getButton() == MouseButton.SECONDARY && torpilleurPivote2) {
        		torpilleur2.setRotate(0);
        		torpilleurPivote2 = false ;
        	} else if (event.getButton() == MouseButton.PRIMARY) {
        		bateauSelectionne = !bateauSelectionne;
          		if (!bateauSelectionne) {
        			torpilleur2Place  = true ;
        			affichageTorpilleur();
        		} else {
        			torpilleur2Place = false;
        			affichageTorpilleur();
        		}
			}
		}
      	
        });
        
    }

	@FXML
	private void clicContreTorpilleur() {
		if (!clicActive){
			activerClic();
		}
    	bateauSelectionne = true;
		bateauCourant = contreTorpilleur ;
        contreTorpilleur.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
	      	@Override
	        public void handle(MouseEvent event) {
	        	if (event.getButton() == MouseButton.SECONDARY && !contreTorpilleurPivote) {
	        		contreTorpilleur.setRotate(90);
	        		contreTorpilleurPivote = true ;
	        	} else if (event.getButton() == MouseButton.SECONDARY && contreTorpilleurPivote) {
	        		contreTorpilleur.setRotate(0);
	        		contreTorpilleurPivote = false ;
	        	} else if (event.getButton() == MouseButton.PRIMARY) {
	        		bateauSelectionne = !bateauSelectionne;
	        		if (!bateauSelectionne) {
	        			labelContreTorpilleur.setText("0/1");
	        		}
				}
	      	}
        });
	}
	
	@FXML
	private void clicCroiseur() {
    	if (!clicActive){
			activerClic();
		}
    	bateauSelectionne = true;
		bateauCourant = croisseur ;
        //System.out.println("clic porte avions");
        //System.out.println(porteAvions);
        //System.out.println(grille);
        croisseur.setOnMouseClicked((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
	      	@Override
	        public void handle(MouseEvent event) {
	        	if (event.getButton() == MouseButton.SECONDARY && !croiseurPivote) {
	        		croisseur.setRotate(90);
	        		croiseurPivote = true ;
	        	} else if (event.getButton() == MouseButton.SECONDARY && croiseurPivote) {
	        		croisseur.setRotate(0);
	        		croiseurPivote = false ;
	        	} else if (event.getButton() == MouseButton.PRIMARY) {
	        		bateauSelectionne = !bateauSelectionne;
	        		if (!bateauSelectionne) {
	        			labelCroisseur.setText("0/1");
	        		}
				}
	      	}
        });
	}
	
	@FXML
	private void clicGridPane() {
		
		
	}
	
	
	private void activerClic() {
		clicActive = true;		
		
		for (Node elt : grille.getChildren()) {
			elt.setOnMouseExited((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
	        	@Override
	        	public void handle(MouseEvent event) {
	        		int x = (int) event.getX() / TAILLE_GRILLE_PIXEL;
	        		int y = (int) event.getY() / TAILLE_GRILLE_PIXEL;
	        		System.out.println("("+x+"; "+y+")");
	        			    			
	        		if (COLONNE_MIN<= x && x <= COLONNE_MAX 
	        			&& LIGNE_MIN <= y && y <= LIGNE_MAX
	        			&& bateauSelectionne)  {
						placerBateau(bateauCourant, x, y);
					}
	        	}
	        });
			
			
		}
	}
	
	private void placerBateau(ImageView bateau ,int x, int y) {
		System.out.println(bateau);
		if (grille.getChildren().contains(bateau)) {
			grille.getChildren().remove(bateau);
		}
		switch (bateau.getId()) {
		case "porteAvions":
			if (porteAvionsPivote) {
				x += (int) (x + 75)/30;				
			} else {
				y += (int) (y + 75)/30;
			}
			break;
		case "croiseur":
			if (croiseurPivote) {
				x += (int)(x+15)/30;
				bateau.setTranslateX(75);
			} else {
				bateau.setTranslateY(75);
			}
			break;
		case "contreTorpilleur":
			if (contreTorpilleurPivote) {
				x += (int) (x + 45)/30;				
			} else {
				y += (int) (y + 45)/30;
			}
			break;
		case "torpilleur1":
			if (torpilleurPivote1) {
				x += (int) (x + 15)/30;				
				bateau.setTranslateX(-15);
			} else {
				y += (int) (y + 30)/30;
				bateau.setTranslateY(-15);
			}
			break;
		case "torpilleur2":
			
			if (torpilleurPivote2) {
				System.out.println(torpilleurPivote2);
				//x += (int) (x - 15)/30;
				//y += (int) (y-15)/30;
				if (x == 0 ) {
					bateau.setTranslateY(0);
				}
				
				bateau.setTranslateX(15);
				
			} else {
				y += (int) (y + 30)/30;
				bateau.setTranslateY(-15);
			}
			break;
		default:
			break;
		}
		grille.add(bateau, x, y);
	}
	
	private void affichageTorpilleur() {
		if ((torpilleur1Place &&  !torpilleur2Place)
			 || (!torpilleur1Place && torpilleur2Place)) {
			labelTorpilleur.setText("1/2");
		} else if (torpilleur1Place && torpilleur2Place) {
			labelTorpilleur.setText("0/2");
		} else {
			labelTorpilleur.setText("2/2");	
		}
	}
		
}