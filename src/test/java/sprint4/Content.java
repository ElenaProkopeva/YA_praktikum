package sprint4;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Content {
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
        // Кликни по кнопке добавления нового контента
        driver.findElement(By.className("profile__add-button")).click();
        // В поле названия введи Москва
        driver.findElement(By.name("name")).sendKeys("Москва");
        // В поле ссылки на изображение введи ссылку
        driver.findElement(By.name("link")).sendKeys("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenium.jpg");
        // Сохрани контент
        driver.findElement(By.xpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        // Дождись появления кнопки удаления карточки
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")));
        // Удали контент
        driver.findElement(By.xpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
