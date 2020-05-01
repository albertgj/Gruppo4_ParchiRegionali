package it.gruppo4.test;

import dao.AnimaleDao;
import dao.DAO;
import dao.OrdineAppartenenzaDao;
import dao.ParcoDao;
import dao.SpecieDao;
import entity.Animale;
import entity.OrdineAppartenenza;
import entity.Parco;
import entity.Specie;

/**
 *
 * @author albert
 */
public class TestMain {

    public static void main(String[] args) {
        DAO d = new DAO();
        AnimaleDao aDao = d.getAnimaleDao();
        ParcoDao pDao = new ParcoDao();
        OrdineAppartenenzaDao oDao = d.getOrdineAppartenenzaDao();
        SpecieDao sDao = d.getSpecieDao();

        /*
        Animale a = new Animale();

        a.setAnnoPrimoAvvistamento("1999");
        a.setLivelloSalute(10);
        a.setNCuccioliFemmine(5);
        a.setNCuccioliMaschi(5);
        a.setNome("cavallo");
        a.setNumeroFemmine(6);
        a.setNumeroMaschi(4);

        Parco p = new Parco();
        p.setNomeParco("Trento park");
        pDao.save(p);
        a.setParco(p);

        a.setRischioEstinzione(1);

        Specie s = new Specie();
        OrdineAppartenenza ord = new OrdineAppartenenza();
        s.setNomeSpecie("equina");
        ord.setDescrizione("Appartiene a ...");
        oDao.save(ord);
        s.setOrdineAppartenenza(ord);
        sDao.save(s);
        a.setSpecie(s);
        aDao.save(a);
         */
        Parco p = new Parco();
        p.setNomeParco("Verona park");
        Parco p2 = new Parco();
        p2.setNomeParco("Trieste Park");
        Parco p3 = new Parco();
        p3.setNomeParco("Trento park");
        Parco p4 = new Parco();
        p4.setNomeParco("Milano park");
        pDao.save(p);
        pDao.save(p2);
        pDao.save(p3);
        pDao.save(p4);
    }
}
