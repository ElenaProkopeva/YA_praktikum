package sprint4;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Profile {
    private WebDriver driver;

    @Test
    public void test() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открой страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");
//        WebElement element = driver.findElement(By.cssSelector(".auth-form__title"));
//        List<WebElement> elements = driver.findElements(By.xpath(".//img"));
        // Это блок авторизации
        driver.findElement(By.id("email")).sendKeys("g777elenagromova@yandex.com");
        driver.findElement(By.id("password")).sendKeys("g777elenagromova@yandex.com");
        driver.findElement(By.className("auth-form__button")).click();

        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("profile__image")));
        // Кликни по изображению профиля
        driver.findElement(By.cssSelector(".profile__image")).click();
        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.id("owner-avatar")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenium.png");
        // Сохрани новое изображение
        driver.findElement(By.xpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();









//        new WebDriverWait(driver,  Duration.ofSeconds(10))
//                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
//        // Найди кнопку и получи её текст
//        String text = driver.findElement(By.className("header__logout")).getText();
//        System.out.println("Текст кнопки: " + text);
//        // Найди футер
//        WebElement element = driver.findElement(By.tagName("footer"));
//        // Прокрути страницу до футера
//        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
