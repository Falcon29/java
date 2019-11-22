package ru.deliveryClub;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {

    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/Anastasia/IdeaProjects/chromedriver.exe");
        driver = new ChromeDriver();
        System.out.println("Chrome driver: start");
    }

    @After
    public void tearDown() {
        System.out.println("Chrome driver: quit");
        driver.quit();
    }
}
