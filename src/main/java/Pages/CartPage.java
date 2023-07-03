package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class CartPage extends BasePage{
    public CartPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
    }
    @FindBy(xpath = "//*[@id=\"jm\"]/header/section/div[2]/a")
    WebElement CartBtn;

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[2]/div/article/div[1]/p[2]")
    public WebElement SubTotal;

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article[1]/footer/button")
    public WebElement RemoveItem1Btn;

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article[2]/footer/button")
    public WebElement RemoveItem2Btn;
    @FindBy(xpath = "//*[@id=\"pop\"]/div/section/div/div/form[2]/button/span")
    public WebElement ConfirmRemoveBtn;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/div/h2")
    public WebElement CartEmptyTxt;

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article[1]/a/div[2]/h3")
    public WebElement Item1;

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article[2]/a/div[2]/h3")
    public WebElement Item2;



    public void openCartPage()
    {
        CartBtn.click();
    }

    public void RemoveItemFromCart() throws InterruptedException {
        RemoveItem1Btn.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        ConfirmRemoveBtn.click();
        Thread.sleep(2000);
        RemoveItem1Btn.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        ConfirmRemoveBtn.click();

    }


}
