/**
 * testCellule.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.plateau;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import jeu.plateau.Cellule;
/**
 * Lancement des tests de Cellule
 * @author quent
 *
 */
class testCellule {

    
    @DisplayName("Test du constructeur de Cellule")
    @Test
    void testCellule() {
        
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-1, 0 , false , false));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(0, -1, true , true));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-1,-1 , false , true));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-100, -1, true , false));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(11, 0 , false , false));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(0, 11 , false , false));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(0, 11, true , true));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(10,-1 , false , true));
        assertThrows(IllegalArgumentException.class , ()-> new Cellule(-1, 10, true , false));
        
        assertDoesNotThrow(()-> new Cellule(10,10,true , false));
        assertDoesNotThrow(()-> new Cellule(0,0,false , true));
        assertDoesNotThrow(()-> new Cellule(10,0,false , false));
        assertDoesNotThrow(()-> new Cellule(0,10,true , true));
        assertDoesNotThrow(()-> new Cellule(8, 5 , true , false));
        assertDoesNotThrow(()-> new Cellule(3 ,4,false , true));
        assertDoesNotThrow(()-> new Cellule(8 ,6,false , false));
        assertDoesNotThrow(()-> new Cellule(6 ,9,true , true));
         
        
    }

    /**
     * Test method for {@link jeu.partie.Cellule#isEstBateau()}.
     */
    @Test
    void testIsEstBateau() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Cellule#setEstBateau(boolean)}.
     */
    @Test
    void testSetEstBateau() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Cellule#isEstTouche()}.
     */
    @Test
    void testIsEstTouche() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Cellule#setEstTouche(boolean)}.
     */
    @Test
    void testSetEstTouche() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Cellule#getX()}.
     */
    @Test
    void testGetX() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Cellule#getY()}.
     */
    @Test
    void testGetY() {
        fail("Not yet implemented");
    }

}
