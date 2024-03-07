import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignement3{
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        WebDriverWait W= new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("rahulshettyacademy");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("learning");
        driver.findElement(By.xpath("//span[text()=' User']")).click();
        W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='modal-body']")));
        System.out.println(driver.findElement(By.xpath("//div[@class='modal-body']")).getText());
        driver.findElement(By.xpath("//button[@id='okayBtn']")).click();
        driver.findElement(By.xpath("//select[@class='form-control']")).click();
        driver.findElement(By.xpath("//option[@value='teach']")).click();
        driver.findElement(By.xpath("//input[@id='terms']")).click();
        driver.findElement(By.xpath("//input[@id='signInBtn']")).click();
        W.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[@class='card-title']")));
        List<WebElement> orders = driver.findElements(By.xpath("//button[@class='btn btn-info']"));
        for(int i =0;i<orders.size();i++) {
            orders.get(i).click();
        }

        driver.findElement(By.xpath("//a[@class='nav-link btn btn-primary']")).click();
        System.out.println("Sucessfully Completed assignment 3");
    }}
