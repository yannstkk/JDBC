package portos.data;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

public class PM extends Personne {

    private static final long serialVersionUID = 1L;

    private int experience;
	
    public int getExperience() {
        return experience;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof PM)) {
            return false;
        }
        PM other = (PM) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Chef de projet : " + getNom() + " " + getPrenom() + " " ;
    }
    
    public PM() {
        super();
    }
}
