package portos.data;

import jakarta.persistence.*;
import java.io.Serializable;

public class Personne implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    public Long getId() { return this.id; }

    private String nom;
    public void setNom(String n) { this.nom = n; }
    public String getNom() { return this.nom; }

    private String prenom;
    public void setPrenom(String p) { this.prenom = p; }
    public String getPrenom() { return this.prenom; }

    private String email;
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email;}

    public Personne() {  }
}
