package Tools.Helper;

import Object.Employees;
import Page.LoginPage;
import Page.MainPage;
import Tools.Asserts;

import static com.codeborne.selenide.Condition.visible;

public class AuthHelper {

    // Авторизация с заполнением полей и нажатием на кнопку "Войти".
    public static void authorization(Employees user) {
        LoginPage.getFieldUser().setValue(user.getLogin());
        LoginPage.getFieldPassword().setValue(user.getPassword());
        LoginPage.getSubmit().click();
        Asserts.checkAuth();
    }

    // Проверка негативной авторизации с ошибкой.
    public static void negativeAuthorization(Employees user){
        LoginPage.getFieldUser().setValue(user.getLogin());
        LoginPage.getFieldPassword().setValue(user.getPassword());
        LoginPage.getSubmit().click();
        LoginPage.getAuthErrorMessage().shouldBe(visible);
        Asserts.checkNegativeAuth();
    }

    // Выход из MainPage в LoginPage.
    public static void exitOnAuthPage(){
        MainPage.getUserMenu().click();
        MainPage.getButtonExit().click();
    }

}