package sprint4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ActivityChangeTest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkActivity() {
        // драйвер для браузера Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // переход на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
        LoginPageMesto objLoginPage = new LoginPageMesto(driver);
        // выполни авторизацию
        objLoginPage.login("g777elenagromova@yandex.com",
                "g777elenagromova@yandex.com");

        // создай объект класса главной страницы приложения
        HomePageMesto objHomePage = new HomePageMesto(driver);
        // дождись загрузки данных профиля на главной странице
        objHomePage.waitForLoadProfileData();

        // кликни на кнопку редактирования профиля
        objHomePage.clickProfileEditButton();

        // создай объект класса для поп-апа редактирования профиля
        ProfilePageMesto objProfilePage = new ProfilePageMesto(driver);

        // это переменная со значением, которое надо ввести в поле «Занятие»
        String newActivity = "Тестировщик";
        // в одном шаге проверь, что поле «Занятие» доступно для редактирования, и введи в него новое значение
        objProfilePage.editProfile(newActivity);
        // сохрани изменения в профиле
        driver.findElement(By.name("userDescription")).getText();
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver ->
                        (ExpectedConditions.textToBePresentInElementLocated(By.xpath("//*[@id=\"owner-description\"]//div[2]"), newActivity)
                        ));
//        new WebDriverWait(driver, Duration.ofSeconds(10))
//                .until(driver ->
//                        (ExpectedConditions.textToBePresentInElementLocated(By.name("userDescription"), newActivity)
//                        && !driver.findElement(By.name("userDescription")).getText().isEmpty()));
        objProfilePage.saveProfile();

        // проверь, что поле «Занятие» на основной странице поменяло значение на новое
        objHomePage.waitForChangedActivity(newActivity);
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
