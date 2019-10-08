package ee.taltech.team7.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping()
    public String greeting() {
            return "Greeting stranger";
    }

    @GetMapping("/{name}")
    public String greeting(@PathVariable String name) {
        name = name.strip();
        return "Welcome  " + name;
    }
}

