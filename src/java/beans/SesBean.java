
package beans;

import entities.Piu;
import entities.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;


@Stateless
public class SesBean {
    
    @PersistenceUnit
    EntityManagerFactory emf;
    
    public boolean insertUser(User u) {
        if (!issetUser(u)) {
            EntityManager em = emf.createEntityManager();
            em.persist(u);
            em.flush();
            em.close();
            return true;
        } else {
            return false;
        }
    } 
    
    
    public boolean insertPiu(Piu p) {
        EntityManager em = emf.createEntityManager();
        em.persist(p);
        em.flush();
        em.close();
        return true;
    }

    
    public boolean issetUser(User u) {
        EntityManager em = emf.createEntityManager();
        User encontrada = em.find(User.class, u.getName());
        em.close();
        return encontrada != null;
    }
    
    public User existName(String username){
        EntityManager em = emf.createEntityManager();
        User finded = em.find(User.class, username);
        if(finded != null){
            return finded;
        }else{
            return null;
        }
    }
    
    public boolean correctUser(String username, String password){
        EntityManager em = emf.createEntityManager();
        User user = existName(username);
        if(user.getPassword().equals(password)){
            return true;
        }else{
            return false;
        }
    }
    
    public List<Piu> selectAllPiusUser(String author) {
        return emf.createEntityManager().createNamedQuery("Piu.findByAuthor").setParameter("authorId", existName(author)).getResultList();
    }
}
