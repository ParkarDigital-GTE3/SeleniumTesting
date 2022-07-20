package SeleniumDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TextboxAutomate {
    WebDriver driver;

    @BeforeMethod
    void setup(){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\Rinal.Lokhande\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();

        driver.get("https://demoqa.com/elements");
        driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div[1]/div/div/div[1]/div")).click();
    }

    @Test
    void autoTextbox(){
        driver.findElement(By.id("item-0")).click();
        driver.findElement(By.id("userName")).sendKeys("Rinal Lokhande");
        driver.findElement(By.id("userEmail")).sendKeys("lok@gmail.com");
        driver.findElement(By.id("currentAddress")).sendKeys("Princenhagelaan 9 4813 DA Breda ");
        driver.findElement(By.id("permanentAddress")).sendKeys("hello world");
        WebElement ele = driver.findElement(By.id("submit"));
        ele.click();
    }

    @AfterMethod
    void  autoMethod(){
        driver.quit();
    }
}
