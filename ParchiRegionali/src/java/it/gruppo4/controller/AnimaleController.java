package it.gruppo4.controller;

import com.google.gson.Gson;
import dao.DAO;
import entity.Animale;
import entity.OrdineAppartenenza;
import entity.Parco;
import entity.Specie;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author albert
 */
@Controller
public class AnimaleController {

    @Autowired
    @Qualifier("dao01")
    private DAO d;

    @RequestMapping(value = "animale/findallanimali.htm", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findAll(HttpServletRequest request) {
        Gson g = new Gson();
        List<Animale> findAll = d.getAnimaleDao().findAll();

        return g.toJson(findAll);
    }

    @RequestMapping(value = "animale/findanimalebyname.htm", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findByName(HttpServletRequest request) {
        Gson g = new Gson();
        Animale a = d.getAnimaleDao().findByName(request.getParameter("nome"));

        return g.toJson(a);
    }

    @RequestMapping(value = "animale/insertanimale.htm", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded; charset=UTF-8", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String saveAnimale(HttpServletRequest request) {
        Gson g = new Gson();

        String annoPrimoAvvistamento = request.getParameter("annoPrimoAvvistamento");
        String livelloSalute = request.getParameter("livelloSalute");
        String nCuccioliFemmine = request.getParameter("nCuccioliFemmine");
        String nCuccioliMaschi = request.getParameter("nCuccioliMaschi");
        String nome = request.getParameter("nome");
        String numeroFemmine = request.getParameter("numeroFemmine");
        String numeroMaschi = request.getParameter("numeroMaschi");
        String rischioEstinzione = request.getParameter("rischioEstinzione");
        String nomeParco = request.getParameter("nomeParco");
        String nomeSpecie = request.getParameter("nomeSpecie");
        String descrizione = request.getParameter("descrizione");

        Animale a = new Animale();

        a.setAnnoPrimoAvvistamento(annoPrimoAvvistamento);
        a.setLivelloSalute(Integer.parseInt(livelloSalute));
        a.setNCuccioliFemmine(Integer.parseInt(nCuccioliFemmine));
        a.setNCuccioliMaschi(Integer.parseInt(nCuccioliMaschi));
        a.setNome(nome);
        a.setNumeroFemmine(Integer.parseInt(numeroFemmine));
        a.setNumeroMaschi(Integer.parseInt(numeroMaschi));

        Parco p = d.getParcoDao().findByName(nomeParco);
        a.setParco(p);

        a.setRischioEstinzione(Integer.parseInt(rischioEstinzione));

        Specie s = new Specie();
        OrdineAppartenenza ord = new OrdineAppartenenza();
        s.setNomeSpecie(nomeSpecie);
        ord.setDescrizione(descrizione);
        d.getOrdineAppartenenzaDao().save(ord);
        s.setOrdineAppartenenza(ord);
        d.getSpecieDao().save(s);
        a.setSpecie(s);
        d.getAnimaleDao().save(a);

        return g.toJson(a);
    }
}
