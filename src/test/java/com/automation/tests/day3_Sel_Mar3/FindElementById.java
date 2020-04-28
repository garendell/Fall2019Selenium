package com.automation.tests.day3_Sel_Mar3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");

        // WebElement username =  // this part is not necessary because???
        Thread.sleep(3000);
        driver.findElement(By.name("username")).sendKeys("tomsmith");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword");
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.tagName("h4")).getText();
        if (expected.equals(actual)) {
            System.out.println("Login test Passed");
        } else {
            System.out.println("Login test Failed");
        }

        //now let's logout.  it's difficult to figure out how to find the logout button
        //because it is tagged as <a   which means a link.
        // it looks like a button, but it's a link.
        //tips about using the cntrl-F search bar:
        // to find attribute like name, id, class, just pub the
        //attri3bute=value pair in square brackets[].  [name="password]
        // a button image on the page may be a <button> or it may be a link <a.
        //we can find the linked text like this (using the visible text):

        WebElement logout = driver.findElement(By.linkText("Logout"));
        //In this test, there was a question about a space in the code.
        // If there is any question about the exact wording or spacing of a linktext,
        // you can use partialLinkText --
        // linkText is like .equals() ; partialLinkText is like .contains() ;
        Thread.sleep(3000);
        logout.click();
        Thread.sleep(3000);
        // getAttribute - returns attribute value
        // <a class = "button secondary radius" href= "/logout>
        // <i class = "icon-2x icon-signout"> Logout</i> </a>
        // a - is a tag name; class is an attribute; href is an attribute;
        // logout is visible text.
        //  if you say getAttribute("class:) it will return "button secondary radius"
        //  "make sure this attribute is present in the element" ... ????

        // let's do a negative test (invalid credentials)
        // set up the exact same code as before, but put in an invalid word in sendKeys:
        driver.findElement(By.name("username")).sendKeys("invalid username");
        Thread.sleep(3000);
        driver.findElement(By.name("password")).sendKeys("invalid password");
        Thread.sleep(3000);
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(3000);

//   idk why these two lines are here - i think i missed the last minutes:
//   String expected = "Welcome to the Secure Area. When you are done click logout below.";
//   String actual = driver.findElement(By.tagName("h4")).getText();

        if (expected.equals(actual)) {
            System.out.println("Login test Passed");
        } else {
            System.out.println("Login test Failed");

            driver.quit();

        }
    }
}
