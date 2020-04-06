package com.automation.tests.day3_Mar3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice  {
    public static void main(String[] args) throws Exception{

        //create a method to use instead of always repeating webdrivermanager.chromedriver setup...
      // WebElement driver = (WebElement) new ChromeDriver();
        //and put it in a "utilities" package under "tests"

        /*
        // open a utilities package under automation
       // tests package - is where we will store all the tests
       // utilities package - is where we will store all the reusable methods
        that will support our tests.  For Example, we can create a class
        with a method that will give us a Webdriver whenever we need it.
         //Then create a class under utilities called DriverFactory
         */

        WebDriver driver = DriverFactory.createADriver("chrome");

             //this results in only one line of code instead of two, and it's reusable
            //we now have this method in the DriverFactory utility package.  We only have to change
                //the BROWSER NAME in the parameters to create the driver we need.

        driver.get("http://practice.cybertekschool.com/sign_up");
                            // after creating the driver, tell the driver to get the URL you want
                            // our code will be written between get and quit... obviously.
                            // all Vasyl's codes are available on the github

            // we are using the sign up page of the cybertek practice site
            // we want to automate the signup process??  or test that it is working right? not sure yet
            // we need to tell the driver to:
                // find the webelement for the signup box,
                // enter the person's name,
                // then find the email box, enter email,
                //then click the sign up button.


      /*  This is my guess about what we will do:
        driver.enterText("name");       wrong - the command is sendKeys
        driver.findElement(By.name("email")  );     ok, but not just driver, use WebElement command first, then tell the driver what to find
        driver.enterText ("email@email.com");   - wrong - not enterText,  use sendKeys
        driver.findElement(By.name ("sign up button") );  yes, but signup button is not available by name, we have to use
        driver.click("sign up button");
      This is what we actually do:   */
        WebElement fullName = driver.findElement(By.name("full_name")  );
        fullName.sendKeys("Mister Twister");
        WebElement email = driver.findElement(By.name("email")  );
        email.sendKeys(" sdet@cybertek.com");
        WebElement signup = driver.findElement(By.name("wooden_spoon")  );
                                                        //use control F to check for uniqueness of locator
                                                        // we discover that there are 3 unique ways to find this element
                                                        //it can be located using  tag name (h3), name, or class name
        Thread.sleep(5000);

        signup.click();  //or you could use "signup.submit" - more common to use click,
        //but sometimes click doesn't work, so then you can use submit.
        Thread.sleep(3000);
                              //now we need to verify that it goes to the final message screen after submission.
                              // we say what message is expected, by entering exact text as expected WebElement
                             // then we set up a WebElement search for that message, using either tag name, name, or class name
        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader") );
        String actual = message.getText();
        if(expected.equals(actual) ){
            System.out.println("Signup test Passed");
        }else{
            System.out.println("Signup test Failed");
        }
        Thread.sleep(3000);

        driver.quit(); //closes everything

    }
}
