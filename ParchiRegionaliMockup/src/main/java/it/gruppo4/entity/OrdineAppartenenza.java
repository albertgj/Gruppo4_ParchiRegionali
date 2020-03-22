package it.gruppo4.entity;

/**
 *
 * @author albert
 */

public class OrdineAppartenenza
{

    private Long id;
    private String descrizione;

    public OrdineAppartenenza(Long id, String descrizione)
    {
        this.id = id;
        this.descrizione = descrizione;
    }
    
    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getDescrizione()
    {
        return this.descrizione;
    }

    public void setDescrizione(String descrizione)
    {
        this.descrizione = descrizione;
    }
}
