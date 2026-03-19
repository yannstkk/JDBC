@Entity
@PrimaryKeyJoinColumn(name = "ID")
public class Developpeur extends Personne {

    private static final long serialVersionUID = 1L;

    @Column
    String poste;

    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }

    @ManyToMany
    @JoinTable(name = "DEVELOPPE",
            joinColumns = @JoinColumn(name = "DEVELOPPEUR_ID"),
            inverseJoinColumns = @JoinColumn(name = "PROJET_ID"))
    private Set<Projet> projets = new HashSet<>();
    public Set<Projet> getProjets() { return projets; }
    public void addProjet(Projet p) { projets.add(p); }

    @ManyToMany
    @JoinTable(name = "MAITRISE",
            joinColumns = @JoinColumn(name = "DEVELOPPEUR_ID"),
            inverseJoinColumns = @JoinColumn(name = "TECHNOLOGIE_ID"))
    private Set<Technologie> technologies = new HashSet<>();
    public Set<Technologie> getTechnologies() { return technologies; }
    public void addTechnologie(Technologie t) { technologies.add(t); }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (getId() != null ? getId().hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Developpeur)) { // correction du bug
            return false;
        }
        Developpeur other = (Developpeur) object;
        if ((this.getId() == null && other.getId() != null) || (this.getId() != null && !this.getId().equals(other.getId()))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Développeur : " + getNom() + " " + getPrenom();
    }

    public Developpeur() { super(); }
}