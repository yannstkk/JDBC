package agence.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Ville implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Column
    private String nom;
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    @Column
    private String pays;
    public String getPays() {
        return pays;
    }
    public void setPays(String pays) {
        this.pays = pays;
    }

    @OneToMany(mappedBy = "ville")
    private Set<Etape> etapes = new HashSet<>();

    public Set<Etape> getEtapes() {
        return etapes;
    }

    public void setEtapes(Set<Etape> etapes) {
        this.etapes = etapes;
    }
    public void addEtapes(Etape e) {
        this.etapes.add(e);
    }

    public Ville() {
        super();
    }

    @Override
    public String toString() { return "Ville " + getNom() + " " + getPays();

    }
}