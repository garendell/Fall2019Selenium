package com.automation.tests.day2_Sel_Mar1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);

        //ok, now use WebELEMENT to find the element we want
        //we are looking for the main input box in google
        // we already used "inspect" to find that the input box
        //is tagged using <name=q>
        // now we tell the driver to find it by name:
        WebElement search = driver.findElement(By.name("q"));

        //ok, we found the element using "SEARCH".
        // now we want to test test entry - how to enter text there?
        //use the sendKeys method, give it a text to enter, then tell it to Enter:
        search.sendKeys("Java", Keys.ENTER);
        //how did we simulate pressing Enter? - by adding the command: keys.ENTER
        //add another wait to make sure computer has time to process all this
        Thread.sleep(2000);

        //now let's try finding something by link text:
        //look at google.com with the "inspect" HTML box open
        //if click on the News link at the top,you will see the highlighted code for that.
        //We know this News button has a link to the news; also <a> means link text.
        // You can direct Selenium to click on the news link using link text locator:
        WebElement news = driver.findElement(By.linkText("News"));
        news.click();  //for Selenium to simulate a click on the News button.
        Thread.sleep(4000);

        driver.quit();
    }
}
/*
Recap:
Basic Navigation
get() - open website
navigate().to() - same as get
navigate().back() - go back to previous site
navigate().forward() - move forward in the browser history
navigater().refresh() - reload the page
getTitle() - displays page title (not URL)
getCurrentURL - displays URL of open page
close()  closes current window "(or tabs)
quit()  closes all windows (or tabs)
windowHandle - Id of each window;  use to move between windows.
WebElement - objects that appear on a web page
Locators - name, Id, tag name, class name, text, link text, Xpath, Css.

Syntax for finding webElement
WebElement = driver.findElement(By.name("value");

to simulate entering text:
element.sendKeys()

to press enter button:
element.sendKeys(keys.ENTER);

to click:
element.click()

 */