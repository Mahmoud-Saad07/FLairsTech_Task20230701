package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class RegisterationPage extends BasePage {

    //WebDriver driver;
    public RegisterationPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        action = new Actions(driver);
    }

    @FindBy(id = "input_identifierValue")
    WebElement EmailOrPhone;

    @FindBy(xpath = "//button[@type='submit']//span[@class='mdc-button__touch']")
    WebElement ContBtn1;

    @FindBy(name = "password")
    WebElement Pass1;

    @FindBy(xpath = "/html/body/div/div[4]/form/div/div[1]/div[4]/label/input")
    WebElement ConfirmPass1;

    @FindBy(xpath = "//*[@id=\"card_password\"]/div[5]/div/button")
    WebElement ContBtn2;

    @FindBy(id = "input_first_name")
    WebElement Fname;
    @FindBy(id = "input_last_name")
    WebElement Lname;

    @FindBy(name = "phone[number]")
    WebElement Phone;

    @FindBy(xpath = "/html/body/div/div[4]/form/div/div[2]/div[5]/div/button/span[3]")
    WebElement ContBtn3;

    @FindBy(id = "gender")
    WebElement Gender;

    @FindBy(xpath = "//span[normalize-space()='Male']")
    WebElement SelectGender;

    @FindBy(id = "input_birth_date")
    WebElement BirthDate;

    @FindBy(id = "acceptTC")
    WebElement TermsBtn;
    @FindBy(xpath = "//button[@id='confirmBtn']//span[@class='mdc-button__touch']")
    WebElement ContBtn4;

    @FindBy(xpath = "//*[@id=\"form_success\"]/div/div/div[2]/div/button/span[3]")
    public WebElement SuccessBtn;
    @FindBy(xpath = "//*[@id=\"form_success\"]/div/div/div[1]/h2")
    public WebElement SuccessMsg;

    @FindBy(xpath = "//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")
    public WebElement UserNameBtn;


    @FindBy(xpath = "//*[@id=\"dpdw-login-box\"]/div/form/button")
    public WebElement LogoutBtn;

    public void registerationFlow(String emailOrPhone, String password1, String confirmPassword1, String fName,
                                  String lName, String phone, String birthDate) throws InterruptedException {

        EmailOrPhone.sendKeys(emailOrPhone);
        ContBtn1.click();
        Thread.sleep(2000);
        Pass1.sendKeys(password1);
        ConfirmPass1.sendKeys(confirmPassword1);
        Thread.sleep(2000);
        ContBtn2.click();
//        action.moveToElement(ContBtn2).click(ContBtn2).build().perform();
//        Thread.sleep(500);
        driver.manage().timeouts().implicitlyWait(200, TimeUnit.SECONDS);
        Fname.sendKeys(fName);
        Lname.sendKeys(lName);
        Phone.sendKeys(phone);
        ContBtn3.click();
        Thread.sleep(1000);
        Gender.click();
        SelectGender.click();
        BirthDate.sendKeys(birthDate);
        TermsBtn.click();
        ContBtn4.click();

    }

    public void tryToLogOut() {

        UserNameBtn.click();
        driver.manage().timeouts().implicitlyWait(150, TimeUnit.SECONDS);
        LogoutBtn.click();


    }

}
//cntbtn2 /html/body/div/div[4]/form/div/div[1]/div[5]/div/button
//    @FindBy(xpath = "//*[@id=\"jm\"]/header/section/div[2]/div[1]/label")
//    public WebElement UserNameLogout;
//@FindBy(xpath = "/html/body/div[1]/header/section/div[2]/div[1]/label/text()")
//public WebElement UserNameBtn;