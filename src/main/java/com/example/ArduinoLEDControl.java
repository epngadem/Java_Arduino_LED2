package com.example;
import java.io.IOException;
import java.util.Scanner;
import com.fazecast.jSerialComm.SerialPort;

public class ArduinoLEDControl {

    public static void main(String[] args) throws InterruptedException, IOException {
        // Étape 1 : Test et ouverture du port COM8
        SerialPort sp = SerialPort.getCommPort("COM8");
        sp.setComPortParameters(9600, 8, 1, 0);
        sp.setComPortTimeouts(SerialPort.TIMEOUT_WRITE_BLOCKING, 0, 0);

        System.out.println("Tentative d'ouverture du port COM8...");
        if (!sp.openPort()) {
            System.out.println("ERREUR : Le port COM8 ne peut pas être ouvert. Assurez-vous qu'il est libre.");
            return;
        }
        System.out.println("Port COM8 ouvert avec succès.");

        // Étape 2 : Gestion des commandes utilisateur
        Scanner input = new Scanner(System.in);

        while (true) {
            System.out.println("\nEntrez '1' pour allumer la LED, '0' pour l'éteindre ou 'q' pour quitter : ");
            String command = input.nextLine(); // Lire la commande de l'utilisateur

            // Quitter si l'utilisateur entre 'q'
            if (command.equalsIgnoreCase("q")) {
                System.out.println("Fermeture du programme...");
                break;
            }

            // Envoyer la commande valide à l'Arduino
            if (command.equals("1") || command.equals("0")) {
                sp.getOutputStream().write(command.getBytes()); // Envoyer la commande
                sp.getOutputStream().flush(); // S'assurer que la commande est envoyée
                System.out.println("Commande envoyée : " + command);
            } else {
                System.out.println("Commande invalide. Veuillez entrer '1', '0' ou 'q'.");
            }
        }

        // Étape 3 : Fermeture des ressources
        input.close();
        sp.closePort();
        System.out.println("Port COM8 fermé proprement.");
    }
}


