package SeleniumDemo;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

public class tutorialsNinjaDemo {

    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/homepage.html");
    WebDriver driver ;
    @BeforeTest
    public void setup(){
        spark.config().setDocumentTitle("TutorialsNinjaDemoReport");
        extent.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        driver.get("http://tutorialsninja.com/demo/");

    }
    @AfterTest
    public void teardown(){
        extent.flush();//dump all the contents
        driver.quit();
    }

   /* @Test(priority = 1)
    public void test_001(){
        ExtentTest test = extent.createTest("Verify Title").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");

        test.info("I am capturing page title  ");
        String pageTitle = driver.getTitle();
        test.info("I have captured page title  ");
        if (pageTitle.equals("Your Store")) {
            test.pass("Page title is verified: Title captured   " + pageTitle);
        }
        else {
            test.fail("Page title not Verified : title not matched" + pageTitle);
        }

    }
    @Test(priority = 1)
    public void test_002(){
        ExtentTest test = extent.createTest("Verify Logo Presence ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");

        test.info("I am capturing page Logo  ");
        WebElement Logo = driver.findElement(By.id("logo"));
        test.info("I have captured page logo  ");
        if (Logo.isDisplayed()) {
            test.pass("Page Logo present " );
        }
        else {
            test.fail("Page Logo absent" );
        }

    }
@Test(priority = 2)
    public void test_003(){
        ExtentTest test = extent.createTest("check if all buttons displayed are enabled ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");

        test.info("I am capturing all buttons  ");

        WebElement Desktop = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[1]/a"));
        WebElement Laptop = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[2]/a"));
        WebElement Components = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[3]/a"));
        WebElement Tablets = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[4]/a"));
        WebElement Software = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[5]/a"));
        WebElement Phones = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[6]"));
        WebElement Camera = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[7]/a"));
        WebElement MP3player = driver.findElement(By.xpath("//*[@id=\"menu\"]/div[2]/ul/li[8]/a"));

    SoftAssert s= new SoftAssert();

        test.info("I have captured all buttons  ");
        s.assertTrue(Desktop.isDisplayed() && Desktop.isEnabled());
        s.assertTrue(Laptop.isDisplayed() && Laptop.isEnabled());
        s.assertTrue(Components.isDisplayed() && Components.isEnabled());
        s.assertTrue(Tablets.isDisplayed() && Tablets.isEnabled());
        s.assertTrue(Software.isDisplayed() && Software.isEnabled());
        s.assertTrue(Phones.isDisplayed() && Phones.isEnabled());
        s.assertTrue(Camera.isDisplayed() && Camera.isEnabled());
        s.assertTrue(MP3player.isDisplayed() && MP3player.isEnabled());
        s.assertAll();

    }

    @Test(priority = 4)
    public void test_004(){
        ExtentTest test = extent.createTest(" Testing search box  ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");

        test.info("I am capturing search box  ");
        WebElement SearchBox = driver.findElement(By.xpath("//*[@id=\"search\"]/input"));
        test.info("I have captured search box  ");

        test.info("Giving Input  ");
        SearchBox.sendKeys("Iphone"+ Keys.ENTER);
    }*/
 @Test(priority = 3)
    public void test_005(){
        ExtentTest test = extent.createTest(" Testing product name ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");

        test.info("I am capturing product name link  ");

        test.info("I have captured product name  link  ");
//        product.click();
    }

}
