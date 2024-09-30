package HW16;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ImplicitWait {
    public static void main(String[] args) {

//Verifying Checkbox Selection Using Synchronization
//- I want to navigate to `https://syntaxprojects.com/synchronization-waits-homework.php`
//- So that I can verify the functionality of selecting **Option 1** in the checkbox after the appropriate wait time.

        //prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/synchronization-waits-homework.php");

        //1. **Button Click and Checkbox Selection**:
        //   - Click on the button labeled **"Click me"**.
        WebElement clickMeBtn = driver.findElement(By.xpath("//button[@id='show_text_synchronize_three']"));
        clickMeBtn.click();

        //   - Use an appropriate wait method to wait until the checkbox options appear.
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        //   - Once the checkboxes are visible, select **Option 1** from the list of checkboxes.
        WebElement option1CB = driver.findElement(By.xpath("//input[@value='Option-1']"));
        WebElement option2CB = driver.findElement(By.xpath("//input[@value='Option-2']"));
        if(option1CB.isDisplayed() && option2CB.isDisplayed()){
            option1CB.click();
            System.out.println("Checkboxes are displayed");
            System.out.println("Option1 selected");
        }


    }
}



