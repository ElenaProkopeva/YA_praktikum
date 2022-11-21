package sprint4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import org.hamcrest.MatcherAssert;


import java.util.concurrent.TimeUnit;

public class TestAfterAurh {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void checkEmailInHeader() {
        // создали драйвер для браузера Chrome
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // перешли на страницу тестового приложения
        driver.get("https://qa-mesto.praktikum-services.ru/");

        // создай объект класса страницы авторизации
        LoginPageMesto loginPageMesto = new LoginPageMesto(driver);
        // выполни авторизацию
        String email = "g777elenagromova@yandex.com";
        String password = "g777elenagromova@yandex.com";
        // передавай эти переменные внутрь метода
           loginPageMesto.login(email, password);

        // создай объект класса заголовка приложения
        HeaderPageMesto headerPageMesto = new HeaderPageMesto(driver);
        // дождись загрузки заголовка
        headerPageMesto.waitForLoadHeader();
        // получи текст элемента в заголовке
        String actual = headerPageMesto.emailInHeader();
        // сделай проверку, что полученное значение совпадает с email
        MatcherAssert.assertThat(actual, equalTo(email));
    }
    @After
    public void tearDown() {
        // Закрой браузер
        driver.quit();
    }
}
