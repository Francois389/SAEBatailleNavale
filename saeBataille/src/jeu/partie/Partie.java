/**
 * Partie.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package jeu.partie;

/**
 * stockage d'unne partie de bataille navale
 * @author Costes Quentin
 *
 */
public class Partie {
    
    /** joueur numéro 1 */
    private Joueur joueur1;
    
    /** joueur numéro 2 */
    private Joueur joueur2;
    
    /** nombre de tours */
    private int nbTour;
    
    
    /**
     * constructeur de la classe Partie
     * @param joueur1
     * @param joueur2
     */
    public Partie(Joueur joueur1, Joueur joueur2) {

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbTour = 0;
    }

    /**
     * getter du nombre de tours
     * @return la valeur de nbTour
     */
    public int getNbTour() {
        return nbTour;
    }

    /**
     * setter du nombre de tours
     * @param nbTour modifie la valeur de nbTour
     */
    public void setNbTour(int nbTour) {
        this.nbTour = nbTour;
    }

    /**
     * getter du joueur 1
     * @return la valeur de joueur1
     */
    public Joueur getJoueur1() {
        return joueur1;
    }

    /**
     * getter du joueur 2
     * @return la valeur de joueur2
     */
    public Joueur getJoueur2() {
        return joueur2;
    }
    
    /**
     * retourn le joueur qui joue actuellement en fonction du nombre de tours
     * @return 
     */
    public int getJoueurActuel() {
        return this.getNbTour() % 2;
    }
    
    

}
