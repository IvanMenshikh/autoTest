package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ArmPage {

    private SelenideElement buttonCreate;
    private SelenideElement buttonDocTypeKS;
    private SelenideElement buttonDocTypeErrand;
    private SelenideElement userMenu;
    private SelenideElement exitButton;


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
    private SelenideElement getUserMenu(){
        if(userMenu == null){
            userMenu = $x("//span[contains(@id,'USER_MENU')]");
        }
        return userMenu;
    }
    private SelenideElement getExitButton(){
        if(exitButton == null){
            exitButton = $x("//td[text()='Выход']");
        }
        return exitButton;
    }

    public SelenideElement typeDoc(String type) {
    switch (type) {
        case "Карточка согласования":
            return getButtonDocTypeKS();
        case "Поручение":
            return getButtonDocTypeErrand();
        default:
            throw new IllegalArgumentException("Неверный тип документа: " + type);
    }
}
    /**
     * Открываем форму создания по типу документа
     */
    public void createForm(String type){
        getButtonCreate().click();
        typeDoc(type).click();
    }
    public void exitOnAuthorizationPage(){
    getUserMenu().click();
    getExitButton().click();
    }
}


