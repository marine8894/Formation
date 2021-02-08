
package Tri;

import CarnetAdresses.Connaissance;
import Outils.Saisie;
import java.util.ArrayList;
import java.util.Collections;


public class TriCp {
    
    public void triCp(ArrayList<Connaissance> carnet) {

        if (Saisie.saisieChoix("Souhaitez-vous trier par code postal ? [O] / [N]\n").trim().toUpperCase().equals("O")) {
            //Rangement par ordre numérique en fonction du code postal
            Collections.sort(carnet, new CompareCp());
            for (Connaissance c : carnet) {
                System.out.println(c);
            }
        }

    }
}
