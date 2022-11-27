package sprint4.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class HomeScooterPage extends BaseUrlTest{

    // Стрелочка первого элемента в разделе «Вопросы о важном»
    private final By listElementCursor = By.id("accordion__heading-0");
    // Элемент с текстом после нажатия стрелочки в разделе «Вопросы о важном»
    private final By listElementText = By.id("accordion__panel-0");
    // Верхняя кнопка Заказать
    private final By upOrderButton = By.xpath(".//button[@class='Button_Button__ra12g' and text()= 'Заказать']");
    // Нижняя кнопка Заказать
    private final By downOrderButton = By.xpath("//*[@id=\"root\"]/div/div/div[4]/div[2]/div[5]/button");

    public HomeScooterPage(WebDriver driver) {
        this.driver = driver;
    }

    //клик на первом элементе в разделе «Вопросы о важном»
    public void listElementClick(){
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", driver.findElement(listElementCursor));
        driver.findElement(listElementCursor).click();
    }

    //получение элемента после клика на первом элементе в разделе «Вопросы о важном»
    public By getListElement() {
        return listElementText;
    }

    //проверка текста элемента после клика на первом элементе в разделе «Вопросы о важном»
    public String getListElementText(){
        return driver.findElement(listElementText).getText();
    }

    // клик на Верхняя кнопка Заказать
    public  void upOrderButtonClick(){
        driver.findElement(upOrderButton).click();
    }

    // клик на Нижняя кнопка Заказать
    public  void downOrderButtonClick(){
        driver.findElement(downOrderButton).click();
    }

    // клик на кнопку Заказать по xpathWay
    public  void orderButtonClick(String xpathWay){
        driver.findElement(By.xpath(xpathWay)).click();
    }

}
