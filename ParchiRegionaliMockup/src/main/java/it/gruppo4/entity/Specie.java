package it.gruppo4.entity;

/**
 *
 * @author albert
 */
public class Specie
{

    private Long id;
    private String nomeSpecie;
    private OrdineAppartenenza ordineAppartenenza;

    public Specie(Long id, String nomeSpecie, OrdineAppartenenza ordineAppartenenza)
    {
        this.id = id;
        this.nomeSpecie = nomeSpecie;
        this.ordineAppartenenza = ordineAppartenenza;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNomeSpecie()
    {
        return this.nomeSpecie;
    }

    public void setNomeSpecie(String nomeSpecie)
    {
        this.nomeSpecie = nomeSpecie;
    }

    public OrdineAppartenenza getOrdineAppartenenza()
    {
        return this.ordineAppartenenza;
    }

    public void setOrdineAppartenenza(OrdineAppartenenza ordineAppartenenza)
    {
        this.ordineAppartenenza = ordineAppartenenza;
    }
}
