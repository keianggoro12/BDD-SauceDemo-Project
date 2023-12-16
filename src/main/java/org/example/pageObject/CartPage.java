package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage {
    public static WebDriver webDriver;
    public CartPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver = driver;
    }
    @FindBy(xpath = "//div[@class='cart_list']")
    private WebElement fieldCartList;
    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement buttonCO;


    //    Ini pembatasnya =====================

    public boolean verifyCartPage(){
        return fieldCartList.isDisplayed();
    }

    public boolean verifySelectedProduct(String verifyproduct) {
        String quantityProduct = "//div[contains(text(),'"+ verifyproduct + "')]/ancestor::div[@class='cart_item']//div[text()='1']";
        return webDriver.findElement(By.xpath(quantityProduct)).isDisplayed();
    }
    public void removingSelectedProduct(String removing){
        String xpath = "//div[contains(text(),'"+ removing + "')]/ancestor::div[@class='cart_item']//button[text()='Remove']";
        webDriver.findElement(By.xpath(xpath)).click();
    }
    public void clickCOButton(){
        buttonCO.click();
    }




}
