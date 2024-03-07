import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        WebDriverWait W= new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://the-internet.herokuapp.com/");
        driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
        W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Click Here']")));
        driver.findElement(By.xpath("//a[text()='Click Here']")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it= windows.iterator();
        String Window1= it.next();
        String Window2= it.next();
        driver.switchTo().window(Window2);
        System.out.println(driver.findElement(By.cssSelector("div.example")).getText());
        driver.switchTo().window(Window1);
        System.out.println(driver.findElement(By.cssSelector(".example")).getText());
    }
}
