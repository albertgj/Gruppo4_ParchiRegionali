package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author albert
 */
public class ParcoDao
{
    private EntityManager em;

    public ParcoDao(EntityManager em) 
    {
        this.em = em;
    } 
}
