package me.tj3828;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author tj3828
 */

@Controller
public class BookFunctionalHandler {

    public Mono<ServerResponse> allBooks(ServerRequest request) {
        Book book1 = new Book();
        book1.setIsbn("1123");
        book1.setTitle("Boot Spring Boot");

        Book book2 = new Book();
        book2.setIsbn("1123");
        book2.setTitle("Boot Spring Framework5");

        Flux<Book> books = Flux.just(book1, book2);

        // Publisher 타입의 객체를 body에 넘길 수 있음. -> Flux나 Mono 타입 둘다 넘길 수 있음.
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON).body(books, Book.class);
    }

}
