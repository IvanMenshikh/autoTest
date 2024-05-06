package Page;


import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    // Поле "Логин".
    @Getter
    private SelenideElement fieldUser = $x("//input[@name = 'username']");

    // Поле "Пароль".
    @Getter
    private SelenideElement fieldPassword = $x("//input[@name = 'password']");

    // Поле "Войти".
    @Getter
    private SelenideElement submit = $x("//button[text() = 'Войти']");


//    // Поле "Логин".
//    public static SelenideElement getFieldUser(){
//        return $x("//input[@name = 'username']");
//    }
//
//    // Поле "Пароль".
//    public static SelenideElement getFieldPassword(){
//        return $x("//input[@name = 'password']");
//    }
//
//    // Поле "Войти".
//    public static SelenideElement getFieldButtonSubmit(){
//        return $x("//button[text() = 'Войти']");
//    }
}