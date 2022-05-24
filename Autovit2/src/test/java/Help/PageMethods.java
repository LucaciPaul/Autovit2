package Help;

import com.sun.xml.internal.messaging.saaj.soap.ver1_2.BodyElement1_2Impl;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageMethods {

    public WebDriver driver;

    public PageMethods(WebDriver driver){
        this.driver=driver;
    }

    //Validare titlu
    public void ValidateTitleOfPage(String Expected){
        WaitAfterPage(Expected);
        String Actual=driver.getTitle();
        Assert.assertEquals("The title of the page is not as expected",Expected, Actual);
    }

    //Asteptare incarcare pagina
    public void WaitAfterPage(String value){
        new WebDriverWait(driver, 10).until(ExpectedConditions.titleIs(value));
    }

    //Scroll pana la element
    public void ScrollToElement(WebElement Element){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();", Element);
    }

    //Smooth Scroll
    public void ScrollSmooth(){
        double Height = driver.manage().window().getSize().height;
        for
        (int i=0;i<Height;i++) {
            ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,1)", "");
        }
    }



}
