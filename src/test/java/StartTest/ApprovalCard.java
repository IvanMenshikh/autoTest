package StartTest;

import Page.LoginPage;
import Page.MainPage;
import Tools.ConstructorApprovalCard;
import org.testng.annotations.Test;
import Object.Users;

public class ApprovalCard extends BaseTest {

    @Test
    public void startTest(){

        ConstructorApprovalCard constructorApprovalCard = new ConstructorApprovalCard();
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = new MainPage();

        loginPage.negativeAuthorization(Users.negativeUser);
        loginPage.authorization(Users.author_ApprovalCard);
        //mainPage.createDoc("Карточка согласования");
        //constructorApprovalCard.createApprovalCard();

    }

}