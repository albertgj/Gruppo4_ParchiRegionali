package it.gruppo4.entity;

/**
 *
 * @author albert
 */
public class Vegetale
{

    private Long id;
    private String nomePianta;
    private String stagioneFioritura;
    private String noteVarie;
    private Parco parco;
    private Tipologia tipologia;

    public Vegetale(Long id, String nomePianta, String stagioneFioritura, String noteVarie, Parco parco, Tipologia tipologia)
    {
        this.id = id;
        this.nomePianta = nomePianta;
        this.stagioneFioritura = stagioneFioritura;
        this.noteVarie = noteVarie;
        this.parco = parco;
        this.tipologia = tipologia;
    }

    public Long getId()
    {
        return this.id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public String getNomePianta()
    {
        return this.nomePianta;
    }

    public void setNomePianta(String nomePianta)
    {
        this.nomePianta = nomePianta;
    }

    public String getStagioneFioritura()
    {
        return this.stagioneFioritura;
    }

    public void setStagioneFioritura(String stagioneFioritura)
    {
        this.stagioneFioritura = stagioneFioritura;
    }

    public String getNoteVarie()
    {
        return this.noteVarie;
    }

    public void setNoteVarie(String noteVarie)
    {
        this.noteVarie = noteVarie;
    }

    public Parco getParco()
    {
        return this.parco;
    }

    public void setParco(Parco parco)
    {
        this.parco = parco;
    }

    public Tipologia getTipologia()
    {
        return this.tipologia;
    }

    public void setTipologia(Tipologia tipologia)
    {
        this.tipologia = tipologia;
    }
}
