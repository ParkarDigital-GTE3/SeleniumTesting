package SeleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StatusofWebElement {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //url
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.get("https://www.saucedemo.com/");
        //set username and password
            driver.findElement(By.id("user-name")).sendKeys("standard_user");  
            driver.findElement(By.id("password")).sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            //compare actual title and expected title
        //final validation
        String expected_title = "Swag Labs";

        if(expected_title.equals(driver.getTitle())){
            System.out.println("....login Successful....");
        }
        else {
            System.out.println("....login Unsuccessful....");

        }
        driver.close();
    }
}
