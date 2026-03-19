package portos.data;

import jakarta.persistence.*;

import portos.jpa.EntitySingleton;

public class ManagerPM {

    private EntityManager persistance;
    
    public ManagerPM() {
        this.persistance=EntitySingleton.getManager();
    }

    public PM ajouterPM(String nom, String prenom, String email, int experience) throws AppliException {
        PM cdp = new PM();
        cdp.setNom(nom);
        cdp.setPrenom(prenom);
        cdp.setEmail(email);
        cdp.setExperience(experience);
        try {
            persistance.persist(cdp);
        }catch(Exception ex) {
            throw new AppliException(ex);
        }
        return cdp;
    }
    
}
