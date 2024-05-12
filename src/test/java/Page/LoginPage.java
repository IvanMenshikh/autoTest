package Page;


import Object.Employees;
import Tools.Asserts;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage extends MainPage{

    // Переменная максимального ожидания
    int maxTimeout;

    // Поле "Логин".
    public SelenideElement fieldUser = $x("//input[@name = 'username']");

    // Поле "Пароль".
    public SelenideElement fieldPassword = $x("//input[@name = 'password']");

    // Поле "Войти".
    public SelenideElement submit = $x("//button[text() = 'Войти']");

    // Модалка "Ваши данные неверны ... ".
    @Getter
    public static SelenideElement authErrorMessage = $x("//div[text() = 'Ваши данные аутентификации неверны, или сайт Alfresco в данный момент недоступен.']");

    // Модалка ввода данных (Пароль, логин, кнопка "Войти").
    public  SelenideElement loginModalWindow = $x("//form[@action = '/share/page/dologin']");

    // Авторизации
    public void authorization(Employees user){

        // При запуске кода падает тестирование с ошибкой first open URL
//        // Устанавливаю время максимального ожидания в 3 минуты.
//        if (maxTimeout == 0) maxTimeout = 30000;
//
//        // Устанавливаю ожидания отображения полей ввода.
//        await().atMost(maxTimeout / 10, TimeUnit.MILLISECONDS)
//                .until(() -> fieldUser.isDisplayed() && fieldPassword.isDisplayed() && submit.isDisplayed());

        // Запускаю авторизацию.
        this.fieldUser.clear();
        this.fieldUser.setValue(user.getLogin());
        this.fieldPassword.clear();
        this.fieldPassword.setValue(user.getPassword());
        this.submit.click();
        Asserts.checkAuth();

    }

    // Негативная авторизация.
    public void negativeAuthorization(Employees user){

        this.fieldUser.clear();
        this.fieldUser.setValue(user.getLogin());
        this.fieldPassword.clear();
        this.fieldPassword.setValue(user.getPassword());
        this.submit.click();
        Asserts.checkNegativeAuth();

    }

    // Деавторизация под пользователем.
    public void logout(){
        userMenu.click();
        buttonExit.click();
        this.loginModalWindow.shouldBe(visible).isDisplayed();
    }
}

