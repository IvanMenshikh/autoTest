package Helper;

import Page.LoginPage;
import Object.Employees;
import com.codeborne.selenide.Selenide;
import org.awaitility.core.ConditionTimeoutException;

import java.util.concurrent.TimeUnit;

import static org.awaitility.Awaitility.await;

public class AuthHelper extends KsedBaseHelper {

    LoginPage loginPage = new LoginPage();

    // авторизация
    public void authorization(Employees user){
        // Устанавливаю время максимального ожидания в 5 минуты.
        if (maxTimeout == 0) maxTimeout = 50000;
        // Переменная для хранения флага успешного входа.
        boolean loggedIn = false;
        // Переменная для отслеживания количества обновлений страницы.
        int refreshCount = 0;
        // Цикл для ожидания отображения полей ввода или обновления страницы после 5 минут.
        while (!loggedIn) {
            try {
                // Устанавливаю ожидания отображения полей ввода.
                await()
                        .pollInSameThread()
                        .atMost(maxTimeout / 10, TimeUnit.MILLISECONDS)
                        .until(() -> loginPage.getFieldUser().isDisplayed() && loginPage.getFieldPassword().isDisplayed() && loginPage.getSubmit().isDisplayed());
                loginPage.logIn(user.getLogin(), user.getPassword()); // Подтягиваем логин и пароль юзера.
                loggedIn = true; // Успешно вошли.
            } catch (ConditionTimeoutException e) {
                if (refreshCount < 1) {
                    // Обновление страницы и повторное ожидание
                    Selenide.refresh();
                    refreshCount++;
                } else {
                    throw new RuntimeException("Элементы не отобразились на странице авторизации.");
                }
            }
        }
    }
}