package sprint4;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import static org.junit.Assert.*;

// Шаг 1. Создали page object — класс для страницы
public class LoginPageMesto {
    // Шаг 2. Добавили поле driver
    private WebDriver driver;
    // локатор поля «Email»
    private By emailField = By.id("email");
    // локатор поля «Пароль»
    private By passwordField = By.id("password");
    // локатор кнопки входа в приложение
    private By signInButton = By.className("auth-form__button");
    private By registrationButton = By.className("header__auth-link");

    // Шаг 4. Добавили конструктор класса page object
    public LoginPageMesto(WebDriver driver){
        // Инициализировали в нём поле driver
        this.driver = driver;
    }
    // метод проверяет, активна ли кнопка «Войти»
    public boolean checkSignInIsEnabled() {
        return driver.findElement(signInButton).isEnabled();
    }
    // метод заполняет поля «Email»
    public void setUsername(String username) {
        driver.findElement(emailField).sendKeys(username);
    }
    // метод заполненяет поля «Пароль»
    public void setPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }
    // метод кликает по кнопке авторизации
    public void clickSignInButton() {
        driver.findElement(signInButton).click();
    }
    // метод авторизации в приложении: объединяет ввод email, пароля и клик по кнопке
    // это и есть шаг
    public void login(String username, String password){
        setUsername(username);
        setPassword(password);
        clickSignInButton();
    }

    // метод кликает по кнопке «Регистрация»
    public void clickRegistrationButton() {
        driver.findElement(registrationButton).click();
    }
    // метод проверяет текст кнопки «Регистрация»
    public void checkTextRegistrationButton() {
        assertEquals("Наименование кнопки отлично от Регистрация", "Регистрация", driver.findElement(registrationButton).getText());
    }
}
