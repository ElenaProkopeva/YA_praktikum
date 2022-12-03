package sprint4.finalTask;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HomePageUpOrderButtonTest extends BaseUrlTest{

    @Before
    public void startUp() {
      super.before();
    }

    @Test
    public void upOrderButtonTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomeScooterPage homeScooterPage = new HomeScooterPage(driver);
        PersonDataPage personDataPage = new PersonDataPage(driver);

        homeScooterPage.upOrderButtonClick();
        String expectedPageTitle = "Для кого самокат";
        String actualPageTitle = personDataPage.getPageTitle();

        assertEquals("Переход на страницу заказа не выполнен: заголовок страницы неверный", expectedPageTitle, actualPageTitle);
    }

}
