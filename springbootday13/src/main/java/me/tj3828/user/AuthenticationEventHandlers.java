package me.tj3828.user;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationFailureBadCredentialsEvent;
import org.springframework.stereotype.Component;

/**
 * @author tj3828
 */

@Component
public class AuthenticationEventHandlers {

    @EventListener
    public void handleBadCredential(AuthenticationFailureBadCredentialsEvent event) {
        System.out.println(event.getAuthentication().getPrincipal() + " 접속 시도...");
        System.out.println("비밀번호가 틀렸습니다.");
    }

}


