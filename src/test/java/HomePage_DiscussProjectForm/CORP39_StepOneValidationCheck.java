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

public class CORP39_StepOneValidationCheck {
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

    @Test(suiteName = "FirstName field validation message checks step 1")
    public void stepOneFirstNameFieldValidationMessage() {

        HomePage_DiscussProjectFormInteraction.FirstNameFieldValidationMessage();
        Boolean assertResult = HomePage_DiscussProjectFormInteraction.firstNameFieldValidationMessage.isDisplayed();
        resultMap.put("StepOneFirstNameFieldValidationMessage()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for FirstName field is not displayed");
    }

    @Test(suiteName = "LastName field validation message checks step 1")
    public void stepOneLastNameValidationMessage() {

        HomePage_DiscussProjectFormInteraction.LastNameFieldValidationMessage();
        Boolean assertResult = HomePage_DiscussProjectFormInteraction.lastNameFieldValidationMessage.isDisplayed();
        resultMap.put("StepOneLastNameFieldValidationMessage()", assertResult);
        Assert.assertTrue(assertResult, "The validation message for LastName field is not displayed");
    }

    //TO DO
    //    @Test(suiteName = "FirstName field validation message checks step 1_characters > 255")
//    public void stepOneFirstNameFieldValidationMessageCharactersExceed(){
//        HomePageDiscussProjectForm.FirstNameFieldValidationMessageCharactersCount();
//    }

//    @Test(suiteName= "LastName field validation message checks step 1_characters > 255")
//    public void stepOneLastNameFieldValidationMessageCharactersExceed(){
//        HomePageDiscussProjectForm.LastNameValidationMessageCharactersCount();
//    }
//
@AfterTest
public void checkCase446Result() {
    Boolean case39Res = true;
    for (String key : resultMap.keySet()) {
        if (!resultMap.get(key)) {
            case39Res = false;
        }
    }
    if (case39Res) {
        RecordTestRunResult.passedTestRunRecord("39");
    } else {
        RecordTestRunResult.failedTestRunRecord("39");
    }
}
}
