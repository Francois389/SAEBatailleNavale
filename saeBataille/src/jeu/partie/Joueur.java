/**
 * Joueur.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package jeu.partie;

import jeu.plateau.Grille;
import jeu.plateau.Cellule;

/**
 * //TODO Commenter la responsabilités de la classe Joueur
 * @author Costes Quentin
 * @author de Saint Palais Francois
 * @author Denamiel Clément
 * @author Descriaud Lucas
 *
 */
public class Joueur {
    
    /** Le nombre maximal de caractères autorisé pour le nom du joueur */
    private final static int LONGUEUR_MAX_NOM = 20;

	/** Le nom du joueur */
	private String nom;
	
	/** La grille ou les bateaux sont places */
	private Grille mesBateaux;

	/** La grille des tirs effectues */
	private Grille mesTirs;
	
	
	/**
	 * constructeur des joueurs
	 *
	 * @param nom 
	 * @param mesBateaux
	 * @param mesTirs 
	 * @throws IllegalArgumentException
	 */
	public Joueur(String nom, Grille mesBateaux, Grille mesTirs) {
		
		if (!isValide(nom)) {
			throw new IllegalArgumentException("Erreur : Arguments invalides");
		}
		
		this.nom = nom;
		this.mesBateaux = mesBateaux;
		this.mesTirs = mesTirs;
	}
	
	/**
	 * Vérifie la validité du nom d'un joueur. <br>
	 * Le nom d'un joueur est valide si :
	 * <ul>
	 *     <li>Il n'est pas vide</li>
	 *     <li>Il est composé de maximum 
	 *     {@value jeu.partie.Joueur#LONGUEUR_MAX_NOM} caractères</li>
	 * </ul>
	 */
	private static boolean isValide(String nom) {
		return nom != null && !nom.isBlank() && nom.length() <= LONGUEUR_MAX_NOM;	
	}
	
	/** 
	 * Le joueur à attaqué une Cellule.
	 * <ul>
	 *     <li>Si la Cellule est déjà touché on ne fais rien.</li>
	 *     <li>Si la Cellule n'est pas touché mais que ce n'est pas 
	 *     un bateau, on ne fais rien.</li>
	 *     <li>Si la Cellule n'est pas touché et que c'est un bateau,
	 *      alors on marque qu'elle est touché.</li>
	 * @param cible La Cellule ciblé
	 */
	public void tir(Cellule cible) {
		if (!cible.isTouche() && cible.isBateau()) {
		    cible.setEstTouche(true);
		    //Le joueur est trop fort, gg
		} else {
			cible.setEstTouche(false);
		}
	}
	
	
	/** 
	 * Renvoie le nombre de bateaux ennemis touches par le joueur.
	 */
	public int getNbTouche() {
		
		Cellule[][] tableau = mesTirs.getQuadrillage();
		
		int nbTouche = 0;
		
		for (Cellule[] cells : tableau) {
			for (Cellule cell : cells) {
				if (cell.isTouche()) {
					nbTouche++;
				}
			}
		}
		
		return nbTouche;
	}
	

	/** @return le nom du joueur */
	public String getNom() {
		return nom;
	}
	
	/** @return la grille ou les bateaux sont places */
	public Grille getGrilleBateaux() {
		return mesBateaux;
	}
	
	/** @return la grille des tirs effectues */
	public Grille getGrilleTirs() {
		return mesTirs;
	}

    @Override
    public String toString() {
        return "Joueur [nom=" + nom + ",\n mesBateaux=" + mesBateaux + ",\n mesTirs=" + mesTirs + "]";
    }
	
	
}