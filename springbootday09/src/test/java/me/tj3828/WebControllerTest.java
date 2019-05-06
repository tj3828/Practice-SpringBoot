package me.tj3828;

import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

/**
 * @author tj3828
 */


public class WebControllerTest {

    @Test
    public void helloTest() {
        WebController webController = new WebController();
        Model model = new ExtendedModelMap();

        webController.thymeleaf(model, "tak");

        model.asMap().forEach((k,v) -> System.out.println("key: " + k + " value: " + v));
    }

}
