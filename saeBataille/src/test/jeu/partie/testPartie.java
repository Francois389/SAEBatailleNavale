/**
 * testPartie.java                       16 mai 2023
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
class testPartie {
    
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
            Grille mesBateaux = new Grille(quadrillageBateau);
            Grille mesTirs = new Grille(quadrillageTir);
            
            
            
            PartiesValide.add(new Partie(new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir)),
                                         new Joueur("François",new Grille(quadrillageBateau),new Grille (quadrillageTir))));      
        }
    }

    /**
     * Test method for {@link jeu.partie.Partie#Partie(jeu.partie.Joueur, jeu.partie.Joueur)}.
     */
    @Test
    void testConstructeurPartie() {
        Cellule[][] tabCellule = {{new Cellule(1, 2)}};
        Cellule[][] tabCellule2 = {{new Cellule(1, 2)}};
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
        Grille mesBateaux = new Grille(quadrillageBateau);
        Grille mesTirs = new Grille(quadrillageTir);
        
        Joueur j1 = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Françis",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
   
        assertEquals(0, partie.getNbTour());
        assertNotEquals(14567, partie.getNbTour());
        
        partie.setNbTour(1);
        assertEquals(1, partie.getNbTour());
        assertNotEquals(0, partie.getNbTour());
    }

    /**
     * Test method for {@link jeu.partie.Partie#setNbTour(int)}.
     */
    @Test
    void testSetNbTour() {        
        assertDoesNotThrow(PartiesValide.get(0).setNbTour(4));
        assertDoesNotThrow(PartiesValide.get(0).setNbTour(14));
        assertThrows(IllegalArgumentException.class, PartiesValide.get(0).setNbTour(-2));
        
        // on ne peut pas reculer dans les tours
        PartiesValide.get(0).setNbTour(5);
        assertThrows(IllegalArgumentException.class, PartiesValide.get(0).setNbTour(4));
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
        Grille mesBateaux = new Grille(quadrillageBateau);
        Grille mesTirs = new Grille(quadrillageTir);
        
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
        Grille mesBateaux = new Grille(quadrillageBateau);
        Grille mesTirs = new Grille(quadrillageTir);
        
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
        Grille mesBateaux = new Grille(quadrillageBateau);
        Grille mesTirs = new Grille(quadrillageTir);
        
        Joueur j1 = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur j2 = new Joueur("Françis",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partie = new Partie(j1, j2);
   
        
        assertEquals(j1, partie.getJoueurActuel());
        assertNotEquals(j2, partie.getJoueurActuel());
        
        partie.setNbTour(1);        
        
        assertEquals(j2, partie.getJoueurActuel());
        assertNotEquals(j1, partie.getJoueurActuel());
    }

}
