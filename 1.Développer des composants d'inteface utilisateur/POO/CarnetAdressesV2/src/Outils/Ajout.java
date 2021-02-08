package Outils;

import CarnetAdresses.Ami;
import CarnetAdresses.Connaissance;
import Exception.ExceptionsSaisie;
import CarnetAdresses.Famille;
import java.util.ArrayList;
import java.util.Objects;

public class Ajout {

     public static Connaissance creationFiche(Connaissance c) {
        c = null;
        if (Saisie.saisieChoix("Souhaitez-vous ajouter un nouveau contact ? [O]Oui [N]Non\n").trim().toUpperCase().equals("O")) {
            String str = Saisie.selectType("Quel type de contact souhaitez-vous ajouter ? [1]Connaissance [2]Ami [3]Famille\n");
            if (str.equals("1")) {
                String snom = Saisie.saisieNomNotEmpty("Veuillez saisir un nom :\n");
                String sprenom = Saisie.saisieNomNotEmpty("Veuillez saisir un prenom :\n");
                String stel = null;
                do {
                    try {
                        stel = Saisie.saisieTelNotEmpty2("Veuillez saisir un numéro de téléphone :\n");
                    } catch (ExceptionsSaisie ex) {
                        System.out.println(ex.getMessage());
                    }
                } while (stel == null);
                String sadresse = Saisie.saisieNom("n° et rue du nouveau contact :\n");
                String scp = Saisie.saisieNom("Code postal du nouveau contact :\n");
                String sville = Saisie.saisieNom("Ville du nouveau contact :\n");
                String semail = Saisie.saisieNom("Email du nouveau contact :\n");
                c = new Connaissance(snom, sprenom, stel, sadresse, scp, sville, semail);
                System.out.println(c);
            } else if (str.equals("2")) {
                String snom = Saisie.saisieNomNotEmpty("Veuillez saisir un nom :\n");
                String sprenom = Saisie.saisieNomNotEmpty("Veuillez saisir un prenom :\n");
                String stel = null;
                do {
                    try {
                        stel = Saisie.saisieTelNotEmpty2("Veuillez saisir un numéro de téléphone :\n");
                    } catch (ExceptionsSaisie ex) {
                        System.out.println(ex.getMessage());
                    }
                } while (stel == null);
                String sadresse = Saisie.saisieNom("n° et rue du nouveau contact :\n");
                String scp = Saisie.saisieNom("Code postal du nouveau contact :\n");
                String sville = Saisie.saisieNom("Ville du nouveau contact :\n");
                String semail = Saisie.saisieNom("Email du nouveau contact :\n");
                String smobile = Saisie.saisieNom("n° mobile du nouveau contact :\n");
                c = new Ami(snom, sprenom, stel, sadresse, scp, sville, semail, smobile);
                System.out.println(c);
            } else if (str.equals("3")) {
                String snom = Saisie.saisieNomNotEmpty("Veuillez saisir un nom :\n");
                String sprenom = Saisie.saisieNomNotEmpty("Veuillez saisir un prenom :\n");
                String stel = null;
                do {
                    try {
                        stel = Saisie.saisieTelNotEmpty2("Veuillez saisir un numéro de téléphone :\n");
                    } catch (ExceptionsSaisie ex) {
                        System.out.println(ex.getMessage());
                    }
                } while (stel == null);
                String sadresse = Saisie.saisieNom("n° et rue du nouveau contact :\n");
                String scp = Saisie.saisieNom("Code postal du nouveau contact :\n");
                String sville = Saisie.saisieNom("Ville du nouveau contact :\n");
                String semail = Saisie.saisieNom("Email du nouveau contact :\n");
                String smobile = Saisie.saisieNom("n° mobile du nouveau contact :\n");
                String sdatenaissance = Saisie.saisieNom("Date de naissance du nouveau contact :\n");
                c = new Famille (snom, sprenom, stel, sadresse, scp, sville, semail, smobile, sdatenaissance);
                System.out.println(c);
            }
        }
        return c;

    }

//    public static Connaissance ajoutContact() {
//        if (Saisie.saisieChoix("Souhaitez-vous ajouter un nouveau contact ? [O]Oui [N]Non\n").trim().toUpperCase().equals("O")) {
//            String str = Saisie.selectType("Quel type de contact souhaitez-vous ajouter ? [1]Connaissance [2]Ami [3]Famille\n");
//            for (int i = 0; i < 1; i++) {
//                String snom = Saisie.saisieNomNotEmpty("Veuillez saisir un nom :\n");
//                String sprenom = Saisie.saisieNomNotEmpty("Veuillez saisir un prenom :\n");
//                String stel = null;
//                do {
//                    try {
//                        stel = Saisie.saisieTelNotEmpty2("Veuillez saisir un numéro de téléphone :\n");
//                    } catch (ExceptionsSaisie ex) {
//                        System.out.println(ex.getMessage());
//                    }
//                } while (stel == null);
//                String sadresse = Saisie.saisieNom("n° et rue du nouveau contact :\n");
//                String scp = Saisie.saisieNom("Code postal du nouveau contact :\n");
//                String sville = Saisie.saisieNom("Ville du nouveau contact :\n");
//                String semail = Saisie.saisieNom("Email du nouveau contact :\n");
//                switch (str) {
//                    case "1":
//                        Carnet.getCarnet().add(i, new Connaissance(snom, sprenom, stel, sadresse, scp, sville, semail));
//                        break;
//                    case "2":
//                        String smobile = Saisie.saisieNom("n° mobile du nouveau contact :\n");
//                        Carnet.getCarnet().add(i, new Ami(snom, sprenom, stel, sadresse, scp, sville, semail, smobile));
//                        break;
//                    case "3":
//                        smobile = Saisie.saisieNom("n° mobile du nouveau contact :\n");
//                        String sdatenaissance = Saisie.saisieNom("Date de naissance du nouveau contact :\n");
//                        Carnet.getCarnet().add(i, new Famille(snom, sprenom, stel, sadresse, scp, sville, semail, smobile, sdatenaissance));
//                        break;
//                    default:
//                        System.out.println("Veuillez rentrer 1, 2, ou 3");
//                        break;
//                }
//            }
//            System.out.println(Carnet.getCarnet());
//        }
//        return null;
//    }

}