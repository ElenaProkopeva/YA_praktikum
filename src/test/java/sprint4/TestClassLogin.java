package sprint4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class TestClassLogin {
    private final String email;
    private final String password;
    private final boolean isLoggedIn;

    public TestClassLogin(String email, String password, boolean isLoggedIn) {
        this.email = email;
        this.password = password;
        this.isLoggedIn = isLoggedIn;
    }

    // Тестовые данные
    @Parameterized.Parameters
    public static Object[][] getCredentials() {
        return new Object[][] {
                { "qwerty@gmail.com", "Pw123456", true},
                { "email2@test.example", "password2", false},
        };
    }

    @Test
    public void loginTest() {
        // Запускаем браузер, переходим на сайт и заполняем форму авторизации
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открой страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");
        driver.findElement(By.className("email")).sendKeys(email);
        driver.findElement(By.className("password")).sendKeys(password);
        driver.findElement(By.className("form")).click();

        // Если логин прошел успешно (result = true), элемент profile отображается на экране
        // В противном случае элемент не виден
        assertEquals(isLoggedIn, driver.findElement(By.className("profile")).isDisplayed());

        driver.findElement(By.className("auth-form__button")).click();
        if (isLoggedIn) {
            new WebDriverWait(driver, Duration.ofSeconds(10))
                    .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));
        }
        assertEquals(isLoggedIn, driver.findElements(By.cssSelector(".profile__image")).size() != 0);
        driver.quit();
    }
}
