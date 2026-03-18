package cinema.data;

import jakarta.persistence.*;
import cinema.jpa.EntitySingleton;
import java.util.List;

public class ManagerReportage {

    private EntityManager persistance;
    private Query listerReportages;
    
    public ManagerReportage() {
        this.persistance=EntitySingleton.getManager();
        listerReportages = persistance.createNamedQuery("lesreportages");
    }

    public Reportage ajouterReportage(String titre, int annee,String lieu) throws AppliException {
        Reportage r = new Reportage();
        r.setTitre(titre);
        r.setAnnee(annee);
        r.setLieu(lieu);
        try {
            persistance.persist(r);
        }catch(Exception e) {
            throw new AppliException(e);
        }
        return r;
    }

    public List<Reportage> listerReportages() {
	return (List<Reportage>)listerReportages.getResultList();
    }
}
