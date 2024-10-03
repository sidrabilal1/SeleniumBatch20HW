package HW19;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.LinkedHashMap;
import java.util.List;

// ### User Story
//Verifying Dynamic Date Selection in the jQuery Date Picker
//Navigate to `https://syntaxprojects.com/jquery-date-picker-demo-homework.php`
//Ensure the correct "To" and "From" dates are selected from the calendar.

//#### Acceptance Criteria
//
//1. **Select "From" and "To" Dates**:
//   - Select the **From** date and the **To** date in the jQuery date picker.
//   - The code logic should be **dynamic**, meaning it should work with any selected dates without requiring any changes to the core logic.
//   - The selection should not rely on hard-coded date values and should be adaptable if the date range changes.

public class CalendarWithNavigation {

    WebDriver driver;
    int dateTobeSelected;
    String monthToBeSelected;
    int yearToBeSelected;

    public void openBrowser(String url) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    public void fromDatePicker(String month, int date, int year) {

        monthToBeSelected = month;
        dateTobeSelected = date;
        yearToBeSelected = year;
        WebElement fromDateInputBox = driver.findElement(By.xpath("//input[@id='from_date']"));
        fromDateInputBox.click();
        selectYear();
    }

    public void toDatePicker(String month, int date, int year) {

        monthToBeSelected = month;
        dateTobeSelected = date;
        yearToBeSelected = year;
        WebElement toDateInputBox = driver.findElement(By.xpath("//input[@id='to_date']"));
        toDateInputBox.click();
        selectYear();
    }

    public void selectYear() {

        boolean notFound = true;

        while (notFound) {
            WebElement year = driver.findElement(By.xpath("//div/span[@class='ui-datepicker-year']"));
            int currentYear = Integer.parseInt(year.getText());

            if (yearToBeSelected > currentYear) {
                navigateToNext();
            } else if (yearToBeSelected < currentYear) {
                navigateToPrevious();
            } else {
                notFound = false;
                selectMonth();
            }
        }
    }

    public void selectMonth() {

        LinkedHashMap<String, Integer> monthMap = new LinkedHashMap<>();
        monthMap.put("January", 1);
        monthMap.put("February", 2);
        monthMap.put("March", 3);
        monthMap.put("April", 4);
        monthMap.put("May", 5);
        monthMap.put("June", 6);
        monthMap.put("July", 7);
        monthMap.put("August", 8);
        monthMap.put("September", 9);
        monthMap.put("October", 10);
        monthMap.put("November", 11);
        monthMap.put("December", 12);

        boolean notFound = true;
        while (notFound) {
            WebElement month = driver.findElement(By.xpath("//div/span[@class='ui-datepicker-month']"));
            String currentMonth = month.getText();
            if (monthMap.get(monthToBeSelected) < monthMap.get(currentMonth)) {
                navigateToPrevious();
            } else if (monthMap.get(monthToBeSelected) > monthMap.get(currentMonth)) {
                navigateToNext();
            } else {
                notFound = false;
                selectDate();
            }
        }
    }


    public void selectDate() {
        List<WebElement> dates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
        for (WebElement date : dates) {
            String currentDate = date.getText();
            if (currentDate.equals(String.valueOf(dateTobeSelected))) {
                date.click();
                break;
            }
        }
    }


    public void navigateToNext() {
        WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));
        nextBtn.click();
    }

    public void navigateToPrevious() {
        WebElement previousBtn = driver.findElement(By.xpath("//span[text()='Prev']"));
        previousBtn.click();
    }

    public static void main(String[] args) {

        CalendarWithNavigation c = new CalendarWithNavigation();

        try {
            c.openBrowser("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");
            c.fromDatePicker("December", 2, 2023);
            c.toDatePicker("June", 10, 2027);
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            c.closeBrowser();
        }

    }

}
/*WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://syntaxprojects.com/jquery-date-picker-demo-homework.php");

        WebElement calander1 = driver.findElement(By.xpath("//input[@id='from_date']"));
        calander1.click();

        boolean isfound=false;
        while (!isfound) {
            WebElement month = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']"));
            WebElement year = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
            String currentMonth = month.getText();
            String currentYear = year.getText();
            if (currentMonth.equals("January") && currentYear.equals("2025")) {
                //select the date
                List<WebElement> allDates = driver.findElements(By.xpath("//table/tbody/tr/td/a"));
                for(WebElement date:allDates){
                    if(date.getText().equals("4")){
                        date.click();
                        isfound=true;
                        break;
                    }
                }
            } else {
                //click on next button
                WebElement nextBtn = driver.findElement(By.xpath("//span[text()='Next']"));
                nextBtn.click();
            }
        }

    }
}
*/