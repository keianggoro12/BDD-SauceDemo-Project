package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CheckoutFormPage {

    public static WebDriver webDriver;
    public CheckoutFormPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }
    @FindBy(xpath = "//input[@id='first-name']")
    private WebElement fieldFirstname;
    @FindBy(xpath = "//input[@id='last-name']")
    private WebElement fieldLastname;
    @FindBy(xpath = "//input[@id='postal-code']")
    private WebElement fieldPostcode;
    @FindBy(xpath = "//input[@id='continue']")
    private WebElement buttonContinue;
    @FindBy(xpath = "//div[@class='checkout_info']")
    private WebElement COFormWrapper;

    public boolean verifyCOFormWrapper(){
        return COFormWrapper.isDisplayed();
    }
    public void inputFirstname(String firstname){
        fieldFirstname.sendKeys(firstname);
    }
    public void inputLastname (String lastname){
        fieldLastname.sendKeys(lastname);
    }
    public void inputPostcode (String postcode){
        fieldPostcode.sendKeys(postcode);
    }
    public void clickContinue (){
        buttonContinue.click();
    }



}
