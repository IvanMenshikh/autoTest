import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ArmPage {

    private SelenideElement buttonCreate;
    private SelenideElement buttonDocTypeKS;
    private SelenideElement buttonDocTypeErrand;

    private SelenideElement getButtonCreate(){
        if(buttonCreate == null){
            buttonCreate = $x("//button[@id = 'template_x002e_accordion-toolbar_x002e_arm_x0023_default-newDocumentButton-button']");
        }
        return buttonCreate;
    }
    private SelenideElement getButtonDocTypeKS(){
        if(buttonDocTypeKS == null){
            buttonDocTypeKS = $x("//a[@class = 'yuimenuitemlabel']");
        }
        return buttonDocTypeKS;
    }
    private SelenideElement getButtonDocTypeErrand(){
        if(buttonDocTypeErrand == null){
            buttonDocTypeErrand = $x("//a[@class = 'yuimenuitemlabel yuimenuitemlabel-hassubmenu']");
        }
        return buttonDocTypeErrand;
    }
//    private final SelenideElement buttonCreate = $x("//button[@id = 'template_x002e_accordion-toolbar_x002e_arm_x0023_default-newDocumentButton-button']");
//    private final SelenideElement buttonDocTypeErrand = $x("//a[@class = 'yuimenuitemlabel yuimenuitemlabel-hassubmenu']");
//    private final SelenideElement buttonDocTypeKS = $x("//a[@class = 'yuimenuitemlabel']");

    /**
     * Открываем форму создания поручения
     */
    public void createErrand(){
        getButtonCreate().click();
        getButtonDocTypeErrand().click();
        sleep(3000);//Останавливаем код для просмотра конечного результата
    }


}
