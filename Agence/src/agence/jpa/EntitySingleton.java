package agence.jpa;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EntitySingleton {

	private static final String PERSISTENCEUNIT = "Agence";

	private static EntityManager theManager = null;


	private EntitySingleton() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory(PERSISTENCEUNIT);
		theManager = emf.createEntityManager();
	}

	public static EntityManager getManager() {
		if( theManager == null) new EntitySingleton();
		return theManager ;
	}

}
