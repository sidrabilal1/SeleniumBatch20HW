package HW3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IntroToLocators {
    public static void main(String[] args) {


        //Create object instance for Chrome Driver
        WebDriver driver = new ChromeDriver();

        //The user successfully opens Chrome and maximizes the window using `window().maximize()`
        driver.manage().window().maximize();

        //The user navigates to `https://www.syntaxprojects.com/locator-homework.php`
        driver.get("https://www.syntaxprojects.com/locator-homework.php");

        //The user should fill the form using any of the locators (`id`, `name`, `tagname`, `linktext`, `partial linktext`)
        //Fill Fullname by locator -> id
        WebElement fullName = driver.findElement(By.id("fullName"));
        fullName.sendKeys("Jackie Chan");

        //Fill Email by locator -> name
        WebElement email = driver.findElement(By.name("yourEmail"));
        email.sendKeys("amalgeorgegmail.com");

        //Fill Client name by locator -> name
        WebElement clientName = driver.findElement(By.name("ClientName"));
        clientName.sendKeys("sam");

        //Fill Client ID by locator -> id
        WebElement clientId = driver.findElement(By.id("ClientId"));
        clientId.sendKeys("9682898");

        //Fill Client Feedback by locator -> name
        WebElement clientFeedback = driver.findElement(By.name("Clientfeedback"));
        clientFeedback.sendKeys("Well done");

        //Fill Project Name by locator -> id
        WebElement projectName = driver.findElement(By.id("ProjectNameId"));
        projectName.sendKeys("Syntax Project");

        //Fill Project Deadline by locator -> id
        WebElement projectDeadline = driver.findElement(By.id("ProjectTimeId"));
        projectDeadline.sendKeys("20 September 2024");

        //Fill Current Address by locator -> id
        WebElement currentAddress = driver.findElement(By.id("CurrentAddressId"));
        currentAddress.sendKeys("22 lynbrook 11563 NY");

        //Fill Permanent Address by locator -> id
        WebElement permanentAddress = driver.findElement(By.id("PermanentAddressId"));
        permanentAddress.sendKeys("22 lynbrook 11563 NY");

        //When the user clicks the "Submit" button, all the entered options should be displayed on the screen
        //Find the submit button using locator -> name
        WebElement submitButton = driver.findElement(By.name("btn-submit"));
        submitButton.click();

        /* If the email address is not in the correct format (i.e., it doesn't contain an `@` sign),
         the form should not be submitted, and an error message should be displayed*/
        //Enter correct email address and click submit
        email.clear();
        email.sendKeys("amalgeorge@gmail.com");
        submitButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // When the user clicks on the "Click Here" link, a new tab should open in the browser
        //Find Click Here link
        WebElement clickHereLink = driver.findElement(By.linkText("Click Here."));
        clickHereLink.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close the browser
        driver.quit();




    }
}


