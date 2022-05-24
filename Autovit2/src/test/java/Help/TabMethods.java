package Help;

import org.openqa.selenium.WebDriver;

import java.util.ArrayList;

public class TabMethods {
    public WebDriver driver;

    public TabMethods(WebDriver driver){
        this.driver=driver;
    }

    //Switch to tab
    public void SwitchToTab(int index){
        ArrayList ListaTaburi=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(ListaTaburi.get(index).toString());
        System.out.println(driver.getTitle());
    }

    //Switch to default tab
    public void SwitchToDefaultTab(){
        ArrayList ListaTaburi=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(ListaTaburi.get(0).toString());
        System.out.println(driver.getTitle());
    }

    //Switch to window
    public void SwitchToWindow(int index){
        ArrayList ListaTaburi=new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(ListaTaburi.get(index).toString());
        System.out.println(driver.getTitle());
    }
}
