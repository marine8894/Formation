
package Tri;

import CarnetAdresses.Connaissance;
import java.util.Comparator;


public class CompareCp implements Comparator<Connaissance> {

    @Override
    public int compare(Connaissance c1, Connaissance c2) {
        Connaissance cc1 = (Connaissance) c1;
        Connaissance cc2 = (Connaissance) c2;
        if (cc1.getCp() == null){
             cc1.setCp("");
        }
        return cc1.getCp().compareTo(cc2.getCp());

        
            
    }
}
