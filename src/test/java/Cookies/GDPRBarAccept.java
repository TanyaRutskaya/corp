package Cookies;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class GDPRBarAccept {
    public static SelenideElement
            buttonAcceptGDPR = $(By.xpath("//div/button[contains(text(),'Accept')]"));
    static public void  AcceptCookies(){
        buttonAcceptGDPR.click();
    }
}
