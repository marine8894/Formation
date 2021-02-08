package Application;

import CarnetAdresses.*;
import Exception.ExceptionsSaisie;
import Outils.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Carnet monCarnet = new Carnet();
        //Ajout du contact au répertoire

        //Creation d'un nouveau contact
        Connaissance c = null;
        c = Ajout.creationFiche(c);
        monCarnet.AddContact(c);

        //Ajout d'un 2ème contact au répertoire
        c = Ajout.creationFiche(c);
        monCarnet.AddContact(c);

        //Trier par nom
//        TriNom.triNom(Carnet.getCarnet());
        if (Saisie.saisieChoix("Souhaitez-vous trier par nom (ordre alphabétique) de fiche ? [O] / [N]\n").trim().toUpperCase().equals("O")) {
            monCarnet.trierNom();
        }
        for (Connaissance cc : monCarnet.getCarnet()) {
            System.out.println(cc);
        }

        //Trier par cp
        if (Saisie.saisieChoix("Souhaitez-vous trier par code postal de fiche ? [O] / [N]\n").trim().toUpperCase().equals("O")) {
            monCarnet.trierCp();
        }
        for (Connaissance cc : monCarnet.getCarnet()) {
            System.out.println(cc);
        }

        //Trier par type
        if (Saisie.saisieChoix("Souhaitez-vous voir un type de fiche ? [O] / [N]\n").trim().toUpperCase().equals("O")) {
            //Rangement par ordre alphabétique en fonction du type
            //affichage du répertoire
            String str = Saisie.selectType("Quel type de fiche souhaitez-vous voir ? [1]Connaissance [2]Ami [3]Famille\n");
            String strType = "Connaissance";
            switch (str) {
                case "2":
                    strType = "Ami";
                    break;
                case "3":
                    strType = "Famille";
                    break;
            }
            for (Connaissance cc : monCarnet.getCarnet()) {
                if (c.getType().equals(strType)) {
                    System.out.println(cc);
                }
            }
        }

        //Supprimer contact
        ArrayList<Connaissance> fichesTrouvees = monCarnet.rechercheFiche(Recherche.rechercherFicheSupp());
        Connaissance connaissanceTemporaire = null;
        if (fichesTrouvees.size() == 1) {
            connaissanceTemporaire = fichesTrouvees.get(0);
            monCarnet.getCarnet().remove(connaissanceTemporaire);
        } else if (fichesTrouvees.size() > 1) {
            int i = 0;
            for (Connaissance cc : fichesTrouvees) {
                System.out.println((i++) + ":" + cc);
            }
            int saisie = Saisie.saisieNum("Selectionner le numéro de la fiche : \n");
            i = saisie;
            connaissanceTemporaire = fichesTrouvees.get(i);
            monCarnet.getCarnet().remove(connaissanceTemporaire);
        }
        
        System.out.println(monCarnet.getCarnet());
        
        
        
        //Modifier contact
        ArrayList<Connaissance> fichesTrouveesModif = monCarnet.rechercheFiche(Recherche.rechercherFicheModif());
        Connaissance connaissanceTemporaireModif = null;
        if (fichesTrouveesModif.size() == 1) {
            connaissanceTemporaireModif = fichesTrouveesModif.get(0);
        } else if (fichesTrouvees.size() > 1) {
            int i = 0;
            for (Connaissance cc : fichesTrouveesModif) {
                System.out.println((i++) + ":" + cc);
            }
            int saisie = Saisie.saisieNum("Selectionner le numéro de la fiche : \n");
            i = saisie;
            connaissanceTemporaireModif = fichesTrouveesModif.get(i);
            
        }
        Connaissance cc = connaissanceTemporaireModif;
        System.out.println(monCarnet.getCarnet());
        switch (Saisie.saisieChoixModif("Que souhaitez-vous modifier ? [1]Nom & Prenom  [2]n° de téléphone  [3]Adresse  [4]Email  [5]N° mobile  [6]Date de naissance")){
            case "1":
                    String nnom = Saisie.saisieNomNotEmpty("Veuillez indiquer les nouvelles informations:\nNom :");
                   
                    String nprenom = Saisie.saisieNomNotEmpty("Prénom : ");
                    
                    if (nnom.isEmpty()) {
                        nnom = cc.getNom();
                    } else {
                        cc.setNom(nnom);
                    }
                    if (nprenom.isEmpty()) {
                        nprenom = cc.getPrenom();
                    } else {
                        cc.setPrenom(nprenom);
                    }
                    System.out.println("Information modifiée : " + cc.getNom() + " - " + cc.getPrenom());
                    break;
                case "2":
                    String ntel;
                    try {
                        ntel = Saisie.saisieTelNotEmpty2("Veuillez indiquer le nouveau numéro de téléphone fixe :");
                        if (ntel.isEmpty()) {
                            ntel = cc.getTelephone();
                        } else {
                            cc.setTelephone(ntel);
                        }
                    } catch (ExceptionsSaisie ex) {
                        System.out.println(ex.getMessage());
                    }
                    System.out.println("Information modifiée : " + cc.getNom() + " - " + cc.getPrenom() + " - " + cc.getTelephone());
                    break;
                case "3":
                    
                    String nrue = Saisie.saisieNom("Veuillez indiquer les nouvelles informations:\nn° et rue :");
                    if (nrue.isEmpty()) {
                        nrue = cc.getAdresserue();
                    } else {
                        cc.setAdresserue(nrue);
                    }
                    try {
                        cc.setCp(Saisie.saisieCp("Code Postal :"));
                    } catch (ExceptionsSaisie ex) {
                        System.out.println(ex.getMessage());
                    }
                    
                    String nville = Saisie.saisieNom("Ville : ");
                    if (nville.isEmpty()) {
                        nville = cc.getVille();
                    } else {
                        cc.setVille(nville);
                    }
                    System.out.println("Information modifiée : " + cc.getNom() + " - " + cc.getPrenom() + " - " + cc.getAdresserue() + " " + cc.getCp() + " " + cc.getVille());
                    break;

                case "4":
                    
                    String nemail = Saisie.saisieNom("Veuillez indiquer le nouvel email :");
                    if (nemail.isEmpty()) {
                        nemail = cc.getEmail();
                    } else {
                        cc.setEmail(nemail);
                    }
                    System.out.println("Information modifiée : " + cc.getNom() + " - " + cc.getPrenom() + " - " + cc.getEmail());
                    break;
                case "5":
                    String nmobile = Saisie.saisieNom("Veuillez indiquer le nouveau numéro mobile :");
                    if (cc instanceof Ami) {
                        Ami a = (Ami) cc;
                        if (nmobile.isEmpty()) {
                            nmobile = a.getMobile();
                        } else {
                            a.setMobile(nmobile);
                            System.out.println("Information modifiée : " + cc.getNom() + " - " + cc.getPrenom() + " - " + a.getMobile());
                        }
                    }
                case "6":
                    
                    String ndate = Saisie.saisieNom("Veuillez indiquer la nouvelle date de naissance : ");

                    if (cc instanceof Famille) {
                        Famille f = (Famille) cc;
                        if (ndate.isEmpty()) {
                            ndate = f.getDatenaissance();
                        } else {
                            f.setDatenaissance(ndate);
                        }
                        System.out.println("Information modifiée : " + cc.getNom() + " - " + cc.getPrenom() + " - " + f.getDatenaissance());

                    }
                    System.out.println(monCarnet.getCarnet());
                    break;
            }

            System.out.println(monCarnet.getCarnet());
        }
        
    }

