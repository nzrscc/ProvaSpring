package it;

import org.springframework.boot.web.servlet.server.Session;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@Controller
public class MMController {
    private String userName;

    @RequestMapping("/")
    public String home() {

        return "index";
    }

    @PostMapping
    public String getUser(HttpServletRequest request, HttpServletResponse response) {

        String nome = request.getParameter("nome_user");
        request.getSession().setAttribute("nome", nome);
        return "gioco";
    }

    @PostMapping("/tenta")
    public String tenta(HttpServletRequest request) {

        String tent1 = request.getParameter("tent_num1");
        String tent2 = request.getParameter("tent_num2");
        String tent3 = request.getParameter("tent_num3");

        request.getSession().getAttribute("nome");

        request.setAttribute("tent_num1", tent1);
        request.setAttribute("tent_num1", tent2);
        request.setAttribute("tent_num1", tent3);

        return "gioco";

    }
}
