package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

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
    public WebElement RemoveItm1Btn;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div/div[1]/article/article[2]/footer/button")
    public WebElement RemoveItm2Btn;


    public void openCartPage()
    {
        CartBtn.click();
    }

}
