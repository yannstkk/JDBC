package agence.data;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

// à compléter avec les annotations idoines
// la clef primaire, et la représetation
// des associations.

public class Guide extends Personne {


    private static final long serialVersionUID = 1L;
	
	
    private double salaire;
    
    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }    
       
    public Guide() {
        super();
    }

    @Override
    public String toString() { return "Guide " + getNom () + " " + getPrenom() + getSalaire(); }

}
