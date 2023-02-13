package DIC2_JPA;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import DIC2_JPA.entities.vente.Client;
public class FindClientsTest {
    private static final String VENTE_PU_NAME = "ventePU";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(VENTE_PU_NAME);
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT c FROM Client c");
        
        List<Client> clients = q.getResultList();
        
        System.out.println("Liste des clients: " + clients);
        System.out.println("Nombre de clients: "+ clients.size());
        
        em.close();
        emf.close();
    }
}
