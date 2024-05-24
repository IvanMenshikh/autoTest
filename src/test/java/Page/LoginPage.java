package Page;


import Object.Employees;
import Tools.Asserts;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    MainPage mainPage = new MainPage();

    // Поле "Логин".
    @Getter
    public SelenideElement fieldUser = $x("//input[@name = 'username']");

    // Поле "Пароль".
    @Getter
    public SelenideElement fieldPassword = $x("//input[@name = 'password']");

    // Поле "Войти".
    @Getter
    public SelenideElement submit = $x("//button[text() = 'Войти']");

    // Модалка "Ваши данные неверны ... ".
    @Getter
    public static SelenideElement authErrorMessage = $x("//div[@class = 'error']");

    // Модапльное окно ввода данных (Пароль, логин, кнопка "Войти").
    @Getter
    public SelenideElement loginModalWindow = $x("//form[@action = '/share/page/dologin']");

    // Авторизация
    public boolean logIn(String login, String password){
        this.getFieldUser().clear();
        this.getFieldUser().setValue(login);
        this.getFieldPassword().clear();
        this.getFieldPassword().setValue(password);
        this.getSubmit().click();
        Asserts.checkAuth();
        return true;
    }

    // Негативная авторизация.
    public boolean negativeAuthorization(Employees user){
        this.getFieldUser().clear();
        this.getFieldUser().setValue(user.getLogin());
        this.getFieldPassword().clear();
        this.getFieldPassword().setValue(user.getPassword());
        this.getSubmit().click();
        Asserts.checkNegativeAuth();
        return true;
    }

    // Деавторизация под пользователем.
    public boolean logOut(){
        mainPage.getUserMenu().click();
        mainPage.getBtnExit().click();
        this.getLoginModalWindow().shouldBe(visible);
        return getFieldUser().isDisplayed() && getFieldPassword().isDisplayed() && getSubmit().isDisplayed();
    }
}

