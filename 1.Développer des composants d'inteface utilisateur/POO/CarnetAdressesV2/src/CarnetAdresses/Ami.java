
package CarnetAdresses;

import java.util.Optional;


public class Ami extends Connaissance {

 private String mobile;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
    
    
    public Ami(String nom, String prenom, String telephone, String adresserue, String cp, String ville, String email, String mobile) {
        super(nom, prenom, telephone, adresserue, cp, ville, email);
        this.mobile = mobile;
    }
    
 @Override
    public String getType(){
        return "Ami";
    }

    @Override
    public String toString() {
        super.toString();
        return super.toString() + " - MOBILE : " + Optional.ofNullable(mobile).orElse("");
    }
    
    

    
    
}