package hello;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RootController {

    @RequestMapping("/home")
    public String greeting() {
        //model.addAttribute("name", name);
        return "index";
    }

}