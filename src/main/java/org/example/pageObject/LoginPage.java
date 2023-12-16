package org.example.pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public static WebDriver webDriver;
    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver = driver;
    }
    @FindBy(xpath = "//input[@id='user-name']")
    private WebElement fieldUsername;
    @FindBy(xpath = "//input[@id='password']")
    private WebElement fieldPassword;
    @FindBy(xpath = "//input[@id='login-button']")
    private WebElement buttonLogin;
    @FindBy(xpath = "//button[@id='react-burger-menu-btn']")
    private WebElement buttonBurger;

//    Ini pembatasnya =====================
    public boolean verifyfieldUsername(){
        return fieldUsername.isDisplayed();
    }
    public void inputfieldUsername(String username){
        fieldUsername.sendKeys(username);
    }
    public void inputfieldPassword(String password){
        fieldPassword.sendKeys(password);
    }
    public void clickloginbutton(){
        buttonLogin.click();
    }
    public boolean verifybuttonburger(){
        return buttonBurger.isDisplayed();
    }

}
