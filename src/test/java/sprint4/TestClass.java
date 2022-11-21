package sprint4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RunWith(Parameterized.class)
public class TestClass {
    //Добавь необходимые поля
    private final String cityName;
    private final boolean isVisible;

    public TestClass(String cityName, boolean isVisible) {
        this.cityName = cityName;
        this.isVisible = isVisible;
    }

    @Parameterized.Parameters
    public static Object[][] getCities() {
        //Сгенерируй тестовые данные (нам нужно название городов и результат поиска)
        return new Object[][]{
                {"Москва", true},
                {"Санкт-Петербург", true},
        };
    }

    @Test
    public void citiesTest() {
        System.setProperty("webdriver.gecko.driver", "C:/Program Files/Mozilla Firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Открой страницу тестового стенда
        driver.get("https://qa-mesto.praktikum-services.ru/");
        // Выполни авторизацию. Укажи email и пароль своей учетной записи
        driver.findElement(By.id("email")).sendKeys("g777elenagromova@yandex.com");
        driver.findElement(By.id("password")).sendKeys("g777elenagromova@yandex.com");
        driver.findElement(By.className("auth-form__button")).click();
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("header__user")));

        // Найди карточку города по его названию
        String locator = String.format(".//li//h2[text() = '%s']", cityName);
        List<WebElement> elements = driver.findElements(By.xpath(locator));

        // Проверь, что нашёлся хотя бы один нужный элемент
        assertEquals(isVisible, elements.size() != 0);
        driver.quit();
    }
}