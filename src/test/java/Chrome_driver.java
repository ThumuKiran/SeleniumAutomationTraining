import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Chrome_driver {
    public static void main(String Args[]) {
        // setting up the webdriver
        WebDriver driver = new ChromeDriver();
        //webdriver path (this is not mandatory without this also chrome driver will work)
        System.setProperty("webdriver.chrome.driver","Resouce/chromedriver.exe");
        //hittin the URL
        driver.get("https://rahulshettyacademy.com/");
        // Printing the title of the page
        System.out.println(driver.getTitle());
        // Printing the current URL
        System.out.println(driver.getCurrentUrl());
        //closing the tab
        driver.close();
        //closing the hole driver
        driver.quit();

    }
}



