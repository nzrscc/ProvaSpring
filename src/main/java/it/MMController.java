package it;

import it.services.MasterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;


@Controller
public class MMController {
    private MasterService masterService = new MasterService();
    private ArrayList<Integer> master;
    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/user")
    public String getUser(HttpServletRequest request, HttpServletResponse response) {

        String nome = request.getParameter("nome_user");
        request.getSession().setAttribute("nome_user", nome);
        master = masterService.generaMaster();
        for (int n : master)
            System.out.print("Master " + n + " - ");
        return "gioco";
    }

    @PostMapping("/tenta")
    public String tenta(HttpServletRequest request) {

        try {
            ArrayList<Integer> utente_prova = new ArrayList<>();


            String tent1 = request.getParameter("tent_num1");
            String tent2 = request.getParameter("tent_num2");
            String tent3 = request.getParameter("tent_num3");


            request.getSession().getAttribute("nome_user");


            utente_prova.add(Integer.parseInt(tent1));
            utente_prova.add(Integer.parseInt(tent2));
            utente_prova.add(Integer.parseInt(tent3));
            //Stampo a console come CHECK personale
            for (int n : utente_prova) {
                System.out.print(n + " ");
            }
            if(utente_prova.equals(master))
            {
               return "prova";
            }

            return "gioco";
        }catch (Exception e)
        {
            e.printStackTrace();
            return "gioco";
        }
    }
}
