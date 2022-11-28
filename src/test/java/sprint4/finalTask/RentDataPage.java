package sprint4.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class RentDataPage extends BaseUrlTest{
    // Заголовок "Про аренду"
    private final By pageTitle = By.className("Order_Header__BZXOb");
    // Поле Когда привезти
    private final By deliveryDateField = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    // Поле Срок
    private final By periodRentField = By.className("Dropdown-control");
    // Поле Комментарий
    private final By commentRentField = By.xpath(".//input[@placeholder = 'Комментарий для курьера']");
    // кнопка Заказать
    private final By orderButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()= 'Заказать']");

    public RentDataPage(WebDriver driver) {
        this.driver = driver;
    }

    //заполняем детали аренды
    public void enterRentData(String deliveryDate, String periodRent, String colorScooter, String comment){
        driver.findElement(deliveryDateField).sendKeys(deliveryDate);
        driver.findElement(deliveryDateField).sendKeys(Keys.ENTER);
        driver.findElement(periodRentField).click();
        String rentOptionTemplate = ".//div[@class='Dropdown-menu']//*[text()='%s']";
        String rentLocator = String.format(rentOptionTemplate, periodRent);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath(rentLocator)));
        driver.findElement(By.xpath(rentLocator)).click();

       String colorScooterFieldOption = ".//*[@id=\"%s\"]";
       String colorLocator = String.format(colorScooterFieldOption, colorScooter);
       driver.findElement(By.xpath(colorLocator)).click();
       driver.findElement(commentRentField).sendKeys(comment);
    }

    //жмем кнопку Заказать
    public void orderButtonClick(){
        driver.findElement(orderButton).click();
    }

    //получаем текст заголовка страницы
    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }
}
