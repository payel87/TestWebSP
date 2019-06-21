package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class SecurePayHomePage {

    public SecurePayHomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.LINK_TEXT, using = "Support")
    public WebElement supportLink;

    @FindBy(how = How.LINK_TEXT, using = "Contact Us")
    public WebElement contactUsLink;



}
