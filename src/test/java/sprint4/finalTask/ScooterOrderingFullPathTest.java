package sprint4.finalTask;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class ScooterOrderingFullPathTest extends BaseUrlTest{
    private final String xpathWay;

    public ScooterOrderingFullPathTest(String xpathWay) {
        this.xpathWay = xpathWay;
    }

    @Parameterized.Parameters
    public static Object[][] buttonData(){
        return new Object[][] {
                { "//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button"},
                { ".//button[@class='Button_Button__ra12g' and text()= 'Заказать']"},
        };
    }

    @Before
    public void startUp() {
        super.before();
    }

    @Test
    public void scooterOrderingFullPathTest() {
        driver.get("https://qa-scooter.praktikum-services.ru/");

        HomeScooterPage homeScooterPage = new HomeScooterPage(driver);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(xpathWay)));
        homeScooterPage.orderButtonClick(xpathWay);


        PersonDataPage personDataPage = new PersonDataPage(driver);
        personDataPage.enterPersonData("Елена", "Фам", "Моска 12", "Чистые пруды", "79501234545");
        personDataPage.nextButtonClick();

        RentDataPage rentDataPage = new RentDataPage(driver);
        rentDataPage.enterRentData("01.01.2023", "двое суток", "black", "comment");
        rentDataPage.orderButtonClick();

        SubmitOrderPage submitOrderPage = new SubmitOrderPage(driver);
        submitOrderPage.yesButtonClick();

        String expectedWindowTitle = String.format("Заказ оформлен\n%s", submitOrderPage.getOrderNumber());
        String actualWindowTitle = submitOrderPage.getOrderWindowTitle();

        assertEquals("Заказ не оформлен", expectedWindowTitle, actualWindowTitle);
    }


    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
