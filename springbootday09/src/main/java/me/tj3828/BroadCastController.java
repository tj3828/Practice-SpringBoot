package me.tj3828;

import org.springframework.hateoas.Link;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

/**
 * @author tj3828
 */

@RestController
public class BroadCastController {

    @CrossOrigin
    @GetMapping("/broadcast/{id}")
    public BroadCastReource getBroadCast(@PathVariable("id") BroadCast broadCast) {
        if(broadCast.getId() == 100) {
            throw new BroadCastException();
        }

        BroadCastReource broadCastReource = new BroadCastReource();
        broadCastReource.setTitle(broadCast.getId() + " 번째 방송 중입니다.");

        // new Link("http://localhost/broadcast/" + broadCast.getId())
        Link link = linkTo(BroadCastController.class).slash("broadcast").slash(broadCast.getId()).withSelfRel();
        Link listLink = linkTo(BroadCastController.class).slash("broadcast").withRel("broadcastList");

        broadCastReource.add(link, listLink);

        return broadCastReource;
    }
}
