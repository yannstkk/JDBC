package portos.data;

import jakarta.persistence.*;
import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

@Entity
public class Projet implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	public Long getId() { return this.id; }

	@Column
	String nom;
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	@ManyToOne
	@JoinColumn(name = "CHEF_DE_PROJET_ID")
	private PM chefDeProjet;
	public PM getChefDeProjet() { return chefDeProjet; }
	public void setChefDeProjet(PM pm) { chefDeProjet = pm; }

	@ManyToMany(mappedBy = "projets")
	private Set<Developpeur> developpeurs = new HashSet<>();
	public Set<Developpeur> getDeveloppeurs() { return developpeurs; }
	public void addDeveloppeur(Developpeur d) { developpeurs.add(d); }




	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Projet)) {
			return false;
		}
		Projet other = (Projet) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
            return "Projet : " + getNom();
	}

}
