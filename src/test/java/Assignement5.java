import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Assignement5 {
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();
        List<WebElement> iframesize = driver.findElements(By.tagName("frame"));
        System.out.println(iframesize.size());
        //for frames we can use either id, name, index[]
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-middle");
        System.out.print(driver.findElement(By.xpath("//div[@id='content']")).getText());

    }

}
