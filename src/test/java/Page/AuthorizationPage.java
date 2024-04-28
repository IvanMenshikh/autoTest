package Page;

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
            login = $x("//input[@name = 'username']");
        }
        return login;
    }
    private SelenideElement getPassword(){
        if(password == null){
            password = $x("//input[@name = 'password']");
        }
        return password;
    }
    private SelenideElement getButtonAuthorization(){
        if(buttonAuthorization == null){
            buttonAuthorization = $x("//button[text() = 'Войти']");
        }
        return buttonAuthorization;
    }
    private SelenideElement getCheckHomeTitle(){
        if(checkHomeTitle == null){
            checkHomeTitle = $x("//span[text() = 'АРМ СЭД']");
        }
        return checkHomeTitle;
    }

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

    public void authorization(String login, String password) {
        getLogin().setValue(login);
        getPassword().setValue(password);
        getButtonAuthorization().click();
    }

    /**
     * Проверяем, что авторизация прошла успешно.
     */
    public void checkAuthorization(){
        String armTitle = getCheckHomeTitle().getText();
        Assert.assertEquals(armTitle, "АРМ СЭД");
        System.out.println("Титул КСЭД - " + armTitle + " авторизация прошла успешно");
    }
}