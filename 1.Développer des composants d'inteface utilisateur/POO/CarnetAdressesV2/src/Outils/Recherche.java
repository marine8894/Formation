package Outils;

import CarnetAdresses.Carnet;
import CarnetAdresses.Connaissance;
import java.util.ArrayList;
import java.util.Scanner;

public class Recherche {

    Scanner sc = new Scanner(System.in);
    
    

    public static String rechercherFicheSupp() {
        String stri = Saisie.saisieChoix("Souhaitez-vous supprimer une fiche ? [O] / [N]\n");
        if (stri.trim().toUpperCase().equals("O")) {
            String choix = Saisie.saisieNom("Quel nom souhaitez-vous supprimer ?");
        } else if (stri.trim().toUpperCase().equals("N")){
            System.out.println("tampis");
        }
        return stri;
        
    }
    
    
    public static String rechercherFicheModif() {
        String stri = Saisie.saisieChoix("Souhaitez-vous modifier une fiche ? [O] / [N]\n");
        if (stri.trim().toUpperCase().equals("O")) {
            String choix = Saisie.saisieNom("Quel nom souhaitez-vous modifier?");
        } else if (stri.trim().toUpperCase().equals("N")){
            System.out.println("tant pis");
        }
        return stri;
    }
}

    



