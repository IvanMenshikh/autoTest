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
    @Getter
    private final SelenideElement fieldUser = $x("//input[@name = 'username']");

    // Поле "Пароль".
    @Getter
    private final SelenideElement fieldPassword = $x("//input[@name = 'password']");

    // Поле "Войти".
    @Getter
    private final SelenideElement submit = $x("//button[text() = 'Войти']");

    // Модалка "Ваши данные неверны ... ".
    @Getter
    private static final SelenideElement authErrorMessage = $x("//div[@class = 'error']");

    // Модапльное окно ввода данных (Пароль, логин, кнопка "Войти").
    @Getter
    private final SelenideElement loginModalWindow = $x("//form[@action = '/share/page/dologin']");

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
        this.getFieldUser().clear();
        this.getFieldUser().setValue(user.getLogin());
        this.getFieldPassword().clear();
        this.getFieldPassword().setValue(user.getPassword());
        this.getSubmit().click();
        Asserts.checkAuth();

    }

    // Негативная авторизация.
    public void negativeAuthorization(Employees user){

        this.getFieldUser().clear();
        this.getFieldUser().setValue(user.getLogin());
        this.getFieldPassword().clear();
        this.getFieldPassword().setValue(user.getPassword());
        this.getSubmit().click();
        Asserts.checkNegativeAuth();

    }

    // Деавторизация под пользователем.
    public void logout(){
        getUserMenu().click();
        getButtonExit().click();
        this.getLoginModalWindow().shouldBe(visible);
    }
}

