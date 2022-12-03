package sprint4.finalTask;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PersonDataPage{
    private final WebDriver driver;
    // Заголовок "Для кого самокат"
    private final By pageTitle = By.className("Order_Header__BZXOb");
    // Поле Имя
    private final By nameField = By.xpath(".//input[@placeholder = '* Имя']");
    // Поле Фамилия
    private final By surnameField = By.xpath(".//input[@placeholder = '* Фамилия']");
    // Поле Адрес
    private final By addressField = By.xpath(".//input[@placeholder = '* Адрес: куда привезти заказ']");
    // Поле Станция метро
    private final By metroField = By.xpath(".//input[@placeholder = '* Станция метро']");
    // Поле Телефон
    private final By phoneField = By.xpath(".//input[@placeholder = '* Телефон: на него позвонит курьер']");
    // Кнопка Далее
    private final By nextButton = By.xpath(".//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()= 'Далее']");

    public PersonDataPage(WebDriver driver) {
        this.driver = driver;
    }

    // заполнение данных пользователя
    public void enterPersonData(String name, String surname, String address, String metro, String phone){
        driver.findElement(nameField).sendKeys(name);
        driver.findElement(surnameField).sendKeys(surname);
        driver.findElement(addressField).sendKeys(address);
        driver.findElement(metroField).sendKeys(metro);
        String metroOptionTemplate = ".//div[@class='select-search__select']//*[text()='%s']";
        String locator = String.format(metroOptionTemplate, metro);
        driver.findElement(By.xpath(locator)).click();
        driver.findElement(phoneField).sendKeys(phone);

    }
    //жмем кнопку Далее
    public void nextButtonClick(){
        driver.findElement(nextButton).click();
    }

    //получаем текст заголовка страницы
    public String getPageTitle(){
        return driver.findElement(pageTitle).getText();
    }

}
