package it.gruppo4.controller;

/**
 *
 * @author Gjergjaj Albert
 */
import com.google.gson.Gson;
import dao.*;
import entity.*;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerMultiMap {

    @Autowired
    @Qualifier("dao01")
    private DAO d;

    @RequestMapping(value = "/findall.htm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String animaleFindAll(HttpServletRequest request) {
        List<Animale> listaN = d.getAnimaleDao().findAll();
        Gson g = new Gson();

        return (g.toJson(listaN));
    }

    @RequestMapping(value = "/findbyname.htm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String animaleFindByName(HttpServletRequest request) {
        String nome = request.getParameter("nome");

        Animale a = d.getAnimaleDao().findByName(nome);
        Gson g = new Gson();

        return (g.toJson(a));
    }

    @RequestMapping(value = "/insertanimale.htm", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    @ResponseBody
    public String insertAnimale(HttpServletRequest request, Animale animale) {
        Gson g = new Gson();
        Animale s = new Animale();

        d.getAnimaleDao().save(animale);

        return g.toJson(animale);
    }

    @RequestMapping(value = "/deleteanimale.htm", method = RequestMethod.POST, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String deleteAnimale(HttpServletRequest request) {
        String valore = request.getParameter("nome");

        //d.getPersonaDao().deletePersona(valore);
        return "Deleted " + valore;
    }
}
