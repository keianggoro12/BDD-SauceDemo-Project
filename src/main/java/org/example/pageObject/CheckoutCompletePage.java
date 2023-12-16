package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutCompletePage {

    public static WebDriver webDriver;
    public CheckoutCompletePage(WebDriver driver){
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }
    @FindBy(xpath = "//div[@id='checkout_complete_container']")
    private WebElement verifyCOComplete;
    @FindBy(xpath = "//button[@id='back-to-products']")
    private WebElement buttonBackHome;

    public boolean verifyCOComplete(){
        return verifyCOComplete.isDisplayed();
    }
    public void clickBackHomeButton(){
    buttonBackHome.click();
    }

}
