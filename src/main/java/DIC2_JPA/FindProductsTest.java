package DIC2_JPA;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import DIC2_JPA.entities.production.Produit;

public class FindProductsTest {
    private static final String PRODUCTION_PU_NAME = "productionPU";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PRODUCTION_PU_NAME);
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT p FROM Produit p");
        
        List<Produit> produits = q.getResultList();
        
        System.out.println("Liste des produits: " + produits);
        
        em.close();
        emf.close();
    }
}
