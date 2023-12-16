package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pageObject.CartPage;
import org.example.pageObject.InventoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CartSteps {
    private final WebDriver driver = Hooks.driver;
    CartPage cartPage = new CartPage(driver);

    @And("User now already on cart page")
    public void verifyFieldCartPage(){
        Assert.assertTrue(cartPage.verifyCartPage());
    }
    @And("User ensures that the selected product is in accordance with what has been selected, namely {string} and {string}")
    public void selectingProduct(String selectedproduct1, String selectedproduct2 ){
        cartPage.verifySelectedProduct(selectedproduct1);
        Assert.assertTrue(cartPage.verifySelectedProduct(selectedproduct1));
        cartPage.verifySelectedProduct(selectedproduct2);
        Assert.assertTrue(cartPage.verifySelectedProduct(selectedproduct2));
    }
    @Then("User removes one of the products that has been put into the cart in this case is {string}")
    public void removingProduct (String removeProduct) throws InterruptedException{
        cartPage.removingSelectedProduct(removeProduct);
    }
    @And("User click checkout button")
    public void clickCOButton(){
        cartPage.clickCOButton();
    }






}
