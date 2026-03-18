package cinema.data;

import jakarta.persistence.*;

@Entity
@PrimaryKeyJoinColumn(name="id_video")
@NamedQuery(name="lesreportages",query="select r from Reportage r")
public class Reportage extends Video {

    @Column
    String lieu;
    public String getLieu() {
        return lieu;
    }
    public void setLieu(String l) {
        lieu = l;
    }

    public String toString() {
        return "Reportage : " + this.getTitre() + " " + this.getLieu();
    }
}
