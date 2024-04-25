import org.testng.annotations.Test;

public class ErrandTest extends BaseTest {
    private final static String ksedURL = "http://172.30.48.40:8080/share/page";
    @Test
    public void errand(){
        AuthorizationPage authorizationPage = new AuthorizationPage(ksedURL);
        ArmPage armPage = new ArmPage();
        authorizationPage.authorization();
        authorizationPage.checkAuthorization();
        armPage.createErrand();
    }

}