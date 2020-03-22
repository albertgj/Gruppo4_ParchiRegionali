package it.gruppo4.dao;

import it.gruppo4.entity.Animale;
import it.gruppo4.entity.OrdineAppartenenza;
import it.gruppo4.entity.Parco;
import it.gruppo4.entity.Specie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author albert
 */
public class AnimaleDao
{

    private List<Animale> animales = null;

    public AnimaleDao()
    {
        animales = new ArrayList<>();
        animales.add(new Animale(Long.decode("1"), "cavallo", "4", "2", "4", "5", "10", "1", "2020", new Parco(Long.decode("1"), "parco 1"), new Specie(Long.decode("1"), "equina", new OrdineAppartenenza(Long.decode("1"), "mammiferi"))));
        animales.add(new Animale(Long.decode("2"), "cavallo", "3", "5", "10", "5", "10", "1", "2020", new Parco(Long.decode("1"), "parco 1"), new Specie(Long.decode("2"), "equina", new OrdineAppartenenza(Long.decode("2"), "mammiferi"))));
    }

    public List<Animale> findAll()
    {
        return animales;

    }

    public List<Animale> findByName(String nomeAnimale)
    {
        List<Animale> animale = new ArrayList<>();

        for (Animale a : animales)
        {
            if (a.getNome().equals(nomeAnimale))
            {
                System.out.println(a);
                animale.add(a);
            }
        }
        return animale;
    }
}
