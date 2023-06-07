package application.controller;

import java.io.IOException;

import application.Main;
import application.modele.Modele;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;


public class PositionBateauController {
	
	final static private int TAILLE_GRILLE_PIXEL = 30;
	
	final static private int COLONNE_MIN = 0 ;
	
	final static private int COLONNE_MAX = 9 ;
	
	final static private int LIGNE_MIN = 0;
	
	final static private int LIGNE_MAX = 9;
	
	
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
    
    @FXML
    private Text textJoueur;

    private boolean clicActive = false;
    
    private boolean bateauSelectionne = false;
    
    boolean porteAvionsPivote = false ;
    boolean croiseurPivote = false ;
    boolean contreTorpilleurPivote = false ;
    boolean torpilleurPivote1 = false ;
    boolean torpilleurPivote2 = false ; 
    
    boolean porteAvionsPlace = false ;
    boolean croiseurPlace = false ;
    boolean contreTorpilleurPlace = false ;
    boolean torpilleur1Place = false ;
    boolean torpilleur2Place = false ;

    
    private ImageView bateauCourant;
    int coordoneeAplacerX = 0 ; 
    int coordonneAplacerY = 0 ;
   
	
    @FXML
    void initialize() {
        textJoueur.setText(Modele.getPartieEnCours().getJoueurActuel().getNom());
    }
    
    
    @FXML
    private void personalisePartie() throws IOException {
        Main.activerPersonalisePartie();
    }
    
    
    private void placerBateauSurGrille(int taille, boolean tourne) {
		if (porteAvionsPlace && croiseurPlace
		 && torpilleur1Place && torpilleur2Place
		 && contreTorpilleurPlace) {
			Main a = new Main();
			a.chargementTranstion();
			Main.activerEcranTransition();
			  
	  	} else {
	    	if (tourne) {
	        	for (int i = 0 ; i < taille ; i++) {
	        		Modele.getPartieEnCours().getJoueur1()
	        		.getGrilleBateaux().getCellule(coordoneeAplacerX+i, coordonneAplacerY)
	        		.setEstBateau(true);
	        	}	
	    	} else {
				for (int i = 0; i < taille; i++) {
					Modele.getPartieEnCours().getJoueur1()
		    		.getGrilleBateaux().getCellule(coordoneeAplacerX, coordonneAplacerY+i)
		    		.setEstBateau(true);
				}
	    	}
		}
    }
    
    @FXML
    void valider() {
        //TODO vérifier que tous les bateaux on été placé
    }
    
    @FXML
    private void clicPorteAvions() {
    	if (!clicActive){
			activerClic();
		}
    	bateauSelectionne = true;
		bateauCourant = porteAvions ;
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
	        			placerBateauSurGrille(5, porteAvionsPivote);
	        			porteAvionsPlace = true;
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
					torpilleur1Place = bateauSelectionne;
	        		bateauSelectionne = !bateauSelectionne;
	          		if (!bateauSelectionne) {
						placerBateauSurGrille(2, torpilleurPivote1);
	        			affichageTorpilleur();
	        			
	        		} else {
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
					torpilleur2Place = bateauSelectionne;
	        		bateauSelectionne = !bateauSelectionne;
	          		if (!bateauSelectionne) {
	        			placerBateauSurGrille(2, torpilleurPivote2);
	        			affichageTorpilleur();
	        		} else {
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
						placerBateauSurGrille(3, contreTorpilleurPivote);
						contreTorpilleurPlace = true;
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
						placerBateauSurGrille(4, croiseurPivote);
						croiseurPlace = true;
	        			labelCroisseur.setText("0/1");
	        		}
				}
	      	}
        });
	}
	
	@FXML
	private void clicGridPane() {
		
		
	}
	
	/**
	 * //TODO Commentez la fonction de la méthode
	 */
	private void activerClic() {
		clicActive = true;		
		
		for (Node elt : grille.getChildren()) {
			elt.setOnMouseExited((EventHandler<MouseEvent>) new EventHandler<MouseEvent>() {
	        	@Override
	        	public void handle(MouseEvent event) {
	        		int x = (int) event.getX() / TAILLE_GRILLE_PIXEL;
	        		int y = (int) event.getY() / TAILLE_GRILLE_PIXEL;			
	        		if (COLONNE_MIN<= x && x <= COLONNE_MAX 
	        			&& LIGNE_MIN <= y && y <= LIGNE_MAX
	        			&& bateauSelectionne)  {
						placerBateau(bateauCourant, x, y);
					}
	        	}
	        });
			
			
		}
	}
	
	/**
	 * //TODO Commentez la fonction de la méthode
	 * @param bateau
	 * @param x
	 * @param y
	 */
	private void placerBateau(ImageView bateau ,int x, int y) {
 		if (grille.getChildren().contains(bateau)) {
			grille.getChildren().remove(bateau);
		}
		
		coordoneeAplacerX = x ;
		coordonneAplacerY = y ;				   
		
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
	
	/**
	 * //TODO Commentez la fonction de la méthode
	 */
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