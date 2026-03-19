package portos.data;

import jakarta.persistence.EntityManager;

import portos.jpa.EntitySingleton;

public class Portos {

    private EntityManager persistance;
    private ManagerPM mpm;
    private ManagerProjet mp;
    private ManagerDeveloppeur md;
    private ManagerTechnologie mt;

    public Portos() {
        this.persistance=EntitySingleton.getManager();
        this.mpm = new ManagerPM();
        this.mp = new ManagerProjet();
        this.md = new ManagerDeveloppeur();
        this.mt = new ManagerTechnologie();
    }

    public void debuter() {
        this.persistance.getTransaction().begin();
    }

    public ManagerPM getManagerPM() {
		return mpm;
	}

	public ManagerProjet getManagerProjet() {
		return mp;
	}

	public ManagerDeveloppeur getManagerDeveloppeur() {
		return md;
	}

    public ManagerTechnologie getManagerTechnologie() {
    	return mt;
    }
	public void valider() {
        this.persistance.getTransaction().commit();

    }
}
