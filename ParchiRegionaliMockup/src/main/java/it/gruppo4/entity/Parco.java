package it.gruppo4.entity;

/**
 *
 * @author albert
 */
public class Parco
{

    private Long id;
    private String nomeParco;

    public Parco(Long id, String nomeParco)
    {
        this.id = id;
        this.nomeParco = nomeParco;
    }
    
    
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNomeParco()
    {
        return this.nomeParco;
    }

    public void setNomeParco(String nomeParco)
    {
        this.nomeParco = nomeParco;
    }
}
