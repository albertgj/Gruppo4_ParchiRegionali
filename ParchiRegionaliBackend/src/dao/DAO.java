package dao;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

/**
 *
 * @author albert
 */
public class DAO 
{
    private String PERSISTENCE_UNIT_NAME = "DEFAULT_PU";
    private EntityManager em;
    private AnimaleDao animaleDao;
    private OrdineAppartenenzaDao ordineAppartenenzaDao;
    private ParcoDao parcoDao;
    private SpecieDao specieDao;
    private TipologiaDao tipologiaDao;
    private VegetaleDao vegetaleDao;

    public DAO() 
    {
        em = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME).createEntityManager();
        animaleDao = new AnimaleDao(em);
        ordineAppartenenzaDao = new OrdineAppartenenzaDao(em);
        parcoDao = new ParcoDao(em);
        specieDao = new SpecieDao(em);
        tipologiaDao = new TipologiaDao(em);
        vegetaleDao = new VegetaleDao(em);
    }

    public AnimaleDao getAnimaleDao() 
    {
        return animaleDao;
    }

    public OrdineAppartenenzaDao getOrdineAppartenenzaDao() 
    {
        return ordineAppartenenzaDao;
    }

    public ParcoDao getParcoDao()
    {
        return parcoDao;
    }

    public SpecieDao getSpecieDao()
    {
        return specieDao;
    }

    public TipologiaDao getTipologiaDao()
    {
        return tipologiaDao;
    }

    public VegetaleDao getVegetaleDao()
    {
        return vegetaleDao;
    } 
}
