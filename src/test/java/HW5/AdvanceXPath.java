package HW5;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvanceXPath {
    public static void main(String[] args) {

//the user navigates to `https://syntaxprojects.com/advanceXpath-homework.php'
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/advanceXpath-homework.php");

        /*The user should enter the names of books in reverse order
        from least favorite to favorite using advanced Xpath (such as `parent`, `following-sibling`, or `preceding-sibling`)*/

        //enter the name of book3 using advanced Xpath
        WebElement Book3 = driver.findElement(By.xpath("//input[@id='least-favorite']"));
        Book3.sendKeys("Love triangle");

        //enter the name of book2 using advanced Xpath
        WebElement Book2 = driver.findElement(By.xpath("//input[@id='least-favorite']/preceding-sibling::input[1]"));
        Book2.sendKeys("Lord of the Rings");

        //enter the name of book1 using advanced Xpath
        WebElement Book1 = driver.findElement(By.xpath("//input[@id='least-favorite']/preceding-sibling::input[2]"));
        Book1.sendKeys("Happy singh");

        //The user should enter the name of their favorite book using advanced Xpath
        //enter the name of favourite book1 using advanced Xpath
        WebElement favouriteBook1 = driver.findElement(By.xpath("//input[@id='favouriteBook']"));
        favouriteBook1.sendKeys("QISA");

        //enter the name of favourite book2 using advanced Xpath
        WebElement favouriteBook2 = driver.findElement(By.xpath("//input[@id='favouriteBook']/following-sibling::input[1]"));
        favouriteBook2.sendKeys("Manzil");

        //enter the name of favourite book3 using advanced Xpath
        WebElement favouriteBook3 = driver.findElement(By.xpath("//input[@id='favouriteBook']/following-sibling::input[2]"));
        favouriteBook3.sendKeys("Harry Potter");

        //The user should enter the names of grandparent, parent, and child fields using advanced Xpath
        //enter the name of the grandparent
        WebElement grandParent = driver.findElement(By.xpath("//div[@id='familyTree']/child::input[1]"));
        grandParent.sendKeys("Jenny");

        //enter the name of the parent
        WebElement parent = driver.findElement(By.xpath("//div[@id='familyTree']/child::input[2]"));
        parent.sendKeys("James");

        //enter the name of the child
        WebElement child = driver.findElement(By.xpath("//div[@id='familyTree']/child::input[3]"));
        child.sendKeys("Aleesa");

        //wait time
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //close the browser
        driver.close();





    }
}







