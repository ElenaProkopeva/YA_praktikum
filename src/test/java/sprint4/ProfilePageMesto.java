package sprint4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProfilePageMesto {
    private WebDriver driver;
    // создай локатор для поля «Занятие» в профиле пользователя
    private By activity = By.name("userDescription");
            //By.className("popup__input popup__input_type_description");
    // создай локатор для кнопки «Сохранить» в профиле пользователя
    private By save = By.xpath(".//button[@class='button popup__button' and text()= 'Сохранить']");

    public ProfilePageMesto (WebDriver driver){
        this.driver = driver;
    }

    // метод для проверки открытости поля «Занятие», удаления текста из неё и ввода нового значения из параметра
    public void editProfile(String changed){
        if (driver.findElement(activity).isEnabled()){
            driver.findElement(activity).clear();
            driver.findElement(activity).sendKeys(changed);
        }
        else {
            new WebDriverWait(driver, Duration.ofSeconds(10)).until(driver -> driver.findElement(activity).isEnabled());
        }
    }

    public void saveProfile(){
        driver.findElement(save).click();
    }
}
