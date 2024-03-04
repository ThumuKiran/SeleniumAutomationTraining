import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


import java.time.Duration;

public class Assignement2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/angularpractice/");
        driver.findElement(By.xpath("//input[contains(@class,'ng-invalid')][@name='name']")).sendKeys("Kiran");
        driver.findElement(By.xpath("//input[contains(@class,'ng-invalid')][@name='email']")).sendKeys("kiranthumu007@gmail.com");
        driver.findElement(By.xpath("//input[contains(@class,'form-control')][@id='exampleInputPassword1']")).sendKeys("Password");
        driver.findElement(By.xpath("//input[@id='exampleCheck1']")).click();
        driver.findElement(By.xpath("//select[@id='exampleFormControlSelect1']")).click();
        driver.findElement(By.xpath("//select/option[2]")).click();
        driver.findElement(By.xpath("//label[text()='Student']")).click();
        driver.findElement(By.xpath("//input[@name='bday']")).sendKeys("12-10-1993");
        driver.findElement(By.xpath("//input[@value='Submit']")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText());

}}
