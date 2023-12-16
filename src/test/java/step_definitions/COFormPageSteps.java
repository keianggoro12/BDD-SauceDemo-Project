package step_definitions;

import io.cucumber.java.en.When;
import org.example.pageObject.CheckoutFormPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static step_definitions.Hooks.driver;

public class COFormPageSteps {

    private final WebDriver drive = driver;
    CheckoutFormPage coFormPage = new CheckoutFormPage(driver);
    
    @When("User inputs valid personal information {string} {string} with postal code {string}")
    public void personalInfo(String Firstname, String Lastname, String Postcode){
        Assert.assertTrue(coFormPage.verifyCOFormWrapper());
        coFormPage.inputFirstname(Firstname);
        coFormPage.inputLastname(Lastname);
        coFormPage.inputPostcode(Postcode);
        coFormPage.clickContinue();
    }

}
