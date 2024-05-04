package Tools;

import Page.MainPage;
import org.testng.Assert;

public class Asserts {

    // Проверяем, что авторизация прошла успешно.
    public static void checkAuth(){
        String armTitle = MainPage.getLogotipArm().getText();
        Assert.assertEquals(armTitle, "АРМ СЭД");
        System.out.println("Титул КСЭД - " + armTitle + " авторизация прошла успешно");
    }
}
