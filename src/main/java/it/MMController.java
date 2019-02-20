package it;

import it.controller.GameController;
import it.services.MasterService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@Controller
public class MMController {
    private MasterService masterService = new MasterService();
    private GameController gameController = new GameController();
    private int tmpTent;

    @RequestMapping("/")
    public String home() {
        return "index";
    }

    @PostMapping("/user")
    public String getUser(HttpServletRequest request) {

        masterService.setUsernameSaved(request.getParameter("nome_user"));
        request.getSession().setAttribute("nome_user", masterService.getUsernameSaved());
        masterService.generaMaster();
        gameController.resetTentativi();
        tmpTent = gameController.getTentativi();
        request.getSession().setAttribute("tent", tmpTent);
        return "gioco";
    }

    @PostMapping("/tenta")
    public String tenta(HttpServletRequest request) {

        try {
            ArrayList<Integer> utente_prova = new ArrayList<>();

            String tent1 = request.getParameter("tent_num1");
            String tent2 = request.getParameter("tent_num2");
            String tent3 = request.getParameter("tent_num3");
            //Converto in ArrayList(INTEGER)
            utente_prova.add(Integer.parseInt(tent1));
            utente_prova.add(Integer.parseInt(tent2));
            utente_prova.add(Integer.parseInt(tent3));

            request.getSession().getAttribute("nome_user");

            //PROVIAMO QUA
            masterService.setCombUser(utente_prova);

            int[] chekkato = masterService.eseguiConfronto();

            if(chekkato[0] == 3)
            {
                return "vittoria";
            }
            else if(tmpTent > 1) {
                    tmpTent--;
                    request.setAttribute("pos_n", chekkato[0]);
                    request.setAttribute("giu_n", chekkato[1]);
                    request.setAttribute("tent", tmpTent);
                    request.getSession().setAttribute("tent", tmpTent);

                    //Stampo a console come CHECK personale
                    for (int n : utente_prova) {
                        System.out.print(n + " ");
                    }
                    System.out.println(" ");
                    return "gioco";
                }else {
                    return "sconfitta";
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return "gioco";
        }
    }

    @PostMapping("/win")
    public String winner(HttpServletRequest request)
    {
        request.getSession().getAttribute("nome_user");
        request.getSession().getAttribute("tent");

        return "vittoria";
    }

    @PostMapping("/loose")
    public String looser(HttpServletRequest request)
    {
        request.getSession().getAttribute("nome_user");
        return "sconfitta";
    }
}
