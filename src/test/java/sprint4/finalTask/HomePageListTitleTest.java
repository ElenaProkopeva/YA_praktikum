package sprint4.finalTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import static org.junit.Assert.assertEquals;

public class HomePageListTitleTest extends BaseUrlTest{


    @Before
    public void startUp() {
      super.before();
    }

    @Test
    public void listTitleTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomeScooterPage homeScooterPage = new HomeScooterPage(driver);
        homeScooterPage.listElementClick();
        String expectedListTitle = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
        new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.visibilityOfElementLocated(homeScooterPage.getListElement()));
                        //(driver -> driver.findElement(homeScooterPage.getListElement()).isDisplayed());
        String actualListTitle =homeScooterPage.getListElementText();

        assertEquals("Всплывающий текст не совпадает", expectedListTitle, actualListTitle);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
