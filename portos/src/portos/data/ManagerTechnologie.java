package portos.data;

import jakarta.persistence.*;

import portos.jpa.EntitySingleton;

import java.util.List;

public class ManagerTechnologie {

	private EntityManager persistance;
	private TypedQuery<Technologie> qlestechnologies;

	public ManagerTechnologie() {
		this.persistance=EntitySingleton.getManager();
                // modifier le premier paramètre en précisant la bonne requête JPQL
		this.qlestechnologies = this.persistance.createQuery("Requete JPQL", Technologie.class);
                // vous pouvez aussi utiliser à la place une requête nomée 
		// this.qlestechnologies = this.persistance.createNamedQuery("Nom de la requete", Technologie.class);
	}

	public Technologie ajouterTechnologie(String nom) throws AppliException {
		Technologie t = new Technologie();
		t.setNom(nom);
		try {
			persistance.persist(t);
		}catch(Exception ex) {
			throw new AppliException(ex);
		}
		return t;
	}

    public void affecterDeveloppeur(Developpeur d, Technologie t) {
    	// associer le développeur et la technologie
    }
    
    public List<Technologie> lesTechnologies( ) {
    	return this.qlestechnologies.getResultList();
    }
}
