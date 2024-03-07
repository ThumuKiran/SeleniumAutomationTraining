import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class Frames {
    public static void main(String args[]) throws InterruptedException{
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://jqueryui.com/droppable/");
        List<WebElement> iframesize = driver.findElements(By.tagName("iframe"));
        System.out.println(iframesize.size());
        //Switching to frame using webelement
        //driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
        //Switching to frame using index
        driver.switchTo().frame(0);
        //Printing the index size
        Actions a=new Actions(driver);
        WebElement Source= driver.findElement(By.cssSelector("div#draggable"));
        WebElement destination= driver.findElement(By.xpath("//div[@id='droppable']"));
        a.dragAndDrop(Source,destination).build().perform();
        driver.switchTo().defaultContent();

    }
}
