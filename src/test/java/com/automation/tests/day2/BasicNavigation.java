package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {
    public static void main(String[] args) throws InterruptedException {

        /* to start a selenium script we need to:
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
        /*
        there are other commands for back forward and refresh, and navigate to other site,
        like this:
        driver.navigate().to(url);  //for example, navigate to (amazon)
        driver.navigate().back();    // for example, you could use this to go back to google after amz
        driver.navigate().forward();   //the same as the arrows, back, forward, refresh...
        driver.navigate().refresh();
         */

        //if you want to open in maximized or in full screen, you can do this:
        driver.manage().window().maximize();

        //now you can send this to github by clicking the green check mark at the top right.
        //it didn't work - his shows a push button, mine doesn't.  try again. **there's an option to commit AND PUSH,

        Thread.sleep(3000);

        String title = driver.getTitle();  //method that returns title of the page
        String expectedTitle = "Google";
        System.out.println("title is...:" +title);

        if(expectedTitle.equals(title) ){
            System.out.println("Test Passed");
        } else {
            System.out.println("Test Failed");
        }
        //ok, let's try going back to google, then going to Amz, in same window:
        driver.navigate().back();
        driver.navigate().to("http://amazon.com");
        if(driver.getTitle().toLowerCase().contains("Amazon")  ){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
        driver.close(); //to close browser

     //troubleshoot:  if you have any issues with running this, first try updating Chrome and updating Intellij.
        //try to commit to github
    }
    public static void verifyEquals(String arg1, String arg2){
        if(  arg1.equals(arg2) ) {
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
    }

}
