import org.checkerframework.framework.qual.DefaultQualifier;
import org.junit.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

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
        $(byClassName("auth-form__button")).click();
        $(byCssSelector(".profile__image")).click();
        // кликни по изображению профиля
        $(byClassName("profile__image")).click();
        // в поле ссылки на изображение введи ссылку
        $(byId("owner-avatar")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/avatarSelenide.png");
        // сохрани новое изображение
        $(byXpath(".//form[@name='edit-avatar']/button[text()='Сохранить']")).click();
    }
    // закрой браузер

    @Test
    public void test1() {

        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("g777elenagromova@yandex.com");
        $(byId("password")).setValue("g777elenagromova@yandex.com");
        $(byClassName("auth-form__button")).click();
        // кликни по кнопке добавления нового контента
        $(byClassName("profile__add-button")).click();
        // в поле названия введи «Москва»
        //$(byId("place-name")).setValue("Москва");
        $(byName("name")).setValue("Москва");
        // в поле ссылки на изображение введи ссылку
        $(byName("link")).setValue("https://code.s3.yandex.net/qa-automation-engineer/java/files/paid-track/sprint1/photoSelenide.jpg");
        // сохрани контент
        $(byXpath(".//form[@name='new-card']/button[text()='Сохранить']")).click();
        // удали добавленную карточку, кликнув по кнопке удаления
        $(byXpath(".//button[@class='card__delete-button card__delete-button_visible']")).click();
    }

    @Test
    public void test2() {

        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("g777elenagromova@yandex.com");
        $(byId("password")).setValue("g777elenagromova@yandex.com");
        $(byClassName("auth-form__button")).click();
        // кликни по кнопке редактирования профиля
        $(byClassName("profile__edit-button")).click();
        // введи «Аристарх Сократович» в поле «Имя»
        $(byId("owner-name")).setValue("Аристарх Сократович");
        // введи «Автор автотестов» в поле «Занятие»
        $(byId("owner-description")).setValue("Автор автотестов");
        // сохрани изменения
        $(byXpath(".//form[@name='edit']/button[text()='Сохранить']")).click();
    }

    @Test
    public void test3() {

        // создай драйвер для браузера Chrome
        // перейди на страницу тестового стенда
        open("https://qa-mesto.praktikum-services.ru/");
        // выполни авторизацию
        $(byId("email")).setValue("g777elenagromova@yandex.com");
        $(byId("password")).setValue("g777elenagromova@yandex.com");
        $(byClassName("auth-form__button")).click();
        // получи текст второй карточки и сохрани его в переменную cardText
  //      Integer f = $$(byClassName("places__item card")).size();
        $(byXpath(".//li[@class='places__item card']")).shouldBe(visible, Duration.ofDays(8000));
  //      $(byClassName("places__item card")).shouldBe(visible, Duration.ofDays(8000));
        System.out.println($$(byXpath(".//li[@class='places__item card']")).size());
   //     String cardText = $$(byClassName("places__item card")).get(1).find(byClassName("card__title")).getText();
        String cardText = $$(byXpath(".//li[@class='places__item card']")).get(1).find(byClassName("card__title")).getText();
        System.out.println(cardText);
        System.out.println($$(byClassName("card")).size());
        String cardText1 = $$(byClassName("card")).get(1).find(byClassName("card__title")).getText();
        System.out.println(cardText1);
    }
}
