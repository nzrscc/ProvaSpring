package it;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class MMController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
