/**
 * TestGrille.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.plateau;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.plateau.Cellule;
import jeu.plateau.Grille;

/**
 * test de la classe Grille
 * @author Costes Quentin
 * @author de Saint Palais François
 *
 */
class TestGrille {

    private ArrayList<Grille> grilleValide;

    @BeforeEach
    void genererGrileValide() {
        grilleValide = new ArrayList<>();
        Cellule[][] cadrillage = {{new Cellule(0, 0),new Cellule(0, 1)},
            					  {new Cellule(1, 0),new Cellule(1, 1)}};
        grilleValide.add(new Grille(cadrillage));
    }

    /**
     * Test method for {@link jeu.plateau.Grille#Grille(jeu.plateau.Cellule[][])}.
     */
    @Test
    void testConstructeurGrilleINvalide() {
        {/* La grille n'est pas carré */
            Cellule[][] cadrillage = {{new Cellule(0, 0),new Cellule(0, 1)},
                                      {new Cellule(1, 0),new Cellule(1, 1)},
                                      {new Cellule(2, 0),new Cellule(2, 1)}};
            assertThrows(IllegalArgumentException.class,()->new Grille(cadrillage));
        }
        {/* La grille n'est pas carré */
            Cellule[][] cadrillage = {
                    {new Cellule(0, 0),new Cellule(0, 1)},
                    {new Cellule(1, 0),new Cellule(1, 1),new Cellule(1, 2)},
                    {new Cellule(2, 0),new Cellule(2, 1)}};
            assertThrows(IllegalArgumentException.class,()->new Grille(cadrillage));
        }
        {/* Il y a un "trou" */
            Cellule[][] cadrillage = {
                    {new Cellule(0, 0),new Cellule(0, 1),new Cellule(0, 2)},
                    {new Cellule(1, 0),null,new Cellule(1, 2)},
                    {new Cellule(2, 0),new Cellule(2, 1),new Cellule(2, 2)}};
            assertThrows(IllegalArgumentException.class,()->new Grille(cadrillage));
        }
        {/* Deux Cellule ont les même coordonnées */
            Cellule[][] cadrillage = {
                    {new Cellule(0, 0),new Cellule(0, 1),new Cellule(0, 2)},
                    {new Cellule(1, 0),new Cellule(1, 2),new Cellule(1, 2)},
                    {new Cellule(2, 0),new Cellule(2, 1),new Cellule(2, 2)}};
            assertThrows(IllegalArgumentException.class,()->new Grille(cadrillage));
        }
    }


    @Test
	void testGetBateau() {
	    boolean[][] attendu = {{false,false},
	                           {false,false}};
	    
	    assertArrayEquals(attendu, grilleValide.get(0).getBateau());
	    
	    attendu[0][0] = true;
	    attendu[1][0] = true;
        grilleValide.get(0).getCellule(0, 0).setEstBateau(true);
        grilleValide.get(0).getCellule(1, 0).setEstBateau(true);
        
        assertArrayEquals(attendu, grilleValide.get(0).getBateau());
    }

	@Test
	void testGetCellule() {
	    assertInstanceOf(Cellule.class, grilleValide.get(0).getCellule(0, 0));
        assertTrue(grilleValide.get(0).getCellule(0,0).getX() == 0
                && grilleValide.get(0).getCellule(0,0).getY() == 0);
        assertTrue(grilleValide.get(0).getCellule(1,0).getX() == 1
                && grilleValide.get(0).getCellule(1,0).getY() == 0);
        assertThrows(IllegalArgumentException.class,
                ()->grilleValide.get(0).getCellule(Integer.MAX_VALUE,Integer.MAX_VALUE));
        assertThrows(IllegalArgumentException.class,
                ()->grilleValide.get(0).getCellule(Integer.MIN_VALUE,Integer.MIN_VALUE));
        assertThrows(IllegalArgumentException.class,
                ()->grilleValide.get(0).getCellule(2,2));
    }

	@Test
	void testGetQuadrillage() {
        Cellule[][] cadrillage = {{new Cellule(0, 0),new Cellule(0, 1)},
                                  {new Cellule(1, 0),new Cellule(1, 1)}};
        assertArrayEquals(cadrillage, grilleValide.get(0).getQuadrillage());
    }

	@Test
    void testGrilleValide() {
        {/* Grille de deux par deux case */
            Cellule[][] cadrillage = {
                    {new Cellule(0, 0),new Cellule(0, 1)},
                    {new Cellule(1, 0),new Cellule(1, 1)}};
            assertDoesNotThrow(()->new Grille(cadrillage));
        }
        {/* Grille d'une case */
            Cellule[][] cadrillage = {{new Cellule(0, 0)}};
            assertDoesNotThrow(()->new Grille(cadrillage));
        }
        {
        	Cellule[][] cadrillage = new Cellule[10][10];
        	for (int i = 0; i < cadrillage.length; i++) {
    			for (int j = 0; j < cadrillage[i].length; j++) {
    				cadrillage[i][j] = new Cellule(i, j);
    			}
    		}
        	assertDoesNotThrow(()->new Grille(cadrillage));
        }
    }
}
