package it;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
@Controller
public class MMController {

    @RequestMapping("/")
    public String home() {
        return "index";
    }
}
