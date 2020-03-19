package dao;

import entity.Animale;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author albert
 */
public class AnimaleDao {

    private String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    private EntityManager em;

    public AnimaleDao() {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME)
                .createEntityManager();
    }

    public AnimaleDao(EntityManager em) {
        this.em = em;
    }

    public List<Animale> findAll() {
        return null;
        
    }

    public List<Animale> findByName(String cognome) {
        return null;   
    }
}
