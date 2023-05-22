/**
 * TestCellule.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.plateau;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
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
		celluleValide = new ArrayList<Cellule>();
		celluleValide.add(new Cellule(10,10));
        celluleValide.add(new Cellule(0 ,0));
        celluleValide.add(new Cellule(10,0));
        celluleValide.add(new Cellule(0 ,10));
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
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(11  , 0));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(0   , 11));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(0   , 11));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(10  ,-1));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-1  , 10));
    }
    
    @Test
    void testCelluleValide() {
        assertDoesNotThrow(()-> new Cellule(10,10));
        assertDoesNotThrow(()-> new Cellule(0 ,0));
        assertDoesNotThrow(()-> new Cellule(10,0));
        assertDoesNotThrow(()-> new Cellule(0 ,10));
        assertDoesNotThrow(()-> new Cellule(8 ,5));
        assertDoesNotThrow(()-> new Cellule(3 ,4));
        assertDoesNotThrow(()-> new Cellule(8 ,6));
        assertDoesNotThrow(()-> new Cellule(6 ,9));
	}

    /**
     * Test method for {@link jeu.partie.Cellule#isEstBateau()}.
     */
    @Test
    void testIsEstBateau() {
        for (int i = 0; i < celluleValide.size(); i++) {
            assertFalse(celluleValide.get(i).isBateau());
            celluleValide.get(i).setEstBateau(true);
            assertTrue(celluleValide.get(i).isBateau());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#setEstBateau(boolean)}.
     */
    @Test
    void testSetEstBateau() {
        for (int i = 0; i < celluleValide.size(); i++) {
        	celluleValide.get(i).setEstBateau(true);
        	assertTrue(celluleValide.get(i).isBateau());
        	celluleValide.get(i).setEstBateau(false);
        	assertFalse(celluleValide.get(i).isBateau());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#isEstTouche()}.
     */
    @Test
    void testIsEstTouche() {
        for (int i = 0; i < celluleValide.size(); i++) {
        	assertFalse(celluleValide.get(i).isTouche());
        	celluleValide.get(i).setEstTouche(true);
        	assertTrue(celluleValide.get(i).isTouche());
        }        
    }

    /**
     * Test method for {@link jeu.partie.Cellule#setEstTouche(boolean)}.
     */
    @Test
    void testSetEstTouche() {
    	for (int i = 0; i < celluleValide.size(); i++) {
			celluleValide.get(i).setEstTouche(true);
			assertTrue(celluleValide.get(i).isTouche());
			celluleValide.get(i).setEstTouche(false);
			assertFalse(celluleValide.get(i).isTouche());
		}
    }

    /**
     * Test method for {@link jeu.partie.Cellule#getX()}.
     */
    @Test
    void testGetX() {
        int[] xDesCellulesValides = {10, 0 , 10, 0 , 8 , 3 , 8 , 6};
        for (int i = 0; i < celluleValide.size(); i++) {
        	assertEquals(xDesCellulesValides[i],celluleValide.get(i).getX());
        }
    }

    /**
     * Test method for {@link jeu.partie.Cellule#getY()}.
     */
    @Test
    void testGetY() {
    	int[] yDesCellulesValides = {10, 0, 0, 10, 5, 4, 6, 9};
        for (int i = 0; i < celluleValide.size(); i++) {
        	assertEquals(yDesCellulesValides[i],celluleValide.get(i).getY());
        }
    }
    
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

}
