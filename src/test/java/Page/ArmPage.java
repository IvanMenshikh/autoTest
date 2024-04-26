package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.sleep;

public class ArmPage {

    private SelenideElement buttonCreate;
    private SelenideElement buttonDocTypeKS;
    private SelenideElement buttonDocTypeErrand;

    private SelenideElement getButtonCreate(){
        if(buttonCreate == null){
            buttonCreate = $x("//button[text() = 'Создать']");
        }
        return buttonCreate;
    }
    private SelenideElement getButtonDocTypeKS(){
        if(buttonDocTypeKS == null){
            buttonDocTypeKS = $x("//a[text() = 'Карточка согласования']");
        }
        return buttonDocTypeKS;
    }
    private SelenideElement getButtonDocTypeErrand(){
        if(buttonDocTypeErrand == null){
            buttonDocTypeErrand = $x("//a[text() = 'Поручение']");
        }
        return buttonDocTypeErrand;
    }
    /**
     * Открываем форму создания КС
     */
    public void createKS(){
        getButtonCreate().click();
        getButtonDocTypeKS().click();
        sleep(3000);//Останавливаем код для просмотра конечного результата
    }
    /**
     * Открываем форму создания Поручения
     */
    public void createErrand(){
        getButtonCreate().click();
        getButtonDocTypeErrand().click();
    }


}
