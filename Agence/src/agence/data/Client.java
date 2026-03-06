package agence.data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Client extends Personne {

    private static final long serialVersionUID = 1L;

    private int anneeNaissance;

    public int getAnneeNaissance() { return anneeNaissance; }
    public void setAnneeNaissance(int anneeNaissance) { this.anneeNaissance = anneeNaissance; }

    @ManyToMany(mappedBy = "lesInscrits")
    private List<Groupe> lesVoyages = new ArrayList<Groupe>();

    public List<Groupe> getLesVoyages() {
        return lesVoyages;
    }
    public void setLesVoyages(List<Groupe> lesVoyages) {
        this.lesVoyages = lesVoyages;
    }
    public void addLesVoyages(Groupe g) {
        this.lesVoyages.add(g);
    }

    public Client() { super(); }

    @Override
    public String toString() { return "Client " + getNom() + " " + getPrenom() + " " + getAnneeNaissance(); }
}