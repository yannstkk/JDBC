package agence.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

// à compléter avec les annotations idoines
// la clef primaire, et la représetation
// des associations.

public class Circuit  implements Serializable { 

    private static final long serialVersionUID = 1L;



    private String titre ;

    public String getTitre() {
        return titre;
    }
    public void setTitre(String titre) {
        this.titre = titre;
    }



    private int duree ;

    public int getDuree() {
        return duree;
    }
    public void setDuree(int duree) {
        this.duree = duree;
    }



    public Circuit() {
        super();
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCircuit != null ? idCircuit.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Circuit)) {
            return false;
        }
        Circuit other = (Circuit) object;
        if ((this.idCircuit == null && other.idCircuit != null) || (this.idCircuit != null && !this.idCircuit.equals(other.idCircuit))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { return "Circuit " + getTitre () + " " + getDuree(); }


}
