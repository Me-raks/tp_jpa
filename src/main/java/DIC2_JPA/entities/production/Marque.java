package DIC2_JPA.entities.production;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "marque")
@NamedQueries({
        @NamedQuery(name = "Marque.findAll", query = "SELECT m FROM Marque m"),
        @NamedQuery(name = "Marque.findById", query = "SELECT m FROM Marque m WHERE m.id = :id"),
        @NamedQuery(name = "Marque.findByNom", query = "SELECT m FROM Marque m WHERE m.nom = :nom")})
public class Marque implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "NOM")
    private String nom;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "marqueId")
    private Collection<Produit> produitCollection;

    public Marque() {
    }

    public Marque(Integer id) {
        this.id = id;
    }

    public Marque(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Collection<Produit> getProduitCollection() {
        return produitCollection;
    }

    public void setProduitCollection(Collection<Produit> produitCollection) {
        this.produitCollection = produitCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof Marque)) {
            return false;
        }
        Marque other = (Marque) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "DIC2_JPA.entities.production.Marque[ id=" + id + " ]";
    }

}
