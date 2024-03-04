import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.time.Duration;

public class Validation {
    public static void main(String args[]) throws InterruptedException {
        String name = "Kiran";
        // setting up the webdriver
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String password = getPassword(driver);
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.xpath("//form[@class='form']/input[1]")).sendKeys(name);
        driver.findElement(By.cssSelector("input[type*='Pass']")).sendKeys(password);
        Thread.sleep(1000);
        driver.findElement(By.xpath("//span/input[contains(@id,'One')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//input[@id='chkboxTwo']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[text()='Sign In']")).click();
        System.out.println("Sucessfully Logged In");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText());
        Assert.assertEquals(driver.findElement(By.xpath("//p[text()='You are successfully logged in.']")).getText(), "You are successfully logged in.");
        Thread.sleep(2000);
        System.out.println(driver.findElement(By.cssSelector("div.login-container h2")).getText());
        Assert.assertEquals(driver.findElement(By.cssSelector("div.login-container h2")).getText(), "Hello " + name + ",");
        System.out.println("Sucess");
        driver.findElement(By.cssSelector("button.logout-btn")).click();
        System.out.println("Successfully logged out");
        driver.close();
    }
    public static String getPassword(WebDriver driver) throws InterruptedException{
        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000);

        driver.findElement(By.cssSelector(".reset-pwd-btn")).click();

        String passwordText =driver.findElement(By.cssSelector("form p")).getText();

//Please use temporary password 'rahulshettyacademy' to Login.

        String[] passwordArray = passwordText.split("'");
        //0th index - Please use temporary password

        //1st index - rahulshettyacademy' to Login.

        //String passwordArray2 = passwordArray[1].split("'")[0];

        String password = passwordArray[1].split("'")[0];

        return password;
        //0th index - rahulshettyacademy

//1st index - to Login.
    }
}
