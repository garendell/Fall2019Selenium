package com.automation.tests.day3_Mar3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice  {
    public static void main(String[] args) throws Exception{

        //create a method instead of webdrivermanager.chromedriver setup... do this:
      // WebElement driver = (WebElement) new ChromeDriver();

        /*
        // open a utilites package under automation
       // tests package - is where we will store all the tests
       // utilities package - is where we will store all the reusable methods
        that will support our tests.  For Example, we can create a class
        with a method that will give us a Webdriver whenever we need it.
         //Then create a class under utilities called DriverFactory
         */

        WebDriver driver = DriverFactory.createADriver("chrome");

             //this is only one line of code instead of two, because we set up this
                //method in the DriverFactory utility package.  We only have to change
                //the BROWSER NAME in the parameters to create the driver we need.

        driver.get("http://practice.cybertekschool.com/sign_up");
                            //our code goes between get and quit... obviously.
                            // all Vasyl's codes are available on the github

            //now we want to automate the sign up process.
            // we need to tell the driver to
            // find the webelement for the signup box, enter name,
            // then find the email box, enter email,
            //then click the sign up button.

        WebElement fullName = driver.findElement(By.name("full_name")  );
      /*  This is my guess about what we will do:
        driver.enterText("name"); wrong - the command is sendKeys
        driver.findElement(By.name("email")  ); ok, but not just driver, use WebElement
        driver.enterText ("email@email.com"); - wrong - use sendKeys
        driver.findElement(By.name ("sign up button") );
        driver.click("sign up button");
      This is what we actually do:   */
      fullName.sendKeys("Mister Twister");
        WebElement email = driver.findElement(By.name("email")  );
        email.sendKeys(" sdet@cybertek.com");
        WebElement signup = driver.findElement(By.name("wooden_spoon")  );
        Thread.sleep(5000);
        signup.click();  //or you could use "signup.submit" - more common to use click,
                            //but sometimes click doesn't work, so then you can use submit.
       driver.quit(); //closes everything


    }
}
