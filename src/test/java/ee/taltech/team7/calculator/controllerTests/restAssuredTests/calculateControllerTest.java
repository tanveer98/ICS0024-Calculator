package ee.taltech.team7.calculator.controllerTests.restAssuredTests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//rest assured mvc tests for this controller
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class calculateControllerTest {

    @LocalServerPort
    int port;
    private String query = "/c?v=" ;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void positive_values_work() {
        request(query+"=1,2,3,4,5,6", HttpStatus.SC_OK,"squaredValue", 25);
    }

    @Test
    public void negative_values_work() {
        request(query+"1,2,3,4,5", HttpStatus.SC_OK,"squaredValue", 16);

    }

    @Test
    public void mixed_values_work() {
        request(query+"-10,56,2,100", HttpStatus.SC_OK,"squaredValue", (110*110));
    }

    @Test
    public void same_values_return_zero() {
        request(query+"5,5,5,5",HttpStatus.SC_OK,"squaredValue",0);
    }

    @Test
    public void overflowed_input_returns_bad_request() {

        String url = String.format(query+"%d,%d,%d", Long.MAX_VALUE, 0, -2);
        request(url, HttpStatus.SC_BAD_REQUEST, "status", HttpStatus.SC_BAD_REQUEST);
    }

    @Test
    public void null_parameter_returns_bad_request() {
        String url = query+"=3,5,%00";
        request(url, HttpStatus.SC_BAD_REQUEST, "status", HttpStatus.SC_BAD_REQUEST);
    }


    public void request(String url, int statusCode, String jsonPath, int expectedValue) {
        given()
                .when()
                .contentType("application/json")
                .get(url)
                .then()
                .statusCode(statusCode)
                .body(jsonPath,equalTo(expectedValue));

    }
}
