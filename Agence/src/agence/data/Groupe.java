package agence.data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.*;

@Entity
public class Groupe implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idGroupe;

    public Long getIdGroupe() { return idGroupe; }
    public void setIdGroupe(Long idGroupe) { this.idGroupe = idGroupe; }

    private double tarif;
    public double getTarif() {
        return tarif;
    }
    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    private int capacite;
    public int getCapacite() {
        return capacite;
    }
    public void setCapacite(int capacite) {
        this.capacite = capacite;
    }

    @ManyToOne
    @JoinColumn(name = "idGuide")
    private Guide guide;

    public Guide getGuide() { return guide; }
    public void setGuide(Guide guide) {
        this.guide = guide;
    }

    @ManyToOne
    @JoinColumn(name = "idCircuit")
    private Circuit circuit;

    public Circuit getCircuit() { return circuit; }
    public void setCircuit(Circuit circuit) { this.circuit = circuit; }

    @ManyToMany
    @JoinTable(
            name = "INSCRIPTION",
            joinColumns = @JoinColumn(name = "idGroupe"),
            inverseJoinColumns = @JoinColumn(name = "idPersonne")
    )
    private Set<Client> lesInscrits = new HashSet<>();

    public Set<Client> getLesInscrits() {
        return lesInscrits;
    }
    public void setLesInscrits(Set<Client> lesInscrits) {
        this.lesInscrits = lesInscrits;
    }
    public void addLesInscrits(Client c) {
        this.lesInscrits.add(c);
    }

    public Groupe() {}

    @Override
    public int hashCode() {

        return (idGroupe != null ? idGroupe.hashCode() : 0);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Groupe)) return false;
        Groupe other = (Groupe) object;
        if ((this.idGroupe == null && other.idGroupe != null)
                || (this.idGroupe != null && !this.idGroupe.equals(other.idGroupe)))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Groupe " + getIdGroupe() + " " + getCapacite() + " " + getTarif() + " " + guide;
    }
}