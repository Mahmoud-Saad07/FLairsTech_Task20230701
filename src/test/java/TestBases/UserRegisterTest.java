package TestBases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

///////////////////////////// This Is Task One "Create New Account"//////////////////////////////////

public class UserRegisterTest extends TestBase {
    HomePage HomeRegist;
    RegisterationPage RegistPage;
    LoginPage Login;
    Actions action ;

    String emailOrPhone = "TestQC2023@outlook.com";
    String Password = "TestQC@123#2023";

    @Test (priority = 1)
    public void UserWillRegister() throws InterruptedException {
        HomeRegist = new HomePage(driver);
        HomeRegist.openRegisterationPage();
        RegistPage = new RegisterationPage(driver);

        RegistPage.registerationFlow(emailOrPhone, Password,
                Password, "FlairTech", "UserFtech", "01145679900", "1551990");
        Assert.assertTrue(RegistPage.SuccessBtn.isDisplayed());
        System.out.println("Get Started Btn is displayed ");
        String UserSuccessMsg =  RegistPage.SuccessMsg.getText();
        Assert.assertTrue(UserSuccessMsg.contains("Your account has been created!"));
        System.out.println("The Success Msg displayed as : " + UserSuccessMsg);
    }

    @Test (priority = 2)
    public void UsertrytoLogout()  {
        RegistPage.tryToLogOut();
        System.out.println("User is Logged out for 1st time Successfully");
    }

    @Test (priority = 3)
    public void userTrytoLogin() throws InterruptedException {
        Login =new LoginPage(driver);
        Thread.sleep(1500);
//        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        Login.userLogin(emailOrPhone,Password);
        Thread.sleep(1000);
        Login.UserNameBtn.click();
        String VerifyLogin = Login.LogoutBtn.getText();
        Assert.assertTrue(Login.LogoutBtn.isDisplayed());
        System.out.println("Logout Btn TXT is : " + VerifyLogin);
        Assert.assertTrue(VerifyLogin.contains("LOGOUT"));
        System.out.println("User is Logged in Successfully");


    }


}
