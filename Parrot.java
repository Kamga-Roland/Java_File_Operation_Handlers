package TP05;

import java.io.*;

public class Parrot
{
    public static void main(String[] args) throws IOException {

        /* Création d'un objet BufferedReader en une seule ligne
           à partir d'un InputStream (System.in).
           Cela permet de lire du texte saisi par l'utilisateur
           depuis la console, ligne par ligne.
         */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        /* Création d'un objet BufferedWriter en une seule ligne
           à partir d'un OutputStreamWriter (System.out).
           Cela permet d'écrire du texte vers la console.
         */
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BufferedWriter fileWriter = new BufferedWriter(new FileWriter("parrot_output.txt", true));

        // Variable qui stockera la chaîne saisie par l'utilisateur
        String input;

        // Boucle infinie : le programme continue tant qu'il n'est pas arrêté
        while (true) {
            // Lecture d'une ligne saisie par l'utilisateur
            input = br.readLine();

            // Utilisation d'un switch pour traiter différents cas
            switch (input.trim()) { // trim() supprime les espaces en début et fin
                case "Done":
                    // Si l'utilisateur tape "Done", on arrête le programme
                    System.out.println("Programme terminé.");
                    br.close(); // Fermeture du flux de lecture
                    bw.close(); // Fermeture du flux d'écriture
                    return;     // Sortie du programme

                case "":
                    // Si l'utilisateur appuie sur Entrée sans rien écrire
                    System.out.println("Veuillez entrer une chaîne non vide :");
                    break;

                default:
                    // Cas général : on affiche la saisie de l'utilisateur
                    bw.write("Vous avez entré: " + input);
                    bw.newLine(); // Ajout d'un retour à la ligne
                    bw.flush();   // Envoi immédiat du contenu vers la console

                    // écriture dans un fichier
                    fileWriter.write(input);
                    fileWriter.newLine();
                    fileWriter.flush();
                    break;
            }
        }
    }
}
