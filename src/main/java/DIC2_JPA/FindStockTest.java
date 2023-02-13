package DIC2_JPA;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;



public class FindStockTest {
    private static final String PRODUCTION_PU_NAME = "productionPU";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(PRODUCTION_PU_NAME);
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT s.produit.nom,SUM(s.quantite) FROM Stock s GROUP BY s.produit");
        
        List<Object[]> stocks = q.getResultList();
        
        for (Object[] stock : stocks) {
            System.out.println("stock restant: " + stock[1] + ", nom: " + stock[0] );
        }
        
        
        em.close();
        emf.close();
    }
}
