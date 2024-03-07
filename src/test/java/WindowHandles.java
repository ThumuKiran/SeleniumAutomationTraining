import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.util.Strings;

import java.util.Iterator;
import java.util.Set;

public class WindowHandles{
    public static void main(String[] args) throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        System.setProperty("Webdriver.Chrome.driver","C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.cssSelector("a.blinkingText")).click();
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it= windows.iterator();
        String Window1= it.next();
        String Window2= it.next();
        driver.switchTo().window(Window2);
        System.out.println(driver.findElement(By.cssSelector("p.red")).getText());
        String email=driver.findElement(By.cssSelector("p.red")).getText().split("at")[1].trim().split(" ")[0];
        driver.switchTo().window(Window1);
        driver.findElement(By.cssSelector("input#username")).sendKeys(email);
    }
}

