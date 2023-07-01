package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
    }

    @FindBy(xpath = "//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")
    public WebElement AccBtn;
    @FindBy(xpath = "//a[normalize-space()='Sign In']")
    public WebElement signInBtn;
    @FindBy(id = "input_identifierValue")
    WebElement EmailOrPhoneTxt;
    @FindBy(xpath = "//button[@type='submit']//span[@class='mdc-button__touch']")
    WebElement ContBtn1;
    @FindBy(name = "password")
    WebElement Pass1txt;
    @FindBy(xpath = "/html/body/div/div[4]/form/div/div[4]/div[2]/button")
    WebElement LoginBtn;
    @FindBy(xpath = "//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")
    public WebElement UserNameBtn;
    @FindBy(xpath = "//*[@id=\"dpdw-login-box\"]/div/form/button")
    public WebElement LogoutBtn;

    public void userLogin(String email ,String Password) {
        AccBtn.click();
        signInBtn.click();
        driver.manage().timeouts().implicitlyWait(500, TimeUnit.SECONDS);
        EmailOrPhoneTxt.sendKeys(email);
        ContBtn1.click();
        Pass1txt.sendKeys(Password);
        LoginBtn.click();
        action.moveToElement(LoginBtn).click(LoginBtn).build();

    }
}
