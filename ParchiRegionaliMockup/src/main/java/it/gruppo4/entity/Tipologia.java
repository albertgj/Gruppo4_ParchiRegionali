package it.gruppo4.entity;

/**
 *
 * @author albert
 */
public class Tipologia
{

    private Long id;
    private String tipo;
    private String descrizione;

    public Tipologia(Long id, String tipo, String descrizione)
    {
        this.id = id;
        this.tipo = tipo;
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

    public String getTipo()
    {
        return this.tipo;
    }

    public void setTipo(String tipo)
    {
        this.tipo = tipo;
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
