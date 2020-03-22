package it.gruppo4.controller;

/**
 *
 * @author albert
 */

import com.google.gson.Gson;
import it.gruppo4.dao.Dao;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerMultiMap
{

    @Autowired
    @Qualifier("dao1")
    private Dao dao;

    @RequestMapping(value = "/findanimali.htm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findAll()
    {
        Gson g = new Gson();
        String gson = g.toJson(dao.getAnimaleDao().findAll());

        return gson;
    }

    @RequestMapping(value = "/findbyname.htm", method = RequestMethod.GET, produces = "application/json;charset=UTF-8")
    @ResponseBody
    public String findByName(HttpServletRequest request)
    {
        String nomeEsemplare = request.getParameter("nome");
        
        Gson g = new Gson();
        
        return g.toJson(dao.getAnimaleDao().findByName(nomeEsemplare));
    }
}
