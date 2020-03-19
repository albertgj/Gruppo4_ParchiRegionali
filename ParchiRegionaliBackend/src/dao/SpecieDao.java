package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author albert
 */
public class SpecieDao
{
    private EntityManager em;

    public SpecieDao(EntityManager em) 
    {
        this.em = em;
    }
}
