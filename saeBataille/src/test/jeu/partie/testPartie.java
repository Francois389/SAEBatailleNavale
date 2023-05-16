/**
 * testPartie.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.partie;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import jeu.partie.Joueur;
import jeu.partie.Partie;

/**
 * teste de la classe Partie
 * @author quent
 *
 */
class testPartie {

    /**
     * Test method for {@link jeu.partie.Partie#Partie(jeu.partie.Joueur, jeu.partie.Joueur)}.
     */
    @Test
    void testPartie() {
        assertDoesNotThrow(()->new Partie(new Joueur("quentin", new Grille({{new Cellule(1, 2, false, false)}}))));
    }

    /**
     * Test method for {@link jeu.partie.Partie#getNbTour()}.
     */
    @Test
    void testGetNbTour() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Partie#setNbTour(int)}.
     */
    @Test
    void testSetNbTour() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Partie#getJoueur1()}.
     */
    @Test
    void testGetJoueur1() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Partie#getJoueur2()}.
     */
    @Test
    void testGetJoueur2() {
        fail("Not yet implemented");
    }

    /**
     * Test method for {@link jeu.partie.Partie#getJoueurActuel()}.
     */
    @Test
    void testGetJoueurActuel() {
        fail("Not yet implemented");
    }

}
