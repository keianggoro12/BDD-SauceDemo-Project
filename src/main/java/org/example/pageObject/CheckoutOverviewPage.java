package org.example.pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.apache.commons.lang3.StringUtils;

public class CheckoutOverviewPage {

    public static WebDriver webDriver;
    public CheckoutOverviewPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        webDriver = driver;
    }
    @FindBy(xpath = "//div[@id='checkout_summary_container']")
    private WebElement verifyCOSummaryContainer;

    @FindBy (xpath = "//button[@id='finish']")
    private WebElement buttonFinish;
    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    private WebElement subTotalElement;
    @FindBy(xpath = "//div[@class='summary_tax_label']")
    private WebElement taxElement;
    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    private WebElement totalElement;

    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[6]")
    private WebElement finalProductPrice;
    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[7]")
    private WebElement tax;
    @FindBy(xpath = "//*[@id='checkout_summary_container']/div/div[2]/div[8]")
    private WebElement total;



    
    public boolean verifyTotal() {
        double itemTotal = extractAmount(subTotalElement);
        double tax = extractAmount(taxElement);
        double actualTotal = itemTotal + tax;
        String totalText = totalElement.getText();

        return totalText.contains(String.format("$%.2f", actualTotal));
    }
    private double extractAmount(WebElement element) {
        String text = element.getText();
        String amountStr = text.replaceAll("[^\\d.]", ""); // Remove non-digit characters
        return Double.parseDouble(amountStr);
    }
    public void clickFinish(){
        buttonFinish.click();
    }

    public String getProductPrice(String product) {
        String productLocator = "//div[contains(text(),'" + product + "')]/ancestor::div[@class='cart_item']/descendant::div[@class='item_pricebar']/div[@class='inventory_item_price']";
        return webDriver.findElement(By.xpath(productLocator)).getText();
    }
    
    public String getFinalProductPrice() {
        return finalProductPrice.getText();
    }
    
    public String getTaxAmount() {
        return tax.getText();
    }
    
    public String calculateTax() {
        String totalProductPrice = getFinalProductPrice();
        String totalAmount = StringUtils.getDigits(totalProductPrice);
        double totalPrice = Double.parseDouble(totalAmount);
        double expectedTaxValue = Math.ceil((8.00 / 100.00) * totalPrice) / 100;
        String expectedTax = Double.toString(expectedTaxValue);
        return expectedTax;
    }
    
    public String getTotalAmount() {
        return total.getText();
    }
    
    public String calculateTotalCheckout() {
        String totalProductPrice = getFinalProductPrice();
        String totalAmount = StringUtils.getDigits(totalProductPrice);
        double totalPrice = Double.parseDouble(totalAmount) / 100;
        String taxAmount = calculateTax();
        String taxDigits = StringUtils.getDigits(taxAmount);
        double taxValue = Double.parseDouble(taxDigits) / 100;
        double totalCheckout = totalPrice + taxValue;
        String totalCheckoutAmount = Double.toString(totalCheckout);
        return totalCheckoutAmount;
    }
    

}
