package sprint4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegistrationPageMesto {

    private WebDriver driver;
    // локатор поля «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки «Регистрация»
    private By signUpButton = By.className("auth-form__button");

    // конструктор класса
    public RegistrationPageMesto(WebDriver driver){
        this.driver = driver;
    }
    // метод заполняет поле «Email»
    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    // метод заполняет поле «Пароль»
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    // метод кликает по кнопке «Регистрация»
    public void clickSignUpButton() {
        driver.findElement(signUpButton).click();
    }
    // метод регистрации в приложении: объединяет ввод email, пароля и клик по кнопке
    public void register(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignUpButton();
    }
}