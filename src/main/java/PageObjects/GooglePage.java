package PageObjects;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;


public class GooglePage {

    public GooglePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @FindBy(how = How.NAME, using = "q")
    public WebElement searchField;

    @FindBy(how = How.NAME, using = "btnK")
    public WebElement searchButton;

    @FindBy(how = How.XPATH, using ="//h3[contains(text(),'SecurePay online payment and eCommerce solutions')]")
    public WebElement securePayUrl;

    public void enterSearchWord(String word)
    {
        searchField.clear();
        searchField.sendKeys(word);
    }

    public void clickSearchButton()
    {
        searchButton.click();
    }

}
