package dao;

import entity.Parco;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author albert
 */
public class ParcoDao {

    private String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    private EntityManager em;

    public ParcoDao() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public ParcoDao(EntityManager em) {
        this.em = em;
    }

    public List<Parco> findAll() {
        return null;
    }

    public Parco findById(int id) {
        return null;
    }

    public Parco findByName(String nome) {
        return null;
    }

    public boolean save(Parco p) {
        em.getTransaction().begin();
        try {
            em.persist(p);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }

    public void deleteById(int id) {

    }

    public Parco modifyById(int id) {
        return null;
    }
}
