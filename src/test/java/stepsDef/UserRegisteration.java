package stepsDef;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import TestBases.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class UserRegisteration extends TestBase {

    HomePage HomeRegist;
    RegisterationPage RegistPage;
    LoginPage LoginPg;
    Actions action;

    @Given("user Open the Browser then go to JUMIA Home page")
    public void user_Open_the_Browser_then_go_to_JUMIA_Home_page() {
        startDriver("chrome");
        action = new Actions(driver);
        action.moveByOffset(0, 0).click().build().perform();
    }

    @When("I try to open registration page")
    public void i_try_to_open_registration_page() {
        HomeRegist = new HomePage(driver);
        HomeRegist.openRegisterationPage();
    }

    @And("I enter {string} , {string} , {string} , {string} , {string} , {string} , {string}")
    public void i_Enter(String emailOrPhone, String password1, String confirmPassword1, String firstName,
                        String lastName, String Phone, String BirthDate) throws InterruptedException {
        RegistPage = new RegisterationPage(driver);
        RegistPage.registerationFlow(emailOrPhone, password1, confirmPassword1, firstName,
                lastName, Phone, BirthDate);
    }


    @Then("The registration will be done successfully")
    public void theRegistrationWillBeDoneSuccessfully() throws InterruptedException {
        LoginPg = new LoginPage(driver);
        RegistPage = new RegisterationPage(driver);
        Assert.assertTrue(RegistPage.SuccessBtn.isDisplayed());
        System.out.println("Get Started Btn is displayed ");
        String UserSuccessMsg = RegistPage.SuccessMsg.getText();
        Assert.assertTrue(UserSuccessMsg.contains("Your account has been created!"));
        System.out.println("The Success Msg displayed as : " + UserSuccessMsg);
        RegistPage.SuccessBtn.click();
        Thread.sleep(2000);
        Assert.assertTrue(LoginPg.UserNameBtn.isDisplayed());
        String UserNameTxt = LoginPg.UserNameBtn.getText();
        Assert.assertTrue(UserNameTxt.contains(UserNameTxt));
        System.out.println("The User Name is displayed Successfully as : " + UserNameTxt);
        RegistPage.tryToLogOut();


    }

    @After
    public void closeBrowser()
    {
        driver.quit();

    }
}
