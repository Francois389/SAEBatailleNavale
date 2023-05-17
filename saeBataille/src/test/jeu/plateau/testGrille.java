/**
 * testGrille.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.plateau;

import jeu.plateau.Cellule;
import jeu.plateau.Grille;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * test de la classe Grille
 * @author quent
 *
 */
class testGrille {
    
    private ArrayList<Grille> grilleValide;
    
    @BeforeEach
    void genererGrileValide() {
        grilleValide = new ArrayList<Grille>();
        Cellule[][] cadrillage = {{new Cellule(0, 0),new Cellule(0, 1)},
            					  {new Cellule(1, 0),new Cellule(1, 1)},
                                  {new Cellule(2, 0),new Cellule(2, 1)},};
        grilleValide.add(new Grille(cadrillage));
    }

    /**
     * Test method for {@link jeu.plateau.Grille#Grille(jeu.plateau.Cellule[][])}.
     */
    @Test
    void testConstructeurGrille() {
		Cellule[][] cadrillage = {
            {new Cellule(0, 0),new Cellule(0, 1)},
            {new Cellule(1, 0),new Cellule(1, 1)},
            {new Cellule(2, 0),new Cellule(2, 1)},
        };
        
        assertDoesNotThrow(()-> new Grille(cadrillage));
    }

	@Test
	void testGetCellule() {
        
    }
	
	@Test
	void testGetBateau() {
        
    }
	
	@Test
	void testGetQuadrillage() {
        
    }
}
