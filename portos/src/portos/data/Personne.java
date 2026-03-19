package portos.data;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    public Long getId() { return this.id; }

    @Column
    private String nom;
    public void setNom(String n) { this.nom = n; }
    public String getNom() { return this.nom; }

    @Column
    private String prenom;
    public void setPrenom(String p) { this.prenom = p; }
    public String getPrenom() { return this.prenom; }

    @Column
    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Personne() { }
}
