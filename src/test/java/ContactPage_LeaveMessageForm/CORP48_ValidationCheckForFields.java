package ContactPage_LeaveMessageForm;

import Authorization.PageLinks;
import Cookies.GDPRBarAccept;
import HomePage_LeaveMessageForm.HomePage_LeaveMessageFormInteraction;
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

public class CORP48_ValidationCheckForFields {
    private static Map<String, Boolean> resultMap = new HashMap<String, Boolean>();

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        Configuration.browserSize = "1440x900";
    }

    @BeforeTest
    public void setupTest() {
        Selenide.open(PageLinks.qaPageContactUs());
        GDPRBarAccept.AcceptCookies();
    }
    @Test(suiteName = "Validation is displayed for the Name field")
    public static void NameFieldValidationIsDisplayed(){
        HomePage_LeaveMessageFormInteraction.NameFieldValidationMessage();
        Boolean assertResult = HomePage_LeaveMessageFormInteraction.nameFieldError.is(visible);
        resultMap.put("NameFieldValidationIsDisplayed()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for Name field is not displayed");
    }
    @Test(suiteName ="Validation is displayed for the Phone field")
    public static void PhoneFieldValidationMessageIsDisplayed(){
        HomePage_LeaveMessageFormInteraction.PhoneFieldValidationMessage();
        Boolean assertResult = HomePage_LeaveMessageFormInteraction.phoneFieldError.is(visible);
        resultMap.put("PhoneFieldValidationMessageIsDisplayed()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for Phone field is not displayed");
    }
    @Test(suiteName ="Validation is displayed for the Email field")
    public static void EmailFieldValidationMessageIsDisplayed(){
        HomePage_LeaveMessageFormInteraction.EmailFieldValidationMessage();
        Boolean assertResult = HomePage_LeaveMessageFormInteraction.emailFieldError.is(visible);
        resultMap.put("EmailFieldValidationMessageIsDisplayed()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for Email field is not displayed");
    }
    @Test(suiteName ="Validation is displayed for the Company field")
    public static void CompanyFieldValidationMessageIsDisplayed(){
        HomePage_LeaveMessageFormInteraction.CompanyFieldValidationMessage();
        Boolean assertResult = HomePage_LeaveMessageFormInteraction.companyFieldError.is(visible);
        resultMap.put("CompanyFieldValidationMessageIsDisplayed()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for Company field is not displayed");
    }

    @AfterTest
    public void checkCase48Result() {
        Boolean case48Res = true;
        for (String key : resultMap.keySet()) {
            if (!resultMap.get(key)) {
                case48Res = false;
            }
        }
        if (case48Res) {
            RecordTestRunResult.passedTestRunRecord("48");
        } else {
            RecordTestRunResult.failedTestRunRecord("48");
        }
    }
}
