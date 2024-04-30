package StartTest;

import Data.Users;
import Page.CreationFormPage_KS;
import org.testng.annotations.Test;

public class ApprovalCard extends BaseTest {
    private final static String ksedURL = "http://172.30.48.40:8080/share/page";
    @Test
    public void startTest(){
        Page.AuthorizationPage authorizationPage = new Page.AuthorizationPage(ksedURL);
        Page.ArmPage armPage = new Page.ArmPage();
        Page.CreationFormPage_KS ks = new CreationFormPage_KS();
        Data.Users user = new Users();
        authorizationPage.authorization(user.getLoginUser118(), user.getPasswordUser118());
        authorizationPage.checkAuthorization();
        armPage.createForm("Карточка согласования");
        ks.createKs();
        //armPage.exitOnAuthorizationPage();
    }

}