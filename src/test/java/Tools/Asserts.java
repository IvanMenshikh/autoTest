package Tools;

import Page.MainPage;
import org.testng.Assert;

public class Asserts {

    MainPage mainPage = new MainPage();

    // Проверяем, что авторизация прошла успешно.
    public void checkAuth(){
        String armTitle = mainPage.getLogotipArm().getText();
        Assert.assertEquals(armTitle, "АРМ СЭД");
        System.out.println("Титул КСЭД - " + armTitle + " авторизация прошла успешно");
    }
}
