/**
 * Joueur.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package jeu.partie;

import jeu.plateau.Grille;

import java.util.Objects;

import jeu.plateau.Cellule;

/**
 * Represente un joueur avec ses grilles et son nom
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
	 * La cellule cible est touche
	 * @param cible La Cellule ciblé
	 */
	public void tir(Cellule cible) {
		cible.setEstTouche(true);
		
	}
	
	
	/** 
	 * @return le nombre de bateaux ennemis touches par le joueur.
	 */
	public int getNbTouche() {
		
		Cellule[][] tableau = mesTirs.getQuadrillage();
		
		int nbTouche = 0;
		
		for (Cellule[] cells : tableau) {
			for (Cellule cell : cells) {
				if (cell.isTouche() && cell.isBateau()) {
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
	
	/** @return nombre de tirs ratés */
	public int getTirRatés() {
	    
	    Cellule[][] tableau = mesTirs.getQuadrillage();
        
        int nbRatés = 0;
        
        for (Cellule[] cells : tableau) {
            for (Cellule cell : cells) {
                if (cell.isTouche() && !cell.isBateau()) {
                    nbRatés++;
                }
            }
        }
        
        return nbRatés;
	    
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(mesBateaux, mesTirs, nom);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Joueur other = (Joueur) obj;
		return Objects.equals(mesBateaux, other.mesBateaux) && Objects.equals(mesTirs, other.mesTirs)
				&& Objects.equals(nom, other.nom);
	}
}




















