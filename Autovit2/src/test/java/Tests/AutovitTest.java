package Tests;

import Base.Base;
import DataBase.DataBase;
import Help.ElementMethods;
import Help.PageMethods;
import Help.TabMethods;
import Objects.ReqSpecificationsObject;
import Objects.FindedSpecificationsObject;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import Queries.SQLAutovit;


import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


public class AutovitTest extends Base {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    public PageMethods pageMethods;
    public ElementMethods elementMethods;
    public TabMethods tabMethods;
    public SQLAutovit sqlAutovit;
    public ReqSpecificationsObject reqSpecificationsObject;
    public FindedSpecificationsObject findedSpecificationsObject;
    DataBase DB = new DataBase();


    @Test
    public void AutovitTest() throws InterruptedException, IOException, SQLException {
        pageMethods = new PageMethods(driver);
        elementMethods = new ElementMethods(driver);
        tabMethods = new TabMethods(driver);
        sqlAutovit = new SQLAutovit(DB);
        reqSpecificationsObject = new ReqSpecificationsObject();

        Autovit();
    }

    public void Autovit() throws InterruptedException, IOException, SQLException {
        //Page validation
        String ExpectedTitle = "AUTOVIT - Anunturi auto, vanzari autoturisme noi si second hand.";
        pageMethods.ValidateTitleOfPage(ExpectedTitle);

        //Accept Cookies
        WebElement Cookies = driver.findElement(By.id("onetrust-accept-btn-handler"));
        elementMethods.ClickElement(Cookies);

        //Insert data
        int numberOfRows = sqlAutovit.getNumberRows();
        for (int indexRows = 1; indexRows <= numberOfRows; indexRows++) {
            reqSpecificationsObject = new ReqSpecificationsObject();
            WebElement Marca = driver.findElement(By.id("filter_enum_make"));
            WebElement Model = driver.findElement(By.id("filter_enum_model"));
            WebElement Pricemin = driver.findElement(By.id("filter_float_price:from"));
            WebElement Pricemax = driver.findElement(By.id("filter_float_price:to"));
            WebElement Yearmin = driver.findElement(By.id("filter_float_year:from"));
            WebElement Yearmax = driver.findElement(By.id("filter_float_year:to"));
            WebElement Search = driver.findElement(By.xpath("//button[@data-testid='submit-btn']"));

            sqlAutovit.SelectBrand(reqSpecificationsObject, "searchfor", indexRows);
            elementMethods.SendKeyElement(Marca, reqSpecificationsObject.getBrand());
            elementMethods.SendEnterElement(Marca);
            elementMethods.WaitAfeterClickableElement(Model);
            sqlAutovit.SelectModel(reqSpecificationsObject, "searchfor", indexRows);
            elementMethods.SendKeyElement(Model, reqSpecificationsObject.getModel());
            elementMethods.SendEnterElement(Model);
            sqlAutovit.SelectPricemin(reqSpecificationsObject, "searchfor", indexRows);
            elementMethods.SendKeyElement(Pricemin, reqSpecificationsObject.getPricemin());
            elementMethods.SendEnterElement(Pricemin);
            sqlAutovit.SelectPricemax(reqSpecificationsObject, "searchfor", indexRows);
            elementMethods.SendKeyElement(Pricemax, reqSpecificationsObject.getPricemax());
            elementMethods.SendEnterElement(Pricemax);
            sqlAutovit.SelectYearmin(reqSpecificationsObject, "searchfor", indexRows);
            elementMethods.SendKeyElement(Yearmin, reqSpecificationsObject.getYearmin());
            elementMethods.SendEnterElement(Yearmin);
            sqlAutovit.SelectYearmax(reqSpecificationsObject, "searchfor", indexRows);
            elementMethods.SendKeyElement(Yearmax, reqSpecificationsObject.getYearmax());
            elementMethods.SendEnterElement(Yearmax);
            sqlAutovit.SelectFuel(reqSpecificationsObject, "searchfor", indexRows);
            elementMethods.ClickElement(Search);
            WebElement Fuel = driver.findElement(By.xpath("//li/input[@placeholder='fuel']"));
            elementMethods.WaitAfterVisibleElement(Fuel);
            elementMethods.SendKeyElement(Fuel, reqSpecificationsObject.getFuel());
            elementMethods.SendEnterElement(Fuel);
            pageMethods.ScrollSmooth();

            //Search for cars
            List<WebElement> Results= driver.findElements(By.xpath("//div[@class='offers list']/article"));
            int index=0;
            while (index < Results.size()){
                FindedSpecificationsObject findedSpecificationsObject = new FindedSpecificationsObject();
                int countArticle=index+1;
                try{
                WebElement Title = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]//h2/a"));
                findedSpecificationsObject.setTitle(Title.getAttribute("title"));}
                catch (NoSuchElementException exception){};
                try{
                WebElement FindedAbout = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]//h3"));
                findedSpecificationsObject.setAbout(FindedAbout.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement FindedEngine = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/ul/li[4]/span"));
                findedSpecificationsObject.setEngine(FindedEngine.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement FindedKm = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/ul/li[2]/span"));
                findedSpecificationsObject.setKm(FindedKm.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement FindedProdYear = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/ul/li[1]/span"));
                findedSpecificationsObject.setProdYear(FindedProdYear.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement FindedLoc = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/h4/span[@class='ds-location-city']"));
                findedSpecificationsObject.setLoc(FindedLoc.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement FindedPrice = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/div[2]/div/div/span/span[1]"));
                findedSpecificationsObject.setPrice(FindedPrice.getText());}
                catch (NoSuchElementException exception){};
                try{
                WebElement FindedLink = driver.findElement(By.xpath("//div[@class='offers list']/article["+countArticle+"]/div[2]/div[1]/h2/a[@href]"));
                findedSpecificationsObject.setLink(FindedLink.getAttribute("href"));}
                catch (NoSuchElementException exception){};

                //Insert in SQL DB
                sqlAutovit.InsertAbout(findedSpecificationsObject, "found");
                index++;
            }

            driver.get("https://www.autovit.ro/");
        }
    }
}