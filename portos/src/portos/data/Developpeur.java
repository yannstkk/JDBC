package portos.data;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

public class Developpeur  extends Personne {

    private static final long serialVersionUID = 1L;
	
    String poste;
	    
    public String getPoste() {
        return poste;
    }

    public void setPoste(String poste) {
        this.poste = poste;
    }

	
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Projet)) {
            return false;
        }
        Projet other = (Projet) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Développeur : " + getNom() + " " + getPrenom();
    }

    public Developpeur() {
    	super();
    }
}
