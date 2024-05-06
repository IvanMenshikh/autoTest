package StartTest;

import Tools.Helper.AuthHelper;
import Tools.Helper.CreateDocHelper;
import org.testng.annotations.Test;

public class ApprovalCard extends BaseTest {

    @Test
    public void startTest(){

        CreateDocHelper createDocHelper = new CreateDocHelper();


        AuthHelper.authorization("Автор_КарточкаСогласования");
        createDocHelper.createDoc("Карточка согласования");
        createDocHelper.createApprovalCard();

    }

}