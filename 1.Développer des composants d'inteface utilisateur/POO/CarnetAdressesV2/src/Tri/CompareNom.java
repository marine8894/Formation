/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tri;

import CarnetAdresses.Connaissance;
import java.util.Comparator;

/**
 *
 * @author marinecharrier
 */
public class CompareNom implements Comparator<Connaissance> {
    
    

    @Override
    public int compare(Connaissance o1, Connaissance o2) {
        Connaissance oo1 = (Connaissance) o1;
        Connaissance oo2 = (Connaissance) o2;
        
        return oo1.getNom().compareTo(oo2.getNom());
    }
    
}
    

