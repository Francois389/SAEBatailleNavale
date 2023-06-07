/**
 * TestPartie.java                       16 mai 2023
 * IUT de Rodez, pas de copyleft, pas de copyright
 */
package test.jeu.partie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Grille;
import jeu.plateau.Cellule;

/**
 * teste de la classe Partie
 * @author Costes Quentin
 *
 */
class TestPartie {
    
    private ArrayList<Partie> PartiesValide;

    @BeforeEach
    void genrerJeuxTest() {
        PartiesValide = new ArrayList<>();

        {
            Cellule[][] quadrillageBateau = {
                    {new Cellule(0, 0),new Cellule(0, 1)},
                    {new Cellule(1, 0),new Cellule(1, 1)}};
            Cellule[][] quadrillageTir = {
                    {new Cellule(0, 0),new Cellule(0, 1)},
                    {new Cellule(1, 0),new Cellule(1, 1)}};
           
            
            
            PartiesValide.add(new Partie(new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir)),
                                         new Joueur("François",new Grille(quadrillageBateau),new Grille (quadrillageTir))));      
        }
    }

    /**
     * Test method for {@link jeu.partie.Partie#Partie(jeu.partie.Joueur, jeu.partie.Joueur)}.
     */
    @Test
    void testConstructeurPartie() {
        Cellule[][] tabCellule = {{new Cellule(0, 0)}};
        Cellule[][] tabCellule2 = {{new Cellule(0, 0)}};
        assertDoesNotThrow(()->new Partie(new Joueur("Quentin",new Grille(tabCellule),new Grille (tabCellule)),
                                          new Joueur("François",new Grille(tabCellule2),new Grille (tabCellule2))));
    }

    /**
     * Test method for {@link jeu.partie.Partie#getNbTour()}.
     */
    @Test
    void testGetNbTour() {
        Cellule[][] quadrillageBateau = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        
        Joueur j1 = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Françis",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
   
        assertEquals(-2, partie.getNbTour());
        assertNotEquals(14567, partie.getNbTour());
        
        partie.incrementNbTour();
        assertEquals(-1, partie.getNbTour());
        assertNotEquals(0, partie.getNbTour());
    }

    /**
     * Test method for {@link jeu.partie.Partie#setNbTour(int)}.
     */
    @Test
    void testIncrementNbTour() {        
		Partie partie = PartiesValide.get(0);
		assertEquals(-2, partie.getNbTour());
		
		partie.incrementNbTour();
		partie.incrementNbTour();
		partie.incrementNbTour();
		assertEquals(1, partie.getNbTour());
    }

    /**
     * Test method for {@link jeu.partie.Partie#getJoueur1()}.
     */
    @Test
    void testGetJoueur1() {
        Cellule[][] quadrillageBateau = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        
        Joueur j1 = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Françis",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
        
        
        assertEquals(j1, partie.getJoueur1());
        assertNotEquals(j2, partie.getJoueur1());
    }

    /**
     * Test method for {@link jeu.partie.Partie#getJoueur2()}.
     */
    @Test
    void testGetJoueur2() {
        Cellule[][] quadrillageBateau = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        
        Joueur j1 = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Françis",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
        
        
        assertEquals(j2, partie.getJoueur2());
        assertNotEquals(j1, partie.getJoueur2());
    }

    /**
     * Test method for {@link jeu.partie.Partie#getJoueurActuel()}.
     */
    @Test
    void testGetJoueurActuel() {
        Cellule[][] quadrillageBateau = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        
        Joueur j1 = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Françis",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
   
        
        assertEquals(j1, partie.getJoueurActuel());
        assertNotEquals(j2, partie.getJoueurActuel());
        
        partie.incrementNbTour();        
        
        assertEquals(j2, partie.getJoueurActuel());
        assertNotEquals(j1, partie.getJoueurActuel());
    }

    /**
     * Test method for {@link jeu.partie.Partie#getAutreJoueur()}.
     */
    @Test
    void testGetAutreJoueur() {
        Cellule[][] quadrillageBateau = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        
        Joueur j1 = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Françis",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
        
        
        assertEquals(j2, partie.getAutreJoueur());
        assertNotEquals(j1, partie.getAutreJoueur());
        
        partie.incrementNbTour();        
        
        assertEquals(j1, partie.getAutreJoueur());
        assertNotEquals(j2, partie.getAutreJoueur());
    }

}
