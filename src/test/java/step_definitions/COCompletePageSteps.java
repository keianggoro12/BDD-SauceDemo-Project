package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.example.pageObject.CheckoutCompletePage;
import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static step_definitions.Hooks.driver;

public class COCompletePageSteps {
    private final WebDriver drive = driver;
    CheckoutCompletePage coCompleteStep = new CheckoutCompletePage(driver);
    LoginPage loginPage = new LoginPage(driver);

    @Then("User has completed their order")
    public void verifyCOComplete(){
        Assert.assertTrue(coCompleteStep.verifyCOComplete());
    }
    @And("User back to inventory page")
    public void clickButtonBackHome()throws InterruptedException{
        coCompleteStep.clickBackHomeButton();
        Assert.assertTrue(loginPage.verifybuttonburger());

    }

}
