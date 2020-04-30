package kmitl_60050143.covid19_spring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Map;
    
@Controller
public class IndexController {
    @RequestMapping("/")
    public String next(Map<String, Object> model) {
        return "student";
    }
}
