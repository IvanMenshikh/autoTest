package Page;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    MainPage mainPage = new MainPage();

    // Поле "Логин".
    @Getter
    public final SelenideElement fieldUser = $x("//input[@name = 'username']");

    // Поле "Пароль".
    @Getter
    public final SelenideElement fieldPassword = $x("//input[@name = 'password']");

    // Поле "Войти".
    @Getter
    public final SelenideElement submit = $x("//button[text() = 'Войти']");

    // Модалка "Ваши данные неверны ... ".
    @Getter
    public static final SelenideElement authErrorMessage = $x("//div[@class = 'error']");

    // Модапльное окно ввода данных (Пароль, логин, кнопка "Войти").
    @Getter
    public final SelenideElement loginModalWindow = $x("//form[@action = '/share/page/dologin']");

    // Авторизация
    public boolean logIn(String login, String password){
        this.getFieldUser().clear();
        this.getFieldUser().setValue(login);
        this.getFieldPassword().clear();
        this.getFieldPassword().setValue(password);
        this.getSubmit().click();
        return true;
    }

    // Негативная авторизация.
    public boolean negativeLogIn(String login, String password){
        this.getFieldUser().clear();
        this.getFieldUser().setValue(login);
        this.getFieldPassword().clear();
        this.getFieldPassword().setValue(password);
        this.getSubmit().click();
        return true;
    }

    // Деавторизация под пользователем.
    public boolean logOut(){
        mainPage.getUserMenu().click();
        mainPage.getBtnExit().click();
        return true;
    }
}

