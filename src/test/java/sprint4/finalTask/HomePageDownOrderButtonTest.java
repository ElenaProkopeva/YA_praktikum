package sprint4.finalTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomePageDownOrderButtonTest extends BaseUrlTest{

    @Before
    public void startUp() {
       super.before();
    }

    @Test
    public void downOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomeScooterPage homeScooterPage = new HomeScooterPage(driver);
        PersonDataPage personDataPage = new PersonDataPage(driver);

        homeScooterPage.downOrderButtonClick();
        String expectedPageTitle = "Для кого самокат";
        String actualPageTitle = personDataPage.getPageTitle();

        assertEquals("Переход на страницу заказа не выполнен: заголовок страницы неверный", expectedPageTitle, actualPageTitle);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
