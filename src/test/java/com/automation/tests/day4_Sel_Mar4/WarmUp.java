package com.automation.tests.day4_Sel_Mar4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.net.URL;

public class WarmUp {
    public static void main(String[] args) {
        //agenda:  Locators and   findElements() --> List <WebElement>
        /*   Warmup tasks:
        @channel WARM-UP
Go to ebay
enter search term
click on search button
print number of results

go to amazon


enter search term
click on search button
verify title contains search term

Go to wikipedia.org
enter search term selenium webdriver
click on search button
click on search result Selenium (software)
verify url ends with Selenium_(software)
         */

       WebDriver driver = new ChromeDriver();
            driver.get("http://ebay.com");
            driver.findElement(By.id("gh-ac")).sendKeys("java book");
            driver.findElement(By.id("gh-btn")).click();
            WebElement searchResults = driver.findElement(By.tagName("h1"));
            System.out.println(searchResults.getText().split(" ")[0]);
            driver.quit();



    }
}
