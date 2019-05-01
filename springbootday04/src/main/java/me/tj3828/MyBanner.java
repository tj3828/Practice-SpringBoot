package me.tj3828;


import org.springframework.boot.Banner;
import org.springframework.core.env.Environment;

import java.io.PrintStream;

/**
 * @author tj3828
 */

public class MyBanner implements Banner {
    @Override
    public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out) {
        out.println("My Spring Boot Banner!!");
    }
}
