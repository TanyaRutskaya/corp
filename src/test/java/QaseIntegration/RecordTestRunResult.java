package QaseIntegration;

import io.restassured.http.ContentType;
import io.restassured.response.ResponseBody;

import static io.restassured.RestAssured.given;

public class RecordTestRunResult {
    public static void failedTestRunRecord(String case_id){

        ResponseBody responseBody=
                given().baseUri(QaseAPIRequests.recordResult())
                        .accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Token", "fecad3817386adfc1575d557adc74cec654a3d7a5bbed281b06afb4102a5458f").
                        body("{\"case_id\":"+ case_id +",\"status\":\"failed\"}").
                        when().
                        post().
                        thenReturn().body();

        System.out.println(responseBody.asPrettyString());
    }
    public static void passedTestRunRecord(String case_id){

        ResponseBody responseBody=
                given().baseUri(QaseAPIRequests.recordResult())
                        .accept(ContentType.JSON).
                        contentType(ContentType.JSON).
                        header("Token", "fecad3817386adfc1575d557adc74cec654a3d7a5bbed281b06afb4102a5458f").
                        body("{\"case_id\":" + case_id +",\"status\":\"passed\"}").
                        when().
                        post().
                        thenReturn().body();

        System.out.println(responseBody.asPrettyString());
    }
}
