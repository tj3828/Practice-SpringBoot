package me.tj3828;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

/**
 * @author tj3828
 */

@Component
public class BroadCastConverter implements Converter<String,BroadCast> {

    @Override
    public BroadCast convert(String s) {

        BroadCast broadCast = new BroadCast();
        broadCast.setId(Integer.valueOf(s));
        return broadCast;

    }
}
