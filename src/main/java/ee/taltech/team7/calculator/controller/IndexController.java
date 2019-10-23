package ee.taltech.team7.calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p> This is class contaims the controller for the index page. All the request sent
 * to the base url gets redirected here!</p>
 * @since v1.0
 */

@RestController
@RequestMapping("/")
public class IndexController {

    /**
     * <p> This is the default method invoked when visiting the base url</p>
     *
     * @return returns the default greeting as a string
     */
    @GetMapping
    public String greeting() {
            return "Greeting stranger";
    }

    /**
     *
     * @param name some string you want to echo
     * @return a string with Welcome appended with the argument string
     */

    @GetMapping("/name/{name}")
    public String greeting(@PathVariable String name) {
        name = name.strip();
        return "Welcome  " + name;
    }

    /**
     * <p> all requests mapped to base-url/swagger goes to this method, it simply redirects to the
     * swagger page</p>
     * @param response HttpServletResponse object, injected by spring. used to redirect
     * @throws IOException
     */
    @GetMapping("/swagger")
    public void swagger(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }
}

