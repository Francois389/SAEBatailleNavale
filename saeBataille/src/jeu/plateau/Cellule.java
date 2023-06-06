/**
 * Cellule.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package jeu.plateau;

/**
 * Représente une cellule avec une position x et y
 * @author Costes Quentin
 * @author de Saint Palais François
 * @author Denamiel Clement
 * @author Descriaud Lucas
 *
 */
public class Cellule {
    
    /** Coordonnées X d'une cellule */
    private int x;
    
    /** Coordonnées X d'une cellule */
    private int y;
    
    /** Booleen qui verifie si une cellule est une cellule bateau */
    private boolean estBateau;
    
    /** Boollen qui verifie si une case a ete touche par un tir  */
    private boolean estTouche;
    
    private final static int COORDONNES_MAX = 9 ; 
    private final static int CORDONNES_MIN = 0;
    
    /** 
     * 
     * @throws IllegalArgumentException 
     */
    public Cellule(int x, int y) {
        
        if (!estValide(x, y)) {
            throw new IllegalArgumentException("arguments invalides");
        } 
		this.x = x;
        this.y = y;
        estBateau = false;
        estTouche = false;
    }
    
    /** 
     * 
     * @throws IllegalArgumentException 
     */
    public Cellule(int x, int y, boolean tir, boolean bateau) {
        
        if (!estValide(x, y)) {
            throw new IllegalArgumentException("arguments invalides");
        } 
		this.x = x;
        this.y = y;
        estBateau = tir;
        estTouche = bateau;
    }
    
    
    /**
     * Vérifie la validite des coordonnees d'un bateau
     */
    private static boolean estValide(int x, int y) {
        return CORDONNES_MIN <= x && x <= COORDONNES_MAX
        	&& CORDONNES_MIN <= y && y <= COORDONNES_MAX;
    }
    
    /** @return la valeur de estBateau */
    public boolean isBateau() {
        return estBateau;
    }

    /** @return la valeur de estTouche */
    public boolean isTouche() {
        return estTouche;
    }

    /**
     * @param estTouche modifie la valeur de estTouche
     */
    public void setEstTouche(boolean estTouche) {
        this.estTouche = estTouche;
    }

    /**
     * @param estTouche modifie la valeur de estTouche
     */
    public void setEstBateau(boolean estTouche) {
        this.estBateau = estTouche;
    }
    /** @return la valeur de x */
    public int getX() {
        return x;
    }

    /** @return la valeur de y */
    public int getY() {
        return y;
    }
    
    public boolean equals(Object arg) {
        if (arg == null) {
            return false;
        }
        if (!(arg instanceof Cellule)) {
            return false;
        }
        Cellule autre = (Cellule) arg;
        return getY() == autre.getY() && getX() == autre.getX(); 
    }


    @Override
    public String toString() {
        return "Cellule [x=" + x + ", y=" + y + ", estBateau=" + estBateau + ", estTouche=" + estTouche + "]";
    }
	
    
}
