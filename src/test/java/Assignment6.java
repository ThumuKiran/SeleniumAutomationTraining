import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
    public static void main(String[] args){
        WebDriver driver=new ChromeDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.findElement(By.xpath("//input[@id='checkBoxOption2']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@id=\"checkbox-example\"]/fieldset/label[2]")).getText());
        String Store=driver.findElement(By.xpath("//div[@id=\"checkbox-example\"]/fieldset/label[2]")).getText();
        WebElement dropdown=driver.findElement(By.xpath("//Select[@id='dropdown-class-example']"));
        Select s=new Select(dropdown);
        s.selectByVisibleText(Store);
        driver.findElement(By.xpath("//input[@id='name']")).sendKeys(Store);
        driver.findElement(By.xpath("//input[@id='alertbtn']")).click();
        Assert.assertEquals(driver.switchTo().alert().getText(),"Hello " + Store +", share this practice page and share your knowledge");
        System.out.println("Hello "+ Store +", share this practice page and share your knowledge");
        driver.switchTo().alert().accept();
    }
}
