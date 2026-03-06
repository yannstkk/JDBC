package agence.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;
import java.util.List;


@Entity
public class Circuit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idCircuit;

    public Long getIdCircuit() { return idCircuit; }
    public void setIdCircuit(Long idCircuit) { this.idCircuit = idCircuit; }

    @Column
    private String titre;
    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    @Column
    private int duree;
    public int getDuree() { return duree; }
    public void setDuree(int duree) { this.duree = duree; }



    @OneToMany(mappedBy = "circuit", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Etape> lesEtapes = new ArrayList<Etape>();


    public List<Etape> getLesEtapes() {
        return lesEtapes;
    }
    public void setLesEtapes(List<Etape> lesEtapes) {
        this.lesEtapes = lesEtapes;
    }



    public void addLesEtapes(Etape e) {
        this.lesEtapes.add(e);
    }
    public void removeLesEtapes(Etape e) {
        this.lesEtapes.remove(e);
    }

    @OneToMany(mappedBy = "circuit")
    private List<Groupe> lesGroupes = new ArrayList<Groupe>();

    public List<Groupe> getLesGroupes() { return lesGroupes; }
    public void setLesGroupes(List<Groupe> lesGroupes) {
        this.lesGroupes = lesGroupes;
    }
    public void addLesGroupes(Groupe g) {
        this.lesGroupes.add(g);
    }

    public Circuit() { super(); }

    @Override
    public int hashCode() {
        return (idCircuit != null ? idCircuit.hashCode() : 0);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Circuit)) return false;
        Circuit other = (Circuit) object;
        if ((this.idCircuit == null && other.idCircuit != null)
                || (this.idCircuit != null && !this.idCircuit.equals(other.idCircuit)))
            return false;
        return true;
    }

    @Override
    public String toString() { return "Circuit " + getTitre() + " " + getDuree(); }
}