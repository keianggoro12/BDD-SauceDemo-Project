package step_definitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.example.pageObject.LoginPage;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import static step_definitions.Hooks.driver;

public class LoginSteps {
    private final WebDriver drive = driver;
    LoginPage loginPage= new LoginPage(driver);
    @Given("User already on login page")
    public void verifyfieldUsername(){
        Assert.assertTrue(loginPage.verifyfieldUsername());
    }

    @When("User login with valid {string} username and {string} password")
    public void credential(String Username, String Password){
        loginPage.inputfieldUsername(Username);
        loginPage.inputfieldPassword(Password);
        loginPage.clickloginbutton();
    }

    @Then("User now already on inventory page")
    public void verifyBurgerButton(){
        Assert.assertTrue(loginPage.verifybuttonburger());
    }


}
