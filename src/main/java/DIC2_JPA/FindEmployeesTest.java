package DIC2_JPA;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import DIC2_JPA.entities.vente.Employe;


public class FindEmployeesTest {
    private static final String VENTE_PU_NAME = "ventePU";
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(VENTE_PU_NAME);
        EntityManager em = emf.createEntityManager();
        
        Query q = em.createQuery("SELECT e FROM Employe e");
        
        List<Employe> employes = q.getResultList();
        
        System.out.println("Liste des employes: " + employes);
        System.out.println("Nombre d'employes: "+ employes.size());
        
        em.close();
        emf.close();
    }
}
