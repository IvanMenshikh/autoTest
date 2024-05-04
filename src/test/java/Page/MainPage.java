package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    public static SelenideElement buttonCreate;// Кнопка "Создать".
    public static SelenideElement buttonDocTypeKS;// Кнопка вида документа "Карточка согласования".
    public static SelenideElement buttonDocTypeErrand;// Кнопка вида документа "Поручение".
    public static SelenideElement userMenu;// Пользовательское меню "Обо мне".
    public static SelenideElement exitButton;// Кнопка выхода из АРМ КСЭД.
    public static SelenideElement logotipArm;// Логотип АРМ.


    public static SelenideElement getButtonCreate(){
        return buttonCreate = $x("//button[text() = 'Создать']");
    }

    public static SelenideElement getButtonDocTypeKS(){
        return buttonDocTypeKS = $x("//a[text() = 'Карточка согласования']");
    }

    public static SelenideElement getButtonDocTypeErrand(){
        return buttonDocTypeErrand = $x("//a[text() = 'Поручение']");
    }

    public static SelenideElement getUserMenu(){
        return userMenu = $x("//span[contains(@id,'USER_MENU')]");
    }

    public static SelenideElement getExitButton(){
        return exitButton = $x("//td[text()='Выход']");
    }

    public static SelenideElement getLogotipArm(){
        return logotipArm = $x("//span[text() = 'АРМ СЭД']");
    }

}


