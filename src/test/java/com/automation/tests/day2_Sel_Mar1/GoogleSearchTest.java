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

        driver.quit();

    }
}
