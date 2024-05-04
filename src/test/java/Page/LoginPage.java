package Page;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    // Поле "Логин".
    public static SelenideElement getFieldUser(){
        return $x("//input[@name = 'username']");
    }

    // Поле "Пароль".
    public static SelenideElement getFieldPassword(){
        return $x("//input[@name = 'password']");
    }

    // Поле "Войти".
    public static SelenideElement getFieldButtonSubmit(){
        return $x("//button[text() = 'Войти']");
    }
}