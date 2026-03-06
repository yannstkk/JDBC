package agence.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

// à compléter avec les annotations idoines
// la clef primaire, et la représetation
// des associations.

public class Ville implements Serializable {


    private static final long serialVersionUID = 1L;
	
		
    private String nom;
    
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    String pays;
	
    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
        
    
    public Ville() {
        super();
    }

    @Override
    public String toString() { return "Ville " + getNom () + " " + getPays(); }

}
