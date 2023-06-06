/**
 * 
 */
package test.sauvegarde;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Cellule;
import jeu.plateau.Grille;
import sauvegarde.Ecriture;

/**
 * @author de Saint Palais François
 *
 */
class TestEcriture {

	/**
	 * Test method for {@link sauvegarde.Ecriture#ecrire(jeu.partie.Partie, java.lang.String)}.
	 */
	@Test
	void testEcrire() {
        
		Cellule[][] quadrillageBateau = {
				{new Cellule(0, 0),new Cellule(0, 1)},
				{new Cellule(1, 0),new Cellule(1, 1)}};
		Cellule[][] quadrillageTir = {
				{new Cellule(0, 0),new Cellule(0, 1)},
				{new Cellule(1, 0),new Cellule(1, 1)}};
		Partie partie = new Partie(new Joueur("Quentin",
				                              new Grille(quadrillageBateau),
				                              new Grille (quadrillageTir)),
				                   new Joueur("François",
				                		      new Grille(quadrillageBateau),
				                		      new Grille (quadrillageTir)));      
		assertDoesNotThrow(()-> Ecriture.ecrire(partie, "ZZZpartieUne"));
	}

}
