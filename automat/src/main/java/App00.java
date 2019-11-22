//import com.sun.org.apache.xalan.internal.xsltc.compiler*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.opera.OperaDriverService;
import org.openqa.selenium.opera.OperaOptions;

import java.io.File;

public class App00 {
    public static void main(String[] args) throws Exception {
        /**
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("D:\\Drivers\\operadriver_win64\\operadriver.exe")).build();
        ChromeDriver driver = new ChromeDriver(service);
        driver.get("http://it-ebooks.info");
        System.out.println(driver.getTitle());

        OperaDriverService service = new OperaDriverService.Builder()
                .usingDriverExecutable(new File("C:\\Windows\\System32\\operadriver.exe")).build(); //path to OperaDriver
        OperaOptions options = new OperaOptions();
        options.setBinary("C:\\Users\\Anastasia\\AppData\\Local\\Programs\\Opera\\launcher.exe");
        OperaDriver driver = new OperaDriver(service, options);
        driver.get("http://it-ebooks.info");
        System.out.println(driver.getTitle());

         */

        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("D:\\Drivers\\chromedriver.exe")).build();
        ChromeDriver driver = new ChromeDriver(service);
        driver.get("http://it-ebooks.info");
        System.out.println(driver.getTitle());
        System.out.println(driver.getCurrentUrl());

        driver.findElement(By.id("q")).sendKeys("Automation");
//        driver.findElement(By.id("q")).sendKeys(Keys.RETURN);
        driver.findElement(By.cssSelector("input[type='submit']")).click();
        Thread.sleep(10000);

        driver.quit();
    }
}
