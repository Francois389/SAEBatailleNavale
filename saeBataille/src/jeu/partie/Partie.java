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
    
    /** Indique si la partie à été sauvegarder */
    private boolean estSauvegarder;
    
    
    /**
     * constructeur de la classe Partie
     * @param joueur1
     * @param joueur2
     */
    public Partie(Joueur joueur1, Joueur joueur2) {

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbTour = -2;
        estSauvegarder = false;
    }
    
    /**
     * constructeur de la classe Partie
     * @param joueur1
     * @param joueur2
     */
    public Partie(Joueur joueur1, Joueur joueur2, int nbTour) {

        this.joueur1 = joueur1;
        this.joueur2 = joueur2;
        this.nbTour = nbTour;
        estSauvegarder = false;
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
     * incremente de 1 la valeur du nombre de tours
     */
    public void incrementNbTour() {
		nbTour++;
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
     * retourne le joueur qui joue actuellement en fonction du nombre de tours
     * @return joueur qui joue actuellement
     */
    public Joueur getJoueurActuel() {
        return this.getNbTour() % 2 == 0
        	   ? joueur1
        	   : joueur2;
    }

    /**
     * retourne le joueur qui ne joue pas actuellement 
     * en fonction du nombre de tours
     * @return joueur qui ne joue pas actuellement
     */
    public Joueur getAutreJoueur() {
        return this.getNbTour() % 2 == 0
                ? joueur2
                : joueur1;
    }

    /**
     * @return the estSauvegarder
     */
    public boolean isEstSauvegarder() {
        return estSauvegarder;
    }

    /**
     * @param etat l'état de sauvegarde de la partie
     */
    public void setEstSauvegarder(boolean etat) {
        this.estSauvegarder = etat;
    }

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Partie other = (Partie) obj;
		return joueur1.equals(other.joueur1)
				&& joueur2.equals(other.joueur2) && nbTour == other.nbTour;
	}
    
    
}
