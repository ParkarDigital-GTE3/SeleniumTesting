package SeleniumDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class qaDemo {
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");


    WebDriver driver;
    @BeforeMethod
    public void setup(){
        extent.attachReporter(spark);
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rinal.Lokhande\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/login");


    }


    @Test(priority = 1)
    public void LoginButton(){
        extent.attachReporter(spark);
        driver.findElement(By.id("login")).isDisplayed();
        System.out.println("login button displayed ");
        driver.findElement(By.id("login")).isEnabled();
        System.out.println("login button enabled ");

    }
    @Test(priority = 2)
    public void NewUserButton(){
        extent.attachReporter(spark);
        driver.findElement(By.id("newUser")).isDisplayed();
        driver.findElement(By.id("newUser")).isEnabled();
    }

    @Test
    public void Login(){
        extent.attachReporter(spark);
        driver.findElement(By.id("userName")).sendKeys("Rinal");
        driver.findElement(By.id("password")).sendKeys("Rinal@123");
        driver.findElement(By.id("login")).sendKeys(Keys.RETURN);
    }

    @AfterMethod
    public void  Teardown(){
        extent.attachReporter(spark);
        driver.quit();

    }
}


