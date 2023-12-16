package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pageObject.CheckoutFormPage;
import org.example.pageObject.CheckoutOverviewPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.apache.commons.lang3.StringUtils;

import static org.junit.Assert.assertEquals;
import static step_definitions.Hooks.driver;

public class COOverviewSteps {

    private final WebDriver drive = driver;
    CheckoutOverviewPage cooverviewstep = new CheckoutOverviewPage(driver);


    @Then("User verify total amount is true")
    public void verifyTotal1(){
        boolean isTotalCorrect = cooverviewstep.verifyTotal();
        Assert.assertTrue(isTotalCorrect);
    }

    @When("User clicks the finish button")
    public void clickFinish(){
        cooverviewstep.clickFinish();
    }
    
    @Then("Verify the price of product {string} should be equal to the total price")
    public void verifyPrice(String product) {
        String actualText = cooverviewstep.getFinalProductPrice();
        String expectedValue = cooverviewstep.getProductPrice(product);
        String actualValue = actualText.substring(actualText.indexOf(expectedValue));
        Assert.assertEquals(expectedValue, actualValue);
    }

    @And("Verify the tax value should be equal to 8% of the total price")
    public void verifyTax() {
        String taxValue = cooverviewstep.getTaxAmount();
        String taxDigits = StringUtils.getDigits(taxValue);
        double tax = Double.parseDouble(taxDigits) / 100.00;
        String expectedTaxValue = Double.toString(tax);
        Assert.assertEquals(cooverviewstep.calculateTax(), expectedTaxValue);
    }

    @And("Verify the total payment should be equal to the total product price plus tax")
    public void verifyTotal() {
        String totalValue = cooverviewstep.getTotalAmount();
        String totalDigits = StringUtils.getDigits(totalValue);
        double total = Double.parseDouble(totalDigits) / 100;
        String expectedTotalValue = Double.toString(total);
        Assert.assertEquals(cooverviewstep.calculateTotalCheckout(), expectedTotalValue);
    }

}
