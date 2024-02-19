package HomePage_LeaveMessageForm;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.testng.Assert;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class HomePage_LeaveMessageFormInteraction {
    public static SelenideElement
            leaveMessageForm = $(By.xpath("//span[contains(text(),'Leave Us a Message')]")),
            nameField = $(By.xpath("//input[@id='userName']")),
            nameFieldError = $(By.xpath("//span[@id='userNameError']")),
            phoneField = $(By.xpath("//input[@id='userPhone']")),
            phoneFieldError = $(By.xpath("//span[@id='userPhoneError']")),
            emailField = $(By.xpath("//input[@id='userEmail']")),
            emailFieldError = $(By.xpath("//span[@id='userEmailError']")),
            companyField = $(By.xpath("//input[@id='company']")),
            companyFieldError = $(By.xpath("//span[@id='companyError']")),
            whatKindOfProjectUHaveField = $(By.xpath("//textarea[@id='userMessage']")),
            privacyPolicyBoxError = $(By.xpath("//span[@id='termsError']")),
            checkBoxPP =$(By.xpath("//div[@class = 'input-group policy-terms label']")),
            businessEmailLink = $(By.xpath("//span[@class='card__mail']")),
            buttonLetsTalk = $(By.xpath("//button[@id='letsTalkBtn']"));

public static void NameFieldValidationMessage(){
    leaveMessageForm.scrollTo();
    nameField.clear();
    phoneField.clear();
    phoneField.sendKeys("123456890");
    emailField.clear();
    emailField.sendKeys("email@mail.com");
    companyField.clear();
    companyField.sendKeys("Axamit");
    whatKindOfProjectUHaveField.clear();
    whatKindOfProjectUHaveField.sendKeys("Test Lorem ipsum sit amet dolor");
    checkBoxPP.scrollTo();
    checkBoxPP.doubleClick();
    buttonLetsTalk.click();
    Assert.assertEquals( nameFieldError.shouldBe(visible),nameFieldError.shouldBe(visible),"The validation message for the field Name is not displayed");
}

public static void PhoneFieldValidationMessage(){
    leaveMessageForm.scrollTo();
    nameField.clear();
    nameField.sendKeys("Some Name");
    phoneField.clear();
    emailField.clear();
    emailField.sendKeys("email@mail.com");
    companyField.clear();
    companyField.sendKeys("Axamit");
    whatKindOfProjectUHaveField.clear();
    whatKindOfProjectUHaveField.sendKeys("Test Lorem ipsum sit amet dolor");
    checkBoxPP.click();
    buttonLetsTalk.click();
    Assert.assertEquals( phoneFieldError.shouldBe(visible),phoneFieldError.shouldBe(visible),"The validation message for the field Phone is not displayed");
}
    public static void EmailFieldValidationMessage(){
        leaveMessageForm.scrollTo();
        nameField.clear();
        nameField.sendKeys("Some Name");
        phoneField.clear();
        phoneField.sendKeys("12345678890");
        emailField.clear();
        companyField.clear();
        companyField.sendKeys("Axamit");
        whatKindOfProjectUHaveField.clear();
        whatKindOfProjectUHaveField.sendKeys("Test Lorem ipsum sit amet dolor");
        checkBoxPP.click();
        buttonLetsTalk.click();
        Assert.assertEquals( emailFieldError.shouldBe(visible),emailFieldError.shouldBe(visible),"The validation message for the field Email is not displayed");
    }
    public static void CompanyFieldValidationMessage(){
        leaveMessageForm.scrollTo();
        nameField.clear();
        nameField.sendKeys("Some Name");
        phoneField.clear();
        phoneField.sendKeys("12345678890");
        emailField.clear();
        emailField.sendKeys("email@email.com");
        companyField.clear();
        whatKindOfProjectUHaveField.clear();
        whatKindOfProjectUHaveField.sendKeys("Test Lorem ipsum sit amet dolor");
        checkBoxPP.click();
        buttonLetsTalk.click();
        Assert.assertEquals( companyFieldError.shouldBe(visible),companyFieldError.shouldBe(visible),"The validation message for the field Company is not displayed");
    }
    public static void CheckBoxValidationMessage(){
        leaveMessageForm.scrollTo();
        nameField.clear();
        nameField.sendKeys("Some Name");
        phoneField.clear();
        phoneField.sendKeys("12345678890");
        emailField.clear();
        emailField.sendKeys("email@email.com");
        companyField.clear();
        companyField.sendKeys("Axamit");
        whatKindOfProjectUHaveField.clear();
        whatKindOfProjectUHaveField.sendKeys("Test Lorem ipsum sit amet dolor");
       // checkBoxPP.click();
        buttonLetsTalk.click();
        Assert.assertEquals( privacyPolicyBoxError.shouldBe(visible),privacyPolicyBoxError.shouldBe(visible),"The validation message for the Privacy Policy Check Box is not displayed");
    }

}
