package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

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
    public void createFormKS(){
        getButtonCreate().click();
        getButtonDocTypeKS().click();
    }
    /**
     * Открываем форму создания Поручения
     */
    public void createFormErrand(){
        getButtonCreate().click();
        getButtonDocTypeErrand().click();
    }


}
