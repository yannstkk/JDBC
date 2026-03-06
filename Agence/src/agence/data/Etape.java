package agence.data;

import java.io.Serializable;
import jakarta.persistence.*;

@Entity
public class Etape implements Serializable {

    private static final long serialVersionUID = 1L;

    @EmbeddedId
    private EtapeId id = new EtapeId();

    public EtapeId getId() {
        return id;
    }
    public void setId(EtapeId id) {
        this.id = id;
    }

    public int getOrdre() {
        return id.getOrdre();
    }
    public void setOrdre(int ordre) {
        id.setOrdre(ordre);
    }



    @ManyToOne
    @MapsId("idCircuit")
    @JoinColumn(name = "idCircuit")
    private Circuit circuit;



    public Circuit getCircuit() { return circuit; }
    public void setCircuit(Circuit circuit) {
        this.circuit = circuit;
        if (circuit != null) id.setIdCircuit(circuit.getIdCircuit());
    }

    @ManyToOne
    @JoinColumn(name = "idVille")
    private Ville ville;

    public Ville getVille() {
        return ville;
    }
    public void setVille(Ville ville) {
        this.ville = ville;
    }

    public Etape() {}

    @Override
    public String toString() {
        return "Etape [circuit=" + (circuit != null ? circuit.getIdCircuit() : "null")
                + ", ordre=" + getOrdre() + "]";
    }
}