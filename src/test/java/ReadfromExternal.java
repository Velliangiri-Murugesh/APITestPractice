import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.io.File;

public class ReadfromExternal {

    @Test
    public void addMemberusingExternal(){

        File jsonfile=new File("Addfile.json");

        RestAssured.given()
                .baseUri("http://localhost:5002/api")
                .auth().basic("admin", "admin")
                .header("content-type", "application/json")
                .body(jsonfile)
                .when().post("members")
                .prettyPrint();

    }
}
