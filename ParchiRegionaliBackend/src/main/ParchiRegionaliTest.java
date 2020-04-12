package main;

import dao.AnimaleDao;
import dao.DAO;
import dao.OrdineAppartenenzaDao;
import dao.ParcoDao;
import dao.SpecieDao;
import dao.TipologiaDao;
import dao.VegetaleDao;
import entity.Animale;
import entity.OrdineAppartenenza;
import entity.Parco;
import entity.Specie;
import entity.Tipologia;
import entity.Vegetale;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Tuple;

/**
 *
 * @author Gjergjaj Albert
 */
public class ParchiRegionaliTest {

    public static void main(String[] args) {
        DAO dao = new DAO();
        //*************************************************************
        AnimaleDao aDao = dao.getAnimaleDao();
        ParcoDao pDao = dao.getParcoDao();
        SpecieDao sDao = dao.getSpecieDao();
        OrdineAppartenenzaDao oDao = dao.getOrdineAppartenenzaDao();
        VegetaleDao vDao = dao.getVegetaleDao();
        TipologiaDao tDao = dao.getTipologiaDao();
        //*************************************************************

        //**********************************Istanze Animale***************************
        Animale animale1 = new Animale();
        animale1.setAnnoPrimoAvvistamento("10 a.c");
        animale1.setLivelloSalute(10);
        animale1.setNCuccioliFemmine(10);
        animale1.setNCuccioliMaschi(10);
        animale1.setNome("cavallo");
        animale1.setNumeroFemmine(9);
        animale1.setNumeroMaschi(9);
        Parco p = new Parco();
        p.setNomeParco("Trieste park");
        pDao.save(p);
        animale1.setParco(p);
        animale1.setRischioEstinzione(10);
        Specie specie = new Specie();
        specie.setNomeSpecie("Equina");
        OrdineAppartenenza od = new OrdineAppartenenza();
        od.setDescrizione("blah blah blah");
        oDao.save(od);
        specie.setOrdineAppartenenza(od);
        sDao.save(specie);
        animale1.setSpecie(specie);

        aDao.save(animale1);

        Vegetale v1 = new Vegetale();
        v1.setNomePianta("arbustri");
        v1.setNoteVarie("casfasfsaf");
        v1.setParco(p);
        v1.setStagioneFioritura("primavera");
        Tipologia t = new Tipologia();
        t.setDescrizione("asfrasfsaf");
        t.setTipo("painta");
        tDao.save(t);
        v1.setTipologia(t);
        vDao.save(v1);
        /*
        for (Animale a : aDao.findFauna(specie)) {
            System.out.println(a.getNome() + " " + a.getParco().getNomeParco() + " " + a.getSpecie().getNomeSpecie());
        }
         */
 /*
        for (Animale a : aDao.selectExtinction()) {
            System.out.println(a.getNome());
        }
         */
 /*
         Integer findNcuccioli = aDao.findNcuccioli(animale1);
         System.out.println(findNcuccioli);
         */
 /*
        for (Long s : vDao.findTotalOfPianta(t)) {
            System.out.println(s);
        }
         */

    }
}
