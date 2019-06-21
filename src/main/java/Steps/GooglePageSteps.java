package Steps;

import Helper.DriverHelper;
import PageObjects.ContactUsPage;
import PageObjects.GooglePage;
import PageObjects.SecurePayHomePage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.interactions.Actions;


public class GooglePageSteps extends BaseSteps{

    private RunContext runContext;
    private static final String PAGETITLE = "SecurePay online payment and eCommerce solutions for businesses";
    private static final String CONTACT_US_PAGETITLE = "Contact Us – SecurePay – Sales – Support – Accounts";

    public GooglePageSteps(RunContext runContext) {
        super(runContext);
        this.runContext = runContext;
    }

    @And("^I Search for ([^\"]*) on website ([^\"]*)$")
    public void iSearchForSecurePayOnWebsite(String word,String websiteUrl) {
        GooglePage googlePage = new GooglePage(runContext.driver);
        //runContext.driver.manage().window().maximize();
        runContext.driver.get(websiteUrl);
        DriverHelper.waitForElementToBePresent(runContext.driver,googlePage.searchField,10);
        googlePage.enterSearchWord(word);
        DriverHelper.waitForElementToBePresent(runContext.driver,googlePage.searchButton,10);
        googlePage.clickSearchButton();
    }

    @When("^I Click through to the SecurePay website$")
    public void iClickThroughToTheSecurePayWebsite() {
        GooglePage googlePage = new GooglePage(runContext.driver);
        SecurePayHomePage securePayHomePage=new SecurePayHomePage((runContext.driver));
        //clicking on the first website displayed for SecurePay
        googlePage.securePayUrl.click();
        DriverHelper.waitForElementToBePresent(runContext.driver,securePayHomePage.supportLink,10);
        if(runContext.driver.getTitle().equalsIgnoreCase(PAGETITLE))
        {
            System.out.println("Navigated to correct SecurePay Home Page");
            runContext.isTestFailed=false;
        }
        else
        {
            System.out.println("Not Navigated to correct SecurePay Home Page");
            runContext.isTestFailed=true;
        }
    }
    @Then("^I Navigate to the contact us page$")
    public void iNavigateToTheContactUsPage() {
        SecurePayHomePage securePayHomePage=new SecurePayHomePage(runContext.driver);
        Actions action = new Actions(runContext.driver);
        //hovering to support and clicking on contact us
        action.moveToElement(securePayHomePage.supportLink).moveToElement(securePayHomePage.contactUsLink).click().build().perform();

    }

    @And("^I Verify that the contact us page is loaded$")
    public void iVerifyThatTheContactUsPageIsLoaded()
    {
        ContactUsPage contactUsPage=new ContactUsPage(runContext.driver);
        DriverHelper.waitForElementToBePresent(runContext.driver,contactUsPage.firstName,10);
        if(runContext.driver.getTitle().equalsIgnoreCase(CONTACT_US_PAGETITLE))
        {
            System.out.println("Navigated successfully to correct Contact Us Page");
            runContext.isTestFailed=false;
        }
        else
        {
            System.out.println("Not Navigated successfully to Contact Us Page");
            runContext.isTestFailed=true;
        }
    }

    @And("^I use randomly generated data to fill in the contact us form$")
    public void iFillTheForm()
    {
        ContactUsPage contactUsPage=new ContactUsPage(runContext.driver);
        contactUsPage.enterFirstName(RandomStringUtils.randomAlphabetic(5));
        contactUsPage.enterLastName(RandomStringUtils.randomAlphabetic(5));
        contactUsPage.enterEmailAddress(RandomStringUtils.randomAlphabetic(5));
        contactUsPage.enterPhoneNumber(RandomStringUtils.randomNumeric(10));
        contactUsPage.enterWebsite(RandomStringUtils.randomAlphabetic(5));
        contactUsPage.enterCompany(RandomStringUtils.randomAlphabetic(5));
        contactUsPage.selectReasonForEnquiry();
    }

}