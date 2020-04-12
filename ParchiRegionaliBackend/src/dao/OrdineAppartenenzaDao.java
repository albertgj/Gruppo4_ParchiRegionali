package dao;

import entity.OrdineAppartenenza;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author albert
 */
public class OrdineAppartenenzaDao {

    private String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    private EntityManager em;

    public OrdineAppartenenzaDao() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public OrdineAppartenenzaDao(EntityManager em) {
        this.em = em;
    }

    public List<OrdineAppartenenza> findAll() {
        return null;
    }

    public OrdineAppartenenza findById(int id) {
        return null;
    }

    public OrdineAppartenenza findByName(String nome) {
        return null;
    }

    public boolean save(OrdineAppartenenza o) {
        em.getTransaction().begin();
        try {
            em.persist(o);
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

    public OrdineAppartenenza modifyById(int id) {
        return null;
    }
}
