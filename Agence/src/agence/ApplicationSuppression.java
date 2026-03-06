package agence;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;

import agence.data.Circuit;
import agence.data.Client;
import agence.data.Etape;
import agence.data.EtapeId;
import agence.data.Groupe;
import agence.data.Guide;
import agence.data.Ville;
import agence.jpa.EntitySingleton;

public class ApplicationSuppression {


    public static void main(String[] args) throws Exception {

	EntityManager persistance = EntitySingleton.getManager();
	persistance.getTransaction().begin();

        /* recherche du circuit */
        Circuit circ = persistance.find(Circuit.class,1L);
        /* recherche d'une étape */
        EtapeId eid = new EtapeId();
        eid.setOrdre(1);
        eid.setIdCircuit(1L);
        Etape e1 = persistance.find(Etape.class, eid);

        /* suppression de l'étape dans la collection du circuit */
        circ.removeLesEtapes(e1);

        /* lister les étapes */
        TypedQuery<Etape> tq = persistance.createQuery("select e from Etape e",Etape.class);
        List<Etape> le = tq.getResultList();
        System.out.println("-----> Les étapes après retrait de la collection.");
        for(Etape e : le) {
            System.out.println(e);
        }

        persistance.flush();
        persistance.refresh(circ);
        persistance.getTransaction().commit();

 	persistance.getTransaction().begin();
       /* suppression du circuit */
        persistance.remove(circ);

            
        /* lister les étapes */
        le = tq.getResultList();
        System.out.println("Les étapes après suppression du circuit.");
        for(Etape e : le) {
            System.out.println(e);
        }

        persistance.getTransaction().commit();
    }

}
