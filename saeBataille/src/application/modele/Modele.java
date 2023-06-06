/**
 * 
 */
package application.modele;

import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Cellule;
import jeu.plateau.Grille;

/**
 * Stock la partie en cours
 * @author de Saint Palais François
 *
 */
public class Modele {

    private static Partie partieEnCours;
    
    private static Joueur joueurGagnant;
    
    private static boolean partieEstCreer;
    
    public static void creerUneNouvellePartie(String nom1, String nom2) {
        Cellule[][] quadrillage = new Cellule[10][10];
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                quadrillage[i][j] = new Cellule(i,j);
            }
        }
        Joueur joueur1 = new Joueur(nom1, new Grille(quadrillage),new Grille(quadrillage));
        Joueur joueur2 = new Joueur(nom2, new Grille(quadrillage),new Grille(quadrillage));
        Modele.partieEnCours = new Partie(joueur1, joueur2);
        Modele.partieEstCreer = true;
        Modele.joueurGagnant = joueur1;
    }
    
    /**
     * Place les bateau de manière aléatoire
     * Nécessite d'avoir créer une partie avant.
     */
    public static void placerLesBateaux() {
        if (!partieEstCreer) {
            throw new IllegalArgumentException("Erreur : Créer une partie avant"
                                               + " de placer les bateaux");
        }
        //TODO Écrire la méthode
    }

    /**
     * @return the partieCreer
     */
    public static boolean isPartieCreer() {
        return partieEstCreer;
    }

    /**
     * @return the partieEnCours
     */
    public static Partie getPartieEnCours() {
        return Modele.partieEnCours;
    }

    /**
     * @param partieEnCours the partieEnCours to set
     */
    public static void setPartieEnCours(Partie nouvellePartieEnCours) {
        Modele.partieEnCours = nouvellePartieEnCours;
    }

    /** @return the joueurGagnant */
    public static Joueur getJoueurGagnant() {
        return Modele.joueurGagnant;
    }

    /**
     * @param joueurGagnant the joueurGagnant to set
     */
    public static void setJoueurGagnant(Joueur nouveauJoueurGagnant) {
    	
        Modele.joueurGagnant = nouveauJoueurGagnant;
    }
    
    
}
