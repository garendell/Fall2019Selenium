package com.automation.tests.day2_Sel_Mar1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class JumpToNewWindow {
    public static void main(String[] args) throws Exception {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/open_new_tab");
        Thread.sleep(3000);
        //every window has its own id, called a window handle
        // we can switch between windows using the window handle
        String windowHandle = driver.getWindowHandle();
        // getWindowHandles() returns id's of ALL currently opened windows
        System.out.println(windowHandle);  // print those id's

        Set<String> windowHandles = driver.getWindowHandles();
        //this is using Set, the collection structure that omits duplicates
        System.out.println(windowHandles); //this prints out the set - notice: name is plural, handleSSS
        //name of the Set, not the driver get method.

        //  driver.switchTo().window( need window id here     );  to get the window id we can use a loop
        for (String windowId :  windowHandles  ) {
            if (!windowId.equals(windowHandle)) {
                //if the window Id is different from the current one, then open the other one.
                driver.switchTo().window(windowId);
            }
        }
          driver.close();
        //or   driver.quit();
    }
}

//Now we know how to navigate, open a site, close a site, go back, go forward,
// open a specific window, switch to a different window, close one window or quit all windows.
//now let's talk about how to search and find specific elements.

//Locators: Id, Class name, tag name, Name, Link text Partial Link Text, XPath, CSS
//Find the HTML text for the site (inspect)
// ControlF opens a search box to find elements (NOT the "filter" box)
// enter the element name in the search box, enclosing it in square brackets