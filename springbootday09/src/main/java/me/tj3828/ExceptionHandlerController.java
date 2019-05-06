package me.tj3828;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author tj3828
 */

@ControllerAdvice
public class ExceptionHandlerController {

    @ExceptionHandler(BroadCastException.class)
    public ResponseEntity<String> handlerException(BroadCastException e) {
        return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);  // 418코드 반환
    }

}
