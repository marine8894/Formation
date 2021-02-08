
package CarnetAdresses;

import java.util.Optional;


public class Famille extends Ami {

private String datenaissance;

    public String getDatenaissance() {
        return datenaissance;
    }

    public void setDatenaissance(String datenaissance) {
        this.datenaissance = datenaissance;
    }

    
    public Famille(String nom, String prenom, String telephone, String adresserue, String cp, String ville, String email, String mobile, String datenaissance) {
        super(nom, prenom, telephone, adresserue, cp, ville, email, mobile);
        this.datenaissance = datenaissance;
    }

        @Override
    public String toString() {
        super.toString();        
        return super.toString() + " - DATE NAISSANCE : " + Optional.ofNullable(datenaissance).orElse("");
    }
    
    
    @Override
    public String getType(){
        return "Famille";
    }
    


    
}