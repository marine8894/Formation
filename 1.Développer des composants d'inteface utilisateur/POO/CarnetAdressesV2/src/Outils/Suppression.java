
package Outils;

import CarnetAdresses.Carnet;
import CarnetAdresses.Connaissance;

public class Suppression {
    
    public static void suppressionFiche (){
        Carnet monCarnet = new Carnet();
        monCarnet.rechercheFiche(Recherche.rechercherFicheSupp());
        System.out.println("bonjour");
//        if (monCarnet.rechercheFiche(Recherche.rechercherFicheSupp()).size()){
//            
//        }
    }
    
}
