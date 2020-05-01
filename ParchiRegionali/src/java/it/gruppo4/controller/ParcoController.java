package it.gruppo4.controller;

import com.google.gson.Gson;
import dao.DAO;
import entity.Parco;
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
public class ParcoController {

    @Autowired
    @Qualifier("dao01")
    private DAO d;

    @RequestMapping(value = "parco/findparchi.htm", method = RequestMethod.GET, produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String findAllParchi(HttpServletRequest request) {
        Gson g = new Gson();
        List<Parco> parchi = d.getParcoDao().findAll();

        return g.toJson(parchi);
    }

    @RequestMapping(value = "parco/insertparco.htm", method = RequestMethod.POST, consumes = "application/x-www-form-urlencoded; charset=UTF-8", produces = "application/json; charset=UTF-8")
    @ResponseBody
    public String saveParco(HttpServletRequest request) {
        Gson g = new Gson();
        String nomeParco = request.getParameter("nomeParco");
        Parco p = new Parco();
        p.setNomeParco(nomeParco);

        d.getParcoDao().save(p);

        return g.toJson(p);
    }
}
