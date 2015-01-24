package org.jboss.tools.example.springmvc.mvc;

import org.jboss.tools.example.springmvc.repo.DbConnection;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by janos on 2015.01.24..
 */

@Controller
@RequestMapping(value="/janos")
public class HomeController {

    @RequestMapping(method= RequestMethod.GET)
    public String string(ModelMap model) throws SQLException {
        String email = null;
        DbConnection dbConnection = new DbConnection("adminSgcCfIV", "QLp-6H8uCjzy", "127.4.117.2:3306/dbapp");
        dbConnection.conn();
        Statement stmt = dbConnection.getConnection().createStatement() ;
        String query = "select * from names;" ;
        ResultSet rs = stmt.executeQuery(query) ;
        while (rs.next()) {
           email = rs.getString(1);
        }
        model.addAttribute("email", email);
        return "janos";
    }
}
