package SeleniumDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class searchTestCases {
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Spark.html");

    WebDriver driver;

    @BeforeTest
    public void BrowserLaunch() {
        spark.config().setDocumentTitle("MyReport");
        extent.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("https://www.google.com");
    }

    @AfterTest
    public void teardown() {
        extent.flush();//dump all the contents
        driver.quit();
    }

    @Test
    public void Test_001() {
        ExtentTest test = extent.createTest("Verify Title").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");

        test.info("I am capturing page title  ");
        String pageTitle = driver.getTitle();
        test.info("I have captured page title  ");
        if (pageTitle.equals("Google")) {
            test.pass("Page title is verified: Title captured   " + pageTitle);
        }
        else {
            test.fail("Page title not Verified : title not matched" + pageTitle);
        }
    }
    @Test
    public void Test_002() {
        ExtentTest test = extent.createTest("Verify Title").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");

        test.info("I am capturing page title  ");
        String pageTitle = driver.getTitle();
        test.info("I have captured page title  ");
        if (pageTitle.equals("Google")) {
            test.pass("Page title is verified: Title captured   " + pageTitle);
        }
        else {
            test.fail("Page title not Verified : title not matched" + pageTitle);
        }
    }


}
