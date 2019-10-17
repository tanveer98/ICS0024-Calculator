package ee.taltech.team7.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/")
public class IndexController {

    @GetMapping
    public String greeting() {
            return "Greeting stranger";
    }

    @GetMapping("/name/{name}")
    public String greeting(@PathVariable String name) {
        name = name.strip();
        return "Welcome  " + name;
    }

    @GetMapping("/swagger")
    public void swagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}

