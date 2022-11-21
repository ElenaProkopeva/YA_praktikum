package sprint4;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Cookietest {
    private WebDriver driver;

    @Before
    public void startUp() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void test() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открой страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");
        Cookie newCookie = new Cookie("my_first_cookie","15");
        driver.manage().addCookie(newCookie);
        driver.manage().deleteCookieNamed("my_first_cookie");
        Cookie newCookie1 = new Cookie("my_first_cookie","25");
        driver.manage().addCookie(newCookie1);

    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
