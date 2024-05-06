package StartTest;

import Tools.Helper.AuthHelper;
import Tools.Helper.CreateDocHelper;
import org.testng.annotations.Test;

public class ErrandCard extends BaseTest {

    @Test
    public void startTest(){

        CreateDocHelper createDocHelper = new CreateDocHelper();

        AuthHelper.authorization("Автор_КарточкиСогласования");
        createDocHelper.createDoc("Поручение");
        createDocHelper.createErrand();

    }

}
