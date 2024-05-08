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
        if (armTitle_Actual.equals(armTitle_Expected)) {
            System.out.println("Титул КСЭД - " + armTitle_Actual + " авторизация прошла успешно.");
        } else {
            System.out.println("Ошибка: Титул КСЭД не совпадает. Ожидаемый титул - " + armTitle_Expected + ", актуальный титул - " + armTitle_Actual);
            Assert.fail("Титул АРМ СЭД не совпадает с ожидаемым результатом");
        }
    }

    //Доработать!
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
    public static void checkDocTitle(String docType) {
        String title_Actual = CreationFormPage.getDoc_CheckDocTitle(docType).getText();
        String title_Expected = "Создать документ \"Карточка согласования\"";
        if (title_Actual.equals(title_Expected)) {
            System.out.println("Вид документа создан корректно. Актуальный титул - " + title_Actual);
        } else {
            System.out.println("Ошибка: Текст в заголовке не совпадает. Ожидаемый титул - " + title_Expected + ", актуальный титул - " + title_Actual);
            Assert.fail("Текст в заголовке не совпадает.");
        }
    }
}
