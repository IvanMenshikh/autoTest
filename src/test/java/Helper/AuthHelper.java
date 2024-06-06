package Helper;

import Object.Employees;
import Page.BlackBarPage;
import Page.LoginPage;
import Page.MainPage;
import io.qameta.allure.Step;

import java.util.concurrent.TimeUnit;

import static Helper.KsedBaseHelper.maxTimeout;
import static com.codeborne.selenide.Condition.innerText;
import static com.codeborne.selenide.Condition.visible;
import static org.awaitility.Awaitility.await;


public class AuthHelper {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();
    BlackBarPage blackBarPage = new BlackBarPage();
    BlackBarHelper blackBarHelper = new BlackBarHelper();

    @Step("Операция авторизации в системе.")
    public void authorization(Employees user) {
        if (maxTimeout == 0) maxTimeout = 60000;
        await()
                .pollInSameThread()
                .atMost(maxTimeout / 10, TimeUnit.MILLISECONDS)
                .until(() -> loginPage.getLoginModalWindow().isDisplayed() // Ожидаем появления модального окна авторизации.
                            && loginPage.getFieldUser().isDisplayed() // Ожидаем появление поля: "Имя пользователя".
                            && loginPage.getFieldPassword().isDisplayed() // Ожидаем появление поля: "Пароль".
                            && loginPage.getSubmit().isDisplayed()); // Ожидаем появление поля: "Войти".
        loginPage.logIn(user.getLogin(), user.getPassword());
        mainPage.getLogotipArm().shouldHave(innerText("АРМ СЭД")); // Проверяем наименование логотипа АРМ.
        mainPage.getBlock("Навигатор").shouldBe(visible); // Проверяем, что поле "Навиготор" видимое.
        blackBarPage.getUserMenu().shouldHave(innerText(user.getName() + " " + user.getSurname())); // Проверяем имя + фамилию авторизированного пользователя.
    }

    @Step("Операция деавторизации с последующей авторизацией под новым пользователем.")
    public void LogOutAndNewAuth(Employees user){
        mainPage.getLogotipArm().shouldHave(innerText("АРМ СЭД"));
        mainPage.getBlock("Навигатор").shouldBe(visible);
        blackBarHelper.logOut();
        if (maxTimeout == 0) maxTimeout = 60000;
        await()
                .pollInSameThread()
                .atMost(maxTimeout / 10, TimeUnit.MILLISECONDS)
                .until(() -> loginPage.getLoginModalWindow().isDisplayed()
                        && loginPage.getFieldUser().isDisplayed()
                        && loginPage.getFieldPassword().isDisplayed()
                        && loginPage.getSubmit().isDisplayed());
        loginPage.logIn(user.getLogin(), user.getPassword());
        mainPage.getLogotipArm().shouldHave(innerText("АРМ СЭД"));
        mainPage.getBlock("Навигатор").shouldBe(visible);
        blackBarPage.getUserMenu().shouldHave(innerText(user.getName() + " " + user.getSurname()));
    }

    @Step("Проверка отрицательной авторизации.")
    public void CheckNegativeLogIn(Employees user){
        if (maxTimeout == 0) maxTimeout = 60000;
        await()
                .pollInSameThread()
                .atMost(maxTimeout / 10, TimeUnit.MILLISECONDS)
                .until(() -> loginPage.getLoginModalWindow().isDisplayed()
                        && loginPage.getFieldUser().isDisplayed()
                        && loginPage.getFieldPassword().isDisplayed()
                        && loginPage.getSubmit().isDisplayed());
        loginPage.negativeLogIn(user.getLogin(), user.getPassword());
        loginPage.getAuthErrorMessage()
                .shouldBe(visible)
                .shouldHave(innerText("Ваши данные аутентификации неверны, или сайт Alfresco в данный момент недоступен."));
    }
}