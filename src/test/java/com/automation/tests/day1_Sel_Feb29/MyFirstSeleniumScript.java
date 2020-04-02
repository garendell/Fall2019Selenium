package com.automation.tests.day1_Sel_Feb29;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {
        //setup chromedriver
        WebDriverManager.chromedriver().setup();

        //create chromedriver object
        ChromeDriver driver = new ChromeDriver();

        // open some website
        driver.get("http://google.com");



    }
}
