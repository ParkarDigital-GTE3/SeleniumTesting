package SeleniumDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test {
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/test.html");
    WebDriver driver ;
    @BeforeTest
    public void setup(){
        spark.config().setDocumentTitle("Register_");
        extent.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://tutorialsninja.com/demo/index.php?route=account/register");

    }
    @AfterTest
    public void teardown(){
        extent.flush();//dump all the contents
        driver.quit();
    }

    @Test
    public void test_007(){
        ExtentTest test = extent.createTest("first name box input ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" giving first name as : Erica ");
        WebElement first_name = driver.findElement(By.id("input-firstname"));
        Assert.assertTrue(first_name.isDisplayed() && first_name.isEnabled());
        first_name.clear();
        first_name.sendKeys("Erica");
        System.out.println(first_name.getText());//System.out.println(first_name.getAttribute("Erica"));
       // System.out.println(first_name.equals("Erica"));
    }

}
