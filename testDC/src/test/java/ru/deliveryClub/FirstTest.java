package ru.deliveryClub;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        driver.get("https://www.delivery-club.ru/entities/food");
        driver.getTitle();

        Assert.assertTrue(driver.getTitle().equals("Delivery club"));
        System.out.println("Test #1: Title name check successfully completed");
    }
}
