package TestBases;

import Pages.HomePage;
import Pages.LoginPage;
import Pages.RegisterationPage;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


///////////////////////////// This Is Task with Example of "Data-Driven Test" when Create New Account //////////////////////////////////
public class UserRegisterTest_DDT extends TestBase {
    HomePage HomeRegist;
    RegisterationPage RegistPage;
    LoginPage Login;
    Actions action;


    @DataProvider(name = "testData")
    public static Object[][] userData() {
        return new Object[][]{
                {"Testing2023@gmail.com", "Test@123#2020", "Test@123#2020", "FLRTechOne", "TestFtechA", "01100012399", "1251990"},
                {"Testqc20023@gmail.com", "Test@321#2022", "Test@321#2022", "FLTech", "TestFTech", "01110012399", "1261991"},

        };
    }

    @Test(priority = 1, dataProvider = "testData")
    public void UserWillRegister(String emailOrPhone, String password1, String confirmPassword1, String fName,
                                 String lName, String phone, String birthDate) throws InterruptedException {
        HomeRegist = new HomePage(driver);
        HomeRegist.openRegisterationPage();
        RegistPage = new RegisterationPage(driver);

        RegistPage.registerationFlow(emailOrPhone, password1, confirmPassword1, fName,
                lName, phone, birthDate);
        Assert.assertTrue(RegistPage.SuccessBtn.isDisplayed());
        System.out.println("Get Started Btn is displayed ");
        String UserSuccessMsg = RegistPage.SuccessMsg.getText();
        Assert.assertTrue(UserSuccessMsg.contains("Your account has been created!"));
        System.out.println("The Success Msg displayed as : " + UserSuccessMsg);
        RegistPage.SuccessBtn.click();
        Thread.sleep(2000);
        RegistPage.tryToLogOut();
        System.out.println("User is Logged out 1st time Successfully");

        Thread.sleep(1000);
        Login = new LoginPage(driver);
        Login.userLogin(emailOrPhone, password1);
        Thread.sleep(2000);
        Login.AccBtn.click();
//        Assert.assertFalse(Login.signInBtn.isDisplayed());
        Thread.sleep(1000);
        Assert.assertTrue(RegistPage.LogoutBtn.isDisplayed());
        System.out.println("User is Login Successfully");
        action = new Actions(driver);
        action.release(Login.AccBtn);
        RegistPage.tryToLogOut();
        System.out.println("User is logged out for the 2nd Time");
//        action.release(Login.AccBtn);


    }

}