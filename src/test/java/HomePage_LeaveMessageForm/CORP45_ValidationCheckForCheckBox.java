package HomePage_LeaveMessageForm;

import Authorization.PageLinks;
import Cookies.GDPRBarAccept;
import QaseIntegration.RecordTestRunResult;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;

public class CORP45_ValidationCheckForCheckBox {
    private static Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1440x900";
    }

    @BeforeTest
    public void setupTest() {
        Selenide.open(PageLinks.qaPageWithCreds());
        GDPRBarAccept.AcceptCookies();
        // HomePage_DiscussProjectFormInteraction.Step2FormDisplayed();
    }
    @Test(suiteName ="Validation is displayed for the Privacy Policy CheckBox")
    public static void CheckBoxPrivacyValidationMessageIsDisplayed(){
        HomePage_LeaveMessageFormInteraction.CheckBoxValidationMessage();
        Boolean assertResult = HomePage_LeaveMessageFormInteraction.privacyPolicyBoxError.is(visible);
        resultMap.put("CheckBoxPrivacyValidationMessageIsDisplayed()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for Check box Privacy Policy is not displayed");
    }
    @AfterTest
    public void checkCase45Result() {
        Boolean case45Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case45Res = false;
            }
        }
        if (case45Res) {
            RecordTestRunResult.passedTestRunRecord("45");
        } else {
            RecordTestRunResult.failedTestRunRecord("45");
        }
    }
}
