package Page;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.testng.Assert;
import Data.Users;
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

    Data.Users user = new Users();
    public void authorization() {
        getLogin().setValue(user.getLoginUser118());
        getPassword().setValue(user.getPasswordUser118());
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