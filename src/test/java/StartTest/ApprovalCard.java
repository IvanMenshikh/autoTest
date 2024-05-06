package StartTest;

import Tools.Asserts;
import Tools.AuthHelper;
import Tools.CreateDocHelper;
import org.testng.annotations.Test;

public class ApprovalCard extends BaseTest {

    @Test
    public void startTest(){

        // Экземпляры классов.
        CreateDocHelper createDocHelper = new CreateDocHelper();
        AuthHelper authHelper = new AuthHelper();
        Asserts asserts = new Asserts();

        authHelper.authorization("Смокин_1");
        asserts.checkAuth();
        createDocHelper.createDoc("Карточка согласования");
        createDocHelper.createApprovalCard();

    }

}