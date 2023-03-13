import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class PostmanEchoTest {

    @Test
    void shouldReturnDate() {

        given()
                .baseUri("https://postman-echo.com")
                .body("04.09.2016")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("04.09.2016"))
        ;
    }

    @Test
    void shouldReturnText() {

        given()
                .baseUri("https://postman-echo.com")
                .contentType("text/plain; charset=UTF-8")
                .body("Шла Саша по Шоссе с сосала сушку")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .body("data", equalTo("Шла Саша по Шоссе с сосала сушку"))
        ;
    }
}
