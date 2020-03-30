package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) {
        /* to start selenium script we need:
        set up webdriver (browser driver) and
        create webdriver object
         */
        WebDriverManager.chromedriver().setup();
        //create a driver object:
        WebDriver driver = new ChromeDriver();
        //this will be the object that carries out our commands
        //In selenium everything starts with WebDriver interface.
        //Chromedriver is a class (imported, see above)
        // set up a driver method.
        // get is the first method, the key to open the door
        driver.get("http://google.com"); //to open website

    }
}
