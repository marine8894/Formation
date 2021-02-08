
package Outils;

import Exception.ExceptionsSaisie;
import java.util.Scanner;


public class Saisie {
    
    
    static Scanner sc = new Scanner(System.in);

    static public int saisirNum(){
        return sc.nextInt();
    }
    
    static public int saisieNum(String saisie){
        System.out.println(saisie);
        return saisirNum();
    }
            
            
    static public String saisirNom() {
        return sc.nextLine();
    }

    static public String saisieNom(String saisie) {
        System.out.print(saisie);
        return saisirNom();
    }

    static public String saisieNomNotEmpty(String saisie) {
        do {
            String s = saisieNom(saisie);
            if (s.trim().isEmpty()) {
                System.out.println("Veuillez rééssayer ! ");
            } else {
                return s;
            }
        } while (true);

    }

    static public String saisieChoix(String saisie) {
        do {
            String s = saisieNom(saisie);
            if (s.trim().isEmpty()) {
                System.out.println("Veuillez rééssayer ! Le champ ne peut être vide...");
            } else if (!s.toUpperCase().equals("O") && !s.toUpperCase().equals("N")) {
                System.out.println("Veuillez rééssayer et ne saisir que [O] ou [N] .");
            } else {
                return s;
            }
        } while (true);
    }

    static public String selectType(String saisie) {
        do {
            String s = saisieNom(saisie);
            if (s.trim().isEmpty()) {
                System.out.println("Veuillez rééssayer ! Le champ ne peut être vide...");
            } else if (!s.equals("1") && !s.equals("2") && !s.trim().equals("3")) {
                System.out.println("Veuillez rééssayer et ne saisir que [1], [2] ou [3].");
            } else {
                return s;
            }
        } while (true);
    }
    
       static public String saisieChoixModif(String saisie) {
        do {
            String s = saisieNom(saisie);
            if (s.trim().isEmpty()) {
                System.out.println("Veuillez rééssayer ! Le champ ne peut être vide...");
            } else if (!s.equals("1") && !s.equals("2") && !s.trim().equals("3") && !s.trim().equals("4") && !s.trim().equals("5") && !s.trim().equals("6") ) {
                System.out.println("Veuillez rééssayer et ne saisir que [1], [2], [3], [4], [5] ou [6].");
            } else {
                return s;
            }
        } while (true);
    }

    static public String saisieCp(String saisie) throws ExceptionsSaisie {
        do {
            String s = saisieNom(saisie);
            if (s.trim().isEmpty()) {
                return "";
            }
            if (s.trim().length() == 5) {
                return s;
            }
            System.out.println("Le code postal doit comporter 5 chiffres ");
        } while (true);
    }

    public static String saisieTelNotEmpty2(String saisie) throws ExceptionsSaisie {
        do {
            String s = saisieNom(saisie);
            if (s.trim().isEmpty()) {
                System.out.println("Le numéro de téléphgne ne peut être vide ");
            } else if (s.length() != 10) {
                System.out.println("Le numéro de téléphone doit comporter 10 chiffres ");
            } else {
                try {
                    Integer.parseInt(s);
                    return s;
                } catch (NumberFormatException nfe) {
                    throw new ExceptionsSaisie("Ceci n'est pas au bon format");
                }
            }
        } while (true);
    }

    
}