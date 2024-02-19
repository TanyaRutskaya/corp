package QaseIntegration;

public class QaseAPIRequests {
    public static String getAllCases(){return "https://api.qase.io/v1/case/CORP";} //get
    public static String createNewTestRun(){return "https://api.qase.io/v1/run/CORP";} //post
    public static String getTestCase(){return " https://api.qase.io/v1/case/CORP/39";} //get
    public static String getTestPlan(){return "https://api.qase.io/v1/plan/CORP/1";}//get
    public static String recordResult(){return "https://api.qase.io/v1/result/CORP/1";}//post

}
