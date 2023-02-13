package DIC2_JPA.entities.vente;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "article_commande")
@NamedQueries({
    @NamedQuery(name = "ArticleCommande.findAll", query = "SELECT a FROM ArticleCommande a"),
    @NamedQuery(name = "ArticleCommande.findByNumeroCommande", query = "SELECT a FROM ArticleCommande a WHERE a.articleCommandePK.numeroCommande = :numeroCommande"),
    @NamedQuery(name = "ArticleCommande.findByLigne", query = "SELECT a FROM ArticleCommande a WHERE a.articleCommandePK.ligne = :ligne"),
    @NamedQuery(name = "ArticleCommande.findByProduitId", query = "SELECT a FROM ArticleCommande a WHERE a.produitId = :produitId"),
    @NamedQuery(name = "ArticleCommande.findByQuantite", query = "SELECT a FROM ArticleCommande a WHERE a.quantite = :quantite"),
    @NamedQuery(name = "ArticleCommande.findByPrixDepart", query = "SELECT a FROM ArticleCommande a WHERE a.prixDepart = :prixDepart"),
    @NamedQuery(name = "ArticleCommande.findByRemise", query = "SELECT a FROM ArticleCommande a WHERE a.remise = :remise")})
public class ArticleCommande implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected ArticleCommandePK articleCommandePK;
    @Basic(optional = false)
    @Column(name = "PRODUIT_ID")
    private int produitId;
    @Basic(optional = false)
    @Column(name = "QUANTITE")
    private int quantite;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "PRIX_DEPART")
    private BigDecimal prixDepart;
    @Basic(optional = false)
    @Column(name = "REMISE")
    private BigDecimal remise;
    @JoinColumn(name = "NUMERO_COMMANDE", referencedColumnName = "NUMERO", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Commande commande;

    public ArticleCommande() {
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public ArticleCommande(ArticleCommandePK articleCommandePK, int produitId, int quantite, BigDecimal prixDepart, BigDecimal remise) {
        this.articleCommandePK = articleCommandePK;
        this.produitId = produitId;
        this.quantite = quantite;
        this.prixDepart = prixDepart;
        this.remise = remise;
    }

    public ArticleCommande(int numeroCommande, int ligne) {
        this.articleCommandePK = new ArticleCommandePK(numeroCommande, ligne);
    }

    public ArticleCommandePK getArticleCommandePK() {
        return articleCommandePK;
    }

    public void setArticleCommandePK(ArticleCommandePK articleCommandePK) {
        this.articleCommandePK = articleCommandePK;
    }

    public int getProduitId() {
        return produitId;
    }

    public void setProduitId(int produitId) {
        this.produitId = produitId;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrixDepart() {
        return prixDepart;
    }

    public void setPrixDepart(BigDecimal prixDepart) {
        this.prixDepart = prixDepart;
    }

    public BigDecimal getRemise() {
        return remise;
    }

    public void setRemise(BigDecimal remise) {
        this.remise = remise;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (articleCommandePK != null ? articleCommandePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ArticleCommande)) {
            return false;
        }
        ArticleCommande other = (ArticleCommande) object;
        if ((this.articleCommandePK == null && other.articleCommandePK != null) || (this.articleCommandePK != null && !this.articleCommandePK.equals(other.articleCommandePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.ept.git.dic2.tp_jpa_ass_niang.entities.ArticleCommande[ articleCommandePK=" + articleCommandePK + " ]";
    }
    
}
