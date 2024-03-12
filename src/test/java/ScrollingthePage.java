import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class ScrollingthePage {
    public static void main(String args[]) throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        JavascriptExecutor js=(JavascriptExecutor)driver;
                js.executeScript("window.scrollBy(0,600)");
                Thread.sleep(5000);
                js.executeScript("document.querySelector('.tableFixHead').scrollTop=5000");

        List<WebElement> values= driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));
        int sum=0;
        for(int i=0;i<values.size();i++)
        {
            sum=sum + Integer.parseInt(values.get(i).getText());
        }
        System.out.println(sum);
        System.out.println(driver.findElement(By.xpath("//div[@class='totalAmount']")).getText());
    }
}
