import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class CalenderUI {
    public static void main(String[] ars) {
        String year = "2028";
        String date = "16";
        String month = "5";
        String[] expectedList = {month,date,year};
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//button[@class='react-date-picker__calendar-button react-date-picker__button']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[@class='react-calendar__navigation__label']")).click();
        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();
        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month) - 1).click();
        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();
        List<WebElement> actualList = driver.findElements(By.cssSelector("Input.react-date-picker__inputGroup__input"));
        for (int i = 0; i < actualList.size(); i++) {
            System.out.println(actualList.get(i).getAttribute("value"));
            Assert.assertEquals(actualList.get(i).getAttribute("value"), expectedList[i]);
        }
    }
}