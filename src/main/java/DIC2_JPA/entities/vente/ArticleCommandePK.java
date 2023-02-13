package DIC2_JPA.entities.vente;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class ArticleCommandePK implements Serializable {

    @Basic(optional = false)
    @Column(name = "NUMERO_COMMANDE")
    private int numeroCommande;
    @Basic(optional = false)
    @Column(name = "LIGNE")
    private int ligne;

    public ArticleCommandePK() {
    }

    public ArticleCommandePK(int numeroCommande, int ligne) {
        this.numeroCommande = numeroCommande;
        this.ligne = ligne;
    }

    public int getNumeroCommande() {
        return numeroCommande;
    }

    public void setNumeroCommande(int numeroCommande) {
        this.numeroCommande = numeroCommande;
    }

    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) numeroCommande;
        hash += (int) ligne;
        return hash;
    }

    @Override
    public boolean equals(Object object) {

        if (!(object instanceof ArticleCommandePK)) {
            return false;
        }
        ArticleCommandePK other = (ArticleCommandePK) object;
        if (this.numeroCommande != other.numeroCommande) {
            return false;
        }
        if (this.ligne != other.ligne) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "sn.ept.git.dic2.tp_jpa_ass_niang.entities.ArticleCommandePK[ numeroCommande=" + numeroCommande + ", ligne=" + ligne + " ]";
    }
    
}
