package ru.Myprotein;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

public class TestMyprotein extends WebDriverSettings{
    @Test
    public void registrationTest() {
        driver.get("https://www.myprotein.ru/");

        //WebElement header = driver.findElement(By.id("header"));   //в драйвер ищет элемент Хедер
        driver.findElement(By.cssSelector("[href=\"/accountHome.account\"]")).click();  //в хедере драйвер ищет кнопку перехода на форму регистрации и кликает по ней

        WebDriverWait wait = new WebDriverWait(driver, 10);  //драйвер ждет 10 секунд, если страница загрузится раньше - продолжит работу, если позже - тест провален

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("new-customer")));

        driver.findElement(By.id("new-customer")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accountCreationForm"))); //ожидатор должен увидеть элемент (в данном случае - форму регистрации)
        // если на странице одна форма, можно сделать By.cssSelector("form"); без квадратных скобок

        driver.findElement(By.id("customerName")).sendKeys("Kotik Molodec");   //в поле с указанным айди (в данном случае имя).вводятся символы в скобках

        Random random = new Random();  //генерация рандомного числа
        int rand = random.nextInt(50) + 1;
        String email = "kotikmolodec" + rand + "@gmail.com";
        driver.findElement(By.id("customerEmail")).sendKeys(email);  //для поля емейл будет создаваться мейл с рандомным числом
        driver.findElement(By.id("confirmCustomerEmail")).sendKeys(email);

        driver.findElement(By.id("customerPassword")).sendKeys("kotik123");
        driver.findElement(By.id("confirmPassword")).sendKeys("kotik123");

        driver.findElement(By.id("OptInReceiveNewsLetterRadio2")).click();

        driver.findElement(By.id("continue")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("responsiveAccountHeader_accountName")));
    }
}
