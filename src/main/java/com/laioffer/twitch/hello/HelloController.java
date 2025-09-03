package com.laioffer.twitch.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Person sayHello(@RequestParam(required = false) String name) {
        if (name == null) {
            name = "Guest";
        }

        return new Person(
                name,
                "Laioffer",
                new Address("...", "SF", "CA", null),
                new Book("Hobbit", "???")
        );
    }

    @GetMapping("/goodbye")
    public String sayGoodbye() {
        return "Goodbye World";
    }

    // This works
//    @GetMapping("/*bye")
//    public String sayGoodbye() {
//        return "Goodbye World";
//    }

}
