import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;

import static com.codeborne.selenide.Selenide.$x;
/**
 * Страница авторизации КСЭД.
 */
public class AuthorizationPage {
    private SelenideElement login;
    private SelenideElement password;
    private SelenideElement buttonAuthorization;
    private SelenideElement checkHomeTitle;

    /**
     * Реализована ленивая инициализация элементов страницы в классе
     */
    private SelenideElement getLogin() {
        if (login == null) {
            login = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-username']");
        }
        return login;
    }
    private SelenideElement getPassword(){
        if(password == null){
            password = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-password']");
        }
        return password;
    }
    private SelenideElement getButtonAuthorization(){
        if(buttonAuthorization == null){
            buttonAuthorization = $x("//button[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-submit-button']");
        }
        return buttonAuthorization;
    }
    private SelenideElement getCheckHomeTitle(){
        if(checkHomeTitle == null){
            checkHomeTitle = $x("//span[@class = 'alfresco-header-Title__text']");
        }
        return checkHomeTitle;
    }

//    //private final SelenideElement login = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-username']");
//    private final SelenideElement password = $x("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-password']");
//    private final SelenideElement buttonAuthorization = $x("//button[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-submit-button']");
//    private final SelenideElement getTitle = $x("//span[@class = 'alfresco-header-Title__text']");
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
        getLogin().setValue("Smoke_user118");
        getPassword().setValue("Test123456");
        getButtonAuthorization().click();
    }

    /**
     * Проверяем, что авторизация прошла успешно.
     */
    public void checkAuthorization(){
        String armTitle = getCheckHomeTitle().getText();
        Assert.assertEquals(armTitle, "АРМ СЭД");
        System.out.println(armTitle);
    }
}