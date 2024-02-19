package HomePage_DiscussProjectForm;

import Authorization.PageLinks;
import QaseIntegration.RecordTestRunResult;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.Assert;
import Cookies.GDPRBarAccept;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static com.codeborne.selenide.Condition.visible;


public class CORP41_StepTwoValidationCheck {
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
        HomePage_DiscussProjectFormInteraction.Step2FormDisplayed();
    }

    @Test(suiteName = "Validation message is displayed for email field_Step2")
    public void stepTwoEmailFieldValidationMessage() {
        HomePage_DiscussProjectFormInteraction.EmailValidationMessage();
        Boolean assertResult = HomePage_DiscussProjectFormInteraction.emailFieldValidationMessage.is(visible);
        resultMap.put("stepTwoEmailFieldValidationMessage()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for Email field is not displayed");
    }

    @Test(suiteName = "Validation message is displayed for Details field_Step2")
    public void stepTwoDetailsFieldValidationMessage() {
        HomePage_DiscussProjectFormInteraction.DescribeYourProjectValidationMessage();
        Boolean assertResult = HomePage_DiscussProjectFormInteraction.detailsFieldValidationMessage.is(visible);
        resultMap.put("stepTwoDetailsFieldValidationMessage()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for Details field is not displayed");
    }

    @Test(suiteName = "Validation message is displayed for Check box_Step2")
    public void stepTwoCheckBoxValidationMessage() {
        HomePage_DiscussProjectFormInteraction.PrivacyPolicyCheckBoxValidationMessage();
        Boolean assertResult = HomePage_DiscussProjectFormInteraction.privacyCheckBoxValidationMessage.is(visible);
        resultMap.put("stepTwoCheckBoxValidationMessage()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for checkbox is not displayed");
    }
    @AfterTest
    public void checkCase41Result() {
        Boolean case41Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case41Res = false;
            }
        }
        if (case41Res) {
            RecordTestRunResult.passedTestRunRecord("41");
        } else {
            RecordTestRunResult.failedTestRunRecord("41");
        }
    }
}