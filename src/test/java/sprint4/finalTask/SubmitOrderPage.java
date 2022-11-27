package sprint4.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubmitOrderPage extends BaseUrlTest{
    // Кнопка Да
    private final By yesButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()= 'Да']");
    // Область текста Заказ оформлен
    private final By orderDoneWindowTitle = By.className("Order_ModalHeader__3FDaJ");
    // номер заказа
    private final By orderNumber= By.className("Order_Text__2broi");

    public SubmitOrderPage(WebDriver driver) {
        this.driver = driver;
    }

    //жмем кнопку Да
    public void yesButtonClick(){
        driver.findElement(yesButton).click();
    }
    //получаем ноер заказа
    public String getOrderNumber() {
        return driver.findElement(orderNumber).getText();
    }
    // получаем текст окна Заказ оформлен
    public String getOrderWindowTitle(){
        return driver.findElement(orderDoneWindowTitle).getText();
    }
}
