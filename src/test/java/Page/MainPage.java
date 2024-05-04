package Page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class MainPage {

    // Кнопка "Создать".
    public static SelenideElement getButtonCreate(){
        return $x("//button[text() = 'Создать']");
    }

    // Кнопка вида документа "Карточка согласования".
    public static SelenideElement getButtonDocTypeKS(){
        return $x("//a[text() = 'Карточка согласования']");
    }

    // Кнопка вида документа "Поручение".
    public static SelenideElement getButtonDocTypeErrand(){
        return $x("//a[text() = 'Поручение']");
    }

    // Пользовательское меню "Обо мне".
    public static SelenideElement getUserMenu(){
        return $x("//span[contains(@id,'USER_MENU')]");
    }

    // Кнопка выхода из АРМ КСЭД.
    public static SelenideElement getExitButton(){
        return $x("//td[text()='Выход']");
    }

    // Логотип АРМ.
    public static SelenideElement getLogotipArm(){
        return $x("//span[text() = 'АРМ СЭД']");
    }

}


