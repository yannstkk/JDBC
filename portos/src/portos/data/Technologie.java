package portos.data;

import jakarta.persistence.*;
import java.util.Set;
import java.io.Serializable;
import java.util.HashSet;

@Entity
public class Technologie implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	public Long getId() { return this.id; }

	@Column
	String nom;
	public String getNom() { return nom; }
	public void setNom(String nom) { this.nom = nom; }

	@ManyToMany(mappedBy = "technologies")
	private Set<Developpeur> developpeurs = new HashSet<>();
	public Set<Developpeur> getDeveloppeurs() { return developpeurs; }
	public void addDeveloppeur(Developpeur d) { developpeurs.add(d); }








	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof Technologie)) {
			return false;
		}
		Technologie other = (Technologie) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
            return "Technologie : " + getNom();
	}

}
