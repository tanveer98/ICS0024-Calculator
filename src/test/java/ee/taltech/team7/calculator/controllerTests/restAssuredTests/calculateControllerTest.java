package ee.taltech.team7.calculator.controllerTests.restAssuredTests;

import io.restassured.RestAssured;
import org.apache.http.HttpStatus;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

//rest assured mvc tests for this controller
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class calculateControllerTest {
    //TODO'S: Integration test using restAssured
    // 1. Same values return zero
    // 2. Negative values work
    // 3. Positive values work

    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void positive_values_work() {
        given()
                .when()
                .contentType("application/json")
                .get("/calculate?v=1,2,3,4,5,6")
                .then()
                .statusCode(200)
                .body("squaredValue", equalTo(25));
    }

    @Test
    public void negative_values_work() {
        given()
                .when()
                .contentType("application/json")
                .get("/calculate?v=-1,-2,-3,-4,-5,-6")
                .then()
                .statusCode(200)
                .body("squaredValue", equalTo(25));
    }

    @Test
    public void same_values_return_zero() {
        given()
                .when()
                .contentType("application/json")
                .get("/calculate?v=5,5,5,5,5")
                .then()
                .statusCode(200)
                .body("squaredValue", equalTo(0));
    }

    @Test
    public void overflowed_input_returns_bad_request() {
        String url = "/calculate?v=";
        url = url + Long.toString(Long.MAX_VALUE);
        url += ",";
        url += Long.toString(0);

        System.out.println(url);

        given()
                .when()
                .contentType("application/json")
                .get(url)
                .then()
                .statusCode(HttpStatus.SC_BAD_REQUEST);
    }

}
