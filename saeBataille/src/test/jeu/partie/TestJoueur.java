/*
 * TestJoueur.java                                       18 mai 2023
 * IUT de Rodez, pas de copyright, ni "copyleft"
 */

package test.jeu.partie;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.partie.Joueur;
import jeu.plateau.Cellule;
import jeu.plateau.Grille;

/**
 * Test unitaire de Joueur
 * @author de Saint Palais François
 */
public class TestJoueur {
    
    private ArrayList<Joueur> joueurValide;

    @BeforeEach
    void genrerJeuxTest() {
        joueurValide = new ArrayList<>();

        {
            Cellule[][] quadrillageBateau = {
                    {new Cellule(0, 0),new Cellule(0, 1)},
                    {new Cellule(1, 0),new Cellule(1, 1)}};
            Cellule[][] quadrillageTir = {
                    {new Cellule(0, 0),new Cellule(0, 1)},
                    {new Cellule(1, 0),new Cellule(1, 1)}};
            Grille mesBateaux = new Grille(quadrillageBateau);
            Grille mesTirs = new Grille(quadrillageTir);
            
            joueurValide.add(new Joueur("Alice", mesBateaux, mesTirs)); 
            joueurValide.add(new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir)));
            joueurValide.add(new Joueur("François",new Grille(quadrillageBateau),new Grille (quadrillageTir)));
        }
    }

    @Test
    void testConstructeurAvecNomValide() {
        Cellule[][] quadrillageBateau = {{new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {{new Cellule(0, 0),new Cellule(0, 1)},
                     {new Cellule(1, 0),new Cellule(1, 1)}};
        Grille mesBateaux = new Grille(quadrillageBateau);
        Grille mesTirs = new Grille(quadrillageTir);
        
        assertDoesNotThrow(()->new Joueur("Alice", mesBateaux, mesTirs));
        assertDoesNotThrow(()->new Joueur("AlexandreLeGrandVIII", mesBateaux, mesTirs));
    }

    @Test
    void testConstructeurAvecNomInvalide() {
        Cellule[][] quadrillageBateau = {{new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {{new Cellule(0, 0),new Cellule(0, 1)},
                     {new Cellule(1, 0),new Cellule(1, 1)}};
        Grille mesBateaux = new Grille(quadrillageBateau);
        Grille mesTirs = new Grille(quadrillageTir);
        assertThrows(IllegalArgumentException.class, 
                                () -> new Joueur("", mesBateaux, mesTirs));
        assertThrows(IllegalArgumentException.class, 
                () -> new Joueur("TropDeCaractères12345", mesBateaux, mesTirs));
        assertThrows(IllegalArgumentException.class, 
                () -> new Joueur(null, mesBateaux, mesTirs));
    }

    @Test
    void testConstructeurAvecGrillesNonNull() {
        assertNotNull(joueurValide.get(0).getGrilleBateaux());
        assertNotNull(joueurValide.get(0).getGrilleTirs());
    }

    @Test
    void testTirSurCelluleTouchee() {
        Cellule cellule = new Cellule(1,1);
        cellule.setEstTouche(true);

        joueurValide.get(0).tir(cellule);

        // Vérifier que la cellule n'est pas touchée à nouveau
        assertFalse(cellule.isTouche());
    }

    @Test
    void testTirSurCelluleBateau() {
        Cellule cellule = new Cellule(1,1);
        cellule.setEstBateau(true);

        joueurValide.get(0).tir(cellule);

        // Vérifier que la cellule est touchée
        assertTrue(cellule.isTouche());
    }

    @Test
    void testTirSurCelluleVide() {
        Cellule cellule = new Cellule(1,1);

        joueurValide.get(0).tir(cellule);
        System.out.println(joueurValide.get(0).getGrilleTirs().getQuadrillage()[1][1]);
        // Vérifier que la cellule n'est pas touchée
        assertFalse(cellule.isTouche());
    }

    

@Test
    void testGetNbTouche() {    
        {
            joueurValide.get(0).getGrilleTirs().getCellule(0, 0).setEstTouche(true);
            joueurValide.get(0).getGrilleTirs().getCellule(1, 1).setEstTouche(true);
            // Vérifier que le nombre de cellules touchées est correct
            assertEquals(0, joueurValide.get(0).getNbTouche());

            joueurValide.get(0).getGrilleTirs().getCellule(0, 0).setEstBateau(true);
            joueurValide.get(0).getGrilleTirs().getCellule(1, 1).setEstBateau(true);
            assertEquals(2, joueurValide.get(0).getNbTouche());

            joueurValide.get(0).getGrilleTirs().getCellule(0, 0).setEstBateau(true);
            joueurValide.get(0).getGrilleTirs().getCellule(1, 1).setEstBateau(false);
            assertEquals(1, joueurValide.get(0).getNbTouche());
        }
        assertEquals(0, joueurValide.get(1).getNbTouche());
    }

    @Test
    void testGetNom() {
        assertEquals("Alice", joueurValide.get(0).getNom());
        assertNotEquals("Quentin", joueurValide.get(0).getNom());
    }
}