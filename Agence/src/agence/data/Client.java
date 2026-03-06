package agence.data;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

// à compléter avec les annotations idoines
// la clef primaire, et la représetation
// des associations.

public class Client  {


    private static final long serialVersionUID = 1L;
	
	
    private int anneeNaissance;
    
    public int getAnneeNaissance() {
        return anneeNaissance;
    }

    public void setAnneeNaissance(int anneeNaissance) {
        this.anneeNaissance = anneeNaissance;
    }
	
    public Client() {
        super();
    }

    @Override
    public String toString() { return "Client " + getNom () + " " + getPrenom() + getAnneeNaissance(); }

}
