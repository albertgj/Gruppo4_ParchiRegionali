package it.gruppo4.controller;

import com.google.gson.Gson;
import dao.DAO;
import entity.Animale;
import entity.OrdineAppartenenza;
import entity.Parco;
import entity.Specie;
import entity.Vegetale;
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
public class VegetaleController {

    @Autowired
    @Qualifier("dao01")
    private DAO d;

    @RequestMapping(value = "animale/findallvegetali.htm", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findAll(HttpServletRequest request) {
        Gson g = new Gson();
        List<Vegetale> findAll = d.getVegetaleDao().findAll();

        return g.toJson(findAll);
    }

    @RequestMapping(value = "animale/findvegetalebyname.htm", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findByName(HttpServletRequest request) {
        Gson g = new Gson();
        Vegetale v = d.getVegetaleDao().findByName(request.getParameter("nome"));

        return g.toJson(v);
    }

    @RequestMapping(value = "animale/insertvegetale.htm", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded; charset=UTF-8", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String saveAnimale(HttpServletRequest request) {
        Gson g = new Gson();

        return null;
    }
}
