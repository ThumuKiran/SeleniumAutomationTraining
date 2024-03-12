import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class SSLCertification {
    public static void main(String ars[]) throws InterruptedException, IOException {
        //Accepting the unsecured links
        ChromeOptions options= new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriver driver=new ChromeDriver(options);
        System.setProperty("webdriver.chrome.driver","C:\\Users\\KN944UF\\IdeaProjects\\Automation\\Resouce\\chromedriver.exe");
        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());
        Thread.sleep(5000);
        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src,new File("C:\\Users\\KN944UF\\IdeaProjects\\Automation\\src\\test\\Screenshots\\Screenshot.png"));

    }
}
