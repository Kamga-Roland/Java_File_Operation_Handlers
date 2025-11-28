package TP05;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Programe {
    public static void main(String[] args) {
        final String NOM_FICHIER = "parrot_output.txt";

        try {
            // Lire toutes les lignes du fichier en une seule fois
            List<String> stringList = Files.readAllLines(Paths.get(NOM_FICHIER));

            // Flux pour écrire vers la console et lire l'entrée utilisateur
            try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
                 BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

                writer.write("Quelle ligne souhaitez-vous lire ?");
                writer.newLine();
                writer.flush();

                int input = Integer.parseInt(reader.readLine());

                // Opération de cloture et Vérification des bornes
                while (input != -1) {
                    if (input >= 0 && input < stringList.size()+1) {
                        System.out.println(stringList.get(input-1));
                        input = Integer.parseInt(reader.readLine());
                    } else {
                        System.out.println("Numéro de ligne incorrect");
                        return;
                    }
                }

            } catch (NumberFormatException e) {
                System.err.println("input incorrect");
            }
        } catch (IOException e) {
            System.err.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        } catch (NumberFormatException e) {
            System.err.println("Entrée invalide : veuillez entrer un nombre.");
        }
    }
}
