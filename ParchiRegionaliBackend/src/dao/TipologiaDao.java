package dao;

import entity.Tipologia;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author albert
 */
public class TipologiaDao {

    private String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    private EntityManager em;

    public TipologiaDao() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public TipologiaDao(EntityManager em) {
        this.em = em;
    }

    public List<Tipologia> findAll() {
        return null;
    }

    public Tipologia findById(int id) {
        return null;
    }

    public Tipologia findByName(String nome) {
        return null;
    }

    public boolean save(Tipologia t) {
        em.getTransaction().begin();
        try {
            em.persist(t);
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

    public Tipologia modifyById(int id) {
        return null;
    }
}
