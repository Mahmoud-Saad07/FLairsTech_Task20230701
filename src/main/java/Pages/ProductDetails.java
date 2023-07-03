package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ProductDetails extends BasePage{
    public ProductDetails(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
    }

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div[2]/div[3]/section/div[1]/article[1]/a/div[1]/img[1]")
    public WebElement Item1;
    @FindBy(xpath = "//*[@id=\"jm\"]/main/div[1]/section/div/div[2]/div[1]/div/h1")
    public WebElement Item1Name;

    @FindBy(xpath = "/html/body/div/main/div[2]/div[3]/section/div[1]/article[2]/a/div[1]/img[1]")
    public WebElement Item2;

    @FindBy(xpath = "//*[@id=\"jm\"]/main/div[1]/section/div/div[2]/div[1]/div/h1")
    public WebElement Item2Name;
//    /html/body/div[1]/main/div[1]/section/div/div[2]/div[1]/div/h1

    @FindBy(xpath = "/html/body/div/main/div[1]/section/div/div[2]/div[3]/div/form/button/span")
    WebElement AddtoCartBtn;

    public void AddItemToCart()
    {
        AddtoCartBtn.click();
    }
    public void OpenItem1Page()
    {
        Item1.click();
    }
    public void OpenItem2Page()
    {
        Item2.click();
    }




}
