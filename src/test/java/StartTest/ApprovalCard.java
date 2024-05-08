package StartTest;

import Tools.Helper.AuthHelper;
import Tools.Helper.CreateDocHelper;
import org.testng.annotations.Test;
import Object.Users;

public class ApprovalCard extends BaseTest {

    @Test
    public void startTest(){

        CreateDocHelper createDocHelper = new CreateDocHelper();

        //AuthHelper.negativeAuthorization(Users.author_ApprovalCard); // Негативная авторизация
        AuthHelper.authorization(Users.author_ApprovalCard);
        createDocHelper.createDoc("Карточка согласования");
        createDocHelper.createApprovalCard();

    }

}