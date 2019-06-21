package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactUsPage {

    public ContactUsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "first-name")
    public WebElement firstName;

    @FindBy(how = How.NAME, using = "last-name")
    public WebElement lastName;

    @FindBy(how = How.NAME, using = "email-address")
    public WebElement email;

    @FindBy(how = How.NAME, using = "phone-number")
    public WebElement phone;

    @FindBy(how = How.NAME, using = "website-url")
    public WebElement website;

    @FindBy(how = How.NAME, using = "business-name")
    public WebElement company;

    @FindBy(how = How.NAME, using = "reason-for-enquiry")
    public WebElement reason;


    public void enterFirstName(String firstname)
    {
        firstName.clear();
        firstName.sendKeys(firstname);

    }

    public void enterLastName(String lastname)
    {

        lastName.clear();
        lastName.sendKeys(lastname);

    }

    public void enterEmailAddress(String emailAddress)
    {
        email.clear();
        email.sendKeys(emailAddress+"@xyz.com");
    }

    public void enterPhoneNumber(String PhoneNum)
    {
        phone.clear();
        phone.sendKeys(PhoneNum);
    }
    public void enterWebsite(String webAddress)
    {
        website.clear();
        website.sendKeys("https://"+webAddress+".com");
    }

    public void enterCompany(String companyName)
    {
        company.clear();
        company.sendKeys(companyName);
    }

    public void selectReasonForEnquiry()
    {
        Select selectReason=new Select(reason);
        selectReason.selectByIndex(1);

    }





}
