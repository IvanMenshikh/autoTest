package Tools.Helper;

import Object.Users;
import Page.LoginPage;
import Page.MainPage;
import Object.Employees;

public class AuthHelper {

    // Авторизация с заполнением полей и нажатием на кнопку "Войти".
    public static void authorization(String name) {

        // Находим пользователя по имени.
        Users user = Employees.getUserByName(name);

        // Заполняем поля и нажимаем на кнопку "Войти".
        LoginPage.getFieldUser().setValue(user.getLogin());
        LoginPage.getFieldPassword().setValue(user.getPassword());
        LoginPage.getSubmit().click();
        Tools.Asserts.checkAuth();
    }

    public static void negativeAuthorization(String name){

        Users user = Employees.getUserByName(name);

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