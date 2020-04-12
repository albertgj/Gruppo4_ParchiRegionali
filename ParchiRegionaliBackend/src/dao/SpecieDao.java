package dao;

import entity.Specie;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author albert
 */
public class SpecieDao {

    private String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    private EntityManager em;

    public SpecieDao() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public SpecieDao(EntityManager em) {
        this.em = em;
    }

    public List<Specie> findAll() {
        return null;
    }

    public Specie findById(int id) {
        return null;
    }

    public Specie findByName(String nome) {
        return null;
    }

    public boolean save(Specie s) {
        em.getTransaction().begin();
        try {
            em.persist(s);
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

    public Specie modifyById(int id) {
        return null;
    }
}
