/**
 * Grille.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package jeu.plateau;

import jeu.plateau.Cellule;

/**
 * //TODO Commenter la responsabilités de la classe Grille
 * @author Costes Quentin
 * @author de Saint Palais François
 * @author Denamiel Clement
 * @author Descriaud Lucas
 *
 */
public class Grille {

	private Cellule[][] quadrillage;
	
	public Grille(Cellule[][] argQuadrillage) {
		if (!estValide(argQuadrillage)) {
            throw new IllegalArgumentException("Erreur : Le quadrillage est invalide");
        }
		quadrillage = argQuadrillage;
	}
	
	/**
	 * Vérifie la validité du quadrillage passé en paramétre.
	 * 
	 * Un quadrillage est valide si :
	 * <ul>
	 *      <li>Il est carré (autant de longueur que de largeur)</li>
	 *      <li>A chaque coordonné il y est une Cellule (pas de trous)</li>
	 *      <li>Il n'existe pas deux Cellule avec les mêmes ocordonnée</li>
	 * </ul>
	 * @param argQuadrillage Le quadrillage testé
	 * @return Renvoie true si le quadrillage est valide
	 */
	private boolean estValide(Cellule[][] argQuadrillage) {
		//TODO Ecrire le test
		return true;
	}
	
	/**
	 * @param x La coordonnée en abscisse de la Cellule recherché 
	 * @param y La coordonnée en ordonné de la Cellule recherché
	 * @return La cellule au coordonné précisé 
	 */
	public Cellule getCellule(int x, int y) {
		//TODO Retourner la cellule correpondante
		return null;
	}
	
	/** @return le quadrillage */
	public Cellule[][] getQuadrillage() {
		return this.quadrillage;
	}
	
	/**
	 * @return Cellule[][] Un tableau contenant 
	 * des tableau (représentant un bateau) qui contient 
	 * les cellules composant le bateau
	 */
	public Cellule[][] getBateau() {
		//TODO Retourner le tableau
		return null;
	}
}
