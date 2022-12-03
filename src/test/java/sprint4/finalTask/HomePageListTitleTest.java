package sprint4.finalTask;

import org.junit.Before;
import org.junit.Test;
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
        String actualListTitle =homeScooterPage.getListElementText();

        assertEquals("Всплывающий текст не совпадает", expectedListTitle, actualListTitle);
    }

}
