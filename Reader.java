package TP05;

import java.io.*;
import java.nio.file.*;

public class Reader {
    public static void main(String[] args) {
        // Définition du nom du fichier à lire
        final String NOM_FICHIER = "parrot_output.txt";

        // Bloc try-with-resources : permet d'ouvrir plusieurs flux et garantit leur fermeture automatique
        try (
                FileInputStream fis = new FileInputStream(NOM_FICHIER); // Ouverture d'un flux de lecture binaire sur l>
                InputStreamReader isr = new InputStreamReader(fis);     // Conversion du flux binaire en flux de caract>
                BufferedReader br = new BufferedReader(isr)             // Ajout d'un tampon pour lire efficacement lig>
        ) {
            String ligne;
            // Boucle de lecture : lit chaque ligne du fichier jusqu'à atteindre la fin (null)
            while ((ligne = br.readLine()) != null) {
                System.out.println(ligne); // Affiche chaque ligne lue dans la console
            }
        } catch (IOException e) {
            // Gestion des erreurs : si le fichier n'existe pas ou qu'une erreur survient
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }
}
