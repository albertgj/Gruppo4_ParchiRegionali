package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author albert
 */
public class OrdineAppartenenzaDao 
{
    private EntityManager em;

    public OrdineAppartenenzaDao(EntityManager em) 
    {
        this.em = em;
    }
}
