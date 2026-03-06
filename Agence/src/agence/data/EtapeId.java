package agence.data;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class EtapeId implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long idCircuit;
    private int ordre;

    public Long getIdCircuit() {
        return idCircuit;
    }
    public void setIdCircuit(Long idCircuit) {
        this.idCircuit = idCircuit;
    }

    public int getOrdre() { return ordre; }
    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    @Override
    public int hashCode() {
        return (idCircuit != null ? idCircuit.hashCode() : 0) + ordre;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof EtapeId)) return false;
        EtapeId other = (EtapeId) object;
        return (this.ordre == other.ordre)
                && ((this.idCircuit == null && other.idCircuit == null)
                || (this.idCircuit != null && this.idCircuit.equals(other.idCircuit)));
    }
}