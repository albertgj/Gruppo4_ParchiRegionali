package dao;

import javax.persistence.EntityManager;

/**
 *
 * @author albert
 */
class VegetaleDao 
{
   private EntityManager em;

    public VegetaleDao(EntityManager em) 
    {
        this.em = em;
    }
}
