package Tools;

import Page.CreationFormPage;
import org.testng.Assert;
import Page.MainPage;
import Page.LoginPage;

public class Asserts {

    // Проверяем, что авторизация прошла успешно.
    public static void checkAuth() {
        String armTitle_Actual = MainPage.getLogotipArm().getText();
        String armTitle_Expected = "АРМ СЭД";
        String navigator_Actual = MainPage.getNavigator().getText();
        String navigator_Expected = "Навигатор";
        if (armTitle_Actual.equals(armTitle_Expected) && navigator_Actual.equals(navigator_Expected)) {
            System.out.println("Авторизация прошла успешно!");
        } else {
            System.out.println("Ошибка: Ожидаемый титул - " + armTitle_Expected + ", актуальный титул - " + armTitle_Actual);
            System.out.println("Ошибка: Ожидаемое наименование поля - " + armTitle_Expected + ", актуальное наименование поля - " + armTitle_Actual);
            Assert.fail("Авторизация провалена. Условия проверки не совпадают с ожиданиями.");
        }
    }

    // Доработать!! authErrorMessage_Actual возвращает пустую строку.
    // Проверка негативной авторизации.
    public static void checkNegativeAuth(){
        String authErrorMessage_Actual = LoginPage.getAuthErrorMessage().getText();
        String authErrorMessage_Expected = "Ваши данные аутентификации неверны, или сайт Alfresco в данный момент недоступен.";
        if(authErrorMessage_Actual.equals(authErrorMessage_Expected)){
            System.out.println("Негативная авторизация завершена удачно, ошибка - " + authErrorMessage_Actual);
        } else {
            System.out.println("Ошибка: Ошибка не совпадает с ожидаемой. Ожидаемая ошибка - " + authErrorMessage_Expected + " актуальная ошибка - " + authErrorMessage_Actual);
            Assert.fail("Ошибка не совпадает с ожидаемой ошибкой");
        }
    }

    // Проверка титула созданного документа в форме создания.
    public static void checkDocTitle(String docType, String docType_Expected) {
        String title_Actual = CreationFormPage.getDoc_CheckDocTitle(docType).getText();
        String title_Expected = "Создать документ \"" + docType_Expected + "\"";
        if (title_Actual.equals(title_Expected)) {
            System.out.println("Вид документа создан корректно. Актуальный титул - " + title_Actual);
        } else {
            System.out.println("Ошибка: Текст в заголовке не совпадает. Ожидаемый титул - " + title_Expected + ", актуальный титул - " + title_Actual);
            Assert.fail("Текст в заголовке не совпадает.");
        }
    }
}
