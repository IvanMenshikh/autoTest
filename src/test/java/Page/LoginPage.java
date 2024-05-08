package Page;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;
@Getter
public class LoginPage {

    // Поле "Логин".
    @Getter
    public static SelenideElement fieldUser = $x("//input[@name = 'username']");

    // Поле "Пароль".
    @Getter
    public static SelenideElement fieldPassword = $x("//input[@name = 'password']");

    // Поле "Войти".
    @Getter
    public static SelenideElement submit = $x("//button[text() = 'Войти']");

    // Модалка "Ваши данные неверны ... ".
    @Getter
    public static SelenideElement authErrorMessage = $x("//div[text() = 'Ваши данные аутентификации неверны, или сайт Alfresco в данный момент недоступен.']");
}
