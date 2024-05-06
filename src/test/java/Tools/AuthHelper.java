package Tools;

import Object.Users;
import Page.LoginPage;
import Page.MainPage;

public class AuthHelper {

    LoginPage loginPage = new LoginPage();
    MainPage mainPage = new MainPage();

    // Авторизация с заполнением полей и нажатием на кнопку "Войти".
    public void authorization(String name) {

        // Находим пользователя по имени.
        Users user = Users.getUserByName(name);

        // Заполняем поля и нажимаем на кнопку "Войти".
        loginPage.getFieldUser().setValue(user.getLogin());
        loginPage.getFieldPassword().setValue(user.getPassword());
        loginPage.getSubmit().click();
    }

    // Выход из MainPage в LoginPage.
    public void exitOnAuthPage(){
        mainPage.getUserMenu().click();
        mainPage.getButtonExit().click();
    }

}