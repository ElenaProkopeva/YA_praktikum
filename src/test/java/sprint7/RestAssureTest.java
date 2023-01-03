package sprint7;
// импортируем RestAssured
import io.restassured.RestAssured;
// импортируем Before
import io.restassured.response.Response;
import org.example.sprint7.Profile;
import org.example.sprint7.User;
import org.junit.Before;
// импортируем Test
import org.junit.Test;
// дополнительный статический импорт нужен, чтобы использовать given(), get() и then()
import static io.restassured.RestAssured.*;
import java.io.File;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import org.hamcrest.MatcherAssert;

public class RestAssureTest {
    // аннотация Before показывает, что метод будет выполняться перед каждым тестовым методом
    @Before
    public void setUp() {
        // повторяющуюся для разных ручек часть URL лучше записать в переменную в методе Before
        // если в классе будет несколько тестов, указывать её придётся только один раз
        RestAssured.baseURI = "https://qa-mesto.praktikum-services.ru";
    }

    // создаём метод автотеста
    @Test
    public void getMyInfoStatusCode() {
        // метод given() помогает сформировать запрос
        given()
                // указываем протокол и данные авторизации
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4NzNlZTJkMTM2ZDAwM2RkODBkNmQiLCJpYXQiOjE2NzI2MzM1NzksImV4cCI6MTY3MzIzODM3OX0.XPyP02YW3lT-BiXVn26yby5MH05l0nFKdRpRpyg7D5w")
                // отправляем GET-запрос с помощью метода get, недостающую часть URL (ручку) передаём в него в качестве параметра
                .get("/api/users/me")
                // проверяем, что статус-код ответа равен 200
                //.then().statusCode(200)
                .then().assertThat().body("data.name", equalTo("Аристарх Сократович"));
    }
    @Test
    public void checkUserNameAndPrintResponseBody() {

        // отправляет запрос и сохраняет ответ в переменную response, экзмепляр класса Response
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4NzNlZTJkMTM2ZDAwM2RkODBkNmQiLCJpYXQiOjE2NzI2MzM1NzksImV4cCI6MTY3MzIzODM3OX0.XPyP02YW3lT-BiXVn26yby5MH05l0nFKdRpRpyg7D5w").get("/api/users/me");
        // проверяет, что в теле ответа ключу name соответствует нужное имя пользователя
        response.then().assertThat().body("data.name",equalTo("Аристарх Сократович"));
        // выводит тело ответа на экран
        System.out.println(response.body().asString());

    }


    @Test
    public void checkUserActivityAndPrintResponseBody() {

        // отправляет запрос и сохраняет ответ в переменную response, экзмепляр класса Response
        Response response = given().auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4NzNlZTJkMTM2ZDAwM2RkODBkNmQiLCJpYXQiOjE2NzI2MzM1NzksImV4cCI6MTY3MzIzODM3OX0.XPyP02YW3lT-BiXVn26yby5MH05l0nFKdRpRpyg7D5w").get("/api/users/me");
        // проверяет, что в теле ответа ключу about соответствует нужное занятие
        response.then().assertThat().body("data.about", equalTo("Автор автотестов"));
        // выводит тело ответа на экран
        System.out.println(response.body().asString());

    }

    @Test
    public void createNewPlaceAndCheckResponse(){
        File json = new File("newCard.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("подставь_сюда_свой_токен")
                        .and()
                        .body(json)
                        .when()
                        .post("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }
    @Test
    public void createNewPlaceAndCheckResponsePatch(){
        File json = new File("newCard.json");
        Response response =
                given()
                        .header("Content-type", "application/json")
                        .auth().oauth2("подставь_сюда_свой_токен")
                        .and()
                        .body(json)
                        .when()
                        .patch("/api/cards");
        response.then().assertThat().body("data._id", notNullValue())
                .and()
                .statusCode(201);
    }
    @Test
    public void updateProfileAndCheckStatusCode() {
        File json = new File("src/test/resources/updateProfile.json"); // запиши файл в файловую переменную
        Response response =
                given()
                        .header("Content-type", "application/json") // заполни header
                        .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4NzNlZTJkMTM2ZDAwM2RkODBkNmQiLCJpYXQiOjE2NzI2MzM1NzksImV4cCI6MTY3MzIzODM3OX0.XPyP02YW3lT-BiXVn26yby5MH05l0nFKdRpRpyg7D5w")
                        .and()
                        .body(json) // заполни body
                        .when()
                        .patch("/api/users/me"); // отправь запрос на ручку
        response.then().assertThat()
                .statusCode(200) // проверь статус ответа
                .and()
                .body("data.name", equalTo("Василий Васильев")); // проверь поле name
    }

    @Test
    public void updateProfile() {
        Profile profile  = new Profile("Василий Васильев", "Самый крутой исследователь"); // создай объект, который соответствует JSON
        given()
          .header("Content-type", "application/json")// заполни header
          .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4NzNlZTJkMTM2ZDAwM2RkODBkNmQiLCJpYXQiOjE2NzI2MzM1NzksImV4cCI6MTY3MzIzODM3OX0.XPyP02YW3lT-BiXVn26yby5MH05l0nFKdRpRpyg7D5w")
          .and()
          .body(profile) // заполни body
                .when()
                .patch("/api/users/me"); // отправь запрос на ручку
    }

    @Test
    public void checkUserName() {
        User user = given()
                .auth().oauth2("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2Mzc4NzNlZTJkMTM2ZDAwM2RkODBkNmQiLCJpYXQiOjE2NzI2MzM1NzksImV4cCI6MTY3MzIzODM3OX0.XPyP02YW3lT-BiXVn26yby5MH05l0nFKdRpRpyg7D5w")
                .get("/api/users/me")
                .body().as(User.class); // напиши код для десериализации ответа в объект типа User
        // выбери подходящий assert
        MatcherAssert.assertThat(user, notNullValue());
    }

    @Test
    public void likeTheFirstPhoto() {
        String oauthToken = "введи_сюда_свой_токен";

        // получение списка фотографий и сохранение _id первой фотографии
        String photoId = given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .get("/api/cards") // отправка GET-запроса
                .then().extract().body().path("data[0]._id"); // получение ID фотографии из массива данных

        // лайк первой фотографии
        given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .put("/api/cards/{photoId}/likes", photoId) // отправка PUT-запроса
                .then().assertThat().statusCode(200); // проверка, что сервер вернул код 200

        // снять лайк с первой фотографии
        given()
                .auth().oauth2(oauthToken) // аутентификация при выполнении запроса
                .delete("/api/cards/{photoId}/likes", photoId) // отправка DELETE-запроса
                .then().assertThat().statusCode(200); // проверка, что сервер вернул код 200
    }

}
