
package CarnetAdresses;

import Outils.Recherche;
import Tri.CompareNom;
import Tri.CompareCp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Carnet {

    private ArrayList<Connaissance> carnet = new ArrayList();

//    static Connaissance c1 = new Connaissance("Legrand", "Florence", "0344452175", "34 avenue du chateau", "94300", "Vincennes", "flep@yahoo.com");
//    static Connaissance c2 = new Connaissance("Dubois", "Andre", "0142545555", null, null, "Paris", "gr@orange.com");
//    static Ami a1 = new Ami("Brisson", "Marie", "017896785", "12 rue des bois", "18000", "Chanteloup", "fr@yahoo.fr", "06125515144");
//    static Ami a2 = new Ami("Nguyen", "Helene", "0145254785", "3 rue des champs", "14000", "Caen", null, null);
//    static Ami a3 = new Ami("Lee", "Jacques", "0145785456", "18 rue des mésanges", "13003", "Marseille", "gm@gmail.com", "0762555255");
//    static Famille f1 = new Famille("Charrier", "Marine", "0457782178", "18 rue du pré", "94300", "Vincennes", "mcha@orange.fr", "0769787810", "14/09/1978");
//    static Famille f2 = new Famille("Charrier", "Jacqueline", "0145678952", "15 avenue de Paris", "14500", "Rouen", "jaaaa@orange.fr", null, null);
//    static Famille f3 = new Famille("Charrier", "George", "0145678952", "9 rue du chateau", "92000", "La Défense", "gcha@orange.fr", "07842748810", "14/05/1942");
    public void AddContact(Connaissance c) {
        carnet.add(c);
        System.out.println(carnet);
    }

    public ArrayList<Connaissance> trierNom() {
        Collections.sort(carnet, new CompareNom());
        return carnet;
    }

    public ArrayList<Connaissance> getCarnet() {
        return carnet;
    }

    public void setCarnet(ArrayList<Connaissance> carnet) {
        this.carnet = carnet;
    }
    
    

    public ArrayList<Connaissance> trierCp() {
        Collections.sort(carnet, new CompareCp());
        return carnet;
    }

    public ArrayList<Connaissance> trierType() {
        Collections.sort(carnet);
        return carnet;
    }

    public void suppContact(Connaissance c) {
        carnet.remove(c);
        System.out.println(c);
    }


    public ArrayList<Connaissance> rechercheFiche(String recherche) {
        ArrayList<Connaissance> rechercheList = new ArrayList();
        System.out.println(carnet.size());
        for (int i = 0; i < carnet.size(); i++) {
            if (carnet.get(i).getNom().equals(recherche.toUpperCase())){
                rechercheList.add(carnet.get(i)) ;
            }
        }
        return rechercheList ;
    }
    
//    public ArrayList<Connaissance> suppression(Connaissance c){
//        carnet.remove(c);
//        return carnet;
//    }

}
