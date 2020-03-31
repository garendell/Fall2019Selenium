package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {
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

        //now you can send this to github by clicking the green check mark at the top right.
        //it didn't work - his shows a push button, mine doesn't.  try again. had to use push command.

        Thread.sleep(3000);

        String title = driver.getTitle();  //method that returns title of the page
        String expectedTitle = "Google";
        System.out.println("title is...:" +title);

        if(expectedTitle.equals(title) ){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        driver.close(); //to close browser

     //troubleshoot:  if you have any issues with running this, first try updating Chrome and updating Intellij.

    }
}
