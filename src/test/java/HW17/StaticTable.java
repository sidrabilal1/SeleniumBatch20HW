package HW17;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;


//Verifying Dynamic Table Search Functionality
//Navigate to `https://syntaxprojects.com/table-search-filter-demo-homework.php`
//Ensure the table fulfills the following criteria dynamically.

public class StaticTable {
    public static void main(String[] args) {

        //Prerequisites
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/table-search-filter-demo-homework.php");

        String country = "USA";

        //1. **Print All Entries with the Country "USA"**:
        List<WebElement> columnCountry = driver.findElements(By.xpath("//table/tbody/tr/td[3]"));
        int count = 1;

        for (WebElement column : columnCountry) {
            if (column.getText().equals(country)) {

                //   - Dynamically search the table for entries where the country is **"USA"**.
                WebElement row = driver.findElement(By.xpath("//table/tbody/tr[" + count + "]"));

                //   - Print all the rows matching criteria
                System.out.println(row.getText());
            }
            count++;
        }


        //2. **Dynamic Logic**:
        //   - Ensure the search and filtering logic is **dynamic** and does not rely on hard-coded xpaths.
        //   - The code should be flexible enough to accommodate changes in the country name
        //   - If the country name changes (e.g., from "USA" to "Canada"),
        //   the same logic should still work, and the output should reflect the correct entries based on the updated country.

        country="Canada"; //changing country name
        count =1;
        for (WebElement column : columnCountry) {
            if (column.getText().equals(country)) {
                WebElement row = driver.findElement(By.xpath("//table/tbody/tr[" + count + "]"));
                System.out.println(row.getText());
            }
            count++;
        }


    }
}
