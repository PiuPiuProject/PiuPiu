
package beans;

import entities.Comment;
import entities.LikePiu;
import entities.Piu;
import entities.User;
import java.util.ArrayList;
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
    
    public boolean insertLike(LikePiu l) {
        EntityManager em = emf.createEntityManager();
        em.persist(l);
        em.flush();
        em.close();
        return true;
    }
    
    public boolean insertFollower(User u) {
        EntityManager em = emf.createEntityManager();
        em.persist(u);
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
    
    public boolean existUser(String username){
        EntityManager em = emf.createEntityManager();
        User finded = em.find(User.class, username);
        if(finded != null){
            return true;
        }else{
            return false;
        }
    }
    
    public Piu existPiu(int piu_id){
        EntityManager em = emf.createEntityManager();
        Piu finded = em.find(Piu.class, piu_id);
        if(finded != null){
            return finded;
        }else{
            return null;
        }
    }
    
    public boolean insertComment(Comment c) {
        EntityManager em = emf.createEntityManager();
        em.persist(c);
        em.flush();
        em.close();
        return true;
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
    
    public List<User> selectAllUsers() {
        return emf.createEntityManager().createNamedQuery("User.findAll").getResultList();
    }
    
    public List<Piu> selectAllPiusUser(String author) {
        return emf.createEntityManager().createNamedQuery("Piu.findByAuthor").setParameter("authorId", existName(author)).getResultList();
    }
    
    public Piu selectPiuId(int piuId) {
        return (Piu) emf.createEntityManager().createNamedQuery("Piu.findByPiuId").setParameter("piuId", piuId);
    }
    
    public List<User> selectUserFollowers(String username){
        EntityManager em = emf.createEntityManager();
        User finded = em.find(User.class, username);
        if(finded != null){
            return (List<User>) finded.getUserCollection();
        }else{
            return null;
        }
    }
    
    public List<User> selectUserToFollow(String username){
        EntityManager em = emf.createEntityManager();
        User finded = em.find(User.class, username);
        if(finded != null){
            return em.createNamedQuery("SELECT u FROM User u WHERE u.username NOT IN  (SELECT f.followee_id.getUsername() FROM Follower f WHERE f.follower_id.getUsername() = :username)")
                    .setParameter("username", username)
                    .getResultList();
        }else{
            return null;
        }
    }
    
    //select u.* from user u where u.username not in  (select f.followee_id from follower f where f.follower_id = "a")
    
}
