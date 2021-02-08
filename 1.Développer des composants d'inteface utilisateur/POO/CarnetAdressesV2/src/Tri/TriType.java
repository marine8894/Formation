
package Tri;

import CarnetAdresses.Connaissance;
import Outils.Saisie;
import java.util.ArrayList;
import java.util.Collections;


public class TriType {
    
    public void triType(ArrayList<Connaissance> carnet) {

        
        if (Saisie.saisieChoix("Souhaitez-vous trier par type de fiche ? [O] / [N]\n").trim().toUpperCase().equals("O")) {
            //Rangement par ordre alphabétique en fonction du type
            //affichage du répertoire
            String str = Saisie.selectType("Quel type de fiche souhaitez-vous voir ? [1]Connaissance [2]Ami [3]Famille\n");
            switch (str) {
                case "2":

                    Collections.sort(carnet);
                    for (Connaissance c : carnet) {
                        if (c.getType().equals("Ami")) {
                            System.out.println(c);
                        }
                    }
                    break;
                case "3":
                    Collections.sort(carnet);
                    for (Connaissance c : carnet) {

                        if (c.getType().equals("Famille")) {
                            System.out.println(c);
                        }
                    }
                    break;
                case "1":
                    Collections.sort(carnet);
                    for (Connaissance c : carnet) {
                        if (c.getType().equals("Connaissance")) {
                            System.out.println(c);
                        }
                    }
                    break;
                default:

            }

        }
    }
}
