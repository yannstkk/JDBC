package portos.data;

import jakarta.persistence.*;

import portos.jpa.EntitySingleton;

import java.util.List;

public class ManagerProjet {

	private EntityManager persistance;
	private TypedQuery<Projet> qlesprojets;

	public ManagerProjet() {
		this.persistance=EntitySingleton.getManager();
                // modifier le premier paramètre en précisant la bonne requête JPQL
		this.qlesprojets = this.persistance.createQuery("SELECT p FROM Projet p", Projet.class);
                // vous pouvez aussi utiliser à la place une requête nomée 
		// this.qlesprojets = this.persistance.createNamedQuery("Nom de la requête", Projet.class);
	}

	public Projet ajouterProjet(String nom) throws AppliException {
		Projet p = new Projet();
		p.setChefDeProjet(null);
		p.setNom(nom);
		try {
			persistance.persist(p);
		}catch(Exception ex) {
			throw new AppliException(ex);
		}
		return p;
	}

	public void affecterDeveloppeur(Developpeur d, Projet p) {
		p.addDeveloppeur(d);
		d.addProjet(p);
	}

	public void gererParChefDeProjet(Projet p, PM pm) {
		p.setChefDeProjet(pm);
		pm.addProjet(p);
	}
    
    public List<Projet> lesProjets( ) {
    	return this.qlesprojets.getResultList();
    }
}
