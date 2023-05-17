package test.jeu.partie;

import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jeu.partie.Joueur;
import jeu.plateau.Grille;
import jeu.plateau.Cellule;

public class testJoueur {

    private Joueur joueur;
    private Grille mesBateaux;
    private Grille mesTirs;

    @BeforeEach
    public void setUp() {
        // Initialiser les objets nécessaires pour les tests
        mesBateaux = new Grille(null);
        mesTirs = new Grille(null);
        joueur = new Joueur("Alice", mesBateaux, mesTirs);
    }

    @Test
    public void testConstructeurAvecNomValide() {
        Assertions.assertEquals("Alice", joueur.getNom());
    }

    @Test
    public void testConstructeurAvecNomInvalide() {
        Assertions.assertThrows(IllegalArgumentException.class, 
                                () -> new Joueur("", mesBateaux, mesTirs));
    }

    @Test
    public void testConstructeurAvecGrillesNonNull() {
        Assertions.assertNotNull(joueur.getGrilleBateaux());
        Assertions.assertNotNull(joueur.getGrilleTirs());
    }

    @Test
    public void testTirSurCelluleTouchee() {
        Cellule cellule = new Cellule(1,1);
        cellule.setEstTouche(true);

        joueur.tir(cellule);

        // Vérifier que la cellule n'est pas touchée à nouveau
        Assertions.assertFalse(cellule.isTouche());
    }

    @Test
    public void testTirSurCelluleBateau() {
        Cellule cellule = new Cellule(1,1);
        cellule.setEstBateau(true);

        joueur.tir(cellule);

        // Vérifier que la cellule est touchée
        Assertions.assertTrue(cellule.isTouche());
    }

    @Test
    public void testTirSurCelluleVide() {
        Cellule cellule = new Cellule(1,1);

        joueur.tir(cellule);

        // Vérifier que la cellule n'est pas touchée
        Assertions.assertFalse(cellule.isTouche());
    }

    

@Test
    public void testGetNbTouche() {
        // Préparer la grille de tirs avec des cellules touchées
        mesTirs.getQuadrillage()[0][0].setEstTouche(true);
        mesTirs.getQuadrillage()[1][1].setEstTouche(true);

        int nbTouche = joueur.getNbTouche();

        // Vérifier que le nombre de cellules touchées est correct
        Assertions.assertEquals(2, nbTouche);
    }
}