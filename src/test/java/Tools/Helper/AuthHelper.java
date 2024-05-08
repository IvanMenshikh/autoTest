package Tools.Helper;

import Object.Employees;
import Page.LoginPage;
import Page.MainPage;

public class AuthHelper {

    // Авторизация с заполнением полей и нажатием на кнопку "Войти".
    public static void authorization(Employees user) {

        // Заполняем поля и нажимаем на кнопку "Войти".
        LoginPage.getFieldUser().setValue(user.getLogin());
        LoginPage.getFieldPassword().setValue(user.getPassword());
        LoginPage.getSubmit().click();
        Tools.Asserts.checkAuth();
    }

    public static void negativeAuthorization(Employees user){


        LoginPage.getFieldUser().setValue(user.getLogin());
        LoginPage.getFieldPassword().setValue(user.getPassword());
        LoginPage.getSubmit().click();
        Tools.Asserts.checkNegativeAuth();
    }

    // Выход из MainPage в LoginPage.
    public static void exitOnAuthPage(){
        MainPage.getUserMenu().click();
        MainPage.getButtonExit().click();
    }

}