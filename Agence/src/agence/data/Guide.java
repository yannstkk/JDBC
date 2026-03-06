package agence.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Guide extends Personne {

    private static final long serialVersionUID = 1L;

    private double salaire;

    public double getSalaire() {
        return salaire; }
    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }


    @OneToMany(mappedBy = "guide")
    private List<Groupe> groupesGeres = new ArrayList<Groupe>();



    public List<Groupe> getGroupesGeres() {
        return groupesGeres;
    }
    public void setGroupesGeres(List<Groupe> groupesGeres) {
        this.groupesGeres = groupesGeres;
    }
    public void addGroupesGeres(Groupe g) {
        this.groupesGeres.add(g);
    }



    public Guide() { super(); }

    @Override
    public String toString() { return "Guide " + getNom() + " " + getPrenom() + " " + getSalaire(); }
}