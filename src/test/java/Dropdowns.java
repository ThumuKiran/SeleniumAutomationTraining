import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class Dropdowns {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        //checkboxes
        Assert.assertFalse(driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).isSelected());
        driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).click();
        Thread.sleep(2000);
        //System.out.println(driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).isSelected());
        Assert.assertTrue(driver.findElement(By.xpath("//input[contains(@id,'IndArm')]")).isSelected());
        // Checkboxes count
        Thread.sleep(2000);
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type='checkbox']"));
        System.out.println(checkboxes.size());

        // When tag is select (static dropdown)
        WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(staticDropdown);
        dropdown.selectByIndex(3);
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        dropdown.selectByValue("INR");
        System.out.println(dropdown.getFirstSelectedOption().getText());
        // dynamic dropdown
        driver.findElement(By.id("divpaxinfo")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        int i = 1;
        while (i < 5) {
            driver.findElement(By.id("hrefIncAdt")).click();
            i++;
        }
        /*for(int i=1;i<5;i++){
          driver.findElement(By.id("hrefIncAdt")).click();
        }*/
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
        Assert.assertEquals(driver.findElement(By.id("divpaxinfo")).getText(), "5 Adult");
        driver.findElement(By.xpath("//input[@id=\"ctl00_mainContent_ddl_originStation1_CTXT\"]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//a[@value=\"HYD\"]")).click();
        driver.findElement(By.xpath("(//a[@value=\"VGA\"])[2]")).click();
        // invisible dropdown
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div/fieldset/input[@id='autosuggest']")).sendKeys("ind");
        Thread.sleep(3000);

        List<WebElement> options = driver.findElements(By.cssSelector("li[class='ui-menu-item'] a"));

        for (WebElement option : options) {

            if (option.getText().equalsIgnoreCase("India")) {

                option.click();

                break;

            }

        }
        //Calender
        driver.findElement(By.xpath("//input[contains(@id,'ctl00_mainContent_view_date1')]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//td[contains(@class,'ui-datepicker-today')]")).click();
        //to check it is enabled or not
        //System.out.println(driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date2']")).isEnabled());
        System.out.println(driver.findElement(By.id("spclearDate")).getAttribute("style"));
        driver.findElement(By.xpath("//label[text()='Round Trip']")).click();
        System.out.println(driver.findElement(By.id("spclearDate")).getAttribute("style"));
        if (driver.findElement(By.id("spclearDate")).getAttribute("style").contains("display: block;")) {
            System.out.println("is enabled");
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);

        }
        System.out.println("Successfully Completed");
        driver.findElement(By.xpath("//input[@name='ctl00$mainContent$btn_FindFlights']")).click();
    }


}
