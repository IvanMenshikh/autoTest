import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class CreateDocCase {

    WebDriver driver = new EdgeDriver();
    Data getDate = new Data();

    private final By login = By.xpath("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-username']");
    private final By password = By.xpath("//div[@class = 'form-field']//input[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-password']");
    private final By buttonJoinInAuthorization = By.xpath("//button[@id = 'page_x002e_components_x002e_slingshot-login_x0023_default-submit-button']");
    private final By buttonCreateDoc = By.xpath("//button[@id = 'template_x002e_accordion-toolbar_x002e_arm_x0023_default-newDocumentButton-button']");
    private final By buttonSelectTypeDoc = By.xpath("//li[@class = 'yuimenuitem yuimenuitem-hassubmenu']//a[@class = 'yuimenuitemlabel yuimenuitemlabel-hassubmenu']");


    @Test
    public void authorization() throws InterruptedException {

    driver.get(getDate.urlKSED);
    driver.manage().window().maximize();
    driver.findElement(login).sendKeys(getDate.login);
    driver.findElement(password).sendKeys(getDate.password);
    driver.findElement(buttonJoinInAuthorization).click();
    Thread.sleep(3000);
    driver.findElement(buttonCreateDoc).click();
    Thread.sleep(3000);
    driver.findElement(buttonSelectTypeDoc).click();


    }

}
