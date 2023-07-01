package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        super(driver);
       this.driver = driver;
        action = new Actions(driver);
    }
    @FindBy(xpath = "//label[normalize-space()='Account']")
    public WebElement accBtn;

    @FindBy(xpath = "//a[normalize-space()='Sign In']")
     public WebElement signInBtn;

    @FindBy(xpath = "/html/body/div/main/div[1]/div[1]/div[1]/div/a[1]")
    WebElement SuperMrkt;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div[1]/div[1]/div[1]/div/div[1]/div/div[1]/div[2]/a[7]")
    WebElement OpenBakery;

    public void openRegisterationPage() {
        accBtn.click();
        signInBtn.click();
    }
    public void OpenBakeryPage ()
    {
        action.moveToElement(SuperMrkt).build().perform();
        OpenBakery.click();

    }




}
