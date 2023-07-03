package TestBases;

import Pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


///////////////////////////// This Is Task Two "Login with the newest Account then doing some Actions"//////////////////////////////////

public class AddProducttoCart extends TestBase {

    HomePage Home;
    ProductDetails ProductDtls;
    CartPage CrtPage;
    String Product1Name = "Freska Coated Choco Sticks - 12 pcs";
    String Product2Name = "Molto Magnum Chocolate Stuffed Croissant – 24 Pcs";
    LoginPage Login;
    String email = "TestQC2023@outlook.com";
    String Password = "TestQC@123#2023";

    @Test(priority = 1)
    public void SelectCategory() throws InterruptedException {
        Login = new LoginPage(driver);
        Login.userLogin(email,Password);
        driver.navigate().refresh();
        Thread.sleep(2000);
        Home = new HomePage(driver);
        Home.OpenBakeryPage();
    }

    @Test(priority = 2)
    public void Add2ItemsToCart() throws InterruptedException {
        ProductDtls = new ProductDetails(driver);
        CrtPage = new CartPage(driver);
        ProductDtls.OpenItem1Page();
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        String Item1name = ProductDtls.Item1Name.getText();
        Assert.assertTrue(Item1name.contains(Product1Name));
        System.out.println("the Name of Opened Item 1 is :  " + Item1name);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        ProductDtls.AddItemToCart();

        Thread.sleep(2000);
        driver.navigate().back();
//        Thread.sleep(2000);
        driver.navigate().refresh();
        Thread.sleep(2000);
//        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);
        ProductDtls.OpenItem2Page();
        driver.manage().timeouts().implicitlyWait(300, TimeUnit.SECONDS);

        String Item2name = ProductDtls.Item2Name.getText();
        Assert.assertTrue(Item2name.contains(Product2Name));
        System.out.println("the Name of Opened Item 2 is :  " + Item2name);
        ProductDtls.AddItemToCart();
        Thread.sleep(2000);

        CrtPage.openCartPage();
        Assert.assertTrue(CrtPage.RemoveItem1Btn.isDisplayed());
        Assert.assertTrue(CrtPage.RemoveItem2Btn.isDisplayed());
        String ViewSubtotal = CrtPage.SubTotal.getText();
        Assert.assertTrue(ViewSubtotal.contains("EGP 272.40"));
        System.out.println("The subtotal for the added Items is : " + ViewSubtotal);


    }
}
