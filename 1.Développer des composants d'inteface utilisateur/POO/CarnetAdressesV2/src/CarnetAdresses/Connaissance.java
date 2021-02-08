
package CarnetAdresses;

import java.util.Optional;


public class Connaissance implements Comparable <Connaissance> {

  private String nom;
    private String prenom;
    private String telephone;
    private String adresserue;
    private String cp;
    private String ville;
    private String email;


    public Connaissance(String nom, String prenom, String telephone, String adresserue, String cp, String ville, String email) {
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setTelephone(telephone);
        this.adresserue = adresserue;
        this.cp = cp;
        this.ville = ville;
        this.email = email;
    }

    public String getType() {
        return "Connaissance";
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        if (nom == null) {
            throw new RuntimeException("Le nom doit être spécifié");
        }
        this.nom = nom.toUpperCase();
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        if (prenom == null) {
            throw new RuntimeException("Le prénom doit être spécifié");
        }
        this.prenom = prenom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        if (telephone == null) {
            throw new RuntimeException("Le telephone doit être spécifié");
        }
        this.telephone = telephone;
    }

    public String getAdresserue() {
        return adresserue;
    }

    public void setAdresserue(String adresserue) {
        this.adresserue = adresserue;
    }

    public String getCp() {
        return cp;
    }

    public void setCp(String cp) {
        this.cp = cp;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CONTACT :  " + nom + " " + prenom + " - TEL : " + telephone + " - ADRESSE : " + Optional.ofNullable(adresserue).orElse("") + ", " + Optional.ofNullable(cp).orElse("") + " - " + Optional.ofNullable(ville).orElse("") + " - EMAIL : " + Optional.ofNullable(email).orElse("");
    }

    public int compareTo(Connaissance o) {
        if (this.nom.equals(o.getNom())) {
            return this.prenom.compareTo(o.getPrenom());
        }
        return this.nom.compareTo(o.getNom());
    }
    
    
 
    
}