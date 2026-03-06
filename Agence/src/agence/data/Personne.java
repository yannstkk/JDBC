package agence.data;

import java.io.Serializable;
import jakarta.persistence.*;


// à compléter avec les annotations idoines
// la clef primaire, et la représetation
// des associations.


public class Personne  implements Serializable { 

    private static final long serialVersionUID = 1L;


    private String nom ;

    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom;}



    private String prenom ;

    public String getPrenom() { return prenom; }
    public void setPrenom(String prenom) { this.prenom = prenom; }



    private String email ;

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }


    private String portable ;

    public String getPortable() { return portable; }
    public void setPortable(String portable) { this.portable = portable; }



    public Personne() {
        super();
    }


    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }



    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPersonne != null ? idPersonne.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Personne)) {
            return false;
        }
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.idPersonne != null) || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { return getNom () + " " + getPrenom(); }


}
