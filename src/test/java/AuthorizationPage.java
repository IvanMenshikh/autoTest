import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;
/**
 * Страница авторизации КСЭД.
 */
public class AuthorizationPage {
    private final SelenideElement login = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-username']");
    private final SelenideElement password = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-password']");
    private final SelenideElement buttonAuthorization = $x("//button[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-submit-button']");
    private final SelenideElement getTitle = $x("//span[@class = 'alfresco-header-Title__text']");
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

    /**
     * Проверяем, что авторизация прошла успешно.
     */
    public void checkAuthorization(){
        String armTitle = getTitle.getText();
        Assert.assertEquals(armTitle, "АРМ СЭД");
        System.out.println(armTitle);
    }
}