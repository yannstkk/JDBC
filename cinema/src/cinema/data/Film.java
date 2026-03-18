package cinema.data;

import jakarta.persistence.*;
import java.util.Set;
import java.util.HashSet;

@Entity
@PrimaryKeyJoinColumn(name="id_video")
@NamedQuery(name="lesfilms",query="select f from Film f")
public class Film  extends Video {

    @Column
    String genre;
    public String getGenre() {
        return genre;
    }
    public void setGenre(String g) {
        genre = g;
    }
  

    
    @ManyToMany()
    @JoinTable(name="Role",joinColumns=@JoinColumn(name="id_film"),
               inverseJoinColumns=@JoinColumn(name="id_acteur"))
    Set<Artiste> acteurs = new HashSet<Artiste>();
    public Set<Artiste> getActeurs() {
        return acteurs;
    }
    public void addActeurs(Artiste a) {
        acteurs.add(a);
    }

    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Film)) {
            return false;
        }
        Film other = (Film) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Film : " + getTitre() + " " + getAnnee() + " " + getGenre();
    }

}
