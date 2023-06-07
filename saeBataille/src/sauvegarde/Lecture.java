/*
 * Ecriture.java                                         26 mai 2023
 * IUT de Rodez, pas de copyright, ni "copyleft"
 */
package sauvegarde;

import java.io.File;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Grille;

/**
 * @author de Saint Palais François
 *
 */
public class Lecture {
    
    /** Chemin du dossier de sauvegarde en partant du project */
    private static final String DOSSIER_SAUVEGARDE = Ecriture.DOSSIER_SAUVEGARDE;
    
    /** Dans le JSON, la Partie sera dans la valeur de cette clé*/
    private static final String CLE = Ecriture.CLE;

    /**
     * Lis le fichier .json a l'adresse indiqué et renvoie un JsonObject
     * @param sauvegarde Le chemin pour la sauvegarde
     * @return
     */
    public static JsonObject lire (String sauvegarde) {
        File input = new File(DOSSIER_SAUVEGARDE + "/"+sauvegarde+".json");
        // on analyse le fichier pour vérifier qu'il n'y a pas de problème
        JsonElement fichier;
        JsonObject tout = null;
        try {
            fichier = JsonParser.parseReader(new FileReader(input));
            tout = fichier.getAsJsonObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return tout;
    }
    
    /**
     * A partir du ObjectJson, construis une Partie avec les données présente 
     * et la renvoie
     * @param jsonObject Le json de la Partie
     * @return La Partie construite
     */
    public static Partie interprete(JsonObject jsonObject) {
        Gson gson = new Gson();

        // Lecture des informations de la partie
        JsonObject partieObj = jsonObject.getAsJsonObject(CLE);
        int nbTour = partieObj.get("nbTour").getAsInt();

        // Lecture du joueur 1
        //On récupère "l'emplacement" des infos
        JsonObject joueur1Obj = partieObj.getAsJsonObject("joueur1");
        JsonObject mesBateauxJoueur1Obj = joueur1Obj.getAsJsonObject("mesBateaux");
        JsonObject mesTirsJoueur1Obj = joueur1Obj.getAsJsonObject("mesTirs");
        //On récupère les infos et on construit le joueur 1
        String nomJoueur1 = joueur1Obj.get("nom").getAsString();
        Grille mesBateauxJoueur1 = gson.fromJson(mesBateauxJoueur1Obj, Grille.class);
        Grille mesTirsJoueur1 = gson.fromJson(mesTirsJoueur1Obj, Grille.class);
        Joueur joueur1 = new Joueur(nomJoueur1, mesBateauxJoueur1, mesTirsJoueur1);

        // Lecture du joueur 2
        //On récupère "l'emplacement" des infos
        JsonObject joueur2Obj = partieObj.getAsJsonObject("joueur2");
        JsonObject mesBateauxJoueur2Obj = joueur2Obj.getAsJsonObject("mesBateaux");
        JsonObject mesTirsJoueur2Obj = joueur2Obj.getAsJsonObject("mesTirs");
        //On récupère les infos et on construit le joueur 2
        String nomJoueur2 = joueur2Obj.get("nom").getAsString();
        Grille mesBateauxJoueur2 = gson.fromJson(mesBateauxJoueur2Obj, Grille.class);
        Grille mesTirsJoueur2 = gson.fromJson(mesTirsJoueur2Obj, Grille.class);
        Joueur joueur2 = new Joueur(nomJoueur2, mesBateauxJoueur2, mesTirsJoueur2);

        
        // Création de la partie avec les données récupérées
        return new Partie(joueur1, joueur2, nbTour);
    }





}
