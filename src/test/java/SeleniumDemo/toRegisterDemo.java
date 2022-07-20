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

public class toRegisterDemo {
    ExtentReports extent = new ExtentReports();
    ExtentSparkReporter spark = new ExtentSparkReporter("target/Register.html");
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

    @Test (priority = 1)
    public void test_006(){
        ExtentTest test = extent.createTest("Register page title ").assignAuthor("Rinal").
                assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" capturing  Register Page title  ");

        if (driver.getTitle().equals("Register Account")){
            test.pass("Page title Matches");
        }
        else {
            test.fail("Page title not Matched ");
        }

    }
    @Test(priority=1)
    public void test_007(){
        ExtentTest test = extent.createTest("first name box input ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" i give first name unto 15 characters  ");
        WebElement first_name = driver.findElement(By.id("input-firstname"));
        Assert.assertTrue(first_name.isDisplayed() && first_name.isEnabled());

    }

    @Test
    public void test_008(){
        ExtentTest test = extent.createTest("First name length check").assignAuthor("Rinal").
                assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" I will check the lower and higher limit of first name  ");
        WebElement first_name = driver.findElement(By.id("input-firstname"));
        first_name.clear();
       String input = "Erica" ;
        first_name.sendKeys(input);
        if ((input.length() > 0)  && (input.length()<33 )){
            test.pass("first matches the given validation");
        }
        else {
            test.fail("first does not matches the given validation");
        }

    }
    @Test
    public void test_009(){
        ExtentTest test = extent.createTest("last name box input ").assignAuthor("Rinal").assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" i give first name unto 15 characters  ");
        WebElement last_name = driver.findElement(By.id("input-lastname"));
        Assert.assertTrue(last_name.isDisplayed() && last_name.isEnabled());

    }

    @Test
    public void test_010(){
        ExtentTest test = extent.createTest("Last name length check").assignAuthor("Rinal").
                assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" I will check the lower and higher limit of Last name  ");
        WebElement last_name = driver.findElement(By.id("input-lastname"));
        last_name.clear();
       String input = "Lokhandeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee";
        last_name.sendKeys(input);
        if ((input.length() > 0)  && (input.length()<33 )){
            test.pass("Last name matches the given validation");
        }
        else {
            test.fail("Last name does not matches the given validation");
        }
    }
    //Verifying redirection to the Login page from Registration page
    @Test
    public void AccountRedirectionTest()
    {
        ExtentTest test = extent.createTest("Account  Redirection Test").assignAuthor("Rinal").
                assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" I will check the Account redirection test  ");

        WebElement Accountlink = driver.findElement(By.xpath("//*[@id=\"account-register\"]/ul/li[2]/a"));
        Accountlink.click();

        String expectedURL = "http://tutorialsninja.com/demo/index.php?route=account/login";
        String actualURL = driver.getCurrentUrl();
        //System.out.println(actualURL);
        Assert.assertEquals(actualURL, expectedURL);

        String expectedTitle = "Account Login";
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }


 @Test
    public void loginRedirectionTest()
    {
        ExtentTest test = extent.createTest("login Redirection Test").assignAuthor("Rinal").
                assignCategory("Functional Testing").assignDevice("Windows");
        test.info(" I will check the login redirection test  ");

        WebElement loginLink = driver.findElement(By.xpath("//*[@id=\"content\"]/p/a"));
        loginLink.click();

        String expectedURL = "http://tutorialsninja.com/demo/index.php?route=account/login";
        String actualURL = driver.getCurrentUrl();
        //System.out.println(actualURL);
        Assert.assertEquals(actualURL, expectedURL);

        String expectedTitle = "Account Login";
        String actualTitle = driver.getTitle();
        //System.out.println(actualTitle);
        Assert.assertEquals(actualTitle, expectedTitle);
    }

}
