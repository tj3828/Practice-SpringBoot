package me.tj3828;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author tj3828
 */

@RestController
public class BookAnnotationController {

    @GetMapping("/foo")
    public String getFoo() {
        return "tj3828";
    }

    @GetMapping("/flux")
    public Flux<String> getFlux() {
        return Flux.just("a", "b", "c");
    }

    @GetMapping("/mono")
    public Mono<String> getMono() {
        return Mono.just("mono");
    }

}
