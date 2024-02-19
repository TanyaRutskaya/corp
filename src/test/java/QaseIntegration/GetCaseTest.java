package QaseIntegration;

import io.restassured.response.ResponseBody;
import org.testng.annotations.BeforeTest;

import java.util.HashMap;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetCaseTest {
    private int planId ;
    private List cases=null;
    private HashMap result =null;
    private double caseId;

    @BeforeTest
    public void getTestPlanId() {
        ResponseBody body = given().queryParam(QaseAPIRequests.getTestPlan())
                .header("Token", "498fb3fd1772c5aa4d580efd256c02abf89bf9c9b3d10546bcbb0b5b29a3b197")
                .get(QaseAPIRequests.getTestPlan())
                .body();
        result = body.jsonPath().getObject("result", HashMap.class);
        planId = (int) result.get("id");
        cases = (List)result.get("cases");
        for (Object element:cases){
            HashMap element2=(HashMap) element;
            caseId = (int)element2.get("case_id");
            System.out.println(caseId);

            for (int i=0; i<caseId; i++){

            }

        }
    }
}
