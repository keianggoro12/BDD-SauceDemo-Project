package step_definitions;


import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.example.pageObject.CartPage;
import org.example.pageObject.InventoryPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class InventorySteps {
    private final WebDriver driver = Hooks.driver;
    InventoryPage inventoryPage = new InventoryPage(driver);
    CartPage cartPage = new CartPage(driver);

    @When("User sort product from {string}")
    public void sortProduct(String sorting){
        inventoryPage.sortProduct(sorting);
    }

    @And("User clicks on the {string} and {string} products to add them to the cart, ensuring a seamless transition to the cart page")
    public void selectingProduct(String selectproduct1, String selectproduct2 ) {
        inventoryPage.clickAddToCartProduct(selectproduct1);
        Assert.assertTrue(inventoryPage.verifyRemovebuttonproduct(selectproduct1));
        inventoryPage.clickAddToCartProduct(selectproduct2);
        Assert.assertTrue(inventoryPage.verifyRemovebuttonproduct(selectproduct1));
        inventoryPage.clickCart();
        Assert.assertTrue(cartPage.verifyCartPage());
    }

}
