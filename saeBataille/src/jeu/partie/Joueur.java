/**
 * Joueur.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package jeu.partie;

import jeu.plateau.Grille;
import jeu.plateau.Cellule;

/**
 * //TODO Commenter la responsabilités de la classe Joueur
 * @author quent
 *
 */
public class Joueur {

	/** le nom du joueur */
	private String nom;
	
	/** la grille ou les bateaux sont places */
	private Grille mesBateaux;

	/** la grille des tirs effectues */
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
			throw new IllegalArgumentException("arguments invalides");
		}
		
		this.nom = nom;
		this.mesBateaux = mesBateaux;
		this.mesTirs = mesTirs;
	}
	
	/**
	 * verifie la validite du nom d'un joueur
	 * - ne doit pas etre vide
	 * - ne doit pas etre trop grand
	 */
	private static boolean isValide(String nom) {
		return 0 < nom.length() && nom.length() <= 20;	
	}
	
	/** 
	 *
	 * @param cible 
	 */
	public void tir(Cellule cible) {
		if (cible.isTouche()) {
			// si la cible est deja une cellule touchee
		} else {
			if (cible.isBateau()) {
				// gg le joueur est trop fort
				cible.setEstTouche(true);
			} else {
				// domage, skill issue
			}
		}
		
	}
	
	
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
		
		return getNbTouche();
	}
	

	/** @return le nom du joueur */
	public String getNom() {
		return nom;
	}
	
	/** @return le nom du joueur */
	public Grille getGrilleBeteaux() {
		return mesBateaux;
	}
	
	/** @return le nom du joueur */
	public Grille getGrilleTirs() {
		return mesTirs;
	}
	
	


}




















