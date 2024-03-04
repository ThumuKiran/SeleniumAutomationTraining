import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Xpath {
    public static void main(String args[]) throws InterruptedException {
        // setting up the webdriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys("Kiran");
        driver.findElement(By.name("inputPassword")).sendKeys("ABC");
        driver.findElement(By.className("signInBtn")).click();
        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
        driver.findElement(By.linkText("Forgot your password?")).click();
        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Ramu");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("kiran.thumu@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).clear();
        System.out.println("Clearing the Screen");
        driver.findElement(By.xpath("//input[@type='text'][2]")).sendKeys("kiran@gmail.com");
        driver.findElement(By.cssSelector("input[placeholder='Phone Number']")).sendKeys("9999999999");
        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.xpath("//form/p[@class='infoMsg']")).getText());
        driver.findElement(By.cssSelector(".go-to-login-btn")).click();
        driver.findElement(By.xpath("//form[@class='form']/input[1]")).sendKeys("Kiran");
        driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys("rahulshettyacademy");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span/input[contains(@id,'One')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        System.out.println("Sucessfully Logged In");
        Thread.sleep(2000);
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")),"You are successfully logged in.");
        driver.close();
    }
}
