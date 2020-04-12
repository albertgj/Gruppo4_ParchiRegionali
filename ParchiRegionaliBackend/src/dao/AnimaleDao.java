package dao;

import entity.Animale;
import entity.Parco;
import entity.Specie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
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

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    //QUERY TRACCIA ESAME
    /**
     * <p>
     * Visualizza l'elenco di tutti gli esemplari di fauna, suddivisi per
     * specie, preseni nei vari parchi</p>
     *
     * @param Specie s
     * @return List<Animale>
     */
    public List<Animale> findFauna() {
        TypedQuery<Object[]> typedQuery = em.createQuery("SELECT u.nome, u.parco.nomeParco, a.nomeSpecie FROM Animale u, Specie a WHERE u.specie.id = a.id ORDER BY u.specie.nomeSpecie", Object[].class);

        List<Object[]> res;

        try {
            res = typedQuery.getResultList();
        } catch (NoResultException e) {
            return null;
        }

        List<Animale> listaFauna = new ArrayList<>();
        Animale as = new Animale();

        for (Object[] objects : res) {
            as.setNome((String) objects[0]);
            Parco asParco = new Parco();
            asParco.setNomeParco((String) objects[1]);
            as.setParco(asParco);
            Specie asSpecie = new Specie();
            asSpecie.setNomeSpecie((String) objects[2]);
            as.setSpecie(asSpecie);
            listaFauna.add(as);
        }

        return listaFauna;
    }

    /**
     * <p>
     * Visualizza tutti gli esemplari a rischio estinzione</p>
     *
     * @return List<Animale>
     */
    public List<Animale> selectExtinction() {
        TypedQuery<Animale> typedQuery = em.createQuery("SELECT u FROM Animale u WHERE u.rischioEstinzione > 7", Animale.class);
        List<Animale> animales = typedQuery.getResultList();

        return animales;
    }

    /**
     * <p>
     * Calcola e visualizza il numero di nascite di un certo esemplare nell'arco
     * di un anno di monitoraggio </p>
     *
     * @param Animale a
     * @return
     */
    public Integer findNcuccioli(Animale a) {
        TypedQuery<Integer> femmine = em.createQuery("SELECT u.nCuccioliFemmine FROM Animale u WHERE u.nome LIKE :n", Integer.class).setParameter("n", a.getNome());
        Integer fNums = femmine.getSingleResult();
        TypedQuery<Integer> maschi = em.createQuery("SELECT u.nCuccioliMaschi FROM Animale u WHERE u.nome LIKE :n", Integer.class).setParameter("n", a.getNome());
        Integer mNums = femmine.getSingleResult();
        
        return fNums + mNums;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    /**
     * <p>
     * Visualizza tutti gli animali</p>
     *
     * @return List<Animale>
     */
    public List<Animale> findAll() {
        TypedQuery<Animale> typedQuery = em.createQuery("SELECT u FROM Animale u", Animale.class);
        List<Animale> animales = typedQuery.getResultList();

        return animales;
    }

    /**
     * <p>
     * Visualizza un animale in base al suo id</p>
     *
     * @param Long id
     * @return Animale
     */
    public Animale findById(Long id) {
        TypedQuery<Animale> typedQuery = em.createQuery("SELECT u FROM Animale u WHERE u.id = :animaleId", Animale.class).setParameter("animaleId", id);
        Animale animale = typedQuery.getResultList().get(0);

        return animale;
    }

    /**
     * <p>
     * Visualizza un animale in base al suo nome</p>
     *
     * @param String nome
     * @return Animale
     */
    public Animale findByName(String nome) {
        TypedQuery<Animale> typedQuery = em.createQuery("SELECT u FROM Animale u WHERE u.nome = :nomeAnimale", Animale.class).setParameter("nomeAnimale", nome);
        Animale animale = typedQuery.getResultList().get(0);

        return animale;
    }

    /**
     * <p>
     * Salva un animale nel db</p>
     *
     * @param Animale a
     * @return boolean
     */
    public boolean save(Animale a) {
        em.getTransaction().begin();
        try {
            em.persist(a);
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

    /**
     * <p>
     * Modifica un attributo di un animale in base all'id</p>
     *
     * @param Long id
     * @return Animale
     */
    public Animale modifyById(Long id) {
        Animale a = em.find(Animale.class, id);
        return null;
    }

    /**
     * <p>
     * Cancella un animale in base all'id</p>
     *
     * @param Long id
     * @return boolean
     */
    public boolean deleteById(Long id) {
        Animale a = em.find(Animale.class, id);

        em.getTransaction().begin();

        try {
            em.remove(a);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            return false;
        }
    }
    //-----------------------------------------------------------------------------------------------------------------------------------------------------
}
