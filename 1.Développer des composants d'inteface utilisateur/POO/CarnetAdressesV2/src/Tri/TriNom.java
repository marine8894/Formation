
package Tri;

import CarnetAdresses.Connaissance;
import Outils.Saisie;
import java.util.ArrayList;
import java.util.Collections;


public class TriNom {
    
    public void triNom(ArrayList<Connaissance> carnet){

        if (Saisie.saisieChoix("Souhaitez-vous trier par nom (ordre alphabétique) ? [O] / [N]\n").trim().toUpperCase().equals("O")) {
            //Rangement par ordre alphabétique en fonction du Nom de famille (premier champ)
            Collections.sort(carnet, new CompareNom());
            for (Connaissance c : carnet) {
                System.out.println(c);
            }
        }

    }
}
