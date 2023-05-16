/**
 * testGrille.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.plateau;

import jeu.plateau.Cellule;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

/**
 * //TODO Commenter la responsabilités de la classe testGrille
 * @author quent
 *
 */
class testGrille {
    
    @BeforeEach
    void genererGrileValide() {
        
    }

    /**
     * Test method for {@link jeu.plateau.Grille#Grille(jeu.plateau.Cellule[][])}.
     */
    @Test
    void testGrille() {
		Cellule[][] cadrillage = {
            {new Cellule(0, 0, false, false),new Cellule(0, 1, false, false)},
            {new Cellule(1, 0, false, false),new Cellule(1, 1, false, false)},
            {new Cellule(2, 0, false, false),new Cellule(2, 1, false, false)},
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
