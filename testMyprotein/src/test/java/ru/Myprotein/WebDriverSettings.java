package ru.Myprotein;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverSettings {
    WebDriver driver; //создаю переменную драйвер

    @Before
    public void setUp() {    //метод для запуска драйвера
        System.setProperty("webdriver.chrome.driver", "/Users/Anastasia/IdeaProjects/chromedriver.exe");  //путь до ХромДрайвера на ЖД
        driver = new ChromeDriver();   //инициализирую драйвер ХромДрайвером
        System.out.println("Chrome driver enabled");  //сообщение о том, что драйвер запущен
    }

    /*
    @After
    public void tearDown() {    //метод для закрытия драйвера
        System.out.println("Chrome driver disabled");
        driver.quit();   //драйвер.закрыть
    }
    */
}
