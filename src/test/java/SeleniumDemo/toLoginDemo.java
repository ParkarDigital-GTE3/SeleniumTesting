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

public class toLoginDemo {
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Login.html");
    WebDriver driver ;
    @BeforeTest
    public void setup(){
        spark.config().setDocumentTitle("Login_");
        extent.attachReporter(spark);
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://tutorialsninja.com/demo/index.php?route=account/login");
    }
    @AfterTest
    public void teardown(){
        extent.flush();//dump all the contents
        driver.quit();
    }

    @Test (priority = 1)
    public void test_001(){
        ExtentTest test = extent.createTest("To check Email and Password input box responsive").assignAuthor("Rinal")
                .assignCategory("Functional Testing").assignDevice("Windows");
        //email
        test.info("Entering email to check whether textbox is responsive ");
        WebElement Email = driver.findElement(By.id("input-email"));

        test.info("Entering password to check whether textbox is responsive");
        WebElement Password = driver.findElement(By.id("input-password"));
        Assert.assertTrue(Email.isDisplayed() && Email.isEnabled() && Password.isDisplayed() && Password.isEnabled());

    }

    @Test (priority = 2)
    public void test_002(){
        ExtentTest test = extent.createTest("Verifying Login with wrong input  ").assignAuthor("Rinal")
                .assignCategory("Functional Testing").assignDevice("Windows");

        //email
        test.info("this email is not registered : expected fail output : input email");
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("Lokhande@gmail.com");
        test.info(" input password  ");
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("erica123");

        //click for login
        test.info("clicked for Login ");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

        String  expected_title = "My Account";
        if (expected_title.equals(driver.getTitle())){test.pass("Login successful\n");}
        else {test.fail(" Warning: No match for E-Mail Address and/or Password.\n");}
    }


    @Test(priority = 3)
    public void test_003(){
        ExtentTest test = extent.createTest("Verifying Login ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" giving Email  ");

        //email
        WebElement Email = driver.findElement(By.id("input-email"));
        Email.clear();
        Email.sendKeys("Lo@gmail.com");

        //password
       test.info("giving password ");
        WebElement Password = driver.findElement(By.id("input-password"));
        Password.clear();
        Password.sendKeys("erica123");

        //click for login
        test.info("clicked for Login ");
        driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

        String  expected_title = "My Account";
        if (expected_title.equals(driver.getTitle())){test.pass("Login successful\n");}
        else {test.fail(" Warning: No match for E-Mail Address and/or Password.\n");}
    }
 @Test
    public  void Test_004(){
     ExtentTest test = extent.createTest("Verifying Login with wrong email format ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");
     test.info(" giving Email : ");
     //email
     WebElement Email = driver.findElement(By.id("input-email"));
     Email.clear();
     Email.sendKeys("Lo@@@@@gmailcom");

     //password
     test.info("giving password ");
     WebElement Password = driver.findElement(By.id("input-password"));
     Password.clear();
     Password.sendKeys("erica123");

     //click for login
     test.info("clicked for Login ");
     driver.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/form/input")).click();

     String  expected_title = "My Account";
     if (expected_title.equals(driver.getTitle())){test.pass("Login successful\n");}
     else {test.fail(" Warning: No match for E-Mail Address and/or Password.\n");}
 }


}
