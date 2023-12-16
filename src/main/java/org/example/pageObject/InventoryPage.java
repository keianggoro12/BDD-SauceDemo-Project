package org.example.pageObject;

import io.cucumber.java.eo.Se;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class InventoryPage {
    public static WebDriver webDriver;
    public InventoryPage(WebDriver driver){
        PageFactory.initElements(driver,this);
        webDriver = driver;
    }

    @FindBy(xpath = "//select[@class='product_sort_container']")
    private WebElement selectSort;

    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-onesie']")
    private WebElement selectProduct1;
    @FindBy(xpath = "//button[@id='remove-sauce-labs-onesie']")
    private WebElement verifyRemovebuttonProduct1;
    @FindBy(xpath = "//button[@id='add-to-cart-sauce-labs-bike-light']")
    private WebElement selectProduct2;

    @FindBy(xpath = "//div[@id='shopping_cart_container']")
    private WebElement buttonCart;


//    ini batasannya ==================

    public void sortProduct(String filtersort){
        Select sort = new Select(selectSort);
        sort.selectByVisibleText(filtersort);
    }
    public void clickCart(){
        buttonCart.click();
    }

    public void clickAddToCartProduct(String selectproduct){
        String xpath = "//div[contains(text(),'"+ selectproduct + "')]/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";
        webDriver.findElement(By.xpath(xpath)).click();
    }

    public boolean verifyRemovebuttonproduct(String removeproduct) {
        String xpath = "//div[contains(text(),'"+ removeproduct + "')]/ancestor::div[@class='inventory_item']//button[text()='Remove']";
        return webDriver.findElement(By.xpath(xpath)).isDisplayed();
    }

}
