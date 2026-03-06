package agence.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.*;

// à compléter avec les annotations idoines
// la clef primaire, et la représetation
// des associations.

public class Groupe  implements Serializable { 

    private static final long serialVersionUID = 1L;

   private double tarif ;

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }



    private int capacite ;

    public int getCapacite() {
        return capacite;
    }

    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }


    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGroupe != null ? idGroupe.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Groupe)) {
            return false;
        }
        Groupe other = (Groupe) object;
        if ((this.idGroupe == null && other.idGroupe != null) || (this.idGroupe != null && !this.idGroupe.equals(other.idGroupe))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() { return "Groupe " + getIdGroupe() + " " + getCapacite () + " " + getTarif() + " " + guide; }


}
