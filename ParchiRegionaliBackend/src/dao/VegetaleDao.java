package dao;

import entity.Animale;
import entity.Tipologia;
import entity.Vegetale;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author albert
 */
public class VegetaleDao {

    private String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    private EntityManager em;

    public VegetaleDao() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    //QUERY TRACCIA ESAME
    /**
     * <h1> Query nr 5</h1>
     * <p>
     * Visualizza totale di una pianta</p>
     *
     * @param Tiplogia t
     * @return List<Long>
     */
    public List<Long> findTotalOfPianta(Tipologia t) {
        TypedQuery<Long> typedQuery = em.createQuery("SELECT COUNT(v.nomePianta) FROM Vegetale v WHERE v.tipologia.id = :tId GROUP BY v.parco", Long.class).setParameter("tId", t.getId());
        List<Long> vegetales = typedQuery.getResultList();

        return vegetales;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    public VegetaleDao(EntityManager em) {
        this.em = em;
    }

    public List<Vegetale> findAll() {
        return null;
    }

    public Vegetale findById(int id) {
        return null;
    }

    public Vegetale findByName(String nome) {
        return null;
    }

    public boolean save(Vegetale v) {
        em.getTransaction().begin();
        try {
            em.persist(v);
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

    public Vegetale modifyById(int id) {
        return null;
    }
}
