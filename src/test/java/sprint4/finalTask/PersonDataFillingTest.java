package sprint4.finalTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class PersonDataFillingTest extends BaseUrlTest{
    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final boolean isNotErrorsPresent;

    public PersonDataFillingTest(String name, String surname, String address, String metro, String phone, boolean isNotErrorsPresent) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.isNotErrorsPresent = isNotErrorsPresent;
    }

    @Parameterized.Parameters
    public static Object[][] personData(){
        return new Object[][] {
                { "Елена", "Фам", "Моска 12", "Чистые пруды", "79501234545", true},
                { "bhj", "bh", "vhj", "Чистые пруды", "jk", false},
        };
    }

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    public void personDataFillingTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/order");

        PersonDataPage personDataPage = new PersonDataPage(driver);
        RentDataPage rentDataPage = new RentDataPage(driver);
        personDataPage.enterPersonData(name, surname, address, metro, phone);
        personDataPage.nextButtonClick();

        String expectedPageTitle = "Про аренду";
        String actualPageTitle = rentDataPage.getPageTitle();
        assertEquals("Поля заполнены с ошибками!", isNotErrorsPresent, actualPageTitle.equals(expectedPageTitle));
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
