package HomePage_DiscussProjectForm;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class HomePage_DiscussProjectFormInteraction {
   public static SelenideElement

           formStep1 = $(By.xpath("//span[@id='step-counter' and (contains(text(),'Step 1'))]")),
           firstNameField = $(By.xpath("//input[@id='first_name']")),
           firstNameFieldValidationMessage = $(By.xpath("//div[@class='error show' and @id='first-error']")),
           lastNameField = $(By.xpath("//input[@id='last_name']")),
           lastNameFieldValidationMessage = $(By.xpath("//div[@class='error show' and @id='last-error']")),
           nextButtonStep1 = $(By.xpath("//button[@id='step-btn-1']")),
           emailField = $(By.xpath("//input[@class='input' and @id='email']")),
           phoneField = $(By.xpath("//input[@class='input' and @id='phone']")),
           privacyPolicyCheckBox = $(By.xpath("//label[@id='gradientCheckbox']")),
           sendButtonStep2 = $(By.xpath("//button[@id='submit-btn']")),
           emailFieldValidationMessage = $(By.xpath("//div[@id='email-error']")),
           describeYourProjectField = $(By.xpath("//textarea[@name='project' and @id='project']")),
           detailsFieldValidationMessage = $(By.xpath("//div[@id='project-error']")),
           formStep2 = $(By.xpath("//span[@id='step-counter' and (contains(text(),'Step 2'))]")),
           privacyCheckBoxValidationMessage = $(By.xpath("//div[@id='terms-error']")),
           backButtonStep2 =$(By.xpath("//button[@id='step-btn-back']"));

    public static void FirstNameFieldValidationMessage() {
        formStep1.scrollTo();
        formStep1.isDisplayed();
        firstNameField.clear();
        nextButtonStep1.click();
        Assert.assertEquals(HomePage_DiscussProjectFormInteraction.firstNameFieldValidationMessage.shouldBe(visible), HomePage_DiscussProjectFormInteraction.firstNameFieldValidationMessage, "The validation message for FirstName is not displayed");
    }

    public static void Step2FormDisplayed() {
        formStep1.scrollTo();
        formStep1.isDisplayed();
        lastNameField.clear();
        lastNameField.sendKeys("lastName");
        firstNameField.clear();
        firstNameField.sendKeys("FirstName");
        nextButtonStep1.click();
    }

    public static void LastNameFieldValidationMessage() {
        formStep1.scrollTo();
        formStep1.isDisplayed();
        lastNameField.clear();
        nextButtonStep1.click();
        Assert.assertEquals(HomePage_DiscussProjectFormInteraction.lastNameFieldValidationMessage.shouldBe(visible), HomePage_DiscussProjectFormInteraction.lastNameFieldValidationMessage, "The validation message for LastName is not displayed");
    }

    public static void FirstNameFieldValidationMessageCharactersCount() {
        formStep1.scrollTo();
        formStep1.isDisplayed();
        firstNameField.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ut nisi sed sem vestibulum sagittis. Vestibulum venenatis sodales finibus. Donec feugiat vitae dui ac scelerisque. Aenean fringilla enim ut metus mattis, eu imperdiet orci molestie. In id turpis bibendum, imperdiet neque porta, rhoncu");
        nextButtonStep1.click();
        Assert.assertEquals(HomePage_DiscussProjectFormInteraction.firstNameFieldValidationMessage.shouldBe(visible), HomePage_DiscussProjectFormInteraction.firstNameFieldValidationMessage, "The validation message for FirstName is not displayed");
    }

    public static void LastNameValidationMessageCharactersCount() {
        formStep1.scrollTo();
        formStep1.isDisplayed();
        lastNameField.sendKeys("Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi ut nisi sed sem vestibulum sagittis. Vestibulum venenatis sodales finibus. Donec feugiat vitae dui ac scelerisque. Aenean fringilla enim ut metus mattis, eu imperdiet orci molestie. In id turpis bibendum, imperdiet neque porta, rhoncu");
        nextButtonStep1.click();
        Assert.assertEquals(HomePage_DiscussProjectFormInteraction.lastNameFieldValidationMessage.shouldBe(visible), HomePage_DiscussProjectFormInteraction.lastNameFieldValidationMessage, "The validation message for LastName is not displayed");
    }

    public static void EmailValidationMessage() {
        if (!formStep2.isDisplayed()) {
            Step2FormDisplayed();
        } else {
            emailField.clear();
            describeYourProjectField.clear();
            describeYourProjectField.sendKeys("some text");
            privacyPolicyCheckBox.click();
            sendButtonStep2.click();
            Assert.assertEquals(HomePage_DiscussProjectFormInteraction.emailFieldValidationMessage.shouldBe(visible), HomePage_DiscussProjectFormInteraction.emailFieldValidationMessage, "The validation message for email field is not displayed");
        }
    }
    public static void DescribeYourProjectValidationMessage() {
        if (!formStep2.isDisplayed()) {
            Step2FormDisplayed();
        } else {
            emailField.clear();
            describeYourProjectField.clear();
            emailField.sendKeys("email@email.com");
            privacyPolicyCheckBox.click();
            sendButtonStep2.click();
            Assert.assertEquals(HomePage_DiscussProjectFormInteraction.detailsFieldValidationMessage.shouldBe(visible), HomePage_DiscussProjectFormInteraction.detailsFieldValidationMessage, "The validation message for Details field is not displayed");
        }
    }
    public static void PrivacyPolicyCheckBoxValidationMessage(){
if (!formStep2.isDisplayed()){
    Step2FormDisplayed();
} else {
        emailField.clear();
        describeYourProjectField.clear();
        emailField.sendKeys("email@email.com");
        describeYourProjectField.sendKeys("some text");
        sendButtonStep2.click();
        Assert.assertEquals(HomePage_DiscussProjectFormInteraction.privacyCheckBoxValidationMessage.shouldBe(visible), HomePage_DiscussProjectFormInteraction.privacyCheckBoxValidationMessage, "The validation message for check box is not displayed");
    }
     }
     public static void BackFromStepTwo(){
        if(!formStep2.isDisplayed()){
            Step2FormDisplayed();
        } else{
            describeYourProjectField.sendKeys("some text");
            backButtonStep2.click();
            Assert.assertEquals(HomePage_DiscussProjectFormInteraction.formStep1.shouldBe(visible),HomePage_DiscussProjectFormInteraction.formStep1, "The Step 2 is still displayed, after the back button is pressed" );
        }
     }
}