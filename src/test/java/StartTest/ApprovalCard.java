package StartTest;

import Page.LoginPage;
import Tools.Helper.CreateDocHelper;
import org.testng.annotations.Test;
import Object.Users;

public class ApprovalCard extends BaseTest {

    @Test
    public void startTest(){

        CreateDocHelper createDocHelper = new CreateDocHelper();
        LoginPage loginPage = new LoginPage();

        //loginPage.negativeAuthorization(Users.negativeUser);
        loginPage.authorization(Users.author_ApprovalCard);
        createDocHelper.createDoc("Карточка согласования");
        createDocHelper.createApprovalCard();

    }

}