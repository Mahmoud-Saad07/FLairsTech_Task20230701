package stepsDef;

import Pages.*;
import TestBases.TestBase;
import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class AddToCart extends TestBase {


    HomePage Home;
    LoginPage LoginPg;
    ProductDetails ProductDtls;
    CartPage Cart;

    @When("User log in with Valid Credentials {string} , {string}")
    public void user_Log_In_With_Valid_Credentials (String emailOrPhone, String password)
    {
        LoginPg = new LoginPage(driver);
        LoginPg.userLogin(emailOrPhone,password);
    }

    @Then("I try to Select Category from the Home page")
    public void iTry_To_Select_Category_From_The_Home_Page() throws InterruptedException {
        driver.navigate().refresh();
        Thread.sleep(2000);
        Home = new HomePage(driver);
        Home.OpenBakeryPage();
    }

    @And("I add Two Items to the CART")
    public void i_Add_Two_Items_To_The_CART() throws InterruptedException {
        ProductDtls = new ProductDetails(driver);
        Cart = new CartPage(driver);
        ProductDtls.OpenItem1Page();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        String Item1name = ProductDtls.Item1Name.getText();
        Assert.assertTrue(Item1name.contains(Item1name));
        System.out.println("the Name of Opened Item 1 is :  " + Item1name);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        ProductDtls.AddItemToCart();

        Thread.sleep(2000);
        driver.navigate().back();
//        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);

        ProductDtls.OpenItem2Page();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        String Item2name = ProductDtls.Item2Name.getText();
        Assert.assertTrue(Item2name.contains(Item2name));
        System.out.println("the Name of Opened Item 2 is :  " + Item2name);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        ProductDtls.AddItemToCart();
        Thread.sleep(2000);

    }

    @And("the Items will be added to the CART and subtotal is calculated correctly")
    public void the_Items_Will_Be_Added_To_The_CART_And_Subtotal_Is_Calculated_Correctly() {
        Cart.openCartPage();
        Assert.assertTrue(Cart.RemoveItem1Btn.isDisplayed());
        String Item1Name = Cart.Item1.getText();
        Assert.assertTrue(Item1Name.contains(Item1Name));
        System.out.println("1st Item : " + Item1Name + " is added to cart Successfully");

        Assert.assertTrue(Cart.RemoveItem2Btn.isDisplayed());
        String Item2Name = Cart.Item2.getText();
        Assert.assertTrue(Item2Name.contains(Item2Name));
        System.out.println("2nd Item : " + Item2Name + " is added to cart Successfully");
        String ViewSubtotal = Cart.SubTotal.getText();
        Assert.assertTrue(ViewSubtotal.contains(ViewSubtotal));
        System.out.println("The subtotal for the added Items is : " + ViewSubtotal);

    }

    @And("I Will Remove the Added Items from Cart")
    public void i_Will_Remove_The_Added_Items_From_Cart() throws InterruptedException {

        Cart.RemoveItemFromCart();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        String CartEmpty = Cart.CartEmptyTxt.getText();
        Assert.assertTrue(CartEmpty.contains(CartEmpty));
        System.out.println("User remove the added Items successfully and the empty Cart Msg is displayed as : " + CartEmpty);
    }

    @After
    public void closeBrowser()
    {
        driver.quit();

    }
}
