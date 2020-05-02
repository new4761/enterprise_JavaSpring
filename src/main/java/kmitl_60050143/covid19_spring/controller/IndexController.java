package kmitl_60050143.covid19_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping
    public String swagger() {
        return "redirect:/swagger-ui.html";
    }
}
