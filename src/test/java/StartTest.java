import Page.CreationFormPage_KS;
import org.testng.annotations.Test;

public class StartTest extends BaseTest {
    private final static String ksedURL = "http://172.30.48.40:8080/share/page";
    @Test
    public void startTest(){
        Page.AuthorizationPage authorizationPage = new Page.AuthorizationPage(ksedURL);
        Page.ArmPage armPage = new Page.ArmPage();
        Page.CreationFormPage_KS ks = new CreationFormPage_KS();
        authorizationPage.authorization();
        authorizationPage.checkAuthorization();
        armPage.createKS();
        ks.ks();

    }

}