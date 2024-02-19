package HomePage_DiscussProjectForm;

import Authorization.PageLinks;
import QaseIntegration.RecordTestRunResult;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import Cookies.GDPRBarAccept;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;

public class CORP43_BackFromStepTwo {
    private Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1440x900";
    }

    @BeforeTest
    public void setupTest() {
        Selenide.open(PageLinks.qaPageWithCreds());
        GDPRBarAccept.AcceptCookies();
    }
    @Test(suiteName= "Pressing Back Button at Step 2 Opens the Step 1")
    public void stepOneDisplayed_backButtonIsPressed(){
        HomePage_DiscussProjectFormInteraction.Step2FormDisplayed();
        HomePage_DiscussProjectFormInteraction.BackFromStepTwo();
        Boolean assertResult = HomePage_DiscussProjectFormInteraction.formStep1.is(visible);
        resultMap.put("stepOneDisplayed_backButtonIsPressed()", assertResult);
        Assert.assertTrue(assertResult, "The step 2 is still displayed, after back button is pressed");

    }
    @AfterTest
    public void checkCase43Result() {
        Boolean case43Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case43Res = false;
            }
        }
        if (case43Res) {
            RecordTestRunResult.passedTestRunRecord("43");
        } else {
            RecordTestRunResult.failedTestRunRecord("43");
        }
    }
}
