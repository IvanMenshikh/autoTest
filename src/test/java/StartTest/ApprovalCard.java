package StartTest;

import org.testng.annotations.Test;

public class ApprovalCard extends BaseTest {

    @Test
    public void startTest(){

        Tools.AuthHelper.authorization("Смокин_1");
        Tools.Asserts.checkAuth();
        Tools.CreateDocHelper.createFormDoc("Карточка согласования");
        Tools.CreateDocHelper.createApprovalCard();

    }

}