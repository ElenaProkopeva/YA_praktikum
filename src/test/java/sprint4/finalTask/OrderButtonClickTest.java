package sprint4.finalTask;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderButtonClickTest extends BaseUrlTest{
    private final String xpathWay;
    private final boolean isOrderRegistrationStart;

    public OrderButtonClickTest(String xpathWay, boolean isOrderRegistrationStart) {
        this.xpathWay = xpathWay;
        this.isOrderRegistrationStart = isOrderRegistrationStart;
    }

    @Parameterized.Parameters
    public static Object[][] personData(){
        return new Object[][] {
                { "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button", true},
                { ".//button[@class='Button_Button__ra12g' and text()= 'Заказать']", true},
        };
    }

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    public void orderButtonClickTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");
        HomeScooterPage homeScooterPage = new HomeScooterPage(driver);
        PersonDataPage personDataPage = new PersonDataPage(driver);

        homeScooterPage.orderButtonClick(xpathWay);
        String expectedPageTitle = "Для кого самокат";
        String actualPageTitle = personDataPage.getPageTitle();

        assertEquals("Переход на страницу заказа не выполнен: заголовок страницы неверный", isOrderRegistrationStart, actualPageTitle.equals(expectedPageTitle));
    }

}
