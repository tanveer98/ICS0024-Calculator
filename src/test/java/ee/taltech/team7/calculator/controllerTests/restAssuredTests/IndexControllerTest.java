package ee.taltech.team7.calculator.controllerTests.restAssuredTests;

import io.restassured.RestAssured;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

//rest assured mvc tests for this controller
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class IndexControllerTest {
    @LocalServerPort
    int port;

    @Before
    public void setUp() {
        RestAssured.port = port;
    }

    @Test
    public void index_runs() {
        String response = given()
                .when()
                .get("/")
                .then()
                .statusCode(200)
                .assertThat()
                .extract().body().asString();
        assertEquals(response,"Greeting stranger");
        assertNotEquals(response, "test");
    }
}
