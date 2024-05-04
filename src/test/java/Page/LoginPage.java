package Page;


import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public static SelenideElement fieldUser;// Поле "Логин".
    public static SelenideElement fieldPassword;// Поле "Пароль".
    public static SelenideElement fieldButtonSubmit;// Поле "Войти".

    public static SelenideElement getFieldUser(){
        return fieldUser = $x("//input[@name = 'username']");
    }

    public static SelenideElement getFieldPassword(){
        return fieldPassword = $x("//input[@name = 'password']");
    }

    public static SelenideElement getFieldButtonSubmit(){
        return fieldButtonSubmit = $x("//button[text() = 'Войти']");
    }
}