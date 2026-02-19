package postman.echo.tests;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class RequestMethodsTests {

    private static final String BASE_URL = "https://postman-echo.com";

    @Test
    public void testGetMethod() {
        given()
                .baseUri(BASE_URL)
                .param("foo1", "bar1")
                .param("foo2", "bar2")
                .when()
                .get("/get")
                .then()
                .statusCode(200)
                .body("args.foo1", equalTo("bar1"))
                .body("args.foo2", equalTo("bar2"));
    }

    @Test
    public void testPostMethod() {
        String requestBody = "{ \"name\": \"John\", \"age\": 30 }";

        given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)

                .body("json.name", equalTo("John"))
                .body("json.age", equalTo(30));

    }

    @Test
    public void testPutMethod() {
        String requestBody = "{ \"name\": \"Jane\", \"job\": \"QAEngineer\" }";

        given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .put("/put")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("Jane"))
                .body("json.job", equalTo("QAEngineer"));
    }

    @Test
    public void testPatchMethod() {
        String requestBody = "{ \"name\": \"Mike\" }";

        given()
                .baseUri(BASE_URL)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .when()
                .patch("/patch")
                .then()
                .statusCode(200)
                .body("json.name", equalTo("Mike"));
    }

    @Test
    public void testDeleteMethod() {
        given()
                .baseUri(BASE_URL)
                .when()
                .delete("/delete")
                .then()
                .statusCode(200);
    }
}