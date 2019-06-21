package Steps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.HashMap;
import java.util.Map;

public class RunContext {

    public WebDriver driver;
    public Scenario scenario;
    public boolean isTestFailed=false;
    public Map<String,String> failedContext= new HashMap<>();

    @Before
    public void init(Scenario scenario){
        ChromeOptions options= new ChromeOptions();
        options.addArguments("start-maximized");
        System.setProperty("webdriver.chrome.driver", "C:\\TestWebPage\\src\\main\\java\\Drivers\\chromedriver\\win32\\2.46\\chromedriver.exe");
        driver  = new ChromeDriver(options);
        this.scenario = scenario;
    }
    @After
    public void tearDown(Scenario scenario){

        //take screenshot
        final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        scenario.embed(screenshot, "image/png");
        if(scenario.isFailed())
        {
            System.out.println(scenario.getName()+ " : FAILED !");
        }
        if(isTestFailed) {
            if(failedContext.size()>0) {
                for(String key:failedContext.keySet()){
                    scenario.write("Failed : "+key +" "+ failedContext.get(key));
                }

            }

        }
        driver.quit();
    }

}
