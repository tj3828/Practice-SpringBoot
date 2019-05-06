package me.tj3828;

import org.springframework.boot.web.servlet.error.ErrorController;

/**
 * @author tj3828
 */
public class MyErrorController implements ErrorController {

    @Override
    public String getErrorPath() {
        return null;
    }
}
