package Help;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ElementMethods {
    public WebDriver driver;

    public ElementMethods(WebDriver driver) {
        this.driver = driver;
    }

    //Wait for Element
    public void WaitAfterVisibleElement(WebElement Element) {
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(Element));
    }

    //Wait after clickable element
    public void WaitAfeterClickableElement(WebElement Element) {
        new WebDriverWait(driver, 2).until(ExpectedConditions.elementToBeClickable(Element));
    }

    //Click
    public void ClickElement(WebElement Element) {
        WaitAfterVisibleElement(Element);
        Element.click();
    }

    //SendKeys
    public void SendKeyElement(WebElement Element, String value) {
        WaitAfterVisibleElement(Element);
        Element.sendKeys(value);
    }

    //Dropdown select
    public void SelectByValueElement(WebElement Element, String value) {
        WaitAfterVisibleElement(Element);
        Select select = new Select(Element);
        select.selectByValue(value);
    }

    //Hover
    public void HoverElement(WebElement Element) {
        Actions actions = new Actions(driver);
        actions.moveToElement(Element).build().perform();
    }

    //Enter
    public void SendEnterElement(WebElement Element) {
        WaitAfterVisibleElement(Element);
        Element.sendKeys(Keys.ENTER);
    }

    //Wait
    public void Wait() {
        new WebDriverWait(driver, 2);
    }

    //Wait to Fill Element
    public void WaitElementtoFill( String textToAppear, WebElement Element) {
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.textToBePresentInElement(Element, textToAppear));
    }

    //Scroll into element
    public void ScrollIntoElement(WebElement element)  {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Scroll
    public void scrollDownBitPage(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,350)");

    }
}
