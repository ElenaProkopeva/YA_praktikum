import org.junit.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class SelenideTests {

    @Test
    public void checkButtonText() {

        open("https://qa-mesto.praktikum-services.ru/");
        //проверь, что на кнопке входа в приложение есть надпись "Войти"
        $(byClassName("auth-form__button")).shouldHave(exactText("Войти"));

    }

    @Test
    public void countCards(){
        open("https://qa-mesto.praktikum-services.ru/");
        // Блок авторизации
        $(byId("email")).setValue("g777elenagromova@yandex.com");
        $(byId("password")).setValue("g777elenagromova@yandex.com");
        $(byClassName("auth-form__button")).click();
        // Подсчитай количество карточек, соответствующих местоположению "Байкал"
        Integer cardsQuantity = $$(byText("Байкал")).size();
        System.out.println(cardsQuantity);

    }
    @Test
    public void test() {
        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("g777elenagromova@yandex.com");
        $(byId("password")).setValue("g777elenagromova@yandex.com");
        $(byCssSelector(".profile__image")).click();
        // кликни по изображению профиля
        $(byClassName("profile__image")).click();
        // в поле ссылки на изображение введи ссылку
        $(byId("owner-avatar")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png");
        // сохрани новое изображение
        $(byXpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }
    // закрой браузер
}
