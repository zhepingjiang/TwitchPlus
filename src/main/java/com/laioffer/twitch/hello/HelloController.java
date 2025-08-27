package com.laioffer.twitch.hello;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Person sayHello() {
        return new Person(
                "John",
                "Laioffer",
                new Address("...", "SF", "CA", "US"),
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
