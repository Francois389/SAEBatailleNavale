/*
 * Ecriture.java                                         26 mai 2023
 * IUT de Rodez, pas de copyright, ni "copyleft"
 */

package sauvegarde;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Cellule;
import jeu.plateau.Grille;

/**
 * Permet la lecture d'un fichier json et son interprétation
 * @author de Saint Palais François
 */
public class Ecriture {

    /** Chemin du dossier de sauvegarde en partant du project */
    protected static final String DOSSIER_SAUVEGARDE = "sauvegardes";
    
    /** Dans le JSON, la Partie sera dans la valeur de cette clé*/
    protected static final String CLE = "partie";

    
    public static void main(String[] args) {
        
        Cellule[][] quadrillageBateau = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Cellule[][] quadrillageTir = {
                {new Cellule(0, 0),new Cellule(0, 1)},
                {new Cellule(1, 0),new Cellule(1, 1)}};
        Joueur francois = new Joueur("François",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Joueur quentin = new Joueur("Quentin",new Grille(quadrillageBateau),new Grille (quadrillageTir));
        Partie partieTest = new Partie(francois,quentin);
        
        ecrire(partieTest, "FvsQ");
    }

    
    
    /**
     * Créer un fichier json pour sauvegarder la partie.
     * Les sauvegardes ce trouvent dans le dossier sauvegardes 
     * @param partieASauvegarde La partie a sauvegarder
     * @param nomPartie Le nom de la partie sauvegardé
     */
    public static void ecrire(Partie partieASauvegarde, String nomPartie) {
        String chemin = DOSSIER_SAUVEGARDE + "/" + nomPartie + ".json";
        creationFichier(chemin);
        JsonObject partieJson = conversionEnJson(partieASauvegarde);
        
        //On crée un objet qui est chargé d'écrire dans un fichier
        Gson ecrivain = new GsonBuilder().setPrettyPrinting().create();
        try {
            //On récupère le fichier finale
            Writer fichier = new FileWriter(chemin);
            //On écrit le fichier
            ecrivain.toJson(partieJson, fichier);
            fichier.flush();
            fichier.close();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        partieASauvegarde.setEstSauvegarder(true);
    }
    
    /**
     * Créer un fichier au chemin indiqué
     * @param chemin Complet du futur fichier ex:"c:/dossier/fichier.json"
     */
    private static void creationFichier(String chemin) {
        try {
            File f = new File(chemin);
            if (f.createNewFile()) {
            } else {
                System.out.println("Le fichier existe déjà");
            }
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    /**
     * Transforme une partie en objetJson
     * @param partieASauvegarde
     * @return
     */
    private static JsonObject conversionEnJson(Partie partieASauvegarde) {
        //Conversion en "liste" JSON
        JsonObject partie = new Gson().toJsonTree(partieASauvegarde).getAsJsonObject();
        //Création d'un objet JSON
        JsonObject partieJson = new JsonObject();
        //On ajoute la liste dans l'objet avec la clé "partie"
        partieJson.add(CLE, partie);
        return partieJson;
    }

}
