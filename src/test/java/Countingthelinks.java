import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Countingthelinks {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver","C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        //Counting the URLS
        System.out.println(driver.findElements(By.tagName("a")).size());
        //Counting the URLS in footer page
        WebElement Footersize= driver.findElement(By.id("gf-BIG"));
        System.out.println(Footersize.findElements(By.tagName("a")).size());
        //Counting in URLS in footer page first table
        WebElement Table1=Footersize.findElement(By.cssSelector("div#gf-BIG table tbody tr td:nth-child(1) ul"));
        System.out.println(Table1.findElements(By.tagName("a")).size());
        //Clicking on eachlink in the first table and opening paes in different tab
        for(int i=1;i<Table1.findElements(By.tagName("a")).size();i++){
            String Clickontabes= Keys.chord(Keys.CONTROL,Keys.ENTER);
            Table1.findElements(By.tagName("a")).get(i).sendKeys(Clickontabes);

        }
        Thread.sleep(3000);
        //getting the title of the each page
        Set<String> windows=driver.getWindowHandles();
        Iterator<String> it= windows.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            System.out.println(driver.getTitle());
        }
    }
}
