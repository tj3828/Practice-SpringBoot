package me.tj3828;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tj3828
 */

@Controller
public class WebController {

    /**
     * ViewName (String) -> ViewResolver -> View (View)
     */

    // based
    @GetMapping("${index.path}")
    public @ResponseBody String hello() {
        return "Hello";
    }

    // freemarker
    @GetMapping("/freemarker")
    public String freemarker(Model model, @RequestParam String name) {
        model.addAttribute("name", name); // key의 default는 타입의 이름.
        return "freemarker";
    }

    //thymeleaf
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model, @RequestParam String name) {
        model.addAttribute("name", name); // key의 default는 타입의 이름.
        return "thymeleaf";
    }


}
