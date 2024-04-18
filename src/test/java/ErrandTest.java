import org.testng.annotations.Test;

public class ErrandTest extends BaseTest {
    private final static String ksedURL = "http://172.30.48.40:8080/share/page";
    private final static String loginUser = "Smoke_user118";
    private final static String passwordUser = "";

    @Test
    public void errand(){
        AuthorizationPage authorizationPage = new AuthorizationPage(ksedURL);
        authorizationPage.authorization();

    }

}