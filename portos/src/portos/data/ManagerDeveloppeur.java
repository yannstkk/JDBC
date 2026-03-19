package portos.data;


import jakarta.persistence.*;

import portos.jpa.EntitySingleton;

public class ManagerDeveloppeur {

    private EntityManager persistance;

    public ManagerDeveloppeur() {
        this.persistance=EntitySingleton.getManager();
    }

    public Developpeur ajouterDeveloppeur(String nom, String prenom, String email, String poste) throws AppliException {
        Developpeur d = new Developpeur();
        d.setNom(nom);
        d.setPrenom(prenom);
        d.setEmail(email);
        d.setPoste(poste);
        try {
            persistance.persist(d);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return d;
    }

}
