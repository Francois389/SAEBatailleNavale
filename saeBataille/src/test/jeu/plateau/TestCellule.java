/**
 * TestCellule.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.plateau;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import jeu.plateau.Cellule;
/**
 * Tests unitaire de la classe Cellule
 * @author Costes Quentin
 * @author de Saint Palais François
 *
 */
class TestCellule {

	private ArrayList<Cellule> celluleValide;

	@BeforeEach
	void genererJeuTest() {
		celluleValide = new ArrayList<>();
		celluleValide.add(new Cellule(9,9));
        celluleValide.add(new Cellule(0 ,0));
        celluleValide.add(new Cellule(9,0));
        celluleValide.add(new Cellule(0 ,9));
        celluleValide.add(new Cellule(8 ,5));
        celluleValide.add(new Cellule(3 ,4));
        celluleValide.add(new Cellule(8 ,6));
        celluleValide.add(new Cellule(6 ,9));
	}

    @Test
    @DisplayName("Test du constructeur de Cellule INvalide")
    void testCelluleInvalide() {

        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-1  , 0));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(0   , -1));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-1  , -1));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-100, -1));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(10  , 0));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(0   , 10));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(9  ,-1));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-1  , 9));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(Integer.MAX_VALUE  , 9));
    }

    /**
     * Test method for {@link jeu.partie.Cellule#Cellule}.
     */
    @Test
    void testCelluleValide() {
    	for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				final int I = i;
				final int J = j;
				assertDoesNotThrow(()-> new Cellule(I,J));
			}
		}
	}

    /**
     * Méthode de test pour {@link Cellule.equals}
     */
    @Test
    void testEquals() {
    	for (int i = 0; i < celluleValide.size(); i++) {
    		assertNotEquals(null, celluleValide.get(i));
    		assertNotEquals(celluleValide.get(i),null);
    		
    		String chaine = "Cellule";
    		assertNotEquals(chaine, celluleValide.get(i));
    		assertNotEquals(celluleValide.get(i),chaine);
    		
    		Cellule laMeme = new Cellule(celluleValide.get(i).getX(),celluleValide.get(i).getY());
			assertEquals(laMeme, celluleValide.get(i));
			
			for (int j = 0; j < celluleValide.size(); j++) {
				if (i != j) {
					assertNotEquals(celluleValide.get(j), celluleValide.get(i));
				}
			}
		}
    }

    /**
     * Test method for {@link jeu.partie.Cellule#getX()}.
     */
    @Test
    void testGetX() {
        int[] xDesCellulesValides = {9, 0 , 9, 0 , 8 , 3 , 8 , 6};
        for (int i = 0; i < celluleValide.size(); i++) {
        	assertEquals(xDesCellulesValides[i],celluleValide.get(i).getX());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#getY()}.
     */
    @Test
    void testGetY() {
    	int[] yDesCellulesValides = {9, 0, 0, 9, 5, 4, 6, 9};
        for (int i = 0; i < celluleValide.size(); i++) {
        	assertEquals(yDesCellulesValides[i],celluleValide.get(i).getY());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#isEstBateau()}.
     */
    @Test
    void testIsEstBateau() {
        for (Cellule element : celluleValide) {
            assertFalse(element.isBateau());
            element.setEstBateau(true);
            assertTrue(element.isBateau());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#isEstTouche()}.
     */
    @Test
    void testIsEstTouche() {
        for (Cellule element : celluleValide) {
        	assertFalse(element.isTouche());
        	element.setEstTouche(true);
        	assertTrue(element.isTouche());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#setEstBateau(boolean)}.
     */
    @Test
    void testSetEstBateau() {
        for (Cellule element : celluleValide) {
        	element.setEstBateau(true);
        	assertTrue(element.isBateau());
        	element.setEstBateau(false);
        	assertFalse(element.isBateau());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#setEstTouche(boolean)}.
     */
    @Test
    void testSetEstTouche() {
    	for (Cellule element : celluleValide) {
			element.setEstTouche(true);
			assertTrue(element.isTouche());
			element.setEstTouche(false);
			assertFalse(element.isTouche());
		}
    }

}
