import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class petStores {


    @Test
    public void getSingleMember() {

        RestAssured.given().baseUri("http://localhost:5002/api")
                .auth().basic("admin", "admin")
                .when()
                .get("authors/01")
                .prettyPrint();

    }

    @Test
    public void getSingleAuthor() {


        RestAssured.given()
                .baseUri("http://localhost:5002/api")
                .auth().basic("admin", "admin")
                .when().get("authors/2")
                .prettyPrint();

    }

    @Test
    public void createMember() {

        RestAssured.given()
                .baseUri("http://localhost:5002/api")
                .auth().basic("admin", "admin")
                .header("content-type", "application/json")
                .body("{\n" +
                        "        \"name\": \"Alpha\",\n" +
                        "        \"gender\":\"Male\"\n" +
                        "}")
                .when().post("members")
                .prettyPrint();

    }

    @Test
    public void putMember() {

        RestAssured.given().baseUri("http://localhost:5002/api")
                .auth().basic("admin", "admin")
                .header("content-type", "application/json")
                .body("{\n" +
                        "        \"name\": \"AlphaDog\",\n" +
                        "        \"gender\": \"Male\"\n" +
                        "}")
                .when().put("members/5")
                .prettyPrint();
    }

    @Test
    public void DeleteMember() {


        RestAssured.given()
                .baseUri("http://localhost:5002/api")
                .auth().basic("admin", "admin")
                .header("content-type", "application/json")
                .when().delete("members/5")
                .prettyPrint();
    }
}
