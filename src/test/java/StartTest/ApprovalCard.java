package StartTest;

import Tools.Helper.AuthHelper;
import Tools.Helper.CreateDocHelper;
import org.testng.annotations.Test;

public class ApprovalCard extends BaseTest {

    @Test
    public void startTest(){

        AuthHelper.authorization("Автор_КарточкиСогласования");
        Tools.Asserts.checkAuth();
        CreateDocHelper.createDoc("Карточка согласования");
        CreateDocHelper.createApprovalCard();

    }

}