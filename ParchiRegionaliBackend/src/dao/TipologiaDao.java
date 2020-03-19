package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author albert
 */

public class TipologiaDao 
{
    private EntityManager em;

    public TipologiaDao(EntityManager em) 
    {
        this.em = em;
    }
}
