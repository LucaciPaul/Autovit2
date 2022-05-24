package Base;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Base {
    public WebDriver driver;


    @Before
    public void Setup(){
        System.setProperty("webdriver.edge.driver", "C:\\Automation\\Edge\\msedgedriver.exe");
        driver = new EdgeDriver();
        driver.get("https://www.autovit.ro/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @After
    public void Teardown(){
        driver.quit();
    }
}
