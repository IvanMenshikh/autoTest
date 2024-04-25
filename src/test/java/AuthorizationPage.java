import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
/**
 * Страница авторизации КСЭД.
 */
public class AuthorizationPage {
    private final SelenideElement login = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-username']");
    private final SelenideElement password = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-password']");
    private final SelenideElement buttonAuthorization = $x("//button[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-submit-button']");

    /**
     * Открываем URL через конструктор.
     * @param url
     */
    public AuthorizationPage(String url) {
        Selenide.open(url);
    }

    /**
     * Авторизация с заполнением полей и нажатием на кнопку "Войти".
     */
    public void authorization() {
        login.setValue("Smoke_user118");
        password.setValue("Test123456");
        buttonAuthorization.click();
    }
}
