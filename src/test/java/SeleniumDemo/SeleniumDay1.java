package SeleniumDemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumDay1 {

    public static void main(String[] args) {
        //launch browser
    //System.setProperty("webdriver.chrome.driver", "C:\\Users\\Rinal.Lokhande\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        //url
        driver.get("https://www.saucedemo.com/");
        //title, url, page source
        System.out.println("title of the page is : "+driver.getTitle());
        System.out.println("url of the page is : "+driver.getCurrentUrl());
        System.out.println("page source of the page is : "+driver.getPageSource());


    }
}
