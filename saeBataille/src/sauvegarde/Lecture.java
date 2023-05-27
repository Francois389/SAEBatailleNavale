/**
 * 
 */
package sauvegarde;

import sauvegarde.Ecriture;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import jeu.partie.Joueur;
import jeu.partie.Partie;
import jeu.plateau.Cellule;
import jeu.plateau.Grille;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileDescriptor;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author de Saint Palais François
 *
 */
public class Lecture {
    
    private static final String DOSSIER_SAUVEGARDE = Ecriture.DOSSIER_SAUVEGARDE;
    
    private static final String CLE = Ecriture.CLE;


    /**
     * @param args
     */
    public static void main(String[] args) {
        
        File input = new File(DOSSIER_SAUVEGARDE + "/FvsQ.json"); // le fichier a lire
        
        try {
            // on analyse le fichier avec la classe adapté
            JsonElement fichier = JsonParser.parseReader(new FileReader(input));
            
            // on récupère le contenu du fichier dans un objet json
            JsonObject tout = fichier.getAsJsonObject();
            
            // on récupère une valeur (ici une liste) avec une clé (ici sommets)
            JsonObject partie = tout.get(CLE).getAsJsonObject();
            System.out.println(tout);

            System.out.println(tout.get(CLE).getAsJsonObject().get("joueur1").getAsJsonObject().get("nom").getAsString());
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
        
        JsonObject tout = lire("FvsQ");
        tout.get(CLE).getAsJsonObject();
        Partie partie = interprete(tout);
        
        System.out.println(partie.getNbTour());
        System.out.println(partie.getJoueur1().getNom());
        System.out.println(partie.getJoueur2().getNom());
        System.out.println(partie.getJoueur2().getNbTouche());
    }
    
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
    
    public static Partie interprete(JsonObject jsonObject) {
        Gson gson = new Gson();

        // Lecture des informations de la partie
        JsonObject partieObj = jsonObject.getAsJsonObject("partie");
        int nbTour = partieObj.get("nbTour").getAsInt();

        // Lecture du joueur 1
        JsonObject joueur1Obj = partieObj.getAsJsonObject("joueur1");
        String nomJoueur1 = joueur1Obj.get("nom").getAsString();
        JsonObject mesBateauxJoueur1Obj = joueur1Obj.getAsJsonObject("mesBateaux");
        Grille mesBateauxJoueur1 = gson.fromJson(mesBateauxJoueur1Obj, Grille.class);
        JsonObject mesTirsJoueur1Obj = joueur1Obj.getAsJsonObject("mesTirs");
        Grille mesTirsJoueur1 = gson.fromJson(mesTirsJoueur1Obj, Grille.class);
        Joueur joueur1 = new Joueur(nomJoueur1, mesBateauxJoueur1, mesTirsJoueur1);

        // Lecture du joueur 2
        JsonObject joueur2Obj = partieObj.getAsJsonObject("joueur2");
        String nomJoueur2 = joueur2Obj.get("nom").getAsString();
        JsonObject mesBateauxJoueur2Obj = joueur2Obj.getAsJsonObject("mesBateaux");
        Grille mesBateauxJoueur2 = gson.fromJson(mesBateauxJoueur2Obj, Grille.class);
        JsonObject mesTirsJoueur2Obj = joueur2Obj.getAsJsonObject("mesTirs");
        Grille mesTirsJoueur2 = gson.fromJson(mesTirsJoueur2Obj, Grille.class);
        Joueur joueur2 = new Joueur(nomJoueur2, mesBateauxJoueur2, mesTirsJoueur2);

        // Création de la partie avec les données récupérées
        return new Partie(joueur1, joueur2, nbTour);
    }





}
