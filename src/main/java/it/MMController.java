package it;

import it.controller.GameController;
import it.services.MasterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
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
    public String getUser(@RequestParam("nome_user") String user, Model model) {

        masterService.setUsernameSaved(user);
        model.addAttribute("nome", masterService.getUsernameSaved());
        masterService.generaMaster();
        gameController.resetTentativi();
        this.tmpTent = gameController.getTentativi();

        return "gioco";
    }

    @PostMapping("/tenta")
    public String tenta(Model model, @RequestParam("tent_num1") String tent1, @RequestParam("tent_num2") String tent2, @RequestParam("tent_num3") String tent3) {

        try {
            ArrayList<Integer> utente_prova = new ArrayList<>();

            //Converto in ArrayList(INTEGER)
            utente_prova.add(Integer.parseInt(tent1));
            utente_prova.add(Integer.parseInt(tent2));
            utente_prova.add(Integer.parseInt(tent3));


            //PROVIAMO QUA
            masterService.setCombUser(utente_prova);
            model.addAttribute("nome", masterService.getUsernameSaved());
            int[] chekkato = masterService.eseguiConfronto();

            if(chekkato[0] == 3)
            {
                model.addAttribute("tent", gameController.getTentativi());
                return "vittoria";
            }
            else if(tmpTent > 1) {
                    tmpTent--;
                model.addAttribute("pos_n", chekkato[0]);
                model.addAttribute("giu_n", chekkato[1]);
                model.addAttribute("tent", tmpTent);

                model.addAttribute("tent_num1", tent1);
                model.addAttribute("tent_num2", tent2);
                model.addAttribute("tent_num3", tent3);

                    return "gioco";
                }else {
                model.addAttribute("nome", masterService.getUsernameSaved());
                    return "sconfitta";
            }
        }catch (Exception e)
        {
            e.printStackTrace();
            return "gioco";
        }
    }
}
