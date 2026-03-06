package agence.data;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    protected Long idPersonne;

    public Long getIdPersonne() {
        return idPersonne;
    }
    public void setIdPersonne(Long idPersonne) {
        this.idPersonne = idPersonne;
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
    private String prenom;
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Column
    private String email;
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    @Column
    private String portable;
    public String getPortable() {
        return portable;
    }
    public void setPortable(String portable) {
        this.portable = portable;
    }



    public Personne() { super(); }

    public Personne(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
    }

    @Override
    public int hashCode() {
        return (idPersonne != null ? idPersonne.hashCode() : 0);
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Personne)) return false;
        Personne other = (Personne) object;
        if ((this.idPersonne == null && other.idPersonne != null)
                || (this.idPersonne != null && !this.idPersonne.equals(other.idPersonne)))
            return false;
        return true;
    }

    @Override
    public String toString() { return getNom() + " " + getPrenom(); }
}