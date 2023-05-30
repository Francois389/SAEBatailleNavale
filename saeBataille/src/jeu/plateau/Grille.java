/**
 * Grille.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package jeu.plateau;


import java.lang.reflect.Array;
import java.util.Arrays;

import jeu.plateau.Cellule;

/**
 * //TODO Commenter la responsabilités de la classe Grille
 * @author Costes Quentin
 * @author de Saint Palais François
 * @author Denamiel Clément
 * @author Descriaud Lucas
 *
 */
public class Grille {

	private Cellule[][] quadrillage;
	
	public Grille(Cellule[][] argQuadrillage) {
		if (!estValide(argQuadrillage)) {
            throw new IllegalArgumentException("Erreur : Le quadrillage est invalide");
        }
		Cellule[][] temp = new Cellule[argQuadrillage.length][argQuadrillage[0].length];
		for (int i = 0; i < argQuadrillage.length; i++) {
            for (int j = 0; j < argQuadrillage[i].length; j++) {
                temp[i][j] = new Cellule(argQuadrillage[i][j].getX(), argQuadrillage[i][j].getY());
            }
        }
		quadrillage = temp;
	}
	
	/**
	 * Vérifie la validité du quadrillage passé en paramètre.
	 * 
	 * Un quadrillage est valide si :
	 * <ul>
	 *      <li>Il est carré (autant de longueur que de largeur)</li>
	 *      <li>A chaque coordonné il y est une Cellule (pas de trous)</li>
	 *      <li>Il n'existe pas deux Cellule avec les mêmes coordonnée</li>
	 * </ul>
	 * @param argQuadrillage Le quadrillage testé
	 * @return Renvoie true si le quadrillage est valide
	 */
	private static boolean estValide(Cellule[][] argQuadrillage) {
		
		int nbColonnes = argQuadrillage.length;
		boolean[][] cellulesPresentes = new boolean[argQuadrillage.length][argQuadrillage[0].length];
		
		for (int i = 0; i < argQuadrillage.length; i++) {
			/* Le quadrillage est carré */
			if (argQuadrillage[i].length != argQuadrillage.length) {
				return false;
			}
			
			/* A chaque coordonné il y est une Cellule (pas de trous) */
			for (int j = 0; j < argQuadrillage.length; j++) {
                if (argQuadrillage[i][j] == null) {
					return false;
				}
                cellulesPresentes[i][j] = true;
            }
            // TODO Il n'existe pas deux Cellule avec les mêmes coordonnée
			
			
		}

		return true;
	}
	
	/**
	 * Retourne la Cellule aux coordonnée indiqué.
	 * Les coordonnée commence à partir de 0.
	 * @param x La coordonnée en abscisse de la Cellule recherché 
	 * @param y La coordonnée en ordonné de la Cellule recherché
	 * @return La cellule au coordonné précisé 
	 */
	public Cellule getCellule(int x, int y) {
	    if (   x < 0 || quadrillage.length < x 
	        || y < 0 || quadrillage[0].length < y) {
            throw new IllegalArgumentException(String.format("Erreur : %d ou %d invalide", x,y));
        }
		return quadrillage[x][y];
	}
	
	/** @return le quadrillage */
	public Cellule[][] getQuadrillage() {
		return this.quadrillage;
	}
	
	/**
	 * @return Cellule[][] Un tableau de tableau contenant
	 * des boolean true si la cellule a cet indice est un bateau false sinon
	 */
	public boolean[][] getBateau() {
	    boolean[][] bateaux = new boolean[quadrillage.length][quadrillage.length];
	 	for (int i = 0; i < quadrillage.length; i++) {
            for (int j = 0; j < quadrillage.length; j++) {
                bateaux[i][j] = quadrillage[i][j].isBateau();
            }
        }
		return bateaux;
	}
}
