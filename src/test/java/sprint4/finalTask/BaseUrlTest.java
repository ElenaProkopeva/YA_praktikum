package sprint4.finalTask;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseUrlTest {
    protected WebDriver driver;

    //инициализируем драйвер
    @Before
    public void before() {
        this.driver = getDriver("chrome"); // firefox  chrome
    }

    //устанавливаем драйвер
    private WebDriver getDriver(String browserName){
        if("chrome".equals(browserName))
            {   WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            }
        return new FirefoxDriver();
}
    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}

