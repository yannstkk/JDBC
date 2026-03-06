package agence;

import jakarta.persistence.EntityManager;

import agence.data.Circuit;
import agence.data.Client;
import agence.data.Etape;
import agence.data.Groupe;
import agence.data.Guide;
import agence.data.Ville;
import agence.jpa.EntitySingleton;

public class ApplicationCreation {


	public static void main(String[] args) throws Exception {

		EntityManager persistance = EntitySingleton.getManager();
		persistance.getTransaction().begin();
		
		/* création d'un client */
		Client c = new Client();
		c.setNom("Roos");
		c.setPrenom("JF");
		c.setAnneeNaissance(1966);
		persistance.persist(c);

		/* création d'un guide */
		Guide g = new Guide();
		g.setNom("Ivanova");
		g.setPrenom("Nathalie");
		g.setSalaire(300);
		persistance.persist(g);
		
		/* création d'un circuit */
		Circuit circ = new Circuit();
		circ.setTitre("T'as pas vu passer la bande ?");
		circ.setDuree(7);
		persistance.persist(circ);

		/* création d'un groupe */
		Groupe gr = new Groupe();
		gr.setTarif(300.0);
		gr.setCapacite(30);
		persistance.persist(gr);

		/* création de deux étapes */
		/* pour le circuit         */
		Etape e1 = new Etape();
		Etape e2 = new Etape();
		e1.setCircuit(circ);
		e1.setOrdre(1);
		e2.setCircuit(circ);
		e2.setOrdre(2);
		persistance.persist(e1);
		persistance.persist(e2);

		/* création de deux villes */
		Ville v1 = new Ville();
		Ville v2 = new Ville();
		v1.setNom("Dunkerque");
		v1.setPays("France");
		v2.setNom("Bergues");
		v2.setPays("France");
		persistance.persist(v1);
		persistance.persist(v2);

		/* association ville-etape */
		v1.addEtapes(e1);
                e1.setVille(v1);
		v2.addEtapes(e2);
                e2.setVille(v2);

		/* association guide-groupe */
		g.addGroupesGeres(gr);
                gr.setGuide(g);

		/* association client-groupe */
		gr.addLesInscrits(c);
		c.addLesVoyages(gr);

		/* association groupe-circuit */
		circ.addLesGroupes(gr);
                gr.setCircuit(circ);

		persistance.getTransaction().commit();
	}

}
