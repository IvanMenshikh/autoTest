package Tools;

import Page.LoginPage;
import Page.MainPage;
import Object.Users;
public class AuthHelper {

    // Авторизация с заполнением полей и нажатием на кнопку "Войти".
    public static void authorization(String name) {

        // Находим пользователя по имени.
        Users user = Users.getUserByName(name);

        // Проверяем, найден пользователь или нет.
        if (user == null) {
            throw new IllegalArgumentException("Пользователь не найден: " + name);
        }

        String login = user.getLogin();
        String password = user.getPassword();

        // Заполняем поля и нажимаем на кнопку "Войти".
        LoginPage.getFieldUser().setValue(login);
        LoginPage.getFieldPassword().setValue(password);
        LoginPage.getFieldButtonSubmit().click();
    }

    // Выход из MainPage в LoginPage.
    public void exitOnAuthPage(){
        MainPage.getUserMenu().click();
        MainPage.getExitButton().click();
    }

}