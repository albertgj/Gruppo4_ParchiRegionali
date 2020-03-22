package it.gruppo4.dao;

import org.springframework.stereotype.Repository;

/**
 *
 * @author albert
 */
@Repository("dao1")
public class Dao
{

    private AnimaleDao animaleDao;
    private OrdineAppartenenzaDao ordineAppartenenzaDao;
    private ParcoDao parcoDao;
    private SpecieDao specieDao;
    private TipologiaDao tipologiaDao;
    private VegetaleDao vegetaleDao;

    public Dao()
    {
        animaleDao = new AnimaleDao();
        ordineAppartenenzaDao = new OrdineAppartenenzaDao();
        parcoDao = new ParcoDao();
        specieDao = new SpecieDao();
        tipologiaDao = new TipologiaDao();
        vegetaleDao = new VegetaleDao();
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
