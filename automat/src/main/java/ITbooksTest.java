import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;

public class ITbooksTest {
    ChromeDriver driver;
    MainPage page;

    @Before
    public void setUp() {
        ChromeDriverService service = new ChromeDriverService.Builder()
                .usingDriverExecutable(new File("D:\\Drivers\\chromedriver.exe")).build();
        driver = new ChromeDriver(service);
        WebDriverWait wait = new WebDriverWait(driver, 30);

        page = new MainPage(driver);

        driver.get("http://it-ebooks.info");

        System.out.println("Step 1: Enter search phrase");
        page.enterSearchableText("Automation");

        System.out.println("Step 2: Click search button");
        page.clickSearchButton();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("container")));
    }

    @Test
    public void testBooksSearch() {
        Assert.assertFalse(driver.getCurrentUrl().contains("https://it-ebooks-search.info/search?q=automation"));
    }

    @After
    public void tearDown() {
        if (driver != null) driver.quit();
    }
}
