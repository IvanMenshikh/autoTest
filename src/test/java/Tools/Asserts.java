package Tools;

import org.testng.Assert;

public class Asserts {

    // Проверяем, что авторизация прошла успешно.
    public static void checkAuth(){
        String armTitle = Page.MainPage.getLogotipArm().getText();
        Assert.assertEquals(armTitle, "АРМ СЭД");
        System.out.println("Титул КСЭД - " + armTitle + " авторизация прошла успешно");
    }



    //Доработать!
    public static void checkNegativeAuth(){
        String errorMes = Page.LoginPage.getMessageErrorAuth().getText();
        Assert.assertEquals(errorMes, "Ваши данные аутентификации неверны, или сайт Alfresco в данный момент недоступен.");
        System.out.println("Проверка negativeAuthorization завершена успешно.");
    }



}
